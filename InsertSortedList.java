import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;


public class InsertSortedList{
    public static void main(String[] args) {
        test10();
        test11();
        test12();
        test13();
    }
    
    static void test10(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(1);
        sll.append(4);
        sll.append(7);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test11(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(1);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test12(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(4);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }
    static void test13(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();        
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    //[ file=insertsortedlist.html title=""
    // Insert node to a sorted list
    public static Node insert(Node node, int n){
        Node head = node;
        Node curr = node; 
        Node prev = null; 
        while(curr != null && n > curr.data){
            prev = curr;
            curr = curr.next;
        }

        if(curr != null){
            if(prev != null){
                // 3, [2]<-[4]  >  [2]<-{3}<-[4]
                prev.next = new Node(n);
                prev.next.next = curr;
            }else{
                // {1} [2] > {1}<-[2]
                head = new Node(n);
                head.next = curr;
            }
        }else{
            // [2] {3}  > [2]<-{3}
            if(prev != null){
                prev.next = new Node(n);
            }else{
                // {3}
                head = new Node(n);
            }
        }
        return head;
    }
    //]
}
