import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class SingleLinkedList_test{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test0(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        sll.append(n1);
        sll.print();

        Aron.end();
    }

    public static void test1(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        sll.append(n1);
        sll.remove(n1);

        sll.print();

        Aron.end();
    }

    public static void test2(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

//        sll.remove(n1);
        List<Node> list = sll.toList();
        Test.t(list.get(0).data == 1);
        Test.t(list.get(1).data == 2);
        Test.t(list.get(2).data == 3);

        sll.print();

        Aron.end();
    }
    public static void test3(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

        sll.remove(n1);
        List<Node> list = sll.toList();
        Test.t(list.get(0).data == 2);
        Test.t(list.get(1).data == 3);

        sll.print();

        Aron.end();
    }
    public static void test4(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

        sll.remove(n2);
        List<Node> list = sll.toList();
        Test.t(list.get(0).data == 1);
        Test.t(list.get(1).data == 3);

        sll.print();

        Aron.end();
    }

    public static void test5(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

        sll.remove(n3);
        List<Node> list = sll.toList();
        Test.t(list.get(0).data == 1);
        Test.t(list.get(1).data == 2);

        sll.print();

        Aron.end();
    }

    public static void test6(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

        sll.remove(n1);
        sll.remove(n2);
        List<Node> list = sll.toList();
        Test.t(list.get(0).data == 3);

        sll.print();

        Aron.end();
    }
    public static void test7(){
        Aron.beg();

        SingleLinkedList sll = new SingleLinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        sll.append(n1);
        sll.append(n2);
        sll.append(n3);

        sll.remove(n1);
        sll.remove(n2);
        sll.remove(n3);
        List<Node> list = sll.toList();
        Test.t(list.size() == 0);

        sll.print();

        Aron.end();
    }
} 

