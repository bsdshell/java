import java.util.*;
import java.io.*;
import classfile.*;

public class TryMaxSum{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test00();
        test11();
        test22();
        test33();
        test44();
        test55();
        test66();
        test77();
        test88();
        test99();
    }
    public static void test0(){
        Aron.beg();
        int[] arr = {2,  -3, 2, 4}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test00(){
        Aron.beg();
        int[] arr = {2,  -3, 2, 4}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        int[] arr = {2}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 2);

        Aron.end();
    }
    public static void test11(){
        Aron.beg();
        int[] arr = {2, -3}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 2);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        int[] arr = {-1, 3}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 3);

        Aron.end();
    }
    public static void test22(){
        Aron.beg();
        int[] arr = {2, -2, 2, 3}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test33(){
        Aron.beg();
        int[] arr = {2, -3, -2, 4, -3, 5}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        int[] arr = {2, -3, 4}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 4);

        Aron.end();
    }
    public static void test4(){
        Aron.beg();
        int[] arr = {2, -3, 4, -2, 5}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 7);

        Aron.end();
    }
    public static void test44(){
        Aron.beg();
        int[] arr = {2, -3, 4, -2, 5}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 7);

        Aron.end();
    }
    public static void test5(){
        Aron.beg();
        int[] arr = {2, -3, 2, -2, 5}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test55(){
        Aron.beg();
        int[] arr = {2, -3, 2, -2, 5}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test66(){
        Aron.beg();
        int[] arr = {2, -3, 2, -2, 5, -3, 2, 1}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test77(){
        Aron.beg();
        int[] arr = {2, -3, 2, -2, 5, -3, 2, 1, 8, -3, 2}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 13);

        Aron.end();
    }
    public static void test88(){
        Aron.beg();
        int[] arr = {-2, -3, 4, 7, -8}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 11);

        Aron.end();
    }
    public static void test99(){
        Aron.beg();
        int[] arr = {-2, 0, 0, 7, -8}; 
        Aron.printArray(arr);
        int max = maxSum2(arr);
        Test.t(max, 7);

        Aron.end();
    }

    /**
    * [2] 
    * [2, -1]
    * [2, -1, -2]
    * [2, -1, -2, 4]
    * [0, 1]
    * [2, -1, 3]
    * [2, -3, 4]
    * Math.max(max, arr[i], sum + arr[i])
    */
    public static int maxSum2(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int max_start = 0;
        int max_end   = 0;
        int len = arr.length;
        for(int i=0; i<len; i++){
            if(sum + arr[i] >= 0){
                if(sum == 0) 
                    max_start = i;
                    
                int m = Math.max(arr[i], sum + arr[i]);

                if(m > max){
                    max = m;
                    max_end = i;
                }

                sum += arr[i];
            }else{
                sum = 0;
            }
        } 
        Print.p("max_start=" + max_start);
        Print.p("max_end  =" + max_end);
        return max;
    }
} 

