import classfile.*;

public class FlapBST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(1);
        //Aron.binImage(bst.root);
        Aron.inorder(bst.root);
        flap(bst.root);
        Ut.l();
        Aron.inorder(bst.root);
        Aron.binImage(bst.root);
        
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
