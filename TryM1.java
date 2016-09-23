import java.util.*;
import java.io.*;
import classfile.*;

public class TryM1{
    public static void main(String[] args) {
        //test0();
        //test1();
        test2();
    }
    public static void test0(){
        Aron.beg();
        SingleLinkedList ss = new SingleLinkedList();
        ss.append(1);
        ss.append(2);
        ss.append(3);

        Node root = reverse(ss.head);
        Aron.printSLL(root);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        SingleLinkedList ss = new SingleLinkedList();
        ss.append(1);

        Node root = reverse(ss.head);
        Aron.printSLL(root);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        SingleLinkedList ss = new SingleLinkedList();
        ss.append(1);
        ss.append(2);
        ss.append(3);
        ss.append(4);

        Node root = reverse(ss.head);
        Aron.printSLL(root);

        Aron.end();
    }
    public static Node reverse2(Node r){
        Node prev = null;
        Node curr = null;
        Node next = null;
        while(r != null){
            curr = r;
            curr.next = prev;

            prev = curr;
            next = curr.next;


            curr = next;
        }
    }
    public static Node reverse(Node r){
        Node root = null;
        if(r != null){
            Stack<Node> stack = new Stack<>();
            while(r != null){
                stack.push(r);
                r = r.next;
            }

            Node curr = null;
            while(!stack.isEmpty()){
                if(root == null)
                    curr = root = stack.pop();
                else{
                    Node n = stack.pop();
                    n.next = null;
                    curr.next = n; 
                    curr = curr.next;
                    //curr.next = null;
                }
            }
        }
        return root;
    }
} 

