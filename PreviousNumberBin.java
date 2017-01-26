import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class PreviousNumberBin{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test_next();
    }
    public static void test0(){
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

        int n = 7;
        Node prev = null;
        Print.pbl("curr=" + n);
        previous(b1.root, n, prev);
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
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root); 

        int n = 1;
        Node prev = null;
        Print.pbl("curr=" + n);
        previous(b1.root, n, prev);
        Aron.end();
    }

    public static void test2(){
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
        Node prev = null;
        Print.pbl("curr=" + n);
        previous(b1.root, n, prev);
        Aron.end();
    }

    // print previous number, previous element, previous node 
    // previous num in binary tree, previous n in binary tree, previous n in binarytree
    // microsoft interview, ms inerview, MS interview
    public static boolean previous(Node r, int n, Node prev){
        if( r != null){
            if(previous(r.left, n, prev))
                return true;
            if(r.data == n){
                if(prev == null)
                    Print.pbl(-1);
                else
                    Print.pbl(prev.data);
                return true;
            }
            if(previous(r.right, n, r))
                return true;
        }
        return false;
    }
    
    static void test_next(){
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

        int n = 5;
        if(!next(b1.root, n)){
            Print.pp("null");
        }

        Aron.end();
    }

    // print the next node, next node,
    // next node from binary tree, next node binary tree
    static Node nextNode = null;
    public static boolean next(Node r, int n){
        if(r != null){
            if(next(r.left, n))
               return true;

            if(nextNode != null){
                Print.pb("next node=" + r.data);
                return true;
            }

            if(r.data == n){
                nextNode = r;
            }

            if(next(r.right, n))
                return true;
        }
        return false;
    }
} 

