import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class delete_node{
    public static void main(String[] args) {
        test0();
        test_deleteNode();
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

