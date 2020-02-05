package com.practice.disjointSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class DisjointSet<T> {
  Map<T,Set<T>> sets;

  public DisjointSet() {
    sets = new HashMap<>();
  }

  public void makeSet(T val) {
    Set<T> set = new Set<>();
    set.val = val;
    set.representative = set;
    set.rank = 0;
    sets.put(val,set);
  }

  public Set<T> findSet(T val) {
    Set<T> set = sets.get(val);
    while(set.representative!=set) {
      set = set.representative;
    }
    return set;
  }

  public void union(T a,T b) {
    Set<T> setA = findSet(a);
    Set<T> setB = findSet(b);
    if(setA.rank > setB.rank) {
      setB.representative = setA;
    } else if(setA.rank < setB.rank) {
      setA.representative = setB;
    } else {
      setA.representative = setB;
      setA.rank = setA.rank+1;
    }
  }
}
