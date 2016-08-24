import java.util.*;
import java.io.*;
import classfile.*;

class MyNode{
    public MyNode[] arr = new MyNode[26];
    public boolean isWord;
    public String word;
    public MyNode(boolean isWord){
        this.isWord = isWord;
        word = null;
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
        test1();
        test2();
        test3();
    }
    static void test2(){
        Aron.beg();
        String str = "abc";
        Print.p((int)str.charAt(0));
        Print.p(str.codePointAt(0));
        Aron.end();
    } 
   
    static void test0(){
        Aron.beg();
        int k = 0;
        String str = "abc";
        Tries t = new Tries();
        insert(t.root, str, k);

        Test.t(contains(t.root, str, k));
        Test.t(contains(t.root, "", k));
        Test.f(contains(t.root, "a", k));
        Test.f(contains(t.root, "d", k));

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        int k = 0;
        String str1 = "tea";
        String str2 = "ten";
        String str3 = "tenny";
        String str4 = "tee";
        String str5 = "teyo";
        Tries t = new Tries();
        insert(t.root, str1, k);
        insert(t.root, str2, k);
        insert(t.root, str3, k);
        insert(t.root, str4, k);
        insert(t.root, str5, k);

        Test.t(contains(t.root, str1, k));
        Test.t(contains(t.root, str2, k));
        Test.t(contains(t.root, str3, k));
        Test.t(contains(t.root, str4, k));
        Test.t(contains(t.root, str5, k));

        Test.f(contains(t.root, "t", k));
        Test.f(contains(t.root, "te", k));
        Test.f(contains(t.root, "teee", k));
        Test.f(contains(t.root, "teae", k));

        List<String> list = new ArrayList<String>(); 
        String partialWord = "te";
        MyNode node = autoComplete(t.root, partialWord, k);
        getList(node, list);
        Aron.line();
        Aron.printList(list);

        Aron.end();
    }
    static void test3(){
        Aron.beg();
        int k = 0;
        String str1 = "tea";
        String str2 = "ten";
        String str3 = "tenny";
        String str4 = "tee";
        String str5 = "teyo";
        Tries t = new Tries();
        insert(t.root, str1, k);
        insert(t.root, str2, k);
        insert(t.root, str3, k);
        insert(t.root, str4, k);
        insert(t.root, str5, k);

        List<String> list = new ArrayList<String>(); 
        String partialWord = "te";
        MyNode node = autoComplete(t.root, partialWord, k);
        getList(node, list);
        Aron.line();
        Print.plb(partialWord);
        Aron.printList(list);

        Aron.end();
    }

    public static void insert(MyNode root, String str, int k){
        if(k == str.length()){
            root.isWord = true;    
            root.word = str;
        }
        else if(k < str.length()){
            int inx = Aron.charIndex(str.charAt(k)); 
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
            int inx = Aron.charIndex(str.charAt(k)); 
            if(root.arr[inx] != null){
                return contains(root.arr[inx], str, k+1);
            }else{
                return false;
            }
        }else{
           return root.isWord;
        }
    }

    public static MyNode autoComplete(MyNode root, String str, int k){
        if(k < str.length()){
            int inx = Aron.charIndex(str.charAt(k)); 
            if(root.arr[inx] != null){
                return autoComplete(root.arr[inx], str, k+1);
            }else{
                return null;
            }
        }else{
           return root;
        }
    }
    public static void getList(MyNode node, List<String> list){
        for(int i=0; i<node.arr.length; i++){
            if(node.arr[i] != null){
                if(!node.arr[i].isWord){
                    getList(node.arr[i], list);
                }else{
                    list.add(node.arr[i].word);
                }
            }
        }
    }
} 
