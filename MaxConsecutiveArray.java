import java.util.*;
import java.io.*;
import classfile.*;

public class MaxConsecutiveArray{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();

        test00();
        test11();
    }
    //[ file=consecutive.html title=""
    //  4, -5, 9, 7, -8, 3
    //--------------------------------------------------------------------------------
    // m = 0
    // max = 0
    //--------------------------------------------------------------------------------
    // m = max(m, m+3) = 3
    // max = 3
    //--------------------------------------------------------------------------------
    // m = max(m, m+-8) = -5 = 0
    // max = 3
    //--------------------------------------------------------------------------------
    // m = max(m, m+7) = 7
    // max = 7
    //--------------------------------------------------------------------------------
    // m = max(m, m+9) = 16
    // max = 16
    //--------------------------------------------------------------------------------
    // m = max(m, m -5) = 11
    // max = 16
    //--------------------------------------------------------------------------------
    // m = max(m, m + 4) = 15
    // max = 16
    //-------------------------------------------------------------------------------- 
    public static int maxConsecutive(int[] arr) {
        int m = 0, max = 0;
        int startIndex = 0;
        int endIndex   = 0;
        if(arr != null) {
            for(int i=0; i<arr.length; i++) {
                if(m + arr[i] > 0){
                    m = Math.max(m + arr[i], arr[i]);

                    if(m > max){
                        max = m;
                    }
                }
                else{
                    m = 0;
                }
            }
        }
        return max;
    }
    //]

    //[ file=maxsumnegative.html  title=""
    public static int maxConsecutiveNegative(int[] arr) {
        int max_so_far = arr[0], currMax = arr[0];
        if(arr != null) {
            for(int i=1; i<arr.length; i++) {
                max_so_far = Math.max(arr[i], currMax + arr[i]);
                currMax = Math.max(currMax, max_so_far);
            }
        }
        return currMax;
    }
    //]

    static void test0() {
        Aron.beg();
        int[] arr = {1, -2, 8, 9, -4, 5};
        int max = maxConsecutive(arr);
        Aron.printArray(arr);
        Test.t(max, 18);
        Aron.end();
    }

    static void test1() {
        Aron.beg();
        int[] arr = {1};
        int max = maxConsecutive(arr);
        Aron.printArray(arr);
        Test.t(max, 1);
        Aron.end();
    }
    static void test2() {
        Aron.beg();
        int[] arr = {1, -9};
        int max = maxConsecutive(arr);
        Aron.printArray(arr);
        Test.t(max, 1);
        Aron.end();
    }
    static void test3() {
        Aron.beg();
        int[] arr = {4, 1, -9, 10};
        int max = maxConsecutive(arr);
        Aron.printArray(arr);
        Test.t(max, 10);
        Aron.end();
    }
    static void test4() {
        Aron.beg();
        int[] arr = {4, 1, -9, 10, 4, -5, 7};
        int max = maxConsecutive(arr);
        Aron.printArray(arr);
        Test.t(max, 16);
        Aron.end();
    }
    public static void test5(){
        Aron.beg();
        int[] arr = {2, -3, -2, 4, -3, 5}; 
        Aron.printArray(arr);
        int max = maxConsecutive(arr);
        Test.t(max, 6);

        Aron.end();
    }
    public static void test6(){
        Aron.beg();
        int[] arr = {2, -3, 2, -2, 5, -3, 2, 1}; 
        Aron.printArray(arr);
        int max = maxConsecutive(arr);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test7(){
        Aron.beg();
        int[] arr = {-2, 0, 0, 7, -8}; 
        Aron.printArray(arr);
        int max = maxConsecutive(arr);
        Test.t(max, 7);

        Aron.end();
    }
    public static void test8(){
        Aron.beg();
        int[] arr = {-2, -3, -1, -4, -8}; 
        Aron.printArray(arr);
        int max = maxConsecutiveNegative(arr);
        Test.t(max, -1);

        Aron.end();
    }
    public static void test00(){
        Aron.beg();
        int[] arr = {-2, -3, -1, -4, -8}; 
        Aron.printArray(arr);
        int max = maxConsecutiveNegative(arr);
        Test.t(max, -1);

        Aron.end();
    }
    public static void test11(){
        Aron.beg();
        int[] arr = {-2, 0, 0, 7, -8}; 
        Aron.printArray(arr);
        int max = maxConsecutiveNegative(arr);
        Test.t(max, 7);

        Aron.end();
    }

}
