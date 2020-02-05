package com.practice.graph;

/**
 * Created by truongnhukhang on 2/5/20.
 */
public class Edge {
  public Node source;
  public Node des;
  public int weight;

  public int getWeight() {
    return weight;
  }

  @Override
  public String toString() {
    return source.val+"-"+des.val+" : "+weight;
  }
}
