import java.util.*;
import java.io.*;
import classfile.*;

public class NonConsecutive{
    public static void main(String[] args) {
         test00_maxNonConsecutiveSum();
         test01_maxNonConsecutiveSum();
         test02_maxNonConsecutiveSum();
         test03_maxNonConsecutiveSum();
         test04_maxNonConsecutiveSum();
    }

    //[file=nonconsecutive.html title="maximum consecutive sum"
    // [ ] {4} 5
    // 
    // [4, 7]
    // m = 4
    // curr = 7 
    // max = 4 
    // => max = 7
    // --------------- 
    // [4, 7, 5]
    // m = 4 
    // curr = 7
    // max = 4
    // ------
    // m = 7
    // curr = 4 + 5 
    // max = 7
    // => max(9, 7) = 9
    // ---------------
    public static int maxNonConsecutiveSum(int[] arr){
        int max = 0;
        if(arr != null && arr.length > 0){
            int len = arr.length;
            int pmax = 0;
            max = arr[0];
            for(int i=1; i<len; i++){
                int m1 = Math.max(pmax + arr[i], arr[i]);
                int m2 = Math.max(max, arr[i]);
                pmax = max;
                max = Math.max(m1, m2);
            } 
        }
        return max;
    }
    //]

    static void test00_maxNonConsecutiveSum(){
        Aron.beg();
        int[] arr = {4}; 
        int max = maxNonConsecutiveSum(arr);
        Test.t(max, 4);
        Aron.end();
    }
    static void test01_maxNonConsecutiveSum(){
        Aron.beg();
        int[] arr = {4, 7}; 
        int max = maxNonConsecutiveSum(arr);
        Test.t(max, 7);
        Aron.end();
    }
    static void test02_maxNonConsecutiveSum(){
        Aron.beg();
        int[] arr = {4, 7, 5}; 
        int max = maxNonConsecutiveSum(arr);
        Test.t(max, 9);
        Aron.end();
    }
    static void test03_maxNonConsecutiveSum(){
        Aron.beg();
        int[] arr = {4, 7, 5, 9, 1, 2, -4, 20}; 
        int max = maxNonConsecutiveSum(arr);
        Test.t(max, 38);
        Aron.end();
    }
    static void test04_maxNonConsecutiveSum(){
        Aron.beg();
        int[] arr = {4, 7, 5, 9, 90, 100}; 
        int max = maxNonConsecutiveSum(arr);
        Test.t(max, 116);
        Aron.end();
    }
}

