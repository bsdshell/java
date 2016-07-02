import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;


public class Try1 {
    public static void main(String[] args) {
        //test0();
        test1();
    }

    public static void test0(){
        List<Integer> list = new ArrayList<Integer>(); 
        Aron.printList(list);
        String dir = "/Users/cat/myfile";
        listFileDir(dir);
    }

    public static void test1(){
        String dir = "/Users/cat/try";
        listDir(dir);
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
