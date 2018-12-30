package com.practice.stack;

public class ThreeStackInOneArray<T> {

  Node<T>[] db = new Node[100];
  int lastInsertedS1 = -1;
  int lastInsertedS2 = -1;
  int lastInsertedS3 = -1;

  public void put(String stackName,T data) {
    int insertedIndex;
    Node<T> temp = new Node<>();
    temp.data = data;
    insertedIndex = insertToNullValue(temp);
    if(insertedIndex==-1) {
      System.out.println("DB is full");
    } else {
      if(stackName.equals("S1")) {
        db[insertedIndex].preIndex = lastInsertedS1;
        lastInsertedS1 = insertedIndex;
      } else if(stackName.equals("S2")) {
        db[insertedIndex].preIndex = lastInsertedS2;
        lastInsertedS2 = insertedIndex;
      } else {
        db[insertedIndex].preIndex = lastInsertedS3;
        lastInsertedS3 = insertedIndex;
      }
    }
  }
  
  public T pop(String stackName) {
    Node<T> result = null;
    if(stackName.equals("S1")) {
      if(lastInsertedS1==-1) {
        System.out.println("Stack is Empty");
        return null;
      } else {
        result = db[lastInsertedS1];
        db[lastInsertedS1] = null;
        lastInsertedS1 = result.preIndex;
      }
    } else if(stackName.equals("S2")) {
      if(lastInsertedS2==-1) {
        System.out.println("Stack is Empty");
        return null;
      } else {
        result = db[lastInsertedS2];
        db[lastInsertedS2] = null;
        lastInsertedS2 = result.preIndex;
      }
    } else {
      if(lastInsertedS3==-1) {
        System.out.println("Stack is Empty");
        return null;
      } else {
        result = db[lastInsertedS3];
        db[lastInsertedS3] = null;
        lastInsertedS3 = result.preIndex;
      }
    }
    return result.data;
  }

  private int insertToNullValue(Node<T> data) {
    for (int i = 0; i < db.length; i++) {
      if(db[i]==null) {
        db[i] = data;
        return i;
      }
    }
    return -1;
  }

  private class Node<T> {
    int preIndex;
    T data;
  }
}
