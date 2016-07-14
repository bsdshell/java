import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.List;
import java.util.*;
import java.lang.Math;
import java.io.*;

import classfile.*;

class MyNode{
    public int data;
    public List<MyNode> list;
    public MyNode(int data){
        this.data = data;
        list = new ArrayList<MyNode>();
    }
}

class MyTree{
    public MyNode root;

    public MyTree(){
    }

    public void create(){
        root = new MyNode(1);
        root.list.add(new MyNode(2));
        root.list.add(new MyNode(3));

        MyNode branch = new MyNode(10);
        branch.list.add(new MyNode(11));
        branch.list.add(new MyNode(12));
        root.list.add(branch);

        MyNode branch1 = new MyNode(20);
        branch1.list.add(new MyNode(21));
        branch1.list.add(new MyNode(22));
        root.list.add(branch1);
    }
    public void printTree(MyNode node, int level, BufferedWriter bw){
        //Aron.beg();

        try{
            if(node != null){
                String format;

                if(level == 0)
                    format = "%1$1s";
                else
                    format = "%1$" + (level*10) + "s";

                //System.out.println(String.format(format, "[" + node.data));
                System.out.print(" [ " + node.data + " ");
                bw.write(" [ " + node.data + " ");
                for(MyNode n : node.list){
                    printTree(n, level+1, bw);
                }
                System.out.print(" ] " + " ");
                bw.write(" ] " + " ");
                //System.out.println(String.format(format, "]"));
            }
        }catch(IOException e){
        }

        //Aron.end();
    }
}

public class Hello1{
    public static void main(String[] args){
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
    }
    public static int height(Node root){
        return root == null ? -1 : Math.max(height(root.left), height(root.right)) + 1;
    }

    public static void printTree(MyNode node, int level){
        if(node != null){
            String format;
            if(level == 0)
                format = "%1$1s";
            else
                format = "%1$" + (level*10) + "s";

            System.out.println(String.format(format, "[" + node.data));
            for(MyNode n : node.list){
                printTree(n, level+1);
            }
            System.out.println(String.format(format, "]"));
        }
    }

    public static void test0(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        System.out.println("[" + height(bst.root) + "]");

        Aron.end();
    }

    public static void test1(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(1);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        System.out.println("[" + height(bst.root) + "]");
        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        System.out.println("[" + height(bst.root) + "]");

        Aron.end();
    }

    public static void test3(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(20);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        print(bst.root);

        Aron.end();
    }

    public static void test4(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        print(bst.root);

        Aron.end();
    }
    
    static void test5(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        print(bst.root);
        System.out.println("\n---------------------------------"); 

        Node curr = bst.root;
        while(curr != null){
            System.out.println("[" + curr.data + "]");
            curr = curr.next;
        }

        Aron.end();
    }
    static void test6(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(3);
        bst.insert(7);
        Aron.inorder(bst.root);
        System.out.println("\n---------------------------------"); 
        print(bst.root);
        System.out.println("\n---------------------------------"); 

        Node curr = bst.root;
        while(curr != null){
            System.out.println("[" + curr.data + "]");
            curr = curr.next;
        }

        Aron.end();
    }

    public static int BinaryTreeLevel(Node root){
        return root == null ? 0 : Math.max(BinaryTreeLevel(root.left), BinaryTreeLevel(root.right)) + 1;
    }

    static Node prev = null;
    public static void printLevel(Node curr, int level){
        if(curr != null){
            if(level == 1 ){
                System.out.println("[" + curr.data + "]");
                if(prev != null){
                    prev.next = curr;
                    prev = curr;
                }else{
                    prev = curr;
                }
            }else{
                printLevel(curr.left, level - 1);
                printLevel(curr.right, level - 1);
            }
        } 
    }
    public static void print(Node curr){
        for(int i = 1; i<= BinaryTreeLevel(curr); i++){
            printLevel(curr, i);
        }
    }
    
    static void test7(){
        Aron.beg();
        Map<Node, Node> map = new HashMap<Node, Node>();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);

        n2.next = n3;
        map.put(n1, n2);
        map.put(n2, n4);
        map.put(n3, n5);
        map.put(n5, n4);

        for(Map.Entry<Node, Node> entry: map.entrySet()){
            Node curr = entry.getValue();
            while(curr != null){
                System.out.println("[" + entry.getKey().data + " " + curr.data + "]");
                curr = curr.next;
            }
        }
        List<Node> list = new ArrayList<Node>();
        list.add(n1);
        getAllPaths(n1, map, 4, list);

        Aron.end();
    }
    
    static void test8(){
        Aron.beg();
        int[] arr = {2, -5, 8, -2, 3};
        System.out.println("[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test9(){
        Aron.beg();
        int[] arr = {-1, -5, 8, -4, 5, -2, 3, -2};
        System.out.println("[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test10(){
        Aron.beg();
        int[] arr = {-1, -5, 8};
        System.out.println("[" + maxList(arr)+ "]");
        Aron.end();
    }

    static void test11(){
        Aron.beg();
        int[] arr = {6, -5, 8};
        System.out.println("[" + maxList(arr)+ "]");
        Aron.end();
    }

    static void buildMap(Node r, int key, Map<Integer, Integer> map){
        if(r != null){
            System.out.println("[" + r.data + "][" + key + "]");
            map.put(key, r.data);
            buildMap(r.left, 2*key + 1, map);
            buildMap(r.right, 2*key + 2, map);
        }
    }
    // index = 0
    static Node buildTree(Map<Integer, Integer> map, int index){
        Integer n = map.get(index);
        if(n != null){
            Node root = new Node(n);
            root.left = buildTree(map, 2*index+1);
            root.right = buildTree(map, 2*index+2);
            return root;
        }
        return null;
    }
    static void getAllPaths(Node n, Map<Node, Node> map, int num, List<Node> list){
        if(n.data == num){
            for(Node node : list){
                System.out.println("[" + node.data + "]");
            }
            System.out.println("\n---------------------------------"); 
        }else{
                Node curr = map.get(n);
                while(curr != null){
                    list.add(curr);
                    getAllPaths(curr, map, num, list);

                    if(list.size() > 0)
                        list.remove(list.size()-1);

                    curr = curr.next;
                }
        }
    }
    static int maxList(int[] arr){
        int max = -1;
        int first = 0;
        int second = 0;
        if(arr != null && arr.length > 0){
            max = arr[0];
            int sum = arr[0];
            for(int i=1; i<arr.length; i++){
                    sum += arr[i];
                    System.out.println("sum[" + sum + "]");
                    System.out.println("arr[" + i + "]=" + arr[i]);
                    if(sum < 0){
                        sum = 0;
                        if(i + 1 < arr.length)
                            first = i + 1;
                    }

                    if( max < Math.max(sum, arr[i])){
                        max = Math.max(sum, arr[i]);
                        second = i;
                    }
            }
            System.out.println("f[" + first + "]");
            System.out.println("s[" + second + "]");
        }
        return max;
    }

    static void test12(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 0, 1, 1},
            {1, 0, 1, 1},
            {0, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 1, 1, 0},
        }; 

//[0][0]=0[0][1]=0[0][2]=5[0][3]=0
//[1][0]=1[1][1]=0[1][2]=0[1][3]=0
//[2][0]=0[2][1]=0[2][2]=0[2][3]=0
//[3][0]=0[3][1]=0[3][2]=3[3][3]=0
//[4][0]=0[4][1]=0[4][2]=0[4][3]=0


        int h = 0;
        int w = 0;
        int height = arr2d.length;
        if(height > 0){
            int width = arr2d[0].length;

            System.out.println("h[" + height + "]");
            System.out.println("w[" + width + "]");
            for(int i=0; i< height; i++){
                for(int j=0; j< width; j++){
                    int count = maxCount(arr2d, i, j, height, width);
                    System.out.print("[" + i + "][" + j + "]=" + count);
                }
                System.out.println("");
            } 
            
        }
        
        Aron.end();
    }

    static int maxCount(int[][] arr2d, int h, int w, int height, int width){
        if(arr2d != null){
            if(arr2d[h][w] == 1){
                arr2d[h][w] = 2;
                int n1 = 0;
                int n2 = 0;
                int n3 = 0;
                int n4 = 0;
                if(h + 1 < height)
                    n1 = maxCount(arr2d, h + 1, w, height, width);
                if(h - 1 >= 0)
                    n2 = maxCount(arr2d, h - 1, w, height, width);
                if(w + 1 < width)
                    n3 = maxCount(arr2d, h, w + 1, height, width);
                if(w - 1 >= 0)
                    n4 = maxCount(arr2d, h, w - 1, height, width);

                return n1 + n2 + n3 + n4 + 1;
            }
        }
        return 0;
    }
    
    static void test13(){
        Aron.beg();

        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("file3.txt"));
            int level = 0; 
            MyTree t = new MyTree();
            t.create();
            t.printTree(t.root, level, bw);

            bw.close();

            BufferedReader br = new BufferedReader(new FileReader("file3.txt"));
            String line;
            while((line = br.readLine()) != null){
                //System.out.println("inside[" + line + "]");
                break;
            }
            System.out.println("\n---------------------------------"); 

            String[] arr = line.split("\\s+");

            List<String> list = new ArrayList<String>(); 
            for(String s : arr){
                System.out.print("<<" + s + ">>"); 
                if(s.trim().length() > 0)
                    list.add(s);
            }

            br.close();
            level = 0;
            MyNode r = null;
            System.out.println("\n buildTree2---------------------------------"); 
            MyNode root = buildTree2(r, list.iterator());

//            System.out.println("\n---------------------------------"); 
//            for(String s : arr){
//                System.out.print("(" + s + ")"); 
//            }
            printTree(root, level);
            System.out.println("\n---------------------------------"); 

        }catch(IOException e){
            System.out.println("[" + e.getMessage() + "]");
        }

        Aron.end();
    }

    static MyNode buildTree2(MyNode root, Iterator<String> ite){
        if(ite.hasNext()){
            String token = ite.next();

            if(token.equals("[")){
                if(root == null)
                    return buildTree2(root, ite);
                else{
                    root.list.add(buildTree2(root, ite));
                    return root;
                }
            }else if(token.equals("]")){
            }
            else{
                MyNode nn = new MyNode(Integer.parseInt(token));
                if(root != null){
                    root.list.add(nn);
                    return buildTree2(root, ite);
                }else{
                    root = new MyNode(Integer.parseInt(token));
                    root.list.add(buildTree2(root, ite)); 
                }
            }
            return root;
        }
        return null;
    }

    static void test14(){
        Aron.beg();
        String file = "file.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null;){
                System.out.println("[" + line + "]");
            }
        }catch(IOException e){
            System.out.println("[" + e.getMessage() + "]");
        }

        String file1 = "file1.txt";
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file1))){
            bw.write("dog\n");
            bw.write("God");
        }catch(IOException e){
            System.out.println("[" + e.getMessage() + "]");
        }

        Aron.end();
    }
    static void test15(){
        Aron.beg();
        
        BST bt = new BST();
        bt.insert(10);
        bt.insert(5);
        bt.insert(15);
        bt.insert(12);
        bt.insert(20); 
        int n = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        buildMap(bt.root, n, map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " " + entry.getValue() +"]");
        }
        int index = 0;
        Node root = buildTree(map, index);
        Aron.inorder(root);
                 
        Aron.end();
    }
    
    static void test16(){
        Aron.beg();

        System.out.println(String.format("[%1$-1s]" , "123"));
//        System.out.println(String.format("[%1$05d]" , "123"));

        Aron.end();
    }

    static void test17(){
        Aron.beg();
        String str = "[1 [2][3][10[11][12]][20[21][22]]]";
        String[] arr = str.split("\\d+");
        for(String s : arr){
            System.out.println("{" + s + "}");
        }
        Aron.end();
    }
    static void test18(){
        Aron.beg();
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> ite = list.iterator();
        while(ite.hasNext()){
            System.out.println("[" + ite.next() + "]"); 
        }
        Aron.end();
    }
}
