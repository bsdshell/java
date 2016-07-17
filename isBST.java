import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

//class Node {
//    public Node left;
//    public Node right;
//    public int data;
//    public Node(int n) {
//        data = n;
//        left = null;
//        right = null;
//    }
//    public Node getLeft() {
//        return left;
//    }
//    public Node getRight() {
//        return right;
//    }
//    public void setLeft(Node l) {
//        left = l;
//    }
//    public void setRight(Node r) {
//        right = r;
//    }
//}
//
class BST {
    Node root;
    public BST() {
        root = null;
    };
    public void insert(int n) {
        if(root == null) {
            root = new Node(n);
        } else {
            Node cur = root;
            boolean end = false;
            while(cur != null && !end) {
                if(n < cur.data) {
                    if(cur.left == null) {
                        cur.left = new Node(n);
                        end = true;
                    } else
                        cur = cur.left;
                } else {
                    if(cur.right == null) {
                        cur.right = new Node(n);
                        end = true;
                    } else
                        cur = cur.right;
                }
            }
        }
    }
    public Node getRoot() {
        return root;
    }
}
class isBST {

    public static void main(String args[]) {
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
        //swap(5, 15, b1.getRoot(), first, second);

        inorder(b1.getRoot());

        Node[] prev = new Node[1];
        prev[0] = null;
        ////System.out.println(isBST(b1.getRoot()));
        System.out.println(isBST2(b1.getRoot(), prev));
        System.out.println(isBST(b1.getRoot(), null));
        System.out.println(isBSTDef(b1.getRoot()));
    }

//    public static void swap(Node root, int m, int n, Node first, Node second) {
//        if(root != null){
//            swap(root.left, m, n, first, second);
//            if(first == null && second == null){
//                if(root.data == m)
//                    first = root;
//                else if (root.data == n)
//                    first = root;
//            }else if(second == null){
//                if(root.data == m)
//                    second = root;
//                else if (root.data == n)
//                    second = root;
//            }
//
//            swap(root.right, m, n, first, second);
//
//            if(first != null && second != null){
//                int tmp = first.data;
//                first.data = second.data;
//                second.data = tmp;
//                first = second = null;
//            }
//        }
//    }

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

    public static void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

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

    public static boolean isBST(Node root, Node previous) {
        if( root != null) {
            if(!isBST(root.left, previous))
                return false;
            if(previous != null && previous.data >= root.data)
                return false;
            if(!isBST(root.right, root))
                return false;
        }
        return true;
    }
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
    //precondition node != null
    public static int max(Node node) {
        if(node.right != null)
            return max(node.right);
        else
            return node.data;
    }

    //precondition node != null
    public static int min(Node node) {
        if(node.left != null)
            return min(node.left);
        else
            return node.data;
    }

    //BST definition
    // 1) left subtree is BST
    // 2) right subtree is BST
    // 3) max(left substree) < parent.data && min(right subtree) > parent.data
    public static boolean isBSTDef(Node node) {
        if(node == null)
            return true;
        else {
            if(!isBSTDef(node.left))
                return false;
            if(!isBSTDef(node.right))
                return false;
            if( !((node.left == null || max(node.left) < node.data) &&
                    (node.right == null || min(node.right) > node.data)))
                return false;
            return true;
        }
    }
}
