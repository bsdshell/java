import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

// multiply number
public class multtry{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        int [] arr1 = {9, 9};
        int [] arr2 = {2};
        int[] arr = mult(arr1, arr2);
        Aron.printArray(arr);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();

        int [] arr1 = {9, 9};
        int [] arr2 = {9};
        int[] arr = mult(arr1, arr2);
        Aron.printArray(arr);
        Aron.end();
    }
    public static int[] mult(int[] arr1, int[] arr2){
        int[] array = null;
        if(arr1 != null && arr2 != null){
            int len1 = arr1.length;
            int len2 = arr2.length;
            int len = len1 + len2;
            int[][] arr = new int[len1][len];
            for(int i = len1-1; i>= 0 ; i--){
                int c = 0;
                int j=0;
                for(j=len2-1; j>=0; j--){
                    int s = arr1[i]*arr2[j];
                        arr[i][i+j+1] = (s + c) % 10;
                        c = (s + c) / 10;
                }
                arr[i][i+j+1] = c;
            }

            array = new int[len];
            int c = 0;
            for(int i=len-1; i >=0; i--){

                int s = 0;
                for(int j=0; j<len1; j++){
                    s += arr[j][i];
                }
                array[i] = (s + c) % 10;
                c = (s + c) / 10;
            }
        }
        return array;
    }
} 

