import java.io.*;
import java.lang.String;
import classfile.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 

class DoubleLinkedList{
    public Node head;
    public Node tail;
    public DoubleLinkedList() {
        head = tail = null;
    }
    public void append(Node no) {
        if(head == null) {
            head = no;
            tail = head;
        } else {
            tail.next = no;
            no.prev = tail;;
            tail = tail.next;
        }
    }
    public void addFirst(Node no) {
        if(head == null) {
            head = no;
            tail = head;
        } else {
            head.prev = no;
            no.next = head;
            head = no;
        }
    }
    public void addNext(Node front, Node no) {
        if(front != null) {
            if(front.next == null) {
                append(no);
            } else {
                Node cur = no;
                Node prev = front;
                Node next = front.next;

                cur.prev = prev;
                cur.next = next;
                prev.next = cur;
                next.prev = cur;
            }
        }
    }
    public void delete(Node node) {
        Node curr = head;
        Node prev = null;
        while(curr != null){
            if(curr == node){
                if(prev == null){ 
                    head = curr.next;
                    if(head != null){   // [curr]->[]
                        curr.next.prev = null;
                        curr.next = null;
                    }else{
                        tail = null;  // [curr] 
                    }

                    curr.next = curr.prev = null;
                }else{  
                    prev.next = curr.next;
                    if(curr.next != null)    // []->[curr]->[] 
                        curr.next.prev = prev;
                    else
                        tail = prev;        // []->[curr] 

                    curr.next = curr.prev = null;
                }
                break;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void show() {
        Node cur = head;
        while(cur != null) {
            System.out.println ("cur=" + cur.data);
            cur = cur.next;
        }
    }

    public void toList(List<Node> list) {
        Node curr = head;
        while(curr != null) {
            list.add(curr);
            curr = curr.next;
        }
    }

    public void show1() {
        Node curr = tail;
        while(curr != null) {
            System.out.println ("rev curr=" + curr.data);
            curr = curr.prev;
        }
    }

}

class Dlinkedlist {
    public static void main(String args[]) {
        test0();
        test_addFirst();
        test_addNext();
        test_delete_first();
        test_delete_middle();
        test_delete_last();
        test_delete_one();
        test_delete_none();
    }
    
    static void test0(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        Node p3 = new Node(5);
        dll.append(p1);
        dll.append(p2);
        dll.append(p3);
        
        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.get(0).data, 3);
        Test.t(list.get(1).data, 4);
        Test.t(list.get(2).data, 5);

        Aron.end();
    }
    static void test_addFirst(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        dll.append(p1);
        dll.append(p2);

        Node firstNode  = new Node(9);
        dll.addFirst(firstNode);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.get(0).data, 9);
        Test.t(list.get(1).data, 3);
        Test.t(list.get(2).data, 4);

        Aron.end();
    }
    static void test_addNext(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        dll.append(p1);
        dll.append(p2);

        Node nextNode = new Node(9);
        dll.addNext(p1, nextNode);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.get(0).data, 3);
        Test.t(list.get(1).data, 9);
        Test.t(list.get(2).data, 4);

        Aron.end();
    }

    static void test_delete_last(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        Node p3 = new Node(5);
        dll.append(p1);
        dll.append(p2);
        dll.append(p3);

        dll.delete(p3);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.size() == 2);
        Test.t(list.get(0).data == 3);
        Test.t(list.get(1).data == 4);

        Aron.end();
    }
    static void test_delete_first(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        Node p3 = new Node(5);
        dll.append(p1);
        dll.append(p2);
        dll.append(p3);
        dll.delete(p1);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.size() == 2);
        Test.t(list.get(0).data == 4);
        Test.t(list.get(1).data == 5);

        Aron.end();
    } 
    static void test_delete_middle(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        Node p3 = new Node(5);
        dll.append(p1);
        dll.append(p2);
        dll.append(p3);
        dll.delete(p2);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.size() == 2);
        Test.t(list.get(0).data == 3);
        Test.t(list.get(1).data == 5);

        Aron.end();
    } 

    static void test_delete_one(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        dll.append(p1);
        dll.delete(p1);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.size() == 0);

        Aron.end();
    } 

    static void test_delete_none(){
        Aron.beg();

        DoubleLinkedList dll = new DoubleLinkedList();
        Node p1 = new Node(3);
        Node p2 = new Node(4);
        dll.append(p1);
        dll.delete(p2);

        List<Node> list = new ArrayList<Node>(); 
        dll.toList(list); 
        Test.t(list.size() == 1);
        Test.t(list.get(0).data == 3);

        Aron.end();
    } 
}
