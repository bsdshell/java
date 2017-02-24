import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
//
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
//
import classfile.*; 


public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
        test1();
    }
    static void test0(){
        Aron.beg();
        Set<String> set = new HashSet<String>(Arrays.asList("cat", "dog")); 
        List<String> list = new ArrayList(set);        
        Print.pbl(list);
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        
        List<String> list = new ArrayList<>(Arrays.asList("cat", "dog", "cow")); 
        Set<String> set = new HashSet<>(list);
        for(String s : set){
            Print.pbl(s);
        }

        Aron.end();
    }
}
