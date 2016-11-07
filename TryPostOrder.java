import java.util.*;
import java.io.*;
import classfile.*;

public class TryPostOrder{
    public static void main(String[] args) {
        //test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        BST b = Aron.createBin();
        postorder(b.root);
        
        Aron.end();
    }
    
    static void test1(){
        Aron.beg();
        BST b = Aron.createBin();
        printSequence(b.root);

        Aron.end();
    }
    
    public static void postorder(Node r){
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        if(r != null){
            s1.push(r);
            while(!s1.empty()){
                Node n = s1.pop();
                if(n.left != null)
                    s1.push(n.left);
                if(n.right != null)
                    s1.push(n.right);
                s2.push(n);
            }
            while(!s2.empty())
                Print.pbl(s2.pop().data);
        }
    }
    static void test2(){
        Aron.beg();
        Aron.end();
    }

    public static void printSequence(Node r){
       Stack<Node> s1 = new Stack<>();  
       Stack<Node> s2 = new Stack<>();  
       if(r != null){ 
           s1.push(r);
           while(!s1.empty() || !s2.empty()){
               while(!s1.empty()){
                   Node n = s1.pop();
                   Print.p(n.data);

                   if(n.left != null)
                       s2.push(n.left);
                   if(n.right != null)
                       s2.push(n.right);
               }

               while(!s2.empty()){
                   Node n = s2.pop();
                   Print.p(n.data);
                   if(n.right != null)
                       s1.push(n.right);
                   if(n.left != null)
                       s1.push(n.left);
               }
           }
           
       }
    }
} 

