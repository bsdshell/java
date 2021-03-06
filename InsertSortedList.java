import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

// sorted linkedlist, sorted linked list
// gf SortedLinkedList.java
public class InsertSortedList{
    public static void main(String[] args) {
        test10();
        test11();
        test12();
        test13();
    }
    
    static void test10(){
        Aron.beg();
        SortedLinkedList sortll = new SortedLinkedList();

        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(1);
        sll.append(4);
        sll.append(7);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = sortll.insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }
    static void test11_thread(){
        Aron.beg();
        SortedLinkedList sortll = new SortedLinkedList();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(1);
        sll.append(4);
        sll.append(7);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = sortll.insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test11(){
        Aron.beg();
        SortedLinkedList sortll = new SortedLinkedList();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(1);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = sortll.insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test12(){
        Aron.beg();
        SortedLinkedList sortll = new SortedLinkedList();
        SingleLinkedList sll = new SingleLinkedList();        
        sll.append(4);
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = sortll.insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }
    static void test13(){
        Aron.beg();
        SortedLinkedList sortll = new SortedLinkedList();
        SingleLinkedList sll = new SingleLinkedList();        
        Aron.printSLL(sll.head);
        Aron.line();  

        Node head = sortll.insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }
}
