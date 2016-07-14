import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

class Interval implements Comparable<Interval> {
    public int begin;
    public int end;
    public Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    public int compareTo(Interval inter) {
        if(this.begin > inter.begin)
            return 1;
        else if(this.begin == inter.begin)
            return 0;
        else
            return -1;
    }
    public String toString() {
        return "[" + begin + " " + end + "]";
    }
}

public class Hello {
    public static void main(String[] args) {
        test0();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test00();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
        test19();
    }
    static void test00() {
        Aron.beg();
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>();
        Stack<Interval> stack = new Stack<Interval>();
        int[] arr1 = {4, 1, 2, 6, 9};
        int[] arr2 = {5, 1, 4, 9, 10};

        for(int i=0; i<arr1.length; i++) {
            queue.add(new Interval(arr1[i], arr2[i]));
        }
        if(queue.size() > 0) {
            stack.push(queue.remove());
        }
        while(!queue.isEmpty()) {
            Interval top = stack.peek();
            Interval inter = queue.remove();
            if(top.end < inter.begin)
                stack.push(inter);
            else {
                stack.peek().end = Math.max(stack.peek().end, inter.end);
            }
        }
        while(!stack.empty()) {
            System.out.println("[" + stack.peek().begin + " " + stack.peek().end + "]");
            stack.pop();
        }

        Aron.end();
    }

    static void test0() {
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

    static void test2() {
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

    static void test3() {
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
    static void test4() {
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
    static void test5() {
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head);
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }

    static void test6() {
        System.out.println("\n--------------------------------------------------------------------------------");
        Aron.name();
        SingleLinkedList sll = new SingleLinkedList();
        Aron.printSLL(sll.head);
        SNode newHead = reversePair(sll.head);
        Aron.printSLL(newHead);
        System.out.println("\n--------------------------------------------------------------------------------");
    }
    static void test7() {
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        Aron.printSLL(sll.head);

        SNode nhead = reverseLinkedList(sll.head);
        Aron.printSLL(nhead);

        Aron.end();
    }

    static void test8() {
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        Aron.printSLL(sll.head);

        SNode nhead = reverseIte(sll.head);
        Aron.printSLL(nhead);
        Aron.end();
    }

    static void test9() {
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);

        SingleLinkedList sll2 = new SingleLinkedList();
        sll2.append(1);
        sll2.append(2);
        sll2.append(3);


        SNode curr = sll.head;
        SNode head = sll.head;

        while(curr != null && curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;

        boolean circular = isCircular(sll.head);
        System.out.println("isCircular[" + circular + "]");

        boolean circular2 = isCircular(sll2.head);
        System.out.println("isCircular2[" + circular2 + "]");

        Aron.end();
    }
    static void test10(){
        Aron.beg();
        String str = "";
        System.out.println("empty str " + str + "[" + isBalance(str) + "]");

        str = "()";
        System.out.println("" + str + "[" + isBalance(str) + "]");
        str = "(";
        System.out.println("" + str + "[" + isBalance(str) + "]");
        str = "(]";
        System.out.println("" + str + "[" + isBalance(str) + "]");
        str = "([)]";
        System.out.println("" + str + "[" + isBalance(str) + "]");
        str = "()([])";
        System.out.println("" + str + "[" + isBalance(str) + "]");
        Aron.end();
    }
    
    static void test11(){
        Aron.beg();
        SingleLinkedList ssl = new SingleLinkedList();
        ssl.append(4);
        ssl.append(7);
        ssl.append(9);
        Aron.printSLL(ssl.head);
        SNode h = insertNodeToSortedList(ssl.head, 3);
        Aron.printSLL(h);
        Aron.end();
    }

    static void test12(){
        Aron.beg();
        SingleLinkedList ssl = new SingleLinkedList();
        ssl.append(4);
        ssl.append(7);
        ssl.append(9);
        Aron.printSLL(ssl.head);
        SNode h = insertNodeToSortedList(ssl.head, 3);
        h = insertNodeToSortedList(ssl.head, 5);
        Aron.printSLL(h);
        Aron.end();
    }

    static void test13(){
        Aron.beg();
        SingleLinkedList ssl = new SingleLinkedList();
        ssl.append(4);
        ssl.append(7);
        ssl.append(9);
        Aron.printSLL(ssl.head);
        SNode newHead = insertNodeToSortedList(ssl.head, 15);
        Aron.printSLL(newHead);
        Aron.end();
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

        SNode head = mergeSortedList(s1.head, s2.head);
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

        SNode head = mergeSortedList(s1.head, s2.head);
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

        SNode head = mergeSortedList(s1.head, s2.head);
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

        SNode head = mergeSortedList(s1.head, s2.head);
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

        SNode head = mergeSortedList(s1.head, s2.head);
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

        SNode head = mergeSortedList(s1.head, s2.head);
        Aron.printSLL(head);
        Aron.end();
    }

    //[ file=nextnext.html title=""
    public static SNode reverseIte(SNode curr) {
        SNode prev = null;
        SNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static SNode reverseLinkedList(SNode curr) {
        if(curr == null || curr.next == null)
            return curr;

        SNode head = reverseLinkedList(curr.next);
        curr.next.next = curr;
        curr.next = null;

        return head;
    }

    public static SNode reversePair(SNode head) {
        SNode curr = head;
        while(curr != null && curr.next != null) {
            int tmp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = tmp;

            curr = curr.next.next;
        }
        return head;
    }

    public static boolean isCircular(SNode curr) {
        if(curr == null)
            return false;
        else {
            SNode next = curr.next;
            if(curr == next)
                return true;

            while(next != null) {
                if(curr == next)
                    return true;

                curr = curr.next;

                next = next.next;
                if(next != null)
                    next = next.next;
            }
        }
        return false;
    }
    //]


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

//    static boolean isBal(String str, int index){
//        if(str != null && index < str.length()){
//            if(!isBal(str, index + 1))
//                return false;
//
//            if(str.charAt(index) == '(' || str.charAt(index) == '[')
//                return isBal(str, index + 1);
//            else
//                return false;
//
//            else if(str.charAt(index) == ')'){
//               if(index - 1 >= 0 && str.charAt(index - 1) == '(') 
//                   return isBal(str, index + 1);
//               else
//                   return false;
//            }else if(str.charAt(index) == ']'){
//               if(index - 1 >= 0 && str.charAt(index - 1) == '[') 
//                   return isBal(str, index + 1);
//               else
//                   return false;
//            }
//        }
//        return true;
//    }

    static SNode mergeSortedList(SNode head1, SNode head2){
        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        SNode curr1 = head1;
        SNode curr2 = head2;
        SNode curr = null; 
        SNode head = null;

        while(curr1 != null || curr2 != null){
            if(curr1 == null){
                if(curr != null)
                    curr.next = new SNode(curr2.data);
                else
                    head = curr = new SNode(curr2.data);

                curr2 = curr2.next;

            }else if(curr2 == null){
                if(curr != null)
                    curr.next = new SNode(curr1.data);
                else
                    head = curr = new SNode(curr1.data);

                curr1 = curr1.next;
            }else{
                if(curr1.data < curr2.data){
                    if(curr == null){
                        head = curr = new SNode(curr1.data);
                    }else{
                        curr.next = new SNode(curr1.data);
                    }

                    curr1 = curr1.next;
                }else{
                    if(curr == null)
                        head = curr = new SNode(curr2.data);
                    else{
                        curr.next = new SNode(curr2.data);
                    }

                    curr2 = curr2.next;
                }
            }

            if(curr.next != null)
                curr = curr.next;
        }
        return head;
    }

    static SNode insertNodeToSortedList(SNode head, int num){
       SNode curr = head; 
       SNode prev = null;

       while(curr != null){
           if(curr.data < num){
               prev = curr;
               if(curr.next == null){
                   prev.next = new SNode(num);
                   return head;
               }
           }else{
               if(prev != null){
                   prev.next = new SNode(num);
                   prev.next.next = curr;
                   return head;
               }else{
                   // first node
                   SNode node = new SNode(num);
                   node.next = curr;
                   head = node;
                   return head;
               }
           }
           curr = curr.next;
       }
       return head;

    }

    static boolean isBalance(String str) {
        Stack<String> stack = new Stack<String>();
        if(str != null) {
            for(int i=0; i<str.length(); i++) {
                String s = str.charAt(i) + "";
                if(s.equals("(") || s.equals("[")) {
                    stack.push(s);
                } else {
                    if(s.equals(")")) {
                    if(!stack.empty() && stack.peek().equals("(")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else if(s.equals("]")) {
                    if(!stack.empty() && stack.peek().equals("[")) {
                            stack.pop();
                        } else {
                            return false;
                        }
                    } else {
                        System.out.println("Error");
                        return false;
                    }

                }
            }
        }
        return stack.empty();
    }
}
