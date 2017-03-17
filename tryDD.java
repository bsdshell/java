import java.util.*;
import java.io.*;
import classfile.*;

    
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
        System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
    } 

    
    Map<String, String> map = new HashMap<String, String>();
    for(Map.Entry<String, String> entry : map.entrySet()){
        System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
    }

    
    Map<String, Set<String>> map = new HashMap<>();
    Set<String> set1 = new HashSet<>(Arrays.asList("cat", "dog"));
    Set<String> set2 = new HashSet<>(Arrays.asList("cat", "dog", "cow"));
    map.put("key1", set1);
    map.put("key2", set2);
    for(Map.Entry<String, Set<String>> entry : map.entrySet()){
        Print.pbl("[" + entry.getKey() + "]->[" + entry.getValue() + "]");
        Print.line();
    } 


public class tryDD{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

