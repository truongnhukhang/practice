package com.practice.leetcode.mock;

public class GetDayOfTheWeek {
  public static void main(String[] args) {
    GetDayOfTheWeek mockInterview = new GetDayOfTheWeek();
    System.out.println(mockInterview.dayOfTheWeek(31,1,2019));
  }

  public String dayOfTheWeek(int day, int month, int year) {
    int[] t = new int[]{0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
    if(month<3) {
      year--;
    }
    String[] dayOfTheWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    int dayOfTheWeekInt = (year + year/4 - year/100 + year/400 + t[month-1] + day) % 7;
    return dayOfTheWeek[dayOfTheWeekInt];
  }
}
