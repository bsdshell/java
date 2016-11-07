import java.util.*;
import java.io.*;
import classfile.*;

public class PartitionFB{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
    }
    public static void test0() {
        Aron.beg();

        Integer[] arr = {0, 2}; 
        Integer[] expectedArray = {2, 0}; 
        partition(arr);
        Aron.printArray(arr);
        Test.t(arr, expectedArray);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        Integer[] arr = {0}; 
        Integer[] expectedArray = {0}; 
        partition(arr);
        Aron.printArray(arr);
        Test.t(arr, expectedArray);

        Aron.end();
    }
    public static void test2() {
        Aron.beg();

        Integer[] arr = {1}; 
        Integer[] expectedArray = {1}; 
        partition(arr);
        Aron.printArray(arr);
        Test.t(arr, expectedArray);

        Aron.end();
    }
    public static void test3() {
        Aron.beg();

        Integer[] arr = {1, 0}; 
        Integer[] expectedArray = {1, 0}; 
        partition(arr);
        Aron.printArray(arr);
        Test.t(arr, expectedArray);

        Aron.end();
    }
    public static void test4() {
        Aron.beg();

        Integer[] arr = {0, 2, 0, 3, 0}; 
        Integer[] expectedArray = {2, 3, 0, 0, 0}; 
        partition(arr);
        Aron.printArray(arr);
        Test.t(arr, expectedArray);

        Aron.end();
    }
    public static void swap(Integer[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    //[ file=part3.html title=""
    // move all zeros to the right side of array
    // [1, 0, 3, 0] => [1, 3, 0, 0]
    public static void partition(Integer[] arr){
        if(arr != null){
            int zeroIndex = 0;
            int len = arr.length;
            for(int i=0; i<len; i++){
                if(arr[i].intValue() > 0){
                    if(i != zeroIndex)
                        swap(arr, i, zeroIndex);
                    // make sure the zeroIndex is not out of bounds
                    if(zeroIndex < len-1)
                        zeroIndex++;
                }
            }
        }
    }
    //]
}

