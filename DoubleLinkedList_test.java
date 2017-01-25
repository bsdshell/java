import java.io.*;
import java.lang.String;
import classfile.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 

class DoubleLinkedList_test{
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
