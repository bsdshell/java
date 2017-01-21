import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class MedianOfStream{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        Integer[] arr = {2, 1, 3, 4, 5, 0};
        int width = arr.length; 
        int lo = 0;
        int hi = arr.length - 1;
        Aron.printArray(arr);
        Ut.l();
        quickSort(arr, lo, hi);
        Aron.printArray(arr);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Integer[] arr = {2, 1};
        int width = arr.length; 
        int lo = 0;
        int hi = arr.length - 1;
        Aron.printArray(arr);
        Ut.l();
        quickSort(arr, lo, hi);
        Aron.printArray(arr);
        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        Integer[] arr = {1, 2};
        int width = arr.length; 
        int lo = 0;
        int hi = arr.length - 1;
        Aron.printArray(arr);
        Ut.l();
        quickSort(arr, lo, hi);
        Aron.printArray(arr);
        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        Integer[] arr = {2};
        int width = arr.length; 
        int lo = 0;
        int hi = arr.length - 1;
        Aron.printArray(arr);
        Ut.l();
        quickSort(arr, lo, hi);
        Aron.printArray(arr);
        Aron.end();
    }

    // test [2, 1] = > [1, 2], pivot = [0]
    public static void quickSort(Integer[] arr, int lo, int hi){
        if(lo < hi){
            int pivot = partition(arr, lo, hi);
            quickSort(arr, lo, pivot -1);
            quickSort(arr, pivot + 1, hi);
        }
    }

    public static int partition(Integer[] arr, int lo, int hi){
        int big = lo;
        int pivot = arr[hi];
        for(int i=lo; i<=hi; i++){
            if(arr[i] <= pivot){
                swap(arr, big, i);
                if(i < hi)
                    big++;
            }
        }
        return big;
    }
    public static void swap(Integer[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    public static void Median(int[] arr){
                    
    }
} 

