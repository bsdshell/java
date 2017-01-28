import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

class NNode{
    NNode left;
    NNode right;
    int data;
    public NNode(int data){
        this.data = data;
    }
}

class BINTree{
    public NNode root = null;
    public BINTree(){
    }

    public void insert(NNode node){
        NNode curr = root;
        if(curr == null){
            root = curr = node;
        }else{
            while(curr != null){
                if(node.data < root.data){
                    if(curr.left == null){
                        curr.left = node;
                        break;
                    }
                    else
                        curr = curr.left;
                }
                else{
                    if(curr.right == null){
                        curr.right = node;
                        break;
                    }
                    else
                        curr = curr.right;
                }
            }
        }
    }

    public void print(NNode r){
        if(r != null){
            print(r.left);
            Print.pb(r.data);
            print(r.right);
        }
    }

}

public class bst_try{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        NNode n1 = new NNode(9);
        NNode n2 = new NNode(5);
        NNode n3 = new NNode(11);
        BINTree tree = new BINTree();
        tree.insert(n1);
        tree.insert(n2);
        tree.insert(n3);
        tree.print(tree.root);
        Ut.l();

        NNode n4 = new NNode(20);
        insert(tree.root, n4); 

        tree.print(tree.root);

        Aron.end();
    }

    public static void insert(NNode r, NNode node){
        if(r == null)
            r = node;
        else{
            if(node.data < r.data)
                if(r.left == null)
                    r.left = node;
                else
                    insert(r.left, node);
            else{
                if(r.right == null)
                    r.right = node;
                else 
                    insert(r.right, node);
            }
        }

    }

    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

