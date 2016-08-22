import java.io.*;
import java.lang.String;
import java.util.*;

import classfile.*;

class PrettyBinPrint {
    public static Node prev = null;
    public static void main(String args[]) {
       test0(); 
       //test1(); 
    }
    
    static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(14);
        b1.insert(17);
        b1.insert(19);

        b1.insert(16);
        b1.insert(10);
//        b1.insert(18);
//        b1.insert(60);
//        b1.insert(2);
//        b1.insert(8);
//        b1.insert(70);

        int[] Arr = new int[100];
        int len=0;
        Node r = b1.root;

        Aron.levelOrder(r); 

        System.out.println(contain(r, 15));
        System.out.println();
        int indent=1;
        Aron.prettyPrint(r, indent);
        System.out.println();

        Aron.binImage(r);
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);

        int[] arr = new int[20]; 
        int index = 0;
        Aron.printAllPath(b1.root, arr, index); 

        Aron.binImage(b1.root);
        Aron.end();
    } 

    public static int MaxDepth(Node r) {
        if( r != null) {
            int nl = MaxDepth(r.left);
            int nr = MaxDepth(r.right);

            return (nl>nr?nl:nr)+1;
        }
        return 0;
    }

    public static boolean contain(Node r, int value) {
        if( r != null) {
            if(contain(r.left, value))
                return true;
            if(r.data == value)
                return true;
            if(contain(r.right, value))
                return true;
        }
        return false;
    }
}
