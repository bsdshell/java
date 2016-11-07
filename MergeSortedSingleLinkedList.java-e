import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

public class MergeSortedSingleLinkedList{
    public static void main(String[] args) {
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
    }
    

    static void test14(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();
        s1.append(4);
        s1.append(7);
        s1.append(9);

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        s2.append(1);
        s2.append(6);
        s2.append(11);
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    static void test15(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();
        s1.append(4);

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        s2.append(1);
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    static void test16(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        s2.append(1);
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    static void test17(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();
        s1.append(1);

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    static void test18(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();
        s1.append(1);
        s1.append(4);
        s1.append(9);

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }
    static void test19(){
        Aron.beg();
        SingleLinkedList s1 = new SingleLinkedList();
        s1.append(1);
        s1.append(4);
        s1.append(9);

        Aron.printSLL(s1.head);
        System.out.println("---------------------------------\n"); 
        SingleLinkedList s2 = new SingleLinkedList();
        s2.append(4);
        
        Aron.printSLL(s2.head);
        System.out.println("---------------------------------\n"); 

        Node head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    //[ file=mergesortedsll.html title=""
    static Node mergeSortedList(Node head1, Node head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        Node curr1 = head1;
        Node curr2 = head2;
        Node curr = null; 
        Node head = null;

        while(curr1 != null || curr2 != null){
            if(curr1 == null){
                if(curr != null)
                    curr.next = new Node(curr2.data);
                else
                    head = curr = new Node(curr2.data);

                curr2 = curr2.next;

            }else if(curr2 == null){
                if(curr != null)
                    curr.next = new Node(curr1.data);
                else
                    head = curr = new Node(curr1.data);

                curr1 = curr1.next;
            }else{
                if(curr1.data < curr2.data){
                    if(curr == null){
                        head = curr = new Node(curr1.data);
                    }else{
                        curr.next = new Node(curr1.data);
                    }

                    curr1 = curr1.next;
                }else{
                    if(curr == null)
                        head = curr = new Node(curr2.data);
                    else{
                        curr.next = new Node(curr2.data);
                    }

                    curr2 = curr2.next;
                }
            }

            if(curr.next != null)
                curr = curr.next;
        }
        return head;
    }
    //]
}
