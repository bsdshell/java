import java.util.*;
import java.io.*;
import classfile.*;

public class TryTry6{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;

        Aron.printSLL(head);
        Ut.l();
        Node newHead = clone(head);

        Aron.printSLL(newHead);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    // [nu] => [nu]
    // [1]  => [1] 
    // [1]->[2]
    // [1]->[2]
    public static Node clone(Node oldCurr){
        Node head = null;
        Node newCurr = null;
        while(oldCurr != null){
            if(head == null)
                newCurr = head = new Node(oldCurr.data);
            else{
                newCurr.next = new Node(oldCurr.data);
                newCurr = newCurr.next;
            }

            oldCurr = oldCurr.next;
        }
        return head;
    }
    public static Node cloneRandom(Node oldCurr){
        Node head = null;
        Node newCurr = null;
        Map<Node, Node> map = new HashMap<Node, Node>();
        while(oldCurr != null){
            if(head == null){
                newCurr = head = new Node(oldCurr.data);
                if(oldCurr.random != null){
                    map.put(oldCurr.random, newCurr);
                }
            }
            else{
                newCurr.next = new Node(oldCurr.data);
                if(oldCurr.random != null){
                    map.put(oldCurr.random, newCurr.next);
                }
                newCurr = newCurr.next;
            }

            oldCurr = oldCurr.next;
        }
        return head;
    }
} 

