import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

// swap nodes in single linkedlist, swap nodes, switch nodes
// add two dumpy nodes to two ends
public class SwapLinkedListNode{
    public static void main(String[] args) {
//        test0();
//        test1();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    public static void test0(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(4);
        sll.append(8);
        sll.print();

        Ut.l();
        sll.addFirst(new Node(0));
        sll.append(9);
        sll.print();

        Aron.end();
    }
    public static void test1(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(4);
        sll.append(8);
        sll.addFirst(0);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int n = sll.count();
        Print.pbl("c=" + n);
        Ut.l();
        sll.print();

        Aron.end();
    }
    static void test3(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        sll.append(c1);
        sll.append(c2);
        sll.append(c3);
        sll.addFirst(0);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->3");
        swapTwoNodes(sll.head, c1, c3);
        sll.print();

        Aron.end();
    } 
    static void test4(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        sll.append(c1);
        sll.append(c2);
        sll.append(c3);
        sll.addFirst(0);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->2");
        swapTwoNodes(sll.head, c1, c2);
        sll.print();

        Aron.end();
    } 
    static void test5(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        sll.append(c1);
        sll.append(c2);
        sll.append(c3);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->2");
        swapTwoNodes(sll.head, c1, c2);
        sll.print();

        Aron.end();
    } 
    static void test6(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        sll.append(c1);
        sll.append(c2);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->1");
        swapTwoNodes(sll.head, c1, c1);
        sll.print();

        Aron.end();
    } 
    static void test7(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        Node c2 = new Node(2);
        Node c3 = new Node(3);
        sll.append(c1);
        sll.append(c2);
        sll.append(c3);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->1");
        swapTwoNodes(sll.head, c1, c1);
        sll.print();

        Aron.end();
    } 
    static void test8(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node c1 = new Node(1);
        sll.append(c1);
        sll.addFirst(new Node(null));
        sll.append(new Node(null));
        sll.print();
        int num = sll.count();
        Print.pbl("c=" + num);
        sll.print();
        Ut.l();
        Print.pbl("1<->1");
        swapTwoNodes(sll.head, c1, c1);
        sll.print();

        Aron.end();
    } 
    public static void swapTwoNodes(Node head, Node n1, Node n2){
        Node p = null;
        Node n = null;
        Node pp = null;
        Node nn = null;
        Node n1_ = null;
        Node n2_ = null;
        Node prev = null;
        Node curr = head;
        while(curr != null){
            if(curr == n1 || curr == n2){
                    if(n1_ == null){
                        p = prev;
                        n1_ = curr;
                        n = curr.next; 
                    }else if(n2_ == null){
                        pp = prev;
                        n2_ = curr;
                        nn = curr.next;
                    }

                    if(n1_ != null && n2_ != null) {
                        // adjacent nodes
                        if(n == n2_){
                            p.next = n2_;
                            n2_.next = n1_;
                            n1_.next = nn;
                        }else{
                            // non adjacent nodes
                            p.next = n2_;    
                            n2_.next = n;
                            pp.next = n1_;
                            n1_.next = nn;
                        }
                        break;
                    }
            }
            prev = curr;
            curr = curr.next;
        }
    }
} 

