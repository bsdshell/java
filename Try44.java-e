import java.util.*;
import java.io.*;
import classfile.*;
public class Try44{
    public static void main(String[] args) {
        test0();
        test1();
        test3();
        test4();
        test5();
    }
    static void test0(){
        Aron.beg();
        Map<String, SNode> map = new HashMap<String, SNode>(); 
        SNode n1 = new SNode(1);
        SNode n2 = new SNode(2);
        SNode n3 = new SNode(3);
        n1.next = n2;
        n2.next = n3;

        map.put("1", n1);
        Aron.printSLL(n1);

        map.put("1", new SNode(1));
        SNode nn = map.get("1");

        Aron.printSLL(nn);


        Aron.end();
    }
    public static Integer[] multiply(Integer[] arr1, Integer[] arr2){
        Integer[] arr3 = null;
        if(arr1 != null && arr2 != null){
            int len1 = arr1.length;
            int len2 = arr2.length;
            Integer[][] arr = new Integer[len1][len1 + len2];

            for(int j=0; j<len1; j++){
                for(int i=0; i<len1 + len2; i++){
                    arr[j][i] = 0;
                }
            }

            for(int i=len1-1; i >= 0; i--){
                int c = 0;
                int j = 0;
                int shift = len1 - 1 - i;
                for(j=len2 -1; j >= 0; j--){
                    int sum = arr1[i] * arr2[j] + c;
                    arr[i][j + (i+1)] = sum % 10;
                    c = sum / 10;
                }
                arr[i][j + (i+1)] = c;
            }

            arr3 = new Integer[len1 + len2];
            int carr = 0;
            for(int j=len1 + len2 -1; j >= 0; j--){
                Integer s = 0;
                for(int i=0; i<len1; i++){
                   s += arr[i][j];
                }
                s += carr;
                arr3[j] = s % 10;
                carr = s / 10;
            }
        }
        return arr3;
    }
    static void test1(){
        Aron.beg();
        int[][] arr = new int[1][0];
        int height = arr.length;
        int width =  height > 0 ? arr[0].length : 0;

        Aron.end();
    } 
    static void test3(){
        Aron.beg();
        Integer[] arr1 = {9, 9}; 
        Integer[] arr2 = {9, 9}; 
        Integer[] arr3 = multiply(arr1, arr2);
        Aron.printArray(arr1);
        Aron.printArray(arr2);
        Aron.printArray(arr3);
        Print.plb(99*99);

        Aron.end();
    } 
    static void test4(){
        Aron.beg();

        Integer[] arr1 = {9}; 
        Integer[] arr2 = {9}; 
        Integer[] arr3 = multiply(arr1, arr2);
        Aron.printArray(arr1);
        Aron.printArray(arr2);
        Aron.printArray(arr3);
        Print.plb(9*9);

        Aron.end();
    } 
    static void test5(){
        Aron.beg();

        Integer[] arr1 = {1, 2, 9}; 
        Integer[] arr2 = {9, 9}; 
        Integer[] arr3 = multiply(arr1, arr2);
        Aron.printArray(arr1);
        Aron.printArray(arr2);
        Aron.printArray(arr3);
        Print.plb(129*99);

        Aron.end();
    } 
} 
