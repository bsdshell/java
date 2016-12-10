import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class ReverseSingleLinkedList {
    public static void main(String args[]) {
        test0();
        test1();
        test2();
    }
    static void test0(){
        Aron.beg();
        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        s.append(n1);
        s.append(n2);
        s.append(n3);
        s.print();
        Node head = ReverseIterationClone(s.head);
        s.Remove(n1);
        s.Remove(n2);
        Print.pbl("Clone and Reverse the list");
        Aron.printSLL(head);
        Ut.l();
        Print.pbl("Original List");
        Aron.printSLL(s.head);
        Aron.end();
    }
    static void test1(){
        Aron.beg();

        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        s.append(n1);
        s.append(n2);
        s.append(n3);
        s.print();
        Ut.l();
        Node head = Reverse3(s.head);
        Aron.printSLL(head);

        Aron.end();
    }
    static void test2(){
        Aron.beg();

        SingleLinkedList s = new SingleLinkedList();
        Node n1 = new Node(1);
        s.append(n1);
        s.print();
        Ut.l();
        Node head = Reverse3(s.head);
        Aron.printSLL(head);

        Aron.end();
    }
    static Node head = null;
    public static Node Reverse(Node curr) {
        if(curr != null) {
            Node node = Reverse(curr.next);
            if(node != null) {
                node.next = curr;
                curr.next = null;
            } else {
                head = curr;
            }
        }
        return curr;
    }

    public static Node Reverse2(Node curr) {
        Node tmp = null;
        if(curr == null)
            return null;
        else if(curr.next == null)
            return curr;
        else {
            tmp = Reverse2(curr.next);
            curr.next.next = curr;
            curr.next = null;
        }
        return tmp;
    }

    public static Node Reverse3(Node curr) {
        Node tmpHead = null;
        if(curr != null){
            tmpHead = Reverse3(curr.next);
            if(tmpHead == null)
                tmpHead = curr;
            else{
                curr.next.next = curr;
                curr.next = null;
            }
        }
        return tmpHead;
    }
    // Modified the original list
    public static Node ReverseOriginalList(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null) {
            Node tmpNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmpNext;
        }
        return prev;
    }
    //Clone the original list and reverse it
    public static Node ReverseIterationClone(Node head) {
        Node curr = head;
        Node prev = null;
        Node newCurr = null;
        Node newPrev = null;
        while(curr != null) {
            newCurr = new Node(curr.data);

            Node newNext = newCurr.next;
            newCurr.next = newPrev;

            newPrev = newCurr;
            newCurr = newNext;
            curr = curr.next;
        }
        return newPrev; //return head
    }
    public static Node ReverseCloneStack(Node mycurr) {
        Stack<Node> st = new Stack<Node>();
        Node curr = mycurr;
        while(curr != null) {
            Print.pbl(curr.data);
            st.push(curr);
            curr = curr.next;
        }
        Ut.l();

        Node head = null;
        Node newPrev = null;
        Node newCurr = null;
        while(!st.isEmpty()) {
            newCurr = new Node(st.pop().data);
            if(newPrev != null)
                newPrev.next = newCurr;
            else
                head= newCurr;
            newPrev = newCurr;
        }
        return head;

    }
    public static Node ReverseClone(Node head) {
        Node curr = head;
        Node prev = null;
        Node newCurr = null;
        Node newPrev = null;
        while(curr != null) {
            newCurr = new Node(curr.data);

            curr.next = prev;
            newCurr.next = newPrev;

            prev = curr;
            curr = curr.next;
            newPrev = newCurr;
            newCurr = newCurr.next;
        }
        return newPrev;
    }
}
