package com.practice.leetcode.mock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class findR {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    String baseStr = input.split("\\s")[0];
    String heightStr = input.split("\\s")[1];
    Double base = Double.valueOf(baseStr);
    Double height = Double.valueOf(heightStr);
    Double hypotenuse = calculateHypotenuse(base,height);
    Double radius = calculateRadius(hypotenuse,base,height);
    String strDouble = String.format("%.4f", radius);
    System.out.println(strDouble);
  }

  private static Double calculateRadius(Double hypotenuse, Double base, Double height) {
    Double triangleArea = base/2 * height;
    return triangleArea/hypotenuse;
  }

  private static Double calculateHypotenuse(Double base, Double height) {
    return Math.sqrt(Math.pow(base/2,2)+Math.pow(height,2));
  }
}
