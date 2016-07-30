import java.util.*;
import classfile.*;

class BSTDict{
    public Node root;
    public BSTDict() {
        root = null;
    }

    public void insert(int n) {
        if(root == null) {
            root = new Node(n);
        } else {
            Node curr = root;
            boolean end = false;
            while(curr != null && !end) {
                if(n < curr.data) {
                    if(curr.left == null) {
                        curr.left = new Node(n);
                        end = true;
                    } else
                        curr = curr.left;
                } else {
                    if(curr.right == null) {
                        curr.right = new Node(n);
                        end = true;
                    } else
                        curr = curr.right;
                }
            }
        }
    }
    public void OneQueue(Node curr) {
        if(curr != null) {
            Queue<Node> q = new LinkedList<Node>();
        }
    }
    public void inorder(Node curr) {
        if(curr != null) {
            inorder(curr.left);
            System.out.println("[" + curr.data + "]");
            inorder(curr.right);
        }
    }
    public boolean findNode(int n) {
        Node curr = root;
        boolean ret = false;
        if(curr != null) {
            if(n < curr.data)
                curr = curr.left;
            else if(n > curr.data)
                curr = curr.right;
            else
                ret = true;
        }
        return ret;
    }
    public boolean findSum(Node r, int n) {
        boolean ret = false;
        if(r == null) {
            if(n == 0)
                ret = true;
        } else if(r != null) {
            boolean bl = findSum(r.left, n - r.data);
            boolean br = findSum(r.right, n - r.data);
            ret = (bl || br);
        }
        return ret;
    }
}

public class BSTDictionary{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();

        String str1 = "tenny";
        String str2 = "tea";
        String str3 = "ten";
        String str4 = "tee";
        Print.p(str1.hashCode());
        Print.p(str2.hashCode());
        Print.p(str3.hashCode());
        Print.p(str4.hashCode());

        BSTDict bst = new BSTDict();
        bst.insert(str1.hashCode());
        bst.insert(str2.hashCode());
        bst.insert(str3.hashCode());
        bst.insert(str4.hashCode());
        
        Aron.end();
    }
}

