import java.util.*;
import java.io.*;
import classfile.*;

class MyNode{
    public MyNode[] arr = new MyNode[26];
    public boolean isWord;
    public MyNode(boolean isWord){
        this.isWord = isWord;
    }
}

class Tries{
    public MyNode root;
    public Tries(){
        root = new MyNode(true);
    }
}


public class Tries2{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();
        int k = 0;
        String str = "abc";
        Tries t = new Tries();
        insert(t.root, str, k);

        System.out.println("[" + contains(t.root, str, k) + "]"); 
        System.out.println("[" + contains(t.root, "a", k) + "]"); 
        System.out.println("[" + contains(t.root, "", k) + "]"); 
        System.out.println("[" + contains(t.root, "d", k) + "]"); 

        Aron.end();
    }

    public static void insert(MyNode root, String str, int k){
        if(k == str.length()){
            root.isWord = true;    
        }
        else if(k < str.length()){
            int inx = getInt(str.charAt(k)); 
            MyNode node = root.arr[inx];
            if(node != null){
                insert(node, str, k+1);
            }else{
                root.arr[inx] = new MyNode(false);
                insert(root.arr[inx], str, k+1);
            }
        }
    }

    public static boolean contains(MyNode root, String str, int k){
        if(k < str.length()){
            int inx = str.charAt(k) - 'a';
            if(root.arr[inx] != null){
                contains(root.arr[inx], str, k+1);
            }else{
                return false;
            }
        }else{
           return root.isWord;
        }
        return true;
    }
    public static int getInt(char ch){
        return ch - 'a';
    }
} 
