import java.util.*;
import java.io.*;
import classfile.*;

public class TryTry5{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 

        Node prev = null;
        Test.t(isBST(b1.root, prev));

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        int m = 15;
        int n = 7;
        List<Node> list = new ArrayList<>(); 

        swapNode(b1.root, m, n, list);

        Node prev = null;
        Test.t(isBST(b1.root, prev));

        Aron.end();
    }

    // List<Node> list = new ArrayList<Node>();
    public static void swapNode(Node root, int m, int n, List<Node> list){
        if(root != null){
            swapNode(root.left, m, n, list);

            if(list.size() < 2 && m == root.data || n == root.data)
                list.add(root);

            if(list.size() == 2){
               Node n1 = list.get(0); 
               Node n2 = list.get(1);
               int tmp = n1.data;
               n1.data = n2.data;
               n2.data = tmp;
               return;
            }
            swapNode(root.right, m, n, list);
        }
    }

    // prev = null
    //          9 
    //       5      12 
    // [9, p
    //      [5, p
    //             [x, nu
    //          true<- ]
    //            [x, p 
    //          true<- ]
    //        ]
    //          
    public static boolean isBST(Node root, Node prev){
        if(root != null){
            if(!isBST(root.left, prev))
                return false;
            if(prev != null && prev.data > root.data)
                return false;
            if(!isBST(root.right, root))
                return false;
        }
        return true;
    }
} 

