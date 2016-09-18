import java.util.*;
import java.io.*;
import classfile.*;

public class Tryj1 {
    public static void main(String[] args) {
        test0();
        

        test1();
    }
    public static void test0() {
        Aron.beg();
        
        Random ran = new Random();
        // 0 - 9
        int num = ran.nextInt(10);
        Print.p(num); 
        
        List<String> list = new ArrayList<String>();
        List<String> list = new LinkedList<String>();
        List<String> list = new Stack<String>();
        List<String> list = new Vector<String>();
        Queue<String> queue = new ArrayList<String>();
        Queue<String> queue = new PriorityQueue<String>(); 

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        

        Aron.end();
    }
}

