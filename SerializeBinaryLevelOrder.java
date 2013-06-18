//Traveral binary tree in level order store it in HashMap
//Reconstruct the binary tree from HashMap
//
//      [p]
//[2*p+1] [2*p+2]
//

import java.util.*;

class Node{
    Node left;
    Node right;
    int data;
    public Node(int data){
        this.data = data;
        left = right = null; 
    }
}
class BinaryTree{
    Node root;
    public BinaryTree(){
        root = null;
    }
    public void insert(int data){
        Node current = root;
        if(current == null){
            root = new Node(data);
        }else{
            boolean done = false;
            while(!done){
                if(data < current.data){
                    if(current.left == null){
                        current.left = new Node(data);
                        done = true;
                    }else{
                        current = current.left;
                    }
                }else{
                    if(current.right == null){
                        current.right = new Node(data);
                        done = true;
                    }else{
                        current = current.right;
                    }
                }
            }

        }
    }
}

public class SerializeBinaryLevelOrder 
{
    public static void main(String[] args)
    {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BinaryTree bt = new BinaryTree();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(12);
        bt.insert(20);

        preorder(bt.root);
        levelOrder(bt.root);
        System.out.println("Hello World!");
        map = levelOrder(bt.root);
        BinaryTree newbt = new BinaryTree();
        int key = 0;
        newbt.root = buildBinaryTree(map, key);
        preorder(newbt.root);
    }
    public static void preorder(Node root){
        if(root != null){
            System.out.print("["+root.data+"]");
            preorder(root.left);
            preorder(root.right);
        } 
    }
    public static Node buildBinaryTree(Map<Integer, Integer> map, int key){
        Node root = null;
        if(map.size() > 0 && map.containsKey(key)){
            root = new Node((Integer)map.get(key));
            map.remove(key);
            root.left   = buildBinaryTree(map, 2*key+1);
            root.right  = buildBinaryTree(map, 2*key+2);
        }
        return root;
    }
    public static Map<Integer, Integer> levelOrder(Node root){
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        Queue<Integer> numq1 = new LinkedList<Integer>();
        Queue<Integer> numq2 = new LinkedList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int parentIndex = -1;
        int[] Array = new int[20];
        if(root != null){
            parentIndex= 0;
            System.out.println("here");
            queue1.add(root);
            numq1.add(parentIndex);
        }
        while(queue1.peek() != null || queue2.peek() != null){
            while(queue1.peek() != null){
                Node no = queue1.remove();
                 parentIndex = numq1.remove(); 
                 map.put(parentIndex, no.data);
                System.out.print("["+no.data+"]");
                System.out.print(" parentIndex="+parentIndex);
                if(no.left != null){
                    queue2.add(no.left);
                    numq2.add(2*parentIndex+1);
                }
                if(no.right != null){
                    queue2.add(no.right);
                    numq2.add(2*parentIndex+2);
                }
            }
            System.out.println("");
            while(queue2.peek() != null){
                Node no = queue2.remove();
                parentIndex = numq2.remove();
                map.put(parentIndex, no.data);
                System.out.print("["+no.data+"]");
                System.out.print(" parentIndex="+parentIndex);
                if(no.left != null){
                    queue1.add(no.left);
                    numq1.add(2*parentIndex+1);
                }
                if(no.right != null){
                    queue1.add(no.right);
                    numq1.add(2*parentIndex+2);
                }
            }
            System.out.println("");
        }
        return map;
    }
}
