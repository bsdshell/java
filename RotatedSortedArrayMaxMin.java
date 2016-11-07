import java.util.*;
import java.io.*;
import classfile.*;

public class RotatedSortedArrayMaxMin{
    public static void main(String[] args) {
        test00_min();
        test0_min();
        test1_min();
        test2_min();
        test3_min();
        test4_min();
        test5_max();
        test6_max();
        test7_max();
        test8_max();
    }
    public static void test00_min(){
        Aron.beg();
        int[] arr = {1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 0);
        Aron.end();
    }
    public static void test0_min(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 0);
        Aron.end();
    }
    public static void test1_min(){
        Aron.beg();
        int[] arr = {2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 1);
        Aron.end();
    }
    public static void test2_min(){
        Aron.beg();
        int[] arr = {3, 1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 1);
        Aron.end();
    }
    public static void test3_min(){
        Aron.beg();
        int[] arr = {4, 1, 2, 3};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 1);
        Aron.end();
    }
    public static void test4_min(){
        Aron.beg();
        int[] arr = {2, 3, 4, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinimumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 3);
        Aron.end();
    }

    // find the index of minimum element of an array
    public static int findMinimumIndex(int[] arr, int lo, int hi){
        if( arr[lo] <= arr[hi])
            return lo;
        else{
            // [2, 1]
            // [3, 1, 2]
            // =>[3, 1] => [1]
            int mid = (lo + hi)/2;
            if(arr[lo] < arr[mid])
                return findMinimumIndex(arr, mid, hi);
            else if(arr[lo] > arr[mid])
                return findMinimumIndex(arr, lo, mid);
            else 
                return hi;
        }
    }
    public static int findMaximumIndex(int[] arr, int lo, int hi){
        if(arr[lo] <= arr[hi])
            return hi;
        else{
            // [2, 1]
            int mid = (lo + hi)/2;
            if( arr[lo] < arr[mid])
                return findMaximumIndex(arr, mid, hi);
            else if(arr[lo] > arr[mid]) 
                return findMaximumIndex(arr, lo, mid);
            else
                return lo;
        }
    }
    public static void test5_max(){
        Aron.beg();
        int[] arr = {2, 3, 4, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaximumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 2);
        Aron.end();
    }
    public static void test6_max(){
        Aron.beg();
        int[] arr = {2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaximumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 0);
        Aron.end();
    }
    public static void test7_max(){
        Aron.beg();
        int[] arr = {1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaximumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 0);
        Aron.end();
    }
    public static void test8_max(){
        Aron.beg();
        int[] arr = {4, 1, 2, 3};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaximumIndex(arr, lo, hi);
        Print.pbl("index=" + index);
        Test.t(index == 0);
        Aron.end();
    }

} 

