import java.util.*;
import java.io.*;
import classfile.*;
public class Dequeue{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();

        Deque<Node> queue = new ArrayDeque<Node>();
        queue.add(new Node(1));
        queue.add(new Node(2));
        System.out.println("size[" + queue.size() + "]"); 
        queue.poll();
        System.out.println("size[" + queue.size() + "]"); 

        Aron.end();
    }
} 
