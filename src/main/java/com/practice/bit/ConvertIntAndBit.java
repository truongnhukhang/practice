package com.practice.bit;

public class ConvertIntAndBit {

  public static void main(String[] args) {
    System.out.println(convertIntToBit(13));
    System.out.println(converBitToInt(convertIntToBit(13)));
  }

  static String convertIntToBit(int number) {
    StringBuilder bit = new StringBuilder();
    while (number!=0) {
      if(number%2==0) {
        bit.insert(0,"0");
      } else {
        bit.insert(0,"1");
      }
      number = number/2;
    }
    return bit.toString();
  }

  static int converBitToInt(String bit) {
    int count = 0;
    int intNum = 0;
    for (int i = bit.length()-1; i > -1  ; i--) {
      int bitValue = Integer.valueOf(String.valueOf(bit.charAt(i)));
      if(bitValue!=0) {
        intNum = intNum + powOf2(count);
      }
      count++;
    }
    return intNum;
  }

  static int powOf2(int num) {
    if(num==0) {
      return 1;
    } else {
      return 2*powOf2(num - 1);
    }
  }
}
