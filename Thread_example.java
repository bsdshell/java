import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

//class DeleteLinkedList{
//    SingleLinkedList sll = new SingleLinkedList();  
//    public DeleteLinkedList(){
//    }
//    public void add(Node n){
//        sll.add(n);
//    }
//    public void delete(Node n){
//        sll.delete
//    }
//}


// simple thread example, thread simple
class Account{
    int sum = 0;
    Node root;
    Queue<Node> queue = new LinkedList<Node>();
    int max = 10;
    public Account(){
    }
    public Account(Node root){
        this.root = root;
    }
    public synchronized void increase(int n){
        sum += n;
        Print.pbl("sum=" + sum);
    }
    
    public synchronized void printLevel(){
        Node curr = root;
        Queue<Node> q = new LinkedList<Node>(); 
        if(curr != null){
            q.add(curr);
            while(q.size() > 0){
                Node node = q.remove();
                Print.pbl("q.data=" + node.data);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
    }

    public void doWork(){
        Random r = new Random();
        Random ran = new Random();
        int n = r.nextInt(100);

//        Print.pbl("random=" + n);
        if(n % 2 == 0){
            add(new Node(ran.nextInt(100)));
        }
        else
            remove();
    }

    public synchronized void add(Node n){
        if(queue.size() < max){
            Print.pbl("add=" + n.data);
            queue.add(n);
        }
        else
            Print.pbl("queue is full");
    }
    public synchronized void remove(){
        if(queue.size() > 0){
            Node n = queue.remove();
            Print.pbl("remove=" + n.data);
            Print.pbl("sleep 3000");

            try{
                Thread.sleep(3000);
            }catch(InterruptedException e) {}
        }
        else
            Print.pbl("queue is empty");
    }
}

class MyThread implements Runnable{
    Account acc;
    public MyThread(Account acc){
        this.acc = acc;
    }
    public void run(){
//        acc.increase(1);
//        acc.printLevel();
        acc.doWork();
        Ut.l();
    }
}

public class Thread_example{
    public static void main(String[] args) {
//        test0();
        test1();
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

        Account acc = new Account(b1.root);
        for(int i=0; i<10; i++){
            Thread t = new Thread(new MyThread(acc));
            t.start();
        }

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        
        Account acc = new Account();
        for(int i=0; i<100; i++){
            Thread t = new Thread(new MyThread(acc));
            t.start();
        }
        Aron.end();
    }
} 

