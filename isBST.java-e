import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class isBST {
    public static void main(String args[]) {
        test0();
        test1_isBSTDef();
        test2_isBSTDef();
        test3_isBSTDef();

        test11_isBST();
        test12_isBST();
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

        Node[] first = new Node[1];
        Node[] second = new Node[1];
        first[0] = null;
        second[0] = null;

        Aron.inorder(b1.getRoot());

        Node[] prev = new Node[1];
        prev[0] = null;
        System.out.println(isBST2(b1.getRoot(), prev));
        System.out.println(isBST(b1.getRoot(), null));
        System.out.println(isBSTDef(b1.getRoot()));
        Aron.end();
    }
    static void test1_isBST(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        Aron.inorder(b1.root);
        Test.t(isBST(b1.root));

        Aron.end();
    }
    static void test11_isBST(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        Node prev = null;
        Aron.inorder(b1.root);
        Test.t(isBST(b1.root, prev));

        Aron.end();
    }
    static void test12_isBST(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(11);
        b1.insert(12);
        b1.insert(13);
        Node prev = null;
        Aron.inorder(b1.root);
        Test.t(isBST(b1.root, prev));

        Aron.end();
    }

    static void test1_isBSTDef(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        Aron.inorder(b1.root);
        Test.t(isBSTDef(b1.root));

        Aron.end();
    }
    static void test2_isBSTDef(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        Aron.inorder(b1.root);
        Test.t(isBSTDef(b1.root));

        Aron.end();
    }
    static void test3_isBSTDef(){
        Aron.beg();
        BST b1 = new BST();
        Aron.inorder(b1.root);
        Test.t(isBSTDef(b1.root));

        Aron.end();
    }
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
    //[ file=isbststatic.html title=""
    public static Node prev = null;
    public static boolean isBST(Node r) {
        if(r != null) {
            if(!isBST(r.left))
                return false;
            if(prev != null && prev.data >= r.data)
                return false;
            prev = r;
            if(!isBST(r.right))
                return false;
        }
        return true;
    }
    //]

    //[ file=isbst.html title=""
    public static boolean isBST(Node root, Node prev) {
        if( root != null) {
            if(!isBST(root.left, prev))
                return false;
            if(prev != null && prev.data >= root.data)
                return false;
            if(!isBST(root.right, root))
                return false;
        }
        return true;
    }
    //]

    //prev[0] = null
    public static boolean isBST2(Node root, Node[] prev) {
        if( root != null) {
            if(!isBST2(root.left, prev))
                return false;

            if(prev[0] != null && prev[0].data > root.data)
                return false;

            prev[0] = root;
            if(!isBST2(root.right, prev))
                return false;
        }
        return true;
    }
    
    //[ file=isbstdef.html title=""
    //
    // precondition node != null
    public static int max(Node node) {
        if(node.right != null)
            return max(node.right);
        else
            return node.data;
    }

    // precondition node != null
    public static int min(Node node) {
        if(node.left != null)
            return min(node.left);
        else
            return node.data;
    }

    // BST definition
    // 1) left subtree is BST
    // 2) right subtree is BST
    // 3) max(left substree) < parent.data && min(right subtree) > parent.data
    public static boolean isBSTDef(Node node) {
        if(node == null)
            return true;
        else {
            if(!isBSTDef(node.left))
                return false;

            if((node.left != null && max(node.left) >= node.data))
                return false;
            if(node.right != null && node.data >= min(node.right))
                return false;

            if(!isBSTDef(node.right))
                return false;
            
            return true;
        }
    }
    //]

}
