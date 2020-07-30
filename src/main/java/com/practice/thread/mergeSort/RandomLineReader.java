package com.practice.thread.mergeSort;

import java.io.*;

public class RandomLineReader {

  public static void main(String[] args) throws IOException {
    // test split
    String filePath = "C:\\Users\\Admins\\Downloads\\1234.txt";
    RandomLineReader randomLineReader = new RandomLineReader();
    RandomAccessFile rFile = new RandomAccessFile(filePath, "rw");
    File p1 = new File("p1.txt");
    if(p1.exists()) {
      p1.delete();
      p1.createNewFile();
    }
    File p2 = new File("p2.txt");
    if(p2.exists()) {
      p2.delete();
      p2.createNewFile();
    }
    char[] delimiters = {'\n','\r'};
    long mid = randomLineReader.getMidLineInPointer(rFile,0,rFile.length());
    FileOutputStream p1OutputStream = new FileOutputStream(p1);
    rFile.seek(0);
    byte[] p1Bytes = new byte[(int) (mid)];
    rFile.readFully(p1Bytes);
    p1OutputStream.write(p1Bytes);
    p1OutputStream.flush();

    rFile.seek(mid);
    FileOutputStream p2OutputStream = new FileOutputStream(p2);
    byte[] p2Bytes = new byte[(int) (rFile.length()-mid)];
    rFile.readFully(p2Bytes);
    p2OutputStream.write(p2Bytes);
    p2OutputStream.flush();
  }


  public static long getMidLineInPointer(RandomAccessFile rFile,long start, long end) throws IOException {
    char[] delimiters = {'\n','\r',};
    long mid = (start + end)/2;
    rFile.seek(mid);
    int temp = rFile.read();
    while(temp>0 && rFile.getFilePointer()<end) {
      for (int i = 0; i < delimiters.length; i++) {
        if(temp==delimiters[i]) {
          return rFile.getFilePointer();

        }
      }
      temp = rFile.read();
    }
    // try to read backward
    mid = mid - 1;
    if(mid>0) {
      rFile.seek(mid);
      while(mid>0 && rFile.getFilePointer()>start) {
        temp = rFile.read();
        for (int i = 0; i < delimiters.length; i++) {
          if(temp==delimiters[i]) {
            return rFile.getFilePointer();
          }
        }
        mid=mid-1;
        rFile.seek(mid);
      }
    }
    return -1;
  }
}
