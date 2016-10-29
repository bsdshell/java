import java.util.*;
import java.io.*;
import classfile.*;

public class MergeExtraSpace{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    static void test0(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 7, 9, 0}; 
        Integer[] arr2 = {3}; 
        int len = 4;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }

    static void test1(){
        Aron.beg();
        Integer[] arr1 = {4, 0}; 
        Integer[] arr2 = {3}; 
        int len = 1;



        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 4, 0}; 
        Integer[] arr2 = {3}; 
        int len = 3;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }

    static void test3(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 4, 0, 0, 0}; 
        Integer[] arr2 = {3, 9}; 
        int len = 3;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }
    static void test4(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 4, 0, 0, 0}; 
        Integer[] arr2 = {4, 5}; 
        int len = 3;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }

    static void test5(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 4, 0, 0, 0}; 
        Integer[] arr2 = {4, 5}; 
        int len = 3;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge2(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }

    static void test6(){
        Aron.beg();
        Integer[] arr1 = {1, 4, 4, 0, 0, 0}; 
        Integer[] arr2 = {2, 3}; 
        int len = 3;

        Aron.printArray(arr1);
        Aron.printArray(arr2);
        System.out.println("\n---------------------------------"); 

        merge2(arr1, len, arr2);
        Aron.printArray(arr1);

        Aron.end();
    }
    //[ file=mergespace.html title=""
    // 2, 4, [] []
    // [2] 3, {4}
    // [3]x
    public static void merge(Integer[] arr1, int len, Integer[] arr2){
        if(arr1 != null && arr2 != null){
            int len2 = arr2.length;
            for(int i=len-1; i>=0; i--){
                arr1[i+len2] = arr1[i];    
            }
            int p1 = len2;
            int p2 = 0; 
            int k = 0;

            while(p2 < len2 || p1 < len + len2){
                if(p2 >= len2){
                    arr1[k] = arr1[p1];
                    p1++;
                }else if(p1 >= len + len2){
                    arr1[k] = arr2[p2];
                    p2++;
                }else{
                    if(arr1[p1] < arr2[p2]){
                        arr1[k] = arr1[p1];
                        p1++;
                    }else{
                        arr1[k] = arr2[p2];
                        p2++;
                    }
                }
                k++;
            }
        }
    } 

    // [2][]
    // [3]
    public static void merge2(Integer[] arr1, int len1, Integer[] arr2){
        if(arr1 != null && arr2 != null){
            if(arr1.length > 0 || arr2.length > 0){
                int len2 = arr2.length;
                int k = len2 + len1 - 1;
                int p1 = len1 - 1;
                int p2 = len2 - 1;

                while(p1 >= 0 || p2 >= 0){ 
                    if(p1 < 0){
                        arr1[k] = arr2[p2];
                        p2--;
                    }else if(p2 < 0){
                        arr1[k] = arr1[p1];
                        p1--;
                    }else{
                        if(arr1[p1] > arr2[p2]){
                            arr1[k] = arr1[p1];
                            p1--;
                        }else{
                            arr1[k] = arr2[p2];
                            p2--;
                        }
                    }
                    k--;
                }
            }
        }
    }

    //]
} 
