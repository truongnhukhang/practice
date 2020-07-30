package com.practice.thread.mergeSort;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.*;

public class MergeSortBigFile {

  private final Object lock = new Object();

  public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
    String fileLocation = "C:/Users/Admins/Downloads/1234.txt";
    long start = System.currentTimeMillis();
    int[] fileCounter = {0};
    MergeSortBigFile mergeSortBigFile = new MergeSortBigFile();
    mergeSortBigFile.mergeSort(fileLocation,fileCounter);
    System.out.println("Time :"+(System.currentTimeMillis()-start));
  }

  public void sort(String fileLocation) {


  }

  public String mergeSort(String fileLocation,int[] fileCounter) throws IOException, ExecutionException, InterruptedException {
    RandomAccessFile rFile = new RandomAccessFile(fileLocation,"rw");
    long mid = RandomLineReader.getMidLineInPointer(rFile,0,rFile.length());
    // file has 1 line
    rFile.close();
    if(mid==-1) {
      return fileLocation;
    }


    String[] parts = splitFileInto2(fileLocation,fileCounter);
    File file = new File(fileLocation);
    file.delete();

    String[] mergeData = new String[2];
    Thread p1Thread = new Thread(()->{
      try {
        mergeData[0] = mergeSort(parts[0], fileCounter);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    p1Thread.start();
    Thread p2Thread = new Thread(()->{
      try {
        mergeData[1] = mergeSort(parts[1], fileCounter);
      } catch (IOException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });
    p2Thread.start();
    p1Thread.join();
    p2Thread.join();
    String part1Sorted = mergeData[0];
    String part2Sorted = mergeData[1];
    merge2FileByLine(part1Sorted,part2Sorted, fileLocation);
    File file1 = new File(parts[0]);
    file1.delete();
    File file2 = new File(parts[1]);
    file2.delete();
    return fileLocation;
  }

  private void merge2FileByLine(String part1Sorted, String part2Sorted,String mergedFile) throws IOException {
    RandomAccessFile r1File = new RandomAccessFile(part1Sorted,"rw");
    RandomAccessFile r2File = new RandomAccessFile(part2Sorted,"rw");
    File file = new File(mergedFile);
    file.createNewFile();
    Writer bw = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream(file, true), "UTF-8"));
    String line1 = r1File.readLine();
    String line2 = r2File.readLine();
    while (line1!=null && line2!=null) {
      if(line1.compareTo(line2)<0){
        if(!line1.isEmpty()) {
          bw.write(line1+"\n");
        }
        line1 = r1File.readLine();
      } else {
        if(!line2.isEmpty()) {
          bw.write(line2+"\n");
        }
        line2 = r2File.readLine();
      }
    }

    if(line1!=null) {
      while (line1!=null) {
        if(!line1.isEmpty()) {
          bw.write(line1+"\n");
        }
        line1 = r1File.readLine();
      }
    }

    if(line2!=null) {
      while (line2!=null) {
        if(!line2.isEmpty()) {
          bw.write(line2+"\n");
        }
        line2 = r2File.readLine();
      }
    }
    bw.close();
    r1File.close();
    r2File.close();
  }


  public String[] splitFileInto2(String fileLocation,int[] fileCounter) throws IOException {
    RandomAccessFile rFile = new RandomAccessFile(fileLocation,"rw");
    String fileName = new File(fileLocation).getName().split("\\.")[0];
    long mid = RandomLineReader.getMidLineInPointer(rFile,0,rFile.length());
    String[] fileLocations = new String[2];
    synchronized (lock) {
      fileLocations[0] = "tmp/"+fileName.split("_\\(")[0]+"_("+(fileCounter[0]++)+".txt";
      fileLocations[1] = "tmp/"+fileName.split("_\\(")[0]+"_("+(fileCounter[0]++)+".txt";
    }

    File p1 = new File(fileLocations[0]);
    File p2 = new File(fileLocations[1]);

    rFile.seek(0);
    FileOutputStream fileOutputStream = new FileOutputStream(p1);
    byte[] firstParts = new byte[(int) mid];
    rFile.readFully(firstParts);
    fileOutputStream.write(firstParts);
    fileOutputStream.flush();
    fileOutputStream.close();

    fileOutputStream = new FileOutputStream(p2);
    byte[] secondParts = new byte[(int) (rFile.length()-mid)];
    rFile.seek(mid);
    rFile.readFully(secondParts);
    fileOutputStream.write(secondParts);
    fileOutputStream.flush();
    fileOutputStream.close();

    rFile.close();

    return fileLocations;
  }
}
