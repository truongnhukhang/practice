package com.practice.tree;

public class Trie {

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("khang");
    trie.insert("kha");
    trie.insert("kh");
    trie.insert("tree");
    trie.insert("trie");

    System.out.println(trie.search("khang"));
    System.out.println(trie.search("kha"));
    System.out.println(trie.search("khng"));
    System.out.println(trie.startsWith("tri"));
    System.out.println(trie.startsWith("try"));
  }

  TrieNode root = new TrieNode();

  public void insert(String word) {
    char[] chars = word.toLowerCase().toCharArray();
    TrieNode node = root;
    for (int i = 0; i < chars.length; i++) {
      int charIndex = chars[i] - 'a';
      if(node.children[charIndex]==null) {
        node.children[charIndex] = new TrieNode();
      }
      node = node.children[charIndex];
    }
    node.hashVal = word.hashCode();
  }

  public boolean search(String word) {
    char[] chars = word.toLowerCase().toCharArray();
    TrieNode node = root;
    for (int i = 0; i < chars.length; i++) {
      int charIndex = chars[i] - 'a';
      node = node.children[charIndex];
      if(node==null) {
        return false;
      }
    }
    return node.hashVal!=null;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    char[] chars = prefix.toLowerCase().toCharArray();
    TrieNode node = root;
    for (int i = 0; i < chars.length; i++) {
      int charIndex = chars[i] - 'a';
      node = node.children[charIndex];
      if(node==null) {
        return false;
      }
    }
    return true;
  }

  public class TrieNode {
    Integer hashVal;
    TrieNode[] children = new TrieNode[26];
  }

}
