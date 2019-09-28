package com.practice.leetcode.explorer.easy.other;

import java.util.Stack;

public class ValidParentheses {
  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
  }

  public static boolean isValid(String s) {
    if(s.length()==0) {
      return true;
    }
    if(s.length()%2==1) {
      return false;
    }
    Stack<Character> characterStack = new Stack<>();
    characterStack.push(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if(!characterStack.isEmpty() && isValidGroup(characterStack.peek(),s.charAt(i))) {
        characterStack.pop();
      } else {
        characterStack.push(s.charAt(i));
      }
    }
    return characterStack.isEmpty();
  }

  public static boolean isValidGroup(char x,char y) {
    return (x=='(' && y==')') || (x=='{' && y=='}') || (x=='[' && y==']');
  }
}
