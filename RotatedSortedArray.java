import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import classfile.*;

public class RotatedSortedArray{
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test0_findMinIndexNew();
        test1_findMinIndexNew();
        test2_findMinIndexNew();
        test3_findMinIndexNew();
        test4_findMinIndexNew();
    }

    static void test1(){
        Aron.beg();
        int[] arr = {4, 3, 2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex(arr, lo, hi);
        Test.t(index, 0);

        Aron.end();
    }


    static void test2(){
        Aron.beg();
        int[] arr = {1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex(arr, lo, hi);
        Test.t(index, 1);
        Aron.end();
    } 

    static void test3(){
        Aron.beg();
        int[] arr = {3};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex(arr, lo, hi);
        Test.t(index, 0);
        Aron.end();
    } 

    static void test4(){
        Aron.beg();
        int[] arr = {3, 4, 5, 1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex(arr, lo, hi);
        Test.t(index, 2);

        Aron.end();
    }

    static void test5(){
        Aron.beg();
        int[] arr = {3, 4, 5, 1, 2};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinIndexNegative(negative(arr), lo, hi);
        Test.t(index, 3); 

        Aron.end();
    }

    static void test6(){
        Aron.beg();
        int[] arr = {2, 1};
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMaxIndex(arr, lo, hi);
        Test.t(index, 0);

        Aron.end();
    }

    // assume there is not duplicated number in the array
    // find the index of maximum value in the rotated sorted array
    public static int findMaxIndex(int[] arr, int lo, int hi) {
        if(arr != null) {
            if(arr[lo] < arr[hi] || lo == hi)
                return hi;
            else {
                int mid = (lo + hi)/2;
                if(arr[lo] < arr[mid])
                    return findMaxIndex(arr, mid, hi);
                else
                    return findMaxIndex(arr, lo, mid);
            }
        }
        return -1;
    }

    // negative all values in the array
    public static int[] negative(int[] arr) {
        int[] tmpArr = new int[arr.length];
        int c=0;
        for(int e: arr) {
            tmpArr[c] = -e;
            c++;
        }
        return tmpArr;
    }

    // find the mininum index from a rotated sorted array
    public static int findMinIndex(int[] arr, int lo, int hi) {
        return findMaxIndex(arr, lo, hi);
    }
    
    public static int findMinIndexNegative(int[] arr, int lo, int hi) {
        if(arr != null) {
            if(arr[lo] > arr[hi] || lo == hi)
                return hi;
            else {
                int mid = (lo + hi)/2;

                if(arr[lo] < arr[mid])
                    return findMinIndexNegative(arr, mid, hi);
                else
                    return findMinIndexNegative(arr, lo, mid);
            }
        }
        return -1;
    }

    static void test0_findMinIndexNew(){
        Aron.beg();
        int[] arr = {1, 2, 3, 4}; 
        int lo = 0;
        int hi = arr.length - 1;
        int index = findMinIndexNew(arr, lo, hi);
        Test.t(findMinIndexNew(arr, lo, hi), 0);

        Aron.end();
    }
    static void test1_findMinIndexNew(){
        Aron.beg();
        int[] arr = {2, 3, 4, 1}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(findMinIndexNew(arr, lo, hi), 3);

        Aron.end();
    }
    static void test2_findMinIndexNew(){
        Aron.beg();
        int[] arr = {1, 2}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(findMinIndexNew(arr, lo, hi), 0);

        Aron.end();
    }
    static void test3_findMinIndexNew(){
        Aron.beg();
        int[] arr = {2, 1}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(findMinIndexNew(arr, lo, hi), 1);

        Aron.end();
    }
    static void test4_findMinIndexNew(){
        Aron.beg();
        int[] arr = {2, 3, 1}; 
        int lo = 0;
        int hi = arr.length - 1;
        Test.t(findMinIndexNew(arr, lo, hi), 2);

        Aron.end();
    }

    public static int findMinIndexNew(int[] arr, int lo, int hi){
        if(arr != null){
            if(arr[lo] < arr[hi] || lo == hi)
                return lo;
            else{
                int mid = 0;
                if((lo + hi) % 2 == 1)
                    mid = ((lo + hi)/2) + 1;
                else 
                     mid = (lo + hi)/2;

                if(arr[mid] < arr[hi])
                    return findMinIndexNew(arr, lo, mid);
                else
                    return findMinIndexNew(arr, mid, hi);
            }
        }
        return -1;
    }

}
