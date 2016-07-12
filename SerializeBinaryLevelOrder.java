//Traveral binary tree in level order store it in HashMap
//Reconstruct the binary tree from HashMap
//
//      [p]
//[2*p+1] [2*p+2]
//

import java.util.*;
import classfile.*;

public class SerializeBinaryLevelOrder {
    public static void main(String[] args) {
        test0();        
    }
    static void test0(){
        Aron.beg();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BST bt = new BST();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(12);
        bt.insert(20);

        Aron.preorder(bt.root);
        levelOrder(bt.root);
        map = levelOrder(bt.root);

        BST newbt = new BST();
        int key = 0;
        newbt.root = buildBinaryTree(map, key);
        Aron.inorder(newbt.root);

        Aron.end();
    }

    public static Node buildBinaryTree(Map<Integer, Integer> map, int key) {
        Node root = null;
        if(map.containsKey(key)) {
            root = new Node((Integer)map.get(key));
            map.remove(key);
            root.left   = buildBinaryTree(map, 2*key+1);
            root.right  = buildBinaryTree(map, 2*key+2);
        }
        return root;
    }

    public static void levelOrderRecursion(Queue<Node> q, Map<Integer, Integer> map, int k) {
        Queue<Node> tmpQueue = new LinkedList<Node>();
        while(q.peek() != null) {
            Node node = q.remove();
            map.put(k, node.data);
            if(node.left != null)
                tmpQueue.add(node.left);
            if(node.right != null)
                tmpQueue.add(node.right);
        }
        if(tmpQueue.peek() != null)
            levelOrderRecursion(tmpQueue, map, k);
    }

    public static Map<Integer, Integer> levelOrder(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        Queue<Integer> numq1 = new LinkedList<Integer>();
        Queue<Integer> numq2 = new LinkedList<Integer>();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int parentIndex = -1;
        int[] Array = new int[20];
        if(root != null) {
            parentIndex= 0;
            System.out.println("here");
            queue1.add(root);
            numq1.add(parentIndex);
        }
        while(queue1.peek() != null || queue2.peek() != null) {
            while(queue1.peek() != null) {
                Node no = queue1.remove();
                parentIndex = numq1.remove();
                map.put(parentIndex, no.data);
                System.out.print("["+no.data+"]");
                System.out.print(" parentIndex="+parentIndex);
                if(no.left != null) {
                    queue2.add(no.left);
                    numq2.add(2*parentIndex+1);
                }
                if(no.right != null) {
                    queue2.add(no.right);
                    numq2.add(2*parentIndex+2);
                }
            }
            System.out.println("");
            while(queue2.peek() != null) {
                Node no = queue2.remove();
                parentIndex = numq2.remove();
                map.put(parentIndex, no.data);
                System.out.print("["+no.data+"]");
                System.out.print(" parentIndex="+parentIndex);
                if(no.left != null) {
                    queue1.add(no.left);
                    numq1.add(2*parentIndex+1);
                }
                if(no.right != null) {
                    queue1.add(no.right);
                    numq1.add(2*parentIndex+2);
                }
            }
            System.out.println("");
        }
        return map;
    }
}
