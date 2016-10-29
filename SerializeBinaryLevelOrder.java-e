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
        test1();        
        test2();        
        test3();        
        test4();        
        test5();        
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
    static void test1(){
        Aron.beg();

        BST bt = new BST();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(12);
        bt.insert(20);

        Aron.inorder(bt.root);
        levelOrder2(bt.root);

        Aron.end();
    }

    static void test2(){
        Aron.beg();
        //System.out.println(String.format("[%-20s]=[%s]" , "label", "content" ));
        System.out.println(String.format("[%-20s]=[%s]" , 9, "content" ));
        for(int i=0; i<5; i++){
            System.out.println(String.format("[%1$05d]" , i));
        } 
        Aron.end();
    } 
    
    static void test3(){
        Aron.beg();
        padding();
        Aron.end();
    }

    static void test4(){
        Aron.beg();

        for(int i=0; i< 5; i++){
            String str = "%1$-" + (i + 1) + "s";
            String value = String.format(str, i);
            System.out.println("["+ value + "]");
        } 
        Aron.end();
    }
    static void test5(){
        Aron.beg();

        BST bt = new BST();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(12);
        bt.insert(20);

        int level = level(bt.root);
        System.out.println("level[" + level + "]");
        for(int i=1; i<=level; i++){
            prettyPrint(bt.root, i);
            System.out.println();
        } 
        Aron.end();
    }
    static int level(Node root){
        if(root != null){
            return Math.max(level(root.left), level(root.right)) + 1;
        }
        return 0;
    }

    static void prettyPrint(Node r, int level){
        if(r != null){
                //String format = "%1$-" + level + "s";
                String format = "%1$" + (level + 10) + "s";
                String str = "[" + r.data + "]";
                System.out.print(String.format(format, str));

            prettyPrint(r.left, level - 1);
            prettyPrint(r.right, level - 1);
        }
    }

    static void padding(){
        String[] left  = {"Technology", "Technic", "Technologies", "Technisian"};
        String[] right = {"Continuous", "Continua", "Continuously", "Continuation"};
        for(int i=0; i< left.length; i++){
            String str = "%1$-" + (i + 4) + "s";
            //System.out.println("str[" + str + "]");
            //String value = String.format("%1$-15s %2$15s", left[i], right[i]);
            String value = String.format(str + " %2$15s", left[i], right[i]);
            System.out.println("[" + value + "]");
        } 
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

    
    public static void levelOrder2(Node curr) {
        if(curr != null){
            Queue<Node> q1 = new LinkedList<Node>();
            Queue<Node> q2 = new LinkedList<Node>();
            q1.add(curr);
            while(!q1.isEmpty() || !q2.isEmpty()){

                while(!q1.isEmpty()){
                    Node node = q1.remove();
                    System.out.println("[" + node.data + "]");
                    if(node.left != null)
                        q2.add(node.left);
                    if(node.right != null)
                        q2.add(node.right);
                }

                while(!q2.isEmpty()){
                    Node node = q2.remove();
                    System.out.println("[" + node.data + "]");

                    if(node.left != null)
                        q1.add(node.left);
                    if(node.right != null)
                        q2.add(node.right);
                }
            }
        }
    }
    public static Map<Integer, Integer> levelOrder(Node root) {
        Queue<Node> queue1 = new LinkedList<Node>();
        Queue<Node> queue2 = new LinkedList<Node>();
        Queue<Integer> numq1 = new LinkedList<Integer>();
        Queue<Integer> numq2 = new LinkedList<Integer>();
        Map<Integer, Integer> orderedMap = new LinkedHashMap<Integer, Integer>();

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
                orderedMap.put(parentIndex, no.data);

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
                orderedMap.put(parentIndex, no.data);

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
