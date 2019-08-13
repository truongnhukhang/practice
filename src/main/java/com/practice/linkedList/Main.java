package com.practice.linkedList;

public class Main {
  public static void main(String[] args) {
    LinkedListImplementSimple<String> implementSimple = new LinkedListImplementSimple<>();
    implementSimple.insert("A");
    implementSimple.insert("B");

    implementSimple.reserve();
    implementSimple.println();
    implementSimple.insert("C");
    implementSimple.insert("D");
    implementSimple.insert("E");
    implementSimple.insert("F");
    implementSimple.insert("G");
    implementSimple.insert("H");
    implementSimple.println();
    implementSimple.reserve();
    implementSimple.println();
  }
}
