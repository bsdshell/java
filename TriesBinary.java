import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

// gx http://www.geeksforgeeks.org/find-pair-rows-binary-matrix-maximum-bit-difference/
// count the maximum different bits in binary matrix
class TNode{
    public TNode[] arr = new TNode[2];
    public boolean isWord = false;
    public TNode(boolean isWord){
        this.isWord = isWord;
    }
    public TNode(){
    }
}

public class TriesBinary{
    public static void main(String[] args) {
//        test0();
//        test1();
        test2();
    }
    public static void insert(TNode node, String s, int index){
        if(index < s.length()){
            int inx = s.charAt(index) - '0';
            if(node.arr[inx] == null)
                node.arr[inx] = new TNode(false);
            insert(node.arr[inx], s, index+1);
        }else{
            node.isWord = true;
        }
    }
    public static boolean contains(TNode root, String s, int index){
        if(s != null){
            if(index < s.length()){
                int n = s.charAt(index) - '0';    
                if(root.arr[n] == null)
                    return false;
                else
                    return contains(root.arr[n], s, index+1);
            }else{
                return root.isWord;
            }
        }
        return false;
    }
    
    public static void print(TNode node){
        if(node != null){
            if(node.arr[0] != null){
                Print.pp(0);
                print(node.arr[0]);
                Print.pp("\n");
            }
            if(node.arr[1] != null){
                Print.pp(1);
                print(node.arr[1]);
                Print.pp("\n");
            }
        }
    }
   
    public static int countDiff(TNode node){
        if(node != null){
            if(node.arr[0] != null && node.arr[1] != null){
                int l = countDiff(node.arr[0]);
                int r = countDiff(node.arr[1]);
                return l + r + 1;
            }
        }
        return 0;
    }
    public static void test0(){
        Aron.beg();

        String s1 = "011";
        String s2 = "111";
        String s3 = "010";
        TNode root = new TNode(true);
        int index = 0;
        insert(root, s1, index);
        insert(root, s2, index);
        insert(root, s3, index);
        print(root);
        Aron.end();
    }

    public static void test1(){
        Aron.beg();
        String[] array = {
            "011",
            "111",
            "010",
            "000",
        };
        String s1 = "011";
        String s2 = "111";
        String s3 = "010";
        TNode root = new TNode();
        int index = 0;

        for(int i=1; i<array.length; i++){
            insert(root, array[i], index);
        }

        int num = countDiff(root);
        Print.pp("num=" + num);

        Aron.end();
    }

    static void test2(){
        Aron.beg();

        String[] array = {
            "011",
            "111",
            "010",
        };
        TNode root = new TNode();
        int index = 0;

        for(int i=1; i<array.length; i++){
            insert(root, array[i], index);
        }
        
        boolean b = contains(root, "111", index);
        Test.t(b == true);
        b = contains(root, "000", index);
        Test.t(b == false);

        Aron.end();
    } 
} 

