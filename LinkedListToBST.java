import java.util.*;
import java.io.*;
import classfile.*;

public class LinkedListToBST{
    public static void main(String[] args) {
        //test0_buildTree();
        test01_buildTree();
        test2_middleLinkedList();
        test3_middleLinkedList();
        test4_buildTree2();
        test0_buildTree3();
        test0_buildTree4();
    }
    static void test0_buildTree() {
        Aron.beg();
        int[] arr = {1, 2, 3, 4};
        int lo = 0;
        int hi = arr.length-1;
        Node root = buildTree(arr, lo, hi);
        Aron.levelOrder(root);
        Aron.inorder(root);
        Aron.binImage(root);

        Aron.end();
    }

    static void test01_buildTree() {
        Aron.beg();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        int lo = 0;
        int hi = arr.length-1;
        Node root = buildTree(arr, lo, hi);
        Aron.levelOrder(root);
        Aron.inorder(root);
        Aron.binImage(root);

        Aron.end();
    }
    public static Node buildTree(int[] arr, int lo, int hi) {
        if(lo <= hi) {
            int mid = 0;
            if ((lo + hi)%2 == 1)
                mid = (lo + hi)/2 + 1;
            else
                mid = (lo + hi)/2;
            Node parent = new Node(arr[mid]);
            parent.left = buildTree(arr, lo, mid-1);
            parent.right = buildTree(arr, mid+1, hi);
            return parent;
        }
        return null;
    }
    static int index = 0;
    public static Node buildTree2(int[] arr, int count){
        if(count == 0)
            return null;
        else{
            Node left = buildTree2(arr, count/2);
            Node parent = new Node(arr[index]);
            parent.left = left;

            index++;
            parent.right = buildTree2(arr, count - count/2 - 1);
            return parent;
        }
    }

    public static Node buildTree3(Iterator<Integer> ite, int count){
        if(count == 0)
            return null;
        else{
            Node left = buildTree3(ite, count/2);
            Node parent = new Node(ite.next());
            parent.left = left;

            parent.right = buildTree3(ite, count - count/2 - 1);
            return parent;
        }
    }

    static void test0_buildTree3(){
        Aron.beg();
        Integer[] arr = {1, 2, 3, 4}; 
        final Iterator<Integer> ite = Arrays.asList(arr).iterator();
        int count = arr.length;
        Node parent = buildTree3(ite, count);
        Aron.inorder(parent);
        Aron.line();
        Aron.preorder(parent);

        Aron.end();
    }

    static void test0_buildTree4(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);

        int count = 3;
        Node parent = buildTree4(sll.head, count);

        Aron.inorder(parent);
        Ut.l();
        Aron.preorder(parent);

        Aron.end();
    }
    public static Node buildTree4(Node curr, int count){
        if(count == 0)
            return null;
        else{
            Node left = buildTree4(curr, count/2);
            Node parent = new Node(curr.data);
            parent.left = left;
            parent.right = buildTree4(curr.next, count - count/2 - 1);
            return parent;
        }
    }

    public static Node middleLinkedList(Node head){
        int steps = 2;
        int count = 0;

        Node first = head;
        if(first != null) {
            Node second = first.next;
            while(second != null && second.next != null) {
                first = first.next;
                while(count < steps && second != null) {
                   second = second.next;
                    count++;
                }
                steps++;
                count = 0;
            }
        }
        return first;
    }

    static void test2_middleLinkedList(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        sll.append(3);
        sll.append(4);
        Aron.printSLL(sll.head);
        Node node = middleLinkedList(sll.head);
        Test.t(node.data, 2);

        Aron.end();
    } 
    static void test3_middleLinkedList(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(2);
        Aron.printSLL(sll.head);
        Node node = middleLinkedList(sll.head);
        Test.t(node.data, 1);

        Aron.end();
    } 
    
    static void test4_buildTree2(){
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        
        
        int[] arr = {1, 2, 3, 4}; 
        int index = 0;
        int count = arr.length;

        Node parent = buildTree2(arr, count);
        Aron.levelOrder(parent);
        Aron.inorder(parent);

        Aron.end();
    }
}

