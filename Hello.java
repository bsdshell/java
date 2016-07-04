import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

public class Hello {
    public static void main(String[] args) {
        test0();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    
    static void test0(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(5);
        sll.append(4);
        sll.append(2);
        Aron.printSLL(sll.head);
        SNode newHead = cloneLinkedList(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }

    static void test2(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }

    static void test3(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.append(4);
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }
    static void test4(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }
    static void test5(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }
    static void test6(){
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head); 
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }

    public static SNode reversePair(SNode head){
        SNode curr = head;
        while(curr != null && curr.next != null){
            int tmp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = tmp;

            curr = curr.next.next;
        }
        return head;
    }

    static SNode cloneLinkedList(SNode head) {
        SNode newHead = null;
        SNode newCurr = null;
        SNode curr = head;

        if(curr != null) {
            newCurr = newHead = new SNode(head.data);

            while(curr.next != null) {
                newCurr.next = new SNode(curr.next.data);
                newCurr = newCurr.next;
                curr = curr.next;
            }
        }
        return newHead;
    }
}
