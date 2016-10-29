import java.util.*;
import java.io.*;
import classfile.*;

public class graphexample{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        Node root = createGraph();
        preorderGraph(root);
        Aron.line();
        postorderGraph(root);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    public static Node createGraph(){
        Aron.beg();
        Node root = new Node(1);
        Node n1= new Node(2);
        Node n2 = new Node(3);
        Node n3 = new Node(4);

        root.list.add(n1);
        root.list.add(n2);
        root.list.add(n3);

        Node nn1= new Node(22);
        Node nn2 = new Node(33);
        Node nn3 = new Node(44);

        Node nn11= new Node(222);
        Node nn22 = new Node(333);
        Node nn33 = new Node(444);

        n1.list.add(nn1);
        n1.list.add(nn2);
        n1.list.add(nn3);

        n2.list.add(nn11);
        n2.list.add(nn22);
        n2.list.add(nn33);

        return root;
    }

    public static void preorderGraph(Node curr){
        if(curr != null){
            Print.pbl(curr.data);
            for(Node n : curr.list){
                preorderGraph(n);
            }
        }
    }

    public static void postorderGraph(Node curr){
        if(curr != null){
            for(Node n : curr.list){
                postorderGraph(n);
            }
            Print.pbl(curr.data);
        }
    }
} 
