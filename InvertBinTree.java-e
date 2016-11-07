import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

public class InvertBinTree{
    public static void main(String[] args) {
        test0();
        test1();
    }
    
    public static Node invert(Node root){
        if(root != null){
            Node right = invert(root.left);
            Node left  = invert(root.right);
            root.right = right;
            root.left  = left;
            return root;
        }
        return null;
    }
    public static void test0(){
       BST bst = new BST(); 
       bst.insert(10);
       bst.insert(5);
       bst.insert(15);
       bst.insert(7);
       Ut.l();
       Aron.inorder(bst.getRoot());
       Ut.l();
       Node r = invert(bst.getRoot());
       Aron.inorder(r);
    }
    public static void test1(){
       BST bst = new BST(); 
       bst.insert(10);
       bst.insert(5);
       bst.insert(7);
       bst.insert(15);
       bst.insert(12);
       bst.insert(18);
       Ut.l();
       Aron.inorder(bst.getRoot());
       Ut.l();
       Node r = invert(bst.getRoot());
       Aron.binImage(r);
       Aron.inorder(r);
    }
}
