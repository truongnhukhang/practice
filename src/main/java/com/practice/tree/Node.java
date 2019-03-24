package com.practice.tree;

/**
 * Created by truongnhukhang on 1/21/19.
 */
public class Node<T extends Comparable<T>> {
  public T value;
  public Node<T> leftChild;
  public Node<T> rightChild;
}
