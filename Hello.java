import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("---------------------------------\n");
        test0();
        test1();
        test2();
    }
    static void test0() {
        System.out.println("---------------------------------\n");
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        System.out.println("\n---------------------------------");
        Aron.postorder(bst.root);
        System.out.println("\n---------------------------------");
        postIteration(bst.root);
        System.out.println("---------------------------------\n");
    }
    static void test1() {
        System.out.println("---------------------------------\n");
        BST bst = new BST();
        bst.insert(10);
        System.out.println("\n---------------------------------");
        Aron.postorder(bst.root);
        System.out.println("\n---------------------------------");
        postIteration(bst.root);
        System.out.println("---------------------------------\n");
    }
    static void test2() {
        System.out.println("---------------------------------\n");
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(8);
        System.out.println("\n---------------------------------");
        Aron.postorder(bst.root);
        System.out.println("\n---------------------------------");
        postIteration(bst.root);
        System.out.println("---------------------------------\n");
    }

    public static void postIteration(Node root) {
        System.out.println("\n---------------------------------");
        Stack<Node> stack = new Stack<Node>();
        Node curr = root;
        while(curr != null || stack.isEmpty() == false) {
            if(curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                Node node = stack.peek();
                if(node.isVisited) {
                    System.out.println("[" + node.data + "]");
                    stack.pop();
                } else {
                    node.isVisited = true;
                    curr = node.right;
                }
            }
        }
        System.out.println("\n---------------------------------");
    }
}
