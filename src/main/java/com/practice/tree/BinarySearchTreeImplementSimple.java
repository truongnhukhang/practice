package com.practice.tree;

import com.practice.queue.QueueImplementSimple;

import java.util.ArrayDeque;
import java.util.Queue;

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
    Queue<Node> queue = new ArrayDeque<>();
    queue.add(root);
    levelOrder(queue);
  }

  private void levelOrder(Queue<Node> queue) {
    Node node = queue.poll();
    while (node!=null) {
      System.out.println(node.value);
      if(node.leftChild!=null) {
        queue.add(node.leftChild);
      }
      if(node.rightChild!=null) {
        queue.add(node.rightChild);
      }
      node = queue.poll();
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

  public void delete(T t) {
    Node temp = root;
    Node deleteNode = null;
    Node prv = null;
    boolean isleft = false;
    while (temp!=null) {
      if(temp.value.compareTo(t)<0) {
        prv = temp;
        temp= temp.leftChild;
        isleft = true;
      } else if(temp.value.compareTo(t)>0) {
        prv = temp;
        temp=temp.rightChild;
        isleft = false;
      } else {
        deleteNode = temp;
        if(deleteNode.leftChild==null && deleteNode.rightChild==null) {
          if(isleft) {
            prv.leftChild = null;
          } else {
            prv.rightChild = null;
          }
        } else if(deleteNode.leftChild!=null && deleteNode.rightChild!=null) {
          // find the min node of right sub tree
          Node prvMinNode = deleteNode;
          Node minNode = deleteNode.rightChild;
          while (true) {
            if(minNode.leftChild!=null) {
              prvMinNode = minNode;
              minNode = minNode.leftChild;
            } else {
              deleteNode.value = minNode.value;
              prvMinNode.leftChild = null;
              break;
            }
          }

        } else {
          if(isleft) {
            if(deleteNode.leftChild!=null) {
              prv.leftChild = deleteNode.leftChild;
            } else {
              prv.leftChild = deleteNode.rightChild;
            }
          } else  {
            if(deleteNode.leftChild!=null) {
              prv.rightChild = deleteNode.leftChild;
            } else {
              prv.rightChild = deleteNode.rightChild;
            }
          }
        }
      }
    }
  }
}
