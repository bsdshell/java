import java.io.*;
import java.lang.String;
import java.util.*;



public class InvertBinTree{
    public static void main(String[] args) {
        System.out.println("Hello World!");
        test0();
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
       System.out.println("---------------------------------\n"); 
       Aron.inorder(bst.getRoot());
       System.out.println("---------------------------------\n"); 
       Node r = invert(bst.getRoot());
       Aron.inorder(r);
    }
}
