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
        int m = 0;
        int max = 0;
        if(arr != null) {
            for(int i=0; i<arr.length; i++) {
                if(m + arr[i] > 0)
                    m = Math.max(m + arr[i], arr[i]);
                else
                    m = 0;

                if(m > max)
                    max = m;
            }
        }
        return max;
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
}

