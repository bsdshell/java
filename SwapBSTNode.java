import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class SwapBSTNode {
    public static void main(String args[]) {
//        test0();
//        test00();
        test000();
    }
    static void test0(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);

        b1.insert(17);
        b1.insert(199);
        b1.insert(16);

        Ut.l();

        Aron.inorder(b1.root);
        Aron.binImage(b1.root);
        Ut.l();

        Node[] first = new Node[1];
        Node[] second = new Node[1];
        first[0] = null;
        second[0] = null;
        swap(199, 16, b1.root, first, second);
        Aron.binImage(b1.root);
        Aron.inorder(b1.root);
        Aron.end();
    }
    static void test00(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);

        b1.insert(17);
        b1.insert(199);
        b1.insert(16);

        Ut.l();

        Aron.inorder(b1.root);
        Aron.binImage(b1.root);
        Ut.l();

        Node tmp = null;
        swap2(b1.root, 199, 16, tmp);
        Aron.binImage(b1.root);
        Aron.inorder(b1.root);
        Aron.end();
    }
    static void test000(){
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);

        b1.insert(17);
        b1.insert(199);
        b1.insert(16);

        Ut.l();

        Aron.inorder(b1.root);
        Aron.binImage(b1.root);
        Ut.l();

        Node tmp = null;
        swap2(b1.root, 10, 16, tmp);
        Aron.binImage(b1.root);
        Aron.inorder(b1.root);
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Aron.end();
    } 

    // old way to swap two nodes
    public static void swap(int m, int n, Node root, Node[] first, Node[] second) {
        if(root != null) {
            swap(m, n, root.left, first, second);
            if(root.data == m) {
                first[0] = root;
            } else if(root.data == n) {
                second[0] = root;
            }
            if( first[0] != null && second[0] != null) {
                int tmp = first[0].data;
                first[0].data = second[0].data;
                second[0].data = tmp;
                first[0] = null;
                second[0] = null;
            }
            swap(m, n, root.right, first, second);
        }
    }

    // better swap than the first one, don't need array any more
    public static Node swap2(Node r, int m, int n, Node tmp) {
        if(r != null){
            Node left = swap2(r.left, m, n, tmp);
            if(left == null){
                if(r.data == m){
                    if(tmp == null)
                        tmp = r;
                    else{
                        r.data = n;
                        tmp.data = m;
                        return r;
                    }
                }else if(r.data == n){
                    if(tmp == null)
                        tmp = r;
                    else{
                        tmp.data = n;
                        r.data = m;
                        return r;
                    }
                }
            }else{
                return left;
            }
            Node right = swap2(r.right, m, n, tmp);
            return right;
        }
        return null;
    }

    
    // new way to swap two nodes
    public static Node swapTwoNodes(Node r, int n1, int n2){
        Node node1 = getNode(r, n1);
        Node node2 = getNode(r, n2); 
        if(node1 != null && node2 != null){
            int tmp = node1.data;
            node1.data = node2.data;
            node2.data = tmp;
        }
        return r;
    } 
    public static Node getNode(Node r, int n1){
        if(r != null){
            if( r.data == n1)
                return r;
            Node p1 = getNode(r.left, n1);
            if(p1 != null)
                return p1;
            Node p2 = getNode(r.right, n1);
            if(p2 != null)
                return p2;
                
        }
        return null;
    } 
}
