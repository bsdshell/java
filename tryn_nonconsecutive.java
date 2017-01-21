import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class tryn_nonconsecutive{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
    public static void test0(){
        Aron.beg();
        Integer[] arr = {3, 4, 2};
        int width = arr.length; 
        int max = getMax(arr);
        Print.pbl("max=" + max);
        Test.t(max == 5);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Integer[] arr = {3};
        int width = arr.length; 
        int max = getMax(arr);
        Print.pbl("max=" + max);
        Test.t(max == 3);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        Integer[] arr = {3, 4, -1, 5, 2};
        int width = arr.length; 
        int max = getMax(arr);
        Print.pbl("max=" + max);
        Test.t(max == 9);

        Aron.end();
    }
    // 3, 4, 2
    public static int getMax(Integer[] arr){
        int pmax = 0;
        int max= Math.max(pmax, arr[0]); 
        for(int i=1; i<arr.length; i++){
            int m1 = Math.max(pmax + arr[i], arr[i]); // s_k is not in S
            int m2 = Math.max(max, arr[i]);  // s_k not in s
            pmax = max;
            max = Math.max(m1, m2);
        }
        return max;
    }
} 

