package com.practice.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class ReorderDataInLogFiles {


  public String[] reorderLogFilesSort(String[] logs) {
    Arrays.sort(logs,(s1,s2)->{
      if(isDigitLog(s1) && isDigitLog(s2)) {
        return 0;
      }
      if(!isDigitLog(s1) && !isDigitLog(s2)) {
        return s1.substring(s1.indexOf(' ')).compareTo(s2.substring(s2.indexOf(' ')));
      }
      if(isDigitLog(s1)) {
        return 1;
      }
      return -1;
    });
    return logs;
  }

  public String[] reorderLogFiles(String[] logs) {
    // move dig log to the end of arrays
    String digLogPrefix = "dig";
    int lastDigIndex = logs.length-1;
    String[] results = new String[logs.length];
    int startLogLetter = 0; int startLogDig = results.length-1;
    for(int i=logs.length-1;i>=0;i--) {
      if(isDigitLog(logs[i])) {
        results[startLogDig] = logs[i];
        startLogDig--;
      } else {
        results[startLogLetter] = logs[i];
        startLogLetter++;
      }
    }

    // select sort for letter log

    for(int i=0;i<startLogLetter;i++) {
      for(int j=i+1;j<startLogLetter;j++) {
        if(results[i].replaceFirst(results[i].split(" ")[0],"").compareTo(results[j].replaceFirst(results[j].split(" ")[0],""))>0) {
          String temp = "";
          temp = results[i];
          results[i] = results[j];
          results[j] = temp;
        }
      }
    }


    return results;
  }

  public boolean isDigitLog(String log) {
    return isNumeric(log.substring(0,log.indexOf(' ')));
  }

  public static boolean isNumeric(String strNum) {
    if (strNum == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(strNum);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }
}
