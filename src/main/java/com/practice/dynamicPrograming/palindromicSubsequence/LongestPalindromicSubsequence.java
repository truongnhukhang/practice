package com.practice.dynamicPrograming.palindromicSubsequence;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {
  public static void main(String[] args) {
    String s = "gphyvqruxjmwhonjjrgumxjhfyupajxbjgthzdvrdqmdouuukeaxhjumkmmhdglqrrohydrmbvtuwstgkobyzjjtdtjroqpyusfsbjlusekghtfbdctvgmqzeybnwzlhdnhwzptgkzmujfldoiejmvxnorvbiubfflygrkedyirienybosqzrkbpcfidvkkafftgzwrcitqizelhfsruwmtrgaocjcyxdkovtdennrkmxwpdsxpxuarhgusizmwakrmhdwcgvfljhzcskclgrvvbrkesojyhofwqiwhiupujmkcvlywjtmbncurxxmpdskupyvvweuhbsnanzfioirecfxvmgcpwrpmbhmkdtckhvbxnsbcifhqwjjczfokovpqyjmbywtpaqcfjowxnmtirdsfeujyogbzjnjcmqyzciwjqxxgrxblvqbutqittroqadqlsdzihngpfpjovbkpeveidjpfjktavvwurqrgqdomiibfgqxwybcyovysydxyyymmiuwovnevzsjisdwgkcbsookbarezbhnwyqthcvzyodbcwjptvigcphawzxouixhbpezzirbhvomqhxkfdbokblqmrhhioyqubpyqhjrnwhjxsrodtblqxkhezubprqftrqcyrzwywqrgockioqdmzuqjkpmsyohtlcnesbgzqhkalwixfcgyeqdzhnnlzawrdgskurcxfbekbspupbduxqxjeczpmdvssikbivjhinaopbabrmvscthvoqqbkgekcgyrelxkwoawpbrcbszelnxlyikbulgmlwyffurimlfxurjsbzgddxbgqpcdsuutfiivjbyqzhprdqhahpgenjkbiukurvdwapuewrbehczrtswubthodv";
    long start = System.currentTimeMillis();
//    System.out.println(new LongestPalindromicSubsequence().findMaxSub(0,s.length()-1, s,new HashMap<>()));
    System.out.println("Time : " + (System.currentTimeMillis()-start));
    start = System.currentTimeMillis();
    System.out.println(new LongestPalindromicSubsequence().findMaxSubTable(0,s.length()-1, s,new Integer[s.length()][s.length()]));
    System.out.println("Time : " + (System.currentTimeMillis()-start));
  }

  public int findMaxSub(int start, int end, String s, Map<String,Integer> map) {
    if(start==end) {
      return 1;
    }
    if(end<start) {
      return 0;
    }
    String key = start+"|"+end;
    if(map.get(key)!=null) {
      return map.get(key);
    }
    int max = 1;
    for (int i = start; i <= end ; i++) {
      for (int j = end; j > i ; j--) {
        if(s.charAt(i)==s.charAt(j)) {
          int temp = 2 + findMaxSub(i+1,j-1,s,map);
          if(temp > max) {
            max = temp;
          }
        }
      }
    }
    map.put(key,max);
    return max;
  }

  public int findMaxSubTable(int start, int end, String s, Integer[][] table) {
    if(start==end) {
      return 1;
    }
    if(end<start) {
      return 0;
    }
    if(table[start][end]!=null) {
      return table[start][end];
    }
    int max = 0;
    if(s.charAt(start)==s.charAt(end)) {
      max = 2 + findMaxSubTable(start+1,end-1,s,table);
    } else {
      int tmp1 = findMaxSubTable(start+1,end,s,table);
      int tmp2 = findMaxSubTable(start,end-1,s,table);
      max = Math.max(tmp1,tmp2);
    }
    table[start][end] = max;
    return max;
  }
}
