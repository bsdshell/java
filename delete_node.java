import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class delete_node{
    public static void main(String[] args) {
//        test0();
//        test_deleteNode();
//        test_delete();
//        test_delete1();
//        test_delete2();
        //test_deleteList();
        test_rotateRight();
        test_rotateLeft();
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

        Aron.end();
    }
    public static void test_delete(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(9);
        b1.insert(8);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        int n = 8;
        Node root = delete(b1.root, n);

        Ut.l();
        Aron.prettyPrint(b1.root, level, isLeaf);
        

        Aron.end();
    }

    public static void test_delete1(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(9);
        b1.insert(8);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        int n = 7;
        Node root = delete(b1.root, n);

        Ut.l();
        Aron.prettyPrint(b1.root, level, isLeaf);
        

        Aron.end();
    }

    public static void test_delete2(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(9);
        b1.insert(8);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        int n = 10;
        Node root = b1.root;
        Node node = delete(b1.root, n);
        if(b1.root.data == n)
            root = b1.root.left;

        Ut.l();
        Aron.prettyPrint(root, level, isLeaf);

        Aron.end();
    }

    public static void test_deleteList(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(9);
        b1.insert(8);
        b1.insert(7);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        int n = 10;
        Node root = deleteList(b1.root, n);
        Ut.l();
        Aron.prettyPrint(root, level, isLeaf);
        

        Aron.end();
    }

    public static void test_rotateRight(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(9);
        b1.insert(8);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);

        Node root = rotateRight(b1.root);
        Aron.prettyPrint(root, level, isLeaf);


        Aron.end();
    }
    public static void test_rotateLeft(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(8);
        b1.insert(9);
        b1.insert(10);
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);

        Node root = rotateLeft(b1.root);
        Aron.prettyPrint(root, level, isLeaf);


        Aron.end();
    }
    public static Node rotateRight(Node curr){
        if(curr != null){
            if(curr.left != null && curr.left.left != null){
                Node parent = curr.left;
                parent.right = curr;
                curr.left = null;
                return parent;
            }
        }
        return null;
    }
    
    public static Node rotateLeft(Node curr){
        if(curr != null){
            if(curr.right != null && curr.right.right != null){
                Node parent = curr.right;
                parent.left = curr;
                curr.right = null;
                return parent;
            }
        }
        return null;
    }
    
    public static Node deleteList(Node curr, int n){
        if(curr != null){
            if(curr.data == n)
                return curr.left;
            else{
                delete(curr, n);
                return curr;
            }
        }
        return null;
    }

    public static Node delete(Node curr, int n){
        if(curr != null){
                if(curr.data == n)
                    return curr.left;
                else{
                    curr.left = delete(curr.left, n);
                    return curr;
                }
               
        }
        return null;
    }

    public static void deleteNode(Node curr){
        Node r = curr;
        while(r != null){
            Node left = r.left;
            Node right = r.right;
            if(left != null && right != null){
                while(left.left != null)
                    left = left.left;

                left.left = right;

                Print.pb("d=" + r.data);
                r = r.left;
            }else if(left != null){
                Print.pb("d=" + r.data);
                r = r.left;
            }else if(right != null){
                Print.pb("d=" + r.data);
                r = r.right;
            }else{
                Print.pb("d=" + r.data);
                r = null;
            }
        }
    }
    public static void test_deleteNode(){
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
        deleteNode(b1.root);

        Aron.end();
    }
} 

