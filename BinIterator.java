import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

//[ file=binite.html title=""
// binary iterator
class BinaryIterator {
    Node curr;
    Stack<Node> stack;
    public BinaryIterator(Node root) {
        curr = root;
        stack = new Stack<Node>();
    }

    public boolean hasNext() {
        return (curr != null || stack.isEmpty() == false);
    }

    public Node next() {
        while(hasNext()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.pop();
                curr = node.right;
                return node;
            }
        }
        return null;
    }
}
//]

public class BinIterator {
    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
    
    static void test0() {
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);

        BinaryIterator bi = new BinaryIterator(bst.root);
        System.out.println("\n---------------------------------");
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------");
        while(bi.hasNext()) {
            System.out.println("[" + bi.next().data + "]");
        }
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);

        BinaryIterator bi = new BinaryIterator(bst.root);
        System.out.println("\n---------------------------------");
        Aron.inorder(bst.root);
        System.out.println();
        while(bi.hasNext()) {
            System.out.println("[" + bi.next().data + "]");
        }
        Aron.end();
    }
    static void test2() {
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(20);
        bst.insert(18);

        BinaryIterator bi = new BinaryIterator(bst.root);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------");
        while(bi.hasNext()) {
            System.out.println("[" + bi.next().data + "]");
        }
        Aron.end();
    }
}
