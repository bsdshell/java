import java.util.*;
import java.io.*;
import classfile.*;

public class TryTest1 {
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();

        test0_quickSort();
        test1_quickSort();
        test2_quickSort();
        test3_quickSort();
        test4_quickSort();
    }
    static void test0() {
        Aron.beg();
        int[] arr = {1}; 
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 0);
        Aron.printArray(arr);

        Aron.end();
    }
    static void test1() {
        Aron.beg();
        int[] arr = {1, 2}; 
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 1);
        Aron.printArray(arr);

        Aron.end();
    }
    static void test2() {
        Aron.beg();
        int[] arr = {2, 1};  
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 0);
        Aron.printArray(arr);

        Aron.end();
    }
    static void test3() {
        Aron.beg();
        int[] arr = {2, 3, 1};  
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 0);
        Aron.printArray(arr);

        Aron.end();
    }
    static void test4() {
        Aron.beg();
        int[] arr = {2, 3, 4, 6, 5};  
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 3);
        Aron.printArray(arr);

        Aron.end();
    }
    static void test5() {
        Aron.beg();
        int[] arr = {2, 6, 7, 4, 5};  
        int lo = 0;
        int hi = arr.length-1;
        Test.t(partition(arr, lo, hi), 2);
        Aron.printArray(arr);

        Aron.end();
    }
    static int partition(int[] arr, int lo, int hi){
        int big = lo;
        if(arr != null && lo < hi){
            int pivot = arr[hi];

            for(int i=lo; i<=hi; i++){
                if(arr[i] <= pivot){
                    Aron.swap(arr, big, i);
                    if(i < hi)
                        big++;
                }
            }
        }
        return big;
    }
    // [1]
    // [2, 1] -> [1] [2]
    // [2, 1, 3] ->  [2, 1] [3] -> (0, 1)  p = 2
    //                  [1] [2] p = 0
    //                  
    static void quickSort(int[] arr, int lo, int hi){
        if(lo < hi){
            int pivotIndex = partition(arr, lo, hi);
            quickSort(arr, lo, pivotIndex-1);
            quickSort(arr, pivotIndex+1, hi);
        }
    }
    
    static void test0_quickSort(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4}; 
        int lo = 0;
        int hi = arr.length-1;
        quickSort(arr, lo, hi);
        Test.t(Aron.arrayInc(arr), true);
        Aron.end();
    }
    static void test1_quickSort(){
        Aron.beg();
        int[] arr = {4, 2, 3, 1}; 
        int lo = 0;
        int hi = arr.length-1;
        quickSort(arr, lo, hi);
        Test.t(Aron.arrayInc(arr), true);
        Aron.end();
    }
    static void test2_quickSort(){
        Aron.beg();
        int[] arr = {4, 2}; 
        int lo = 0;
        int hi = arr.length-1;
        quickSort(arr, lo, hi);
        Test.t(Aron.arrayInc(arr), true);
        Aron.end();
    } 
    static void test3_quickSort(){
        Aron.beg();
        int[] arr = {4, 2, 5}; 
        int lo = 0;
        int hi = arr.length-1;
        quickSort(arr, lo, hi);
        Test.t(Aron.arrayInc(arr), true);
        Aron.end();
    } 
    static void test4_quickSort(){
        Aron.beg();
        int[] arr = {1, 4, 8, 20, 3, 6, 4, 2, 5}; 
        int lo = 0;
        int hi = arr.length-1;
        quickSort(arr, lo, hi);
        Test.t(Aron.arrayInc(arr), true);
        Aron.printArray(arr);
        Aron.end();
    } 

}

