import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryTry0{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        List<Integer> list = new ArrayList<Integer>(); 
        Donald_Trump(list);
        Aron.printList(list);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    public static void Donald_Trump(List<Integer> mlist){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        mlist = list.stream().collect(Collectors.toList());
        Aron.printList(mlist); 
    }
} 

