import java.util.*;
class Node{
        int data;
        Node left;
        Node right;
    public Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree{
    Node root;
    public BinaryTree(){
        root = null;
    }
    public void insert(int data){
        if(root == null){
            root = new Node(data);
        }else{
            Node current = root;
            boolean end = false;
            while(!end){
                if(data < current.data){
                   if(current.left == null){
                       current.left = new Node(data);
                       end = true;
                   }else{
                       current = current.left; 
                   }
                }
                else{
                    if(current.right== null){
                       current.right= new Node(data);
                        end = true;
                    }
                    else{
                       current = current.right;
                    }
                }
            }
        } 
    }
    public void preorder(Node root)
    {
        if(root != null){
            System.out.println("preorder["+root.data+"]");
            preorder(root.left);
            preorder(root.right);
        }
    }

}

public class BinaryToArray 
{
    public static void main(String[] args)
    {
        BinaryTree bin = new BinaryTree();
        bin.insert(10);
        bin.insert(15);
        bin.insert(12);
        bin.insert(20);
        bin.insert(30);
            
        bin.preorder(bin.root);

        int[] Array = new int[20];
        System.out.println("Hello World!");
    }
    public void int[] BinaryToArray(Node root){
        
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        if(root != null)
            queue1.offer(root);
        while(queue1.peek()){
            Node no = queue1.remove();
            if(no.left != null){
                queue2.offer(no.left);
            }
        }

    }
}
