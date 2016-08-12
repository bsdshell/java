class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
class BST {
    Node root;
    public BST() {
        root = null;
    }
    public void insert(int data) {
        if(root == null)
            root = new Node(data);
        else {
            Node curr = root;
            boolean done = false;
            while(!done) {
                if(data < curr.data) {
                    if(curr.left != null) {
                        curr = curr.left;
                    } else {
                        curr.left = new Node(data);
                        done = true;
                    }
                } else {
                    if(curr.right != null) {
                        curr = curr.right;
                    } else {
                        curr.right = new Node(data);
                        done = true;
                    }
                }
            }
        }
    }
}

public class FlapBST {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(1);
        inorder(bst.root);
        flap(bst.root);
        System.out.println("After flap the BST");
        inorder(bst.root);
    }
    public static void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print("["+root.data+"]");
            inorder(root.right);
        }
    }
    public static void flap(Node root) {
        if(root != null) {
            flap(root.left);
            flap(root.right);
            Node tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }
    }
}
