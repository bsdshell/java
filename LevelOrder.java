import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;

class LevelOrder {
    public static Node prev = null;
    public static void main(String args[]) {
        test0();    
        test1();    
    }
    
    static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(7);
        b1.insert(17);
        b1.insert(19);
        b1.insert(130);
        b1.insert(16);
        b1.insert(10);
        b1.insert(1);
        b1.insert(11);

        Node r = b1.getRoot();
        Queue<Node> q = new LinkedList<Node>();
        q.offer(b1.getRoot());
        LevelOrderRecursion(q);
        System.out.println("");
        LevelOrder(b1.getRoot());
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(7);
        b1.insert(17);
        b1.insert(19);
        b1.insert(130);
        b1.insert(16);
        b1.insert(10);
        b1.insert(1);
        b1.insert(11);
        LevelOrder(b1.root);
        LevelOrderOneQueue(b1.root);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Aron.end();
    } 

    //level order recursion levelorder recursion
    public static void LevelOrderRecursion(Queue<Node> q) {
        Queue<Node> q1 = new LinkedList<Node>();
        while(q.peek() != null) {
            Node node = q.poll();
            Print.pb(node.data);
            if(node.left != null)
                q1.offer(node.left);
            if(node.right != null)
                q1.offer(node.right);
        }
        System.out.println();
        if(q1.peek() != null)
            LevelOrderRecursion(q1);
    }

    // level order with one queue
    public static void LevelOrderOneQueue(Node root) {
        if(root != null){
            Queue<Node> queue = new LinkedList<Node>();
            queue.offer(root);
            while(queue.peek() != null){
                Node curr = queue.remove();
                Print.pb(curr.data);
                if(curr.left != null)
                    queue.offer(curr.left);
                if(curr.right != null)
                    queue.offer(curr.right);

            }
        }
    }

    //level order with two queues
    public static void LevelOrder(Node cur) {
        Queue<Node> Q1 = new LinkedList<Node>();
        Queue<Node> Q2 = new LinkedList<Node>();
        Q1.offer(cur);
        while(Q1.peek() != null || Q2.peek() != null) {
            while(Q1.peek() != null) {
                Node top = Q1.poll();
                System.out.print(top.data + " ");
                if(top.left != null)
                    Q2.offer(top.left);
                if(top.right != null)
                    Q2.offer(top.right);
            }
            System.out.println();
            while(Q2.peek() != null) {
                Node top = Q2.poll();

                System.out.print(top.data + " ");
                if(top.left != null)
                    Q1.offer(top.left);
                if(top.right != null)
                    Q1.offer(top.right);
            }
            System.out.println();
        }
    }
}
