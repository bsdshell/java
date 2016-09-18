import java.util.*;
import java.io.*;
import classfile.*;

public class MaxDiff{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0() {
        Aron.beg();
        int[] arr = {2, 4}; 
        int max = maxDiff(arr);
        Test.t(max, 2);
        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        int[] arr = {2, 4, 7, 1, 7, 2}; 
        int max = maxDiff(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test2() {
        Aron.beg();
        int[] arr = {4, 1, 7}; 
        int max = maxDiff(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        int[] arr = {15, 10, 17, 1, 9}; 
        int max = maxDiff(arr);
        Test.t(max, 8);

        Aron.end();
    }

    //[file=maxdiff.html title=""
    // [2, 4, 7, 1, 7, 2]
    // [4, 2] => 0
    // [1, 3, 4]
    // [3, 1, 7]
    public static int maxDiff(int[] arr){
        int maxDiff = 0;
        if(arr != null && arr.length > 1){
            int len = arr.length;
            int min = arr[0];
            for(int i=1; i<len; i++){

                if(arr[i-1] < min)
                    min = arr[i-1];
                    
                if(arr[i] - min > maxDiff)
                    maxDiff = arr[i] - min;
            } 
        }
        return maxDiff;
    }
    //]
}

