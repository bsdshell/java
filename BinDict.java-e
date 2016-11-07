import java.util.*;
import java.io.*;
import classfile.*;

public class BinDict{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
    static void test0(){
        Aron.beg();
        BST bst = new BST();

        // read dictionary file
        List<String> list = Aron.readFile("text/words.txt"); 

        // add dictionary file to list
        int count = 0;
        while(count < list.size()){
            Random ran = new Random();
            int index = ran.nextInt(list.size());
            //Print.p("index=[" + index + " " + list.size());
            bst.insert(list.indexOf(index));
            list.remove(index);
            //Print.p(list.indexOf(index));
        }

          Aron.inorder(bst.root);
//        Test.t(bst.contains("cat".hashCode()));
//
//        Print.pl("level=" + Aron.level(bst.root));

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        BST bst = new BST();
        bst.insert(1);
        bst.insert(2);
        bst.insert(3);

        Test.t(Aron.height(bst.root) == 2);
        Test.t(Aron.level(bst.root) == 3);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        
        Aron.end();
    } 
} 
