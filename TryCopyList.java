import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryCopyList{
    public static void main(String[] args) {
        test0();
        test1();
    }

    public static void test0(){
        Aron.beg();
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3)); 
        List<Integer> ll = list.stream().collect(Collectors.toList()); 
        Aron.printList(ll);
        

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }

    public static void copyList(){
    }
} 

