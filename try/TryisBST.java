import java.util.*;
import java.io.*;
import classfile.*;

public class TryisBST{
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
        int m = 1, n = 7;
        Aron.inorder(b1.root);
        Aron.swapNode(b1.root, m, n);
        Ut.l();
        Aron.inorder(b1.root);

        Node prev = null;
        Test.f(isBST(b1.root, prev));

        Aron.end();
    }
    // prev = null
    public static boolean isBST(Node r, Node prev){
        if(r != null){
            if(!isBST(r.left, prev))
                return false;
            if(prev != null && prev.data > r.data)
                return false;
            if(!isBST(r.right, r))
                return false;
        }
        return true;
    }
} 

