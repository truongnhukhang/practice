package com.practice.leetcode.explorer.medium.sortingAndSearching;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRoom2 {
  public static void main(String[] args) {
    int[][] intervals = {{0,30},{5,10},{15,20}};
    System.out.println((new MeetingRoom2()).minMeetingRooms(intervals));
  }

  public int minMeetingRooms(int[][] intervals) {
    if(intervals.length==0) {
      return 0;
    }
    Arrays.sort(intervals,(o1, o2)->{return o1[0]-o2[0];});
    PriorityQueue<Integer> timeDoneRooms = new PriorityQueue<>();
    int num = 1; // number room
    timeDoneRooms.offer(intervals[0][1]);
    int[] in = null;
    int startTime = 0;
    int endTime = 0;
    for ( int i=1; i<intervals.length; i++) {
      in = intervals[i];
      startTime = in[0];
      endTime = in[1];
      int firstDoneRoom = timeDoneRooms.peek();
      if(startTime < firstDoneRoom) {
        num++;
      } else {
        timeDoneRooms.poll();
      }
      timeDoneRooms.offer(endTime);
    }
    return num;
  }
}
