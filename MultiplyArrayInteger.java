import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*; 

class MultiplyArrayInteger {
    public static void main(String args[]) {
        test00();
        test0();
        test1();
    }

    //[ file=multiply.html title=""
    /**
    * Multiple all the integers except the current one
    * No Division is allowed
    * Runtime is O(n)
    * [2, 3, 4] => [3*4, 2*4, 2*3] => [12, 8, 6]
    */ 
    public static int[] multiple(int[] arr){
        if (arr == null){
            throw new IllegalArgumentException("arr must not be null.");
        }else{
            int len = arr.length;
            int[] arr1 = new int[len];
            int[] arr2 = new int[len];
            if(len > 1){
                arr1[0] = arr2[len-1] = 1;
                for(int i=1; i<len; i++){
                    arr1[i] = arr[i-1]*arr1[i-1];
                    arr2[len-1 - i] = arr[len-i]*arr2[len-i];
                }
                for(int i=0; i<len; i++)
                arr1[i] = arr1[i]*arr2[i];
            }
            return arr1;
        }
    } 
    //]
    public static void test00() {
        Aron.beg();
        int[] arr1 = {2}; 
        int[] arr = multiple(arr1);
        Aron.printArray(arr);

        Aron.end();
    }

    public static void test0() {
        Aron.beg();
        int[] arr1 = {2, 3}; 
        int[] arr = multiple(arr1);
        Aron.printArray(arr);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        int[] arr1 = {2, 3, 4}; 
        int[] arr = multiple(arr1);
        Aron.printArray(arr);
        Aron.end();
    }

}
