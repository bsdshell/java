import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class BinDeleteNode{
    static Node prevNode = null;
    public static void main(String[] args) {
//        test9();
//        test10();
//        test11();
//        test12();
//        test13();
        test14();
    }
    
    static void test9(){
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
        int n = 15;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test10(){
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
        int n = 10;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test11(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        int n = 7;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test12(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(12);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        int n = 10;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test13(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(12);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        int n = 12;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test14(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        int n = 10;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }
    static void test15(){
        Aron.beg();
        
        BST b1 = new BST();
        b1.insert(10);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 
        int n = 13;
        Node newRoot = delete(b1.root, n);
        Aron.binImage(newRoot); 

        Aron.end();
    }


    public static Node findMin(Node r){
        Node curr = r;
        while(r != null && curr.left != null){
            curr = curr.left;
        }
        return curr;
    }

    // gf http://quiz.geeksforgeeks.org/binary-search-tree-set-2-delete/
    public static Node delete(Node r, int n){
        if(r != null){
            if(n < r.data)
                r.left = delete(r.left, n);
            else if(n > r.data)
                r.right = delete(r.right, n);
            else{
                if(r.left == null)
                    return r.right;
                else if(r.right == null)
                    return r.left;
                else{
                    Node min = findMin(r.right);
                    r.data = min.data;
                    r.right = delete(r.right, min.data);
                }

            }
            return r;
        }
        return null;
    }
} 

