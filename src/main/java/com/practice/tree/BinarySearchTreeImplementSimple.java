package com.practice.tree;

/**
 * Created by truongnhukhang on 1/21/19.
 */
public class BinarySearchTreeImplementSimple<T extends Comparable<T>> {
  Node<T> root;

  public void insert(T data) {
    if(root==null) {
      root = new Node<>();
      root.value = data;
    } else {
      insertToNode(data,root);
    }
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

  public void inOrderPrint() {
    inOrder(root);
  }

  private void inOrder(Node node) {
    if(node.leftChild!=null) {
      inOrder(node.leftChild);
    }
    System.out.println(node.value);
    if(node.rightChild!=null) {
      inOrder(node.rightChild);
    }
  }

  public void preOrderPrint() {
    preOrder(root);
  }

  private void preOrder(Node node) {
    System.out.println(node.value);
    if(node.leftChild!=null) {
      preOrder(node.leftChild);
    }
    if(node.rightChild!=null) {
      preOrder(node.rightChild);
    }
  }

  public void postOrderPrint() {
    postOrder(root);
  }

  private void postOrder(Node node) {
    if(node.leftChild!=null) {
      postOrder(node.leftChild);
    }
    if(node.rightChild!=null) {
      postOrder(node.rightChild);
    }
    System.out.println(node.value);
  }

  public void levelOrderPrint() {
    System.out.println(root.value);
    levelOrder(root);
  }

  private void levelOrder(Node node) {
    if(node!=null) {
      if(node.leftChild!=null) {
        System.out.println(node.leftChild.value);
      }
      if(node.rightChild!=null) {
        System.out.println(node.rightChild.value);
      }
      levelOrder(node.leftChild);
      levelOrder(node.rightChild);
    }
  }

  public int height() {
    return heightFromNode(root);
  }

  private int heightFromNode(Node node) {
    int leftHeight = 0;
    int rightHeight = 0;
    if(node.leftChild!=null) {
      leftHeight = heightFromNode(node.leftChild);
    }
    if(node.rightChild!=null) {
      rightHeight = heightFromNode(node.rightChild);
    }
    return 1 + Math.max(leftHeight,rightHeight);
  }

  public boolean isBalanceTree() {
    return isBalanceFromNode(root);
  }

  private boolean isBalanceFromNode(Node node) {
    int leftHeight = 0;
    int rightHeight = 0;
    if(node.leftChild!=null) {
      leftHeight = heightFromNode(node.leftChild);
    }
    if(node.rightChild!=null) {
      rightHeight = heightFromNode(node.rightChild);
    }
    return Math.abs(leftHeight-rightHeight) < 2;
  }
}
