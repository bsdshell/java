import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;

public class PartitionArray{
    public static void main(String[] args) {
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    
    static void test3(){
        Aron.beg();
        Integer[] arr = {2, 0, 3, 0};
        partition(arr);
        Aron.printArray(arr);
        Aron.end();
    } 
    static void test4(){
        Aron.beg();
        Integer[] arr = {2, 0, 3};
        partition(arr);
        Aron.printArray(arr);
        Aron.end();
    }
    static void test5(){
        Aron.beg();
        Integer[] arr = {0, 0, 2, 0, 0, 3, 2, 0, 3};
        partition(arr);
        Aron.printArray(arr);
        Aron.end();
    }
    static void test6(){
        Aron.beg();
        Integer[] arr = {0, 0, 0, 0, 0};
        Aron.printArray(arr);
        Aron.end();
    } 
    static void test7(){
        Aron.beg();
        Integer[] arr = {2, 3};
        Aron.printArray(arr);
        Aron.end();
    } 

    //[ file=partitionarray.html title=""
    static void partition(Integer[] arr){
        if(arr != null){
            int len = arr.length;
            int nonzero = len-1;
            for(int i=len-1; i >= 0; i--){
                if(arr[i] == 0){
                    int tmp = arr[i];
                    arr[i] = arr[nonzero];
                    arr[nonzero] = tmp;
                    nonzero--;
                }
            }
        }
    }
    //]
}
