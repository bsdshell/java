import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*; 

class LowestCommonAncestor{
    public static Node prev = null;
    public static void main(String args[]) {
        test0_findNode();
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    public static void test0_findNode() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(7);
        b1.insert(17);
        b1.insert(19);
        Node r = findNode(b1.root, 17);
        Test.t(r.data, 17);

        Aron.end();
    }


    public static void test00() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(15);
        b1.insert(12);
        b1.insert(7);
        b1.insert(17);
        b1.insert(19);
        b1.insert(130);
        b1.insert(16);
        b1.insert(10);
        b1.insert(1);
        b1.insert(11);

        Node r = b1.getRoot();
        Node lca = LCABinTree(r, 12, 15);
        System.out.println("lca.data=" + lca.data);
        Aron.end();
    }

    public static void test0() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        Node lca = LCA2(b1.root, 1, 7);
        if(lca != null)
            Test.t(lca.data, 5);

        //Aron.binImage(b1.root);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        Node lca = LCA2(b1.root, 5, 7);
        Test.t(lca.data, 5);

        Aron.end();
    }

    public static void test2() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(12);
        b1.insert(15);
        b1.insert(18);
        b1.insert(19);
        b1.insert(35);
        Node lca = LCA2(b1.root, 15, 35);
        Test.t(lca.data, 15);
        //Aron.binImage(b1.root);

        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(12);
        b1.insert(15);
        Node lca = LCA2(b1.root, 12, 15);
        Test.t(lca.data, 12);
        //Aron.binImage(b1.root);

        Aron.end();
    }
    public static void test4() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(12);
        Node lca = LCA2(b1.root, 10, 12);
        Test.t(lca.data, 10);

        Aron.end();
    }

    public static void test5() {
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(11);
        b1.insert(12);
        Node lca = LCA2(b1.root, 12, 10);
        Test.t(lca.data, 10);

        Aron.end();
    }


//    public static Node LCA(Node r, int value1, int value2) {
//        Node ret=null;
//        if(r != null) {
//            if((r.left != null && (value1 == r.left.data || value2 == r.left.data)) ||
//                    (r.right != null && (value1 == r.right.data || value2 == r.right.data)))
//                ret = r;
//            else if(value1 < r.data && value2 < r.data)
//                ret=LCA(r.left, value1, value2);
//            else if(value1 > r.data && value2 > r.data)
//                ret=LCA(r.right, value1, value2);
//            else
//                ret = r;
//        }
//        return ret;
//    }
//
    //[ file=findnode.html title=""
    public static Node findNode(Node root, int n){
        if(root != null){
            if( root.data == n)
                return root;
            Node l = findNode(root.left, n);
            Node r = findNode(root.right, n);
            if(l != null)
                return l;
            else if(r != null)
                return r;
        }
        return null;
    }
    //]

    //[ file=lcanew.html title=""
    public static Node LCA_BasedOnFindNode(Node r, int n1, int n2){
        if(r != null){
            if(r.data == n1 || r.data == n2)
                return r;

           Node left = LCA_BasedOnFindNode(r.left, n1, n2); 
           Node right = LCA_BasedOnFindNode(r.right, n1, n2);

           if(left != null && right != null)
               return r;
           else if(left != null)
               return left;
           else if(right != null)
               return right;
           
        }
        return null;
    }
    //]

    public static Node LCA(Node root, int n1, int n2){
        if(root != null){
            if( root.data == n1 || root.data == n2)
                return root;

            Node l = LCA(root.left, n1, n2);
            Node r = LCA(root.right, n1, n2);
            if(l != null && r != null)
                return root;
            else if(l != null)
                return l;
            else if(r != null)
                return r;
        }
        return null;
    }
    public static Node LCA2(Node r, Node n1, Node n2) {
        Node ret=null;
        if(r != null && n1 != null && n2 != null) {
            if( r.left != null && (r.left.data == n1.data || r.left.data == n2.data) ||
                    r.right != null && (r.right.data == n1.data || r.right.data == n2.data))
                ret = r;
            else if(n1.data < r.data && n2.data < r.data)
                ret=LCA2(r.left, n1, n2);
            else if(n1.data > r.data && n2.data > r.data)
                ret=LCA2(r.right, n1, n2);
            else
                ret=r;
        }
        return ret;
    }

    //LCA for Binary Tree
    public static Node LCABinTree(Node r, int value1, int value2) {
        if( r != null) {
            if( r.data == value1 || r.data == value2)
                return r;
            Node nl = LCABinTree(r.left, value1, value2);
            Node nr = LCABinTree(r.right, value1, value2);
            if( nl != null && nr != null)
                return r;
            else if( nl != null)
                return nl;
            else if( nr != null)
                return nr;

        }
        return null;
    }

    public static boolean equalBinaryTree(Node r1, Node r2) {
        if(r1==null && r2==null)
            return true;
        else if(r1 != null && r2 != null) {
            if(r1.data != r2.data)
                return false;
            if(!equalBinaryTree(r1.left, r2.left))
                return false;
            if(!equalBinaryTree(r1.right, r2.right))
                return false;
        } else
            return false;
        return true;
    }

    // lowest common ancestor, least common ancestor, lca, LCA
    public static Node LCA2(Node root, int n1, int n2) {
    if(root != null){
        if(root.data == n1 || root.data == n2)
            return root;

        Node l = LCA2(root.left, n1, n2);
        Node r = LCA2(root.right, n1, n2);
        if(l != null && r != null)
            return root;
        else if( l != null)
            return l;
        else if( r != null)
            return r;
    }
    return null;
    }

}
