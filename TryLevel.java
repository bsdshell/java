import java.util.*;
import java.io.*;
import classfile.*;

public class TryLevel{
    public static void main(String[] args) {
//        test0();
        test1();
        test2();
    }
    public static void test0(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        //Aron.binImage(b1.root);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(9);
        int level = 1;

        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        level(b1.root, map, level);
        int sum = 0;
        for(int k=0; k<=map.size(); k++){
            int m = (int)Math.pow(2, k);
            for(int i=1; i<=m; i++){
                int index = sum + i;
                Integer value = map.get(index);
                if(value != null)
                    Print.pbl("k=" + k + "  s=" + (sum + i) + " v=" + value);
                
            }
            sum += m;
            Aron.line();
        } 

        int index = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, index, isLeaf);
//        Aron.binImage(b1.root);
        
        Aron.end();
    }
    
    static void test2(){
        Aron.beg();
        int level = 1;
        Aron.line();
        BST b1 = Aron.createBin();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        level(b1.root, map, level);

        int index = 1;
        boolean isLeaf = true;
        Node root = buildTree(map, index);
        Aron.prettyPrint(root, index, isLeaf);


        Aron.end();
    } 

    
    public static Node buildTree(Map<Integer, Integer> map, int index){
        Node r = null;
        Integer n = map.get(index);
        if(n != null){
            r = new Node(n);
            r.left = buildTree(map, 2*index);
            r.right = buildTree(map, 2*index+1);
        }
        return r;
    }

    public static void printLevel(){
        int level = 1;
        Aron.line();
        BST b1 = Aron.createBin();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
        level(b1.root, map, level);
        int sum = 0;
        int num = 0;
        int k = 0;
        while(num < map.size()){
            int m = (int)Math.pow(2, k);
            for(int i=1; i<=m; i++){
                int index = sum + i;
                Integer value = map.get(index);
                if(num < map.size() && value != null){
                    Print.pb("k=" + k + "  s=" + (sum + i) + " v=" + value);
                    num++;
                }
                
            }
            sum += m;
            k++;
            Aron.line();
        } 
//
//        int index = 0;
//        boolean isLeaf = true;
//        Aron.prettyPrint(b1.root, index, isLeaf);
    }
    public static void level(Node r, Map<Integer, Integer> map, int level){
        if(r != null){
            Print.pbl(level + "=>" + r.data);
            map.put(level, r.data);
            level(r.left, map, 2*level);
            level(r.right, map, 2*level + 1);
        }
    } 
} 

