import java.io.*;
import java.util.*;
import classfile.*;

class MyNode{
    public Integer data;
    public MyNode left;
    public MyNode middle;
    public MyNode right; 
    public MyNode(Integer data){
        this.data = data;
    }
}
class Tree{
    public MyNode root;
    public Tree(){
    }
    public void create(){
        if(root == null)
            root = new MyNode(5);

        MyNode l = new MyNode(10);
        MyNode m = new MyNode(12);
        MyNode r = new MyNode(14);
        root.left = l;
        root.middle = m;
        root.right = r;

        MyNode ll = new MyNode(110);
        MyNode mm = new MyNode(112);
        MyNode rr = new MyNode(114);

        root.middle.left = ll;
        root.middle.middle = mm;
        root.middle.right = rr;
    }
}

public class Try5{
    public static void main(String[] args){
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    // init: index = 0
    static void preorder(MyNode r, int index, Map<Integer, Integer> map){
        if(r != null){
            System.out.println("[" + r.data + "]"); 
            map.put(index, r.data);
            preorder(r.left, 3*index + 1, map);
            preorder(r.middle, 3*index + 2, map);
            preorder(r.right, 3*index + 3, map);
        }
    }
    static int maxChildren(MyNode root){
        if(root != null){
            int l      = maxChildren(root.left);
            int m      = maxChildren(root.middle);
            int r      = maxChildren(root.right);
            int left   = l > 1 ? 1 : l;
            int middle = m > 1 ? 1 : m;
            int right  = r > 1 ? 1 : r;

            int sum = left + middle + right;
            return Math.max(Math.max(Math.max(Math.max(l, m), r), sum), 1);
        }
        return 0;
    }

    static void test0(){
        Aron.beg();
        try(BufferedReader br = new BufferedReader(new FileReader("file1.txt"))){
            for(String line; (line = br.readLine()) != null;){
                System.out.println("[" + line + "]");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        Aron.end();
    }
        
    static void test1(){
        Aron.beg();
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("file2.txt"))){
            bw.write("cat");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        Aron.end();
    }
    static MyNode buildTree(Map<Integer, Integer> map, int index){
        Integer value = map.get(index);
        if(value != null){
            MyNode root = new MyNode(value);
            root.left =  buildTree(map, 3*index + 1); 
            root.middle =  buildTree(map, 3*index + 2); 
            root.right =  buildTree(map, 3*index + 3); 
            return root;
        }
        return null;
    }

    static void test2(){
        Aron.beg();
        Tree t = new Tree();
        t.create();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        preorder(t.root, index, map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " " + entry.getValue() + "]"); 
        }

        System.out.println("\n---------------------------------"); 
        
        MyNode node = buildTree(map, 0);
        preorder(node, 0, map);
        Aron.end();
    }

    static void test3(){
        Aron.beg();
        Tree t = new Tree();
        t.create();
        int max = maxChildren(t.root);
        System.out.println("max[" + max + "]"); 
        Aron.end();
    }
    static void test4(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        Aron.inorder(bst.root);
        Node prev = null;
        boolean boo = Aron.isBST(bst.root, prev);
        System.out.println("[" + boo + "]"); 

        Aron.end();
    }


    static void test5(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        Aron.inorder(bst.root);
        Node[] first = new Node[1];
        Node[] second = new Node[1];
        
        //public static void swap(int m, int n, Node root, Node[] first, Node[] second) {
        Aron.swap(5, 15, bst.root, first, second);
        System.out.println("[swap 5, 15]"); 
        Aron.inorder(bst.root);

        Node prev = null;
        boolean boo = Aron.isBST(bst.root, prev);
        System.out.println("[" + boo + "]"); 

        Aron.end();
    }


}
