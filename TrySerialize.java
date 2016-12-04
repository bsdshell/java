import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TrySerialize{
    public static void main(String[] args) {
        test0();
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
        Aron.binImage(b1.root); 

        List<String> list = new ArrayList<String>(); 
        inorder(b1.root, list);
        Aron.printList(list);


        Iterator<String> ite = list.iterator(); 
        Node root = serialize(ite);

        level = 0;
        isLeaf = true;
        Aron.prettyPrint(root, level, isLeaf);
        Aron.binImage(root); 

    }
    public static void inorder(Node r, List<String> list){
        if(r != null){
            list.add(r.data + "");
            inorder(r.left, list);
            inorder(r.right, list);
        }else{
            list.add("#");
        }
    }
    
    public static Node serialize(Iterator<String> ite){
        if(ite.hasNext()){
            String s = ite.next();
            if(!s.equals("#")){
                Node parent = new Node(s);
                parent.left = serialize(ite); 
                parent.right = serialize(ite);
                return parent;
            }
        }
        return null;
    }
} 

