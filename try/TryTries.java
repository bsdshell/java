import java.util.*;
import java.io.*;
import classfile.*;

class TNode{
    boolean isWord;
    Map<String, TNode> map = new HashMap<>();
    public TNode(boolean isWord){
        this.isWord = isWord;
    }
}


public class TryTries {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();

        String[] arr = {"techie"}; 
        int index = 0;
        TNode root = new TNode(true);
        for(String s : arr){

            insert(root, s, index);
        }
        String str = "techie";
        index = 0;
        Test.t(contains(root, str, index));

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        String[] arr = {"techie", "dangling", "c", "ca", "cat", "scene", "ancestor", "scene", "descend", "descended", "sibling", "dangling"}; 
        int index = 0;
        TNode root = new TNode(true);
        for(String s : arr){

            insert(root, s, index);
        }
        String str = "techie";
        index = 0;
        Test.t(contains(root, "c", index));
        Test.t(contains(root, "ca", index));
        Test.t(contains(root, "cat", index));
        Test.f(contains(root, "cats", index));
        Test.t(contains(root, "scene", index));
        Test.f(contains(root, "sence", index));
        Test.f(contains(root, "cense", index));

        Aron.end();
    }

    // 2:40
    //                      [ {a}, {b}] 
    //   [ iw = true { } { }]     [ iw = true { } { }]
    public static void insert(TNode parent, String str, int index){
        if(index < str.length()){
            String k = str.charAt(index) + ""; 
            TNode child = parent.map.get(k);
            if(child == null){
                parent.map.put(k, new TNode(false));
            }
            insert(parent.map.get(k), str, index + 1);
        }else{
            parent.isWord = true;
        }
    }
    // a
    //
    public static boolean contains(TNode parent, String str, int index){
        if(index < str.length()){
            String k = str.charAt(index) + "";
            TNode child = parent.map.get(k);
            return child == null? false : contains(child, str, index + 1);
        }else{
            return parent.isWord;
        }
    }
}

