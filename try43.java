import java.util.*;
import java.io.*;
import classfile.*;

int findMaxIndex(int[] arr, int lo, int li) {
    int mid = (lo + hi)/2;
    if(arr[lo] < arr[mid])
        return findMaxIndex(arr, mid, hi);
    else
        return findMaxIndex(arr, lo, mid);
}

public class try43 {
    public static void main(String[] args) {
        test0();
        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();

        test1();
    }
    public static void test0() {
        Aron.beg();
        // cool
        // This is Binary Search Tree, the runtime is O(log n)
        // deletion, lookup and insection are all O(log n)
        // deletion, lookup and insection are all O(log n)
        // quick sort is O(nlog n)
        // merge sort is O(nlog n)
        // quick sort is different than merge sort
        // Binary Search Tree[BST]
        // Serialization is cool
        // serialize
        // implements
        // extends
        // Could you give me an update on the test result?
        // merge sort is O(nlog n)

        Map<String, String> map = new HashMap<String, String>();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        }

        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
            { 13,  14,  15, 16},
        };
        int height = arr2d.length;
        int width = arr2d[0].length;

        Aron.end();

    }
    public static void test1() {
        Aron.beg();

        Aron.end();
    }
}

