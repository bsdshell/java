import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class Pair {
    Queue<Integer> queue = new LinkedList<Integer>();
    int index;
    public Pair() {
        index = -1;
    }
}

class BinarySearch {
    public static void main(String args[]) {
        Test1();
        Test2();
        Test3();
        Test4();
        test5();
        test6();
    }
    static void test5(){
        Aron.beg();

        int[] arr = {0, 2, 3, 5};
        int lo = 0;
        int hi = arr.length - 1;
        int key = 6;
        List<Integer> list = new ArrayList<Integer>(); 

        BinSearchBetween(arr, lo, hi, key, list);
        Aron.printList(list);

        Aron.end();
    } 
    static void test6(){
        Aron.beg();

        int[] arr = {-Integer.MAX_VALUE, 0, 2, 3, 5, Integer.MAX_VALUE};
        int lo = 0;
        int hi = arr.length - 1;
        int key = -1;
        List<Integer> list = new ArrayList<Integer>(); 

        BinSearchBetween(arr, lo, hi, key, list);
        Aron.printList(list);

        Aron.end();
    } 

    public static void BinSearchIndex(int[] arr, int left, int right, int key, Pair pair) {
        if(arr != null && left <= right) {
            int middle = (left + right)/2;
            if(key < arr[middle]) {
                if(pair.queue.size() >= 2)
                    pair.queue.remove();
                pair.queue.add(middle-1);

                BinSearchIndex(arr, left, middle - 1, key, pair);
            } else if(key > arr[middle]) {
                if(pair.queue.size() >= 2)
                    pair.queue.remove();
                pair.queue.add(middle+1);

                BinSearchIndex(arr, middle + 1, right, key, pair);
            } else
                pair.index = middle;
        }
    }

    public static boolean BinSearch(int[] arr, int left, int right, int key) {
        boolean ret = false;
        if(arr != null && left <= right) {
            int middle = (left + right)/2;
            if(key < arr[middle]) {
                ret = BinSearch(arr, left, middle - 1, key);
            } else if(key > arr[middle]) {
                ret = BinSearch(arr, middle + 1, right, key);
            } else
                ret = true;
        }
        return ret;
    }
    public static boolean BinSearchBetween(int[] arr, int left, int right, int key, List<Integer> list) {
        boolean ret = false;
        if(arr != null && left <= right) {
            int middle = (left + right)/2;
            list.add(middle);

            if(key < arr[middle]) {
                ret = BinSearchBetween(arr, left, middle - 1, key, list);
            } else if(key > arr[middle]) {
                ret = BinSearchBetween(arr, middle + 1, right, key, list);
            } else
                ret = true;
        }
        return ret;
    }


    public static void Test1() {
        int[] arr = {1, 2, 3, 5};
        int left = 0;
        int right = arr.length - 1;
        int key = 1;
        boolean ret = BinSearch(arr, left, right, key);
        System.out.println(ret);
    }

    public static void Test2() {
        int[] arr = {1};
        int left = 0;
        int right = arr.length - 1;
        int key = 1;
        boolean ret = BinSearch(arr, left, right, key);
        System.out.println(ret);
    }

    public static void Test3() {
        int[] arr = {2};
        int left = 0;
        int right = arr.length - 1;
        int key = 1;
        boolean ret = BinSearch(arr, left, right, key);
        System.out.println(ret);
    }

    public static void Test4() {
        int[] arr = {0, 2, 3, 5};
        int left = 0;
        int right = arr.length - 1;
        int key = 6;
        Pair pair = new Pair();

        BinSearchIndex(arr, left, right, key, pair);
        for(Integer p:pair.queue) {
            System.out.println("p="+p);
        }
        System.out.println("index="+pair.index);
    }
}
