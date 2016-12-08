import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class BinDeleteNode{
    static Node prevNode = null;
    public static void main(String[] args) {
        //test0();
        //test1();
        //test2();
        //test3();
        //test4();
//        test5();
//        test6();
//        test7();
        test8();
    }
    public static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(3);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Node root = Aron.cloneBinaryTree(b1.root);
        Aron.binImage(root); 

        Node prev = null;
        int n = 3;
        boolean isLeft = true;
        delete(b1.root, n, isLeaf);

        level = 0;
        isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(3);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Node prev = null;
        int n = 5;
        boolean isLeft = true;
        delete(b1.root, n, isLeaf);

        level = 0;
        isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(3);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Node prev = null;
        int n = 1;
        boolean isLeft = true;
        delete(b1.root, n, isLeaf);

        level = 0;
        isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(3);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Node prev = null;
        int n = 15;
        boolean isLeft = true;
        delete(b1.root, n, isLeaf);

        level = 0;
        isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    
    static void test4(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(3);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Node prev = null;
        int n = 5;
        boolean isLeft = true;
        delete2(b1.root, n, isLeaf);
//
//        level = 0;
//        isLeaf = true;
//        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    static void test5(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
//        b1.insert(1);
//        b1.insert(3);
//        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Node prev = null;
        int n = 15;
        boolean isLeft = true;
        delete2(b1.root, n, isLeft);
//
//        level = 0;
//        isLeaf = true;
//        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        Aron.end();
    }
    static void test6(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        Node prev = null;
        preorderPrev(b1.root, prev);

        Aron.end();
    }

    public static void delete2(Node r, int n, boolean isLeft){
        if(r != null){
            
        }
    }
    public static void preorderPrev(Node r, Node prev){
        if(r != null){
            if(prev == null){
                Print.p(prev);
                Print.p("->" + r.data);
            }else{
                Print.pbl(prev.data + "->" + r.data);
            }
            preorderPrev(r.left, r);
            preorderPrev(r.right, r);
        }
    }
    public static Node findMin(Node r){
        Node curr = r;
        while(curr.left != null){
            curr = curr.left;
        }
        return curr;
    }
    // delete node from Binary Tree 
    // prev = null
    // isLeft = true;
    public static void delete(Node r, int n, boolean isLeft){
        if(r != null) {       
            if(r.data == n){
                if(r.right != null){
                    int tmp = r.data;
                    r.data = r.right.data;
                    r.right.data = tmp;
                    isLeft = false;
                    prevNode = r;
                    delete(r.right, n, isLeft);
                }else{
                    if(r.left == null){
                        if(isLeft)
                            prevNode.left = null;
                        else
                            prevNode.right = null;
                    }
                    else{
                        if(prevNode != null){
                            prevNode.left = r.left;
                        }
                    }
                }
            }else{
                prevNode = r;
                isLeft = true;
                delete(r.left, n, isLeft);
                isLeft = false;
                delete(r.right, n, isLeft);
            }
        }
    }
    
    static void test7(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        
        int n1 = 1;
        int n2 = 15;
        Node root = swapTwoNodes(b1.root, n1, n2);
        Aron.binImage(root); 

        Aron.end();
    }
    static void test8(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        
        int n1 = 10;
        int n2 = 15;
        Node root = swapTwoNodes(b1.root, n1, n2);
        Aron.binImage(root); 

        Aron.end();
    }

    public static Node swapTwoNodes(Node r, int n1, int n2){
        Node node1 = getNode(r, n1);
        Node node2 = getNode(r, n2); 
        if(node1 != null && node2 != null){
            int tmp = node1.data;
            node1.data = node2.data;
            node2.data = tmp;
        }
        return r;
    } 
    public static Node getNode(Node r, int n1){
        if(r != null){
            if( r.data == n1)
                return r;
            Node p1 = getNode(r.left, n1);
            if(p1 != null)
                return p1;
            Node p2 = getNode(r.right, n1);
            if(p2 != null)
                return p2;
                
        }
        return null;
    } 
} 

