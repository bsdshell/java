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
        previous(b1.root, n, prev);
        Aron.end();
    }
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
} 

