import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;


public class Try1 {
    public static void main(String[] args) {
        test1();
        test2();
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
    static void test2(){
        Aron.beg();
        String str = "abc";
        String revStr = reverseW(str);
        System.out.println("[" + revStr + "]");
        System.out.println("[" + reverseWord(str) + "]");
        
        StringBuilder sb = new StringBuilder(str);
        System.out.println("[" + sb.reverse() + "]");
        Aron.end();
    }

    public static void test0(){
        List<Integer> list = new ArrayList<Integer>(); 
        Aron.printList(list);
        String dir = "/Users/cat/myfile";
        listFileDir(dir);
    }
    public static String reverseWord(String str){
        String ret = "";
        if(str != null){
            for(int i=0; i<str.length(); i++){
                ret = str.charAt(i) + ret;
            }
        }
        return ret;
    }
    public static String reverseW(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        int len = sb.length();
        for(int i=0; i<len/2; i++){
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(len - 1 - i));
            sb.setCharAt(len - 1 - i, ch);
        }
        return sb.toString();
    }

    public static void test1(){
        String str = "123";
        for(int i=0; i< str.length(); i++){
            String prefix = str.substring(0, i);
            String suffix = str.substring(i);
            System.out.println("[" + prefix + "]");
            System.out.println("[" + suffix + "]");
        }
    }

    public static void listDir(String directoryName){
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isDirectory()){
                System.out.println(file.getName());
            }
        }
    }

    public static void listFileDir(String directoryName){
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFileDir(file.getAbsolutePath());
            }
        }
    }
}
