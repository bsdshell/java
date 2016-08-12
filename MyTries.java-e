import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class TNode {
    boolean isWord;
    TNode[] array = new TNode[26];
}

class Tries {
    TNode root;
    public Tries() {
        root = new TNode();
        root.isWord = true;
    }
    public int map(char ch) {
        return (int)ch - 'a';
    }

    //[ file=newtries.html title=""
    public  void add(TNode r, int[] arr, int k) {
        if( k < arr.length) {
            if(r.array[arr[k]] == null)
                r.array[arr[k]] = new TNode();

            add(r.array[arr[k]], arr, k+1);
        }else if(k == arr.length){
            r.isWord = true;
        }
    }

    public  boolean contains(TNode r, int[] arr, int k) {
        if(r != null){
            if(k < arr.length) {
                return contains(r.array[arr[k]], arr, k+1);
            }else if (k == arr.length){
                return r.isWord;
            }
        }
        return false;
    }
    public  void addWord(TNode r,  String word, int k) {
        if( k < word.length()) {
            if(r.array[map(word.charAt(k))] == null)
                r.array[map(word.charAt(k))] = new TNode();

            addWord(r.array[map(word.charAt(k))], word, k+1);
        }else{
            r.isWord = true;
        }
    }
    public  boolean containsWord(TNode r, String word, int k) {
          if(r != null){
              if(k == word.length())
                  return r.isWord;
              else if(k < word.length()){
                  return containsWord(r.array[map(word.charAt(k))], word, k+1);
              }
          }
          return false;
    }
    //]
}

class MyTries {
    public static void main(String args[]) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();

        test11();
        test12();
        test13();
        test14();
        test15();
    }
    
    public static void test0() {
        Aron.beg();
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {};
        add(t.root, arr, k);
        System.out.println("[" + (t.contains(t.root, arr, h) == true)+ "]"); 
        Aron.end();
    }

    public static void test1() {
        Aron.beg();
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0};
        add(t.root, arr, k);
        System.out.println("[" + (t.contains(t.root, arr, h) == true)+ "]"); 
        Aron.end();
    }

    public static void test2() {
        Aron.beg();
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0, 0, 1};
        add(t.root, arr, k);
        System.out.println("[" + (t.contains(t.root, arr, h) == true)+ "]"); 
        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0, 0, 1};
        int[] arr1 = {0, 0};
        add(t.root, arr, k);
        System.out.println("[" + (t.contains(t.root, arr, h) == true)+ "]"); 
        Aron.end();
    }

    public static void test4() {
        Aron.beg();
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0};
        int[] arr1 = {0,0};
        add(t.root, arr, k);
        System.out.println("[" + (t.contains(t.root, arr, h) == true)+ "]"); 
        Aron.end();
    }

    public static void test5() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr1 = {0,0,0};
        int[] arr3 = {0};
        add(t.root, arr1, k);
        add(t.root, arr3, k);

        int[] arr2 = {0,0};
        System.out.println("[" + (t.contains(t.root, arr1, h) == true)+ "]"); 
        System.out.println("[" + (t.contains(t.root, arr2, h) == false)+ "]"); 
        System.out.println("[" + (t.contains(t.root, arr3, h) == true)+ "]"); 

        Aron.end();
    }
    // 'a'-> 0
    // 'b'-> 1
    // 'z'-> 25
    public static int map(char ch) {
        return (int)ch - 'a';
    }
    public static void add(TNode r, int[] arr, int k) {
        if( k < arr.length) {
            if(r.array[arr[k]] == null)
                r.array[arr[k]] = new TNode();
            add(r.array[arr[k]], arr, k+1);
        }else{
            r.isWord = true;
        }
    }

    public static void test11() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "abc";
        t.addWord(t.root, word, k);
        System.out.println("[" + (t.containsWord(t.root, word, h) == true ) + "]"); 
        Aron.end();
    }
    public static void test12() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "abc";
        t.addWord(t.root, word, k);
        String word1 = "ab";
        System.out.println("[" + (t.containsWord(t.root, word1, h) == false) + "]"); 
        Aron.end();
    }
    public static void test13() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "a";
        System.out.println("[" + (t.containsWord(t.root, word1, h) == true) + "]"); 

        Aron.end();
    }
    public static void test14() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "aa";
        System.out.println("[" + (t.containsWord(t.root, word1, h) == false) + "]"); 

        Aron.end();
    }
    public static void test15() {
        Aron.beg();

        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "";
        System.out.println("[" + (t.containsWord(t.root, word1, h) == true) + "]"); 

        Aron.end();
    }
}
