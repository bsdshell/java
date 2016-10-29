import java.io.*;
import java.lang.String;
import java.util.*;

class Node {
    Node next;
    int data;
    public Node(int n) {
        next = null;
        data = n;
    }
}

class SLL {
    Node head;
    public SLL() {
        head = null;
    }
    public void append(Node no) {
        Node cur = head;
        if(head == null)
            head = no;
        else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = no;
        }
    }
    static Node next=null;
    public void Reverse(Node cur) {
        if(cur != null) {
            Reverse(cur.next);
            if(next != null)
                next.next = cur;
            else
                head = cur;
            next = cur;
            cur.next = null;
        }
    }
    public Node getHead() {
        return head;
    }
    public void Remove(Node no) {
        if(no != null && head != null) {
            Node curr = head;
            Node prev = null;
            while(curr != null && curr.data != no.data) {
                prev = curr;
                curr = curr.next;
            }
            if(curr != null) { //The node is in the list
                //prev
                //curr
                Node next = curr.next;
                if(prev == null && next == null) {
                    System.out.print("curr.data=1["+curr.data+"]");
                    head = curr = null;
                } else if(prev != null && next == null) {
                    System.out.print("curr.data=2["+curr.data+"]");
                    prev.next = null;
                    curr = null;
                } else if(prev == null && next != null) {
                    System.out.print("curr.data=3["+curr.data+"]");
                    head = next;
                    curr.next = null;
                    curr = null;
                } else { //if(prev != null && next != null)
                    System.out.print("curr.data=4["+curr.data+"]");
                    prev.next = next;
                    curr.next = null;
                    curr = null;
                }
            }
        }
        System.out.println();
    }
    public void show() {
        Node cur=head;
        while(cur != null) {
            System.out.println("cur.data=" + cur.data);
            cur=cur.next;
        }
    }
}

class ReverseSingleLinkedList {
    public static void main(String args[]) {
        SLL s = new SLL();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        s.append(n1);
        s.append(n2);
        s.append(n3);
        s.show();

        //s.Reverse(s.getHead());

        //System.out.println ("Reverse");
        //s.show();
        //Node h = Reverse2(s.getHead());
        //show(h);

        Node newH = ReverseIterationClone(s.getHead());
        s.Remove(n1);
        s.Remove(n2);
        //s.Remove(n3);
        //System.out.println ("Clone");
        System.out.println ("Clone and Reverse the list");
        show(newH);
        System.out.println ("Original List");
        show(s.getHead());

        /*
        System.out.println ("Stack Clone");
        Node head1 = ReverseCloneStack(s.getHead());
        show(head1);
        */
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
            System.out.print("-["+curr.data+"]");
            st.push(curr);
            curr = curr.next;
        }
        System.out.println();

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
    public static void show(Node curr) {
        while(curr != null) {
            System.out.println("["+curr.data+"]");
            curr = curr.next;
        }
    }
}
