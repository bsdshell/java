import java.util.*;
import java.io.*;
import classfile.*;

public class TryCreateTree{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        Node r = createGeneralTree();
        print(r);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }

    public static void print(Node r){ 
        Print.p(r.data);
        for(Node n : r.list)
            print(n);
    }

    public static Node createGeneralTree(){
        Node r = new Node(1); 
        Node n1 = new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);

        Node nn1 = new Node(11);
        Node nn2 = new Node(12);
        Node nn3 = new Node(13);

        Node nn4 = new Node(14);
        Node nn5 = new Node(15);

        n1.list.add(nn1);
        n1.list.add(nn2);
        n1.list.add(nn3);

        n2.list.add(nn4);
        n2.list.add(nn5);

        r.list.add(n1);
        r.list.add(n2);
        r.list.add(n3);
        return r;
    }

} 

