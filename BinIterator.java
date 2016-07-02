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
        Node ret = null;
        while(hasNext()) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.peek();
                stack.pop();
                curr = node.right;
                return node;
            }
        }
        return ret;
    }
}
//]

public class BinIterator {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        test0();
        test1();
    }
    static void test0() {
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
    }
    static void test1(){
        System.out.println("\n---------------------------------");
        BST bst = new BST();
        bst.insert(10);

        BinaryIterator bi = new BinaryIterator(bst.root);
        System.out.println("\n---------------------------------");
        Aron.inorder(bst.root);
        System.out.println();
        while(bi.hasNext()) {
            System.out.println("[" + bi.next().data + "]");
        }
        System.out.println("\n---------------------------------");
    }
}
