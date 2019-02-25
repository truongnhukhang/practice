package com.practice.tree;

/**
 * Created by truongnhukhang on 1/21/19.
 */
public class BinarySearchTreeImplementSimple<T extends Comparable<T>> {
  Node<T> root;

  public void insert(T data) {
    insertToNode(data,root);
  }

  private void insertToNode(T data,Node<T> node) {
    if(data.compareTo(node.value)==-1) {
      if(node.leftChild!=null) {
        insertToNode(data,node.leftChild);
      } else {
        Node<T> insertNode = new Node<>();
        insertNode.value = data;
        node.leftChild = insertNode;
      }
    } else {
      if(node.rightChild!=null) {
        insertToNode(data,node.rightChild);
      } else {
        Node<T> insertNode = new Node<>();
        insertNode.value = data;
        node.rightChild = insertNode;
      }
    }
  }

  private void inOrderPrint() {

  }

  private void inOrder() {

  }

}
