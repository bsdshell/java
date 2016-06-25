import java.io.*;
import java.lang.String;
import java.util.*;

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
    public  int map(char ch) {
        return (int)ch - 'a';
    }
    public  void add(TNode r, int[] arr, int k) {
        if( k < arr.length) {
            if(r.array[arr[k]] == null)
                r.array[arr[k]] = new TNode();
            if(k == arr.length-1)
                r.isWord = true;
            add(r.array[arr[k]], arr, k+1);
        }
    }

    public  boolean contains(TNode r, int[] arr, int h) {
        if(h < arr.length && r.array[arr[h]] != null) {
            if(h + 1 == arr.length && r.isWord)
                return true;
            else
                return contains(r.array[arr[h]], arr, h+1);
        }
        return false;
    }
    public  void addWord(TNode r,  String word, int k) {
        if( k < word.length()) {
            if(r.array[map(word.charAt(k))] == null)
                r.array[map(word.charAt(k))] = new TNode();
            if(k == word.length()-1)
                r.isWord = true;
            addWord(r.array[map(word.charAt(k))], word, k+1);
        }
    }
    public  boolean containsWord(TNode r, String word, int k) {
        if(word.length() == 0)
            return r.isWord;
        if(k < word.length() && r.array[map(word.charAt(k))] != null) {
            if(k + 1 == word.length() && r.isWord)
                return true;
            else
                return containsWord(r.array[map(word.charAt(k))], word, k+1);
        }
        return false;
    }
}

class MyTries {
    public static void main(String args[]) {
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
    public static void test1() {
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0};
        add(t.root, arr, k);
        System.out.println(t.contains(t.root, arr, h));
    }
    public static void test2() {
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0, 0, 1};
        add(t.root, arr, k);
        System.out.println(t.contains(t.root, arr, h));
    }
    public static void test3() {
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0, 0, 1};
        int[] arr1 = {0, 0};
        add(t.root, arr, k);
        System.out.println(t.contains(t.root, arr1, h));
    }

    public static void test4() {
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr = {0};
        int[] arr1 = {0,0};
        add(t.root, arr, k);
        System.out.println(t.contains(t.root, arr1, h));
    }

    public static void test5() {
        System.out.println("test5");
        Tries t = new Tries();
        int k=0;
        int h=0;
        int[] arr1 = {0,0,0};
        int[] arr3 = {0};
        add(t.root, arr1, k);
        add(t.root, arr3, k);

        int[] arr2 = {0,0};
        System.out.println(t.contains(t.root, arr1, h));
        System.out.println(t.contains(t.root, arr2, h));
        System.out.println(t.contains(t.root, arr3, h));
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
            if(k == arr.length-1)
                r.isWord = true;
            add(r.array[arr[k]], arr, k+1);
        }
    }

    public static void test11() {
        System.out.println("test11");
        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "abc";
        t.addWord(t.root, word, k);
        System.out.println(t.containsWord(t.root, word, h) == true);
    }
    public static void test12() {
        System.out.println("test12");
        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "abc";
        t.addWord(t.root, word, k);
        String word1 = "ab";
        System.out.println(t.containsWord(t.root, word1, h)==false);
    }
    public static void test13() {
        System.out.println("test13");
        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "a";
        System.out.println(t.containsWord(t.root, word1, h) == true);
    }
    public static void test14() {
        System.out.println("test14");
        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "aa";
        System.out.println(t.containsWord(t.root, word1, h) == false);
    }
    public static void test15() {
        System.out.println("test15");
        Tries t = new Tries();
        int k=0;
        int h=0;
        String word = "a";
        t.addWord(t.root, word, k);
        String word1 = "";
        System.out.println(t.containsWord(t.root, word1, h) == true);
    }
}
