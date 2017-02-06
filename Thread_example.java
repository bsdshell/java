import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import classfile.*;

class AtomicCount{
    private AtomicInteger num = new AtomicInteger(0);
    public AtomicCount(){
    }
    public void add(){
        int n = num.getAndIncrement();
        Print.pbl("n=" + n);
    } 
    public int get(){
        return num.get();
    }

    public void print(){
        Print.pbl("num=" + num.get());
        int n = num.getAndIncrement();
        Print.pbl("num.getAndIncrement()=" + n);
        int newValue = num.getAndSet(10);
        Print.pbl("newValue=" + newValue);

        for(int i=0; i<3; i++){
            int n1 = num.getAndIncrement();
            Print.pbl("n1=" + n1);
        }

    }
}

class AtomicCountThread implements Runnable{
    AtomicCount ac;
    public AtomicCountThread(AtomicCount ac){
        this.ac = ac;
    }
    public void run(){
        ac.add();
    }
}


class MyLock{
    private boolean isLocked = false;
    public synchronized boolean lock(){
        if(!isLocked){
            isLocked = true;
            return isLocked;
        }
        return false;
    }
    public synchronized void unlock(){
        isLocked = false;
    }
}

class DeleteLinkedList{
    public SingleLinkedList sll;
//    public SingleLinkedList sll = new SingleLinkedList(); 
    int count = 0;
    public DeleteLinkedList(){
        sll = new SingleLinkedList(); 
    }
//    public synchronized void add(){
    public void add(){
        synchronized(this){
            count++;
            sll.add(new Node(count));
        }
    }
}

class ConcurrentQueue{
    // ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    Queue<Node> queue = new LinkedList<Node>();
    MyLock lock = new MyLock();
    //ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    int sum = 0;
    public void add(){
        if(lock.lock()){
            sum++;
            queue.add(new Node(sum));
        }
    }
//    public synchronized void add(){
//        sum++;
//        queue.add(new Node(sum));
//    }
    public void remove(){
        queue.poll();
    }
    public void print(){
        while(!queue.isEmpty()){
            Node n = (Node)queue.poll();
            Print.pbl(n.data);
        }
    }
}

class QueueThread implements Runnable{
    ConcurrentQueue queue;
    public QueueThread(ConcurrentQueue q){
        queue = q;
    }
    public void run(){
        queue.add();        
    }
}


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
                Thread.sleep(1000);
            }catch(InterruptedException e) {}
        }
        else
            Print.pbl("queue is empty");
    }
}

class ThreadLinkedList implements Runnable{
    DeleteLinkedList dll;
    public ThreadLinkedList(DeleteLinkedList dll){
        this.dll = dll;
    }
    public void run(){
        dll.add();
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
//        test1();
//        test2();
//        test3();
//        test4();
        test5();
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
    public static void test2(){
        Aron.beg();
        
        DeleteLinkedList dll = new DeleteLinkedList();
        for(int i=0; i<1000; i++){
            Thread t = new Thread(new ThreadLinkedList(dll));
            t.start();
        }

        dll.sll.print();

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        ConcurrentQueue queue = new ConcurrentQueue();

        for(int i=0; i<50; i++){
            Thread t = new Thread(new QueueThread(queue));
            t.start();
        } 

        queue.print();
        
        Aron.end();
    }
    public static void test4(){
        AtomicCount count = new AtomicCount();
        count.print();
    }

    public static void test5(){
        AtomicCount ac = new AtomicCount(); 
        for(int i=0; i<10; i++){
            Thread t = new Thread(new AtomicCountThread(ac));
            t.start();
        }
    }
} 

