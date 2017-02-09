import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.Date;
import java.io.*;
import java.util.stream.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import classfile.*;


class Message{
    String msg;
    public Message(String msg){
        this.msg = msg;
    }
    public String getMsg(){
        return msg;
    }
    public void setMsg(String msg){
        this.msg = msg;
    }
}

class Producer implements Runnable{
    Queue<String> queue; 
    int num = 0;
    public Producer(Queue<String> q){
        queue = q;
    }
    public void run(){
        try{
            while(true){
                add();
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void add() throws InterruptedException{
        Aron.threadInfo();

        while(queue.size() >= 10){
            wait();
        }

        num++;
        Print.pbl("add msg=" + num);
        queue.add(num + "");
        notify();
    }
    public synchronized String get() throws InterruptedException{
        notify();
        while(queue.size() == 0){
            wait();
        }
        String s = queue.poll();
        Print.pbl("s=" + s);
        return s;
    }
}

class Consumer implements Runnable{
    Producer producer;
    public Consumer(Producer producer){
        this.producer = producer;
    }
    public void run(){
        try{
            while(true){
                String s = producer.get();
                Print.pbl("get msg=" + s);
                Thread.sleep(2000);
            }
        }catch(InterruptedException e){
        }
    }
    public synchronized void remove(){
        Aron.threadInfo();
    }
}


class Waiter implements Runnable{
    Message mq;
    public Waiter(Message mq){
        this.mq = mq;
    }
    public void run(){
        synchronized(mq){
            try{
                Aron.threadInfo();
                mq.wait(); 
                Print.pbl("Waiter end");
            }
            catch(InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }
}

class Notifier implements Runnable{
    Message mq;
    public Notifier(Message mq){
        this.mq = mq;
    }
    public void run(){
        try{
            Aron.threadInfo();

            Thread.sleep(3000);
        }catch(InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        synchronized(mq){
            Print.pbl("Notifier is notifying waiting thread to wake up at=" + new Date());

            mq.notify();
        }
    }
}

class LevelPrint {
    Node r;
    public LevelPrint(Node r) {
        this.r = r;
    }
    public void print() {
        if( r != null) {
            Queue<Node> q = new LinkedList<Node>();
            q.add(r);
            while(!q.isEmpty()) {
                Node n = q.poll();
                Print.pbl(n.data);
                if(n.left != null)
                    q.add(n.left);
                if(n.right != null)
                    q.add(n.right);
            }
        }
    }
}

class ThreadLevelPrint implements Runnable {
    Node r;
    public ThreadLevelPrint(Node r) {
        this.r = r;
    }
    public void run() {
        Ut.l();
        if( r != null) {
            Queue<Node> q = new LinkedList<Node>();
            if(r != null)
                q.add(r);
                while(!q.isEmpty()) {
                    Node n = q.poll();
                    Print.pbl("t=" + n.data);
                    if(n.left != null) {
                        q.add(n.left);
                    }

                    if(n.right != null) {
                        q.add(n.right);
                    }
                }
        }
        Ut.l();
    }
}

class AtomicCount {
    private AtomicInteger num = new AtomicInteger(0);
    public AtomicCount() {
    }
    public void add() {
        int n = num.getAndIncrement();
        Print.pbl("n=" + n);
    }
    public int get() {
        return num.get();
    }

    public void print() {
        Print.pbl("num=" + num.get());
        int n = num.getAndIncrement();
        Print.pbl("num.getAndIncrement()=" + n);
        int newValue = num.getAndSet(10);
        Print.pbl("newValue=" + newValue);

        for(int i=0; i<3; i++) {
            int n1 = num.getAndIncrement();
            Print.pbl("n1=" + n1);
        }

    }
}

class AtomicCountThread implements Runnable {
    AtomicCount ac;
    public AtomicCountThread(AtomicCount ac) {
        this.ac = ac;
    }
    public void run() {
        ac.add();
    }
}


class MyLock {
    private boolean isLocked = false;
    public synchronized boolean lock() {
        if(!isLocked) {
            isLocked = true;
            return isLocked;
        }
        return false;
    }
    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}

class LockThread extends Thread{
    MyLock lock;
    public LockThread(MyLock lock){
        this.lock = lock;
    }
//    public void run(){
//        if(lock.lock()){
//            for(int i=0; i<30; i++){
//                Print.pbl("thread id=" + Thread.currentThread().getId() + "-> i=" + i);
//            } 
//            lock.unlock();
//        }
//    }
    public synchronized void run(){
        for(int i=0; i<10; i++){
            Print.pbl("thread id=" + Thread.currentThread().getId() + "-> i=" + i);
        } 
    }
}

class DeleteLinkedList {
    public SingleLinkedList sll;
//    public SingleLinkedList sll = new SingleLinkedList();
    int count = 0;
    public DeleteLinkedList() {
        sll = new SingleLinkedList();
    }
//    public synchronized void add(){
    public void add() {
        synchronized(this) {
            count++;
            sll.add(new Node(count));
        }
    }
}

class ConcurrentQueue {
    // ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    Queue<Node> queue = new LinkedList<Node>();
    MyLock lock = new MyLock();
    //ConcurrentLinkedQueue queue = new ConcurrentLinkedQueue();
    int sum = 0;
    public void add() {
        if(lock.lock()) {
            sum++;
            queue.add(new Node(sum));
        }
    }
//    public synchronized void add(){
//        sum++;
//        queue.add(new Node(sum));
//    }
    public void remove() {
        queue.poll();
    }
    public void print() {
        while(!queue.isEmpty()) {
            Node n = (Node)queue.poll();
            Print.pbl(n.data);
        }
    }
}

class QueueThread implements Runnable {
    ConcurrentQueue queue;
    public QueueThread(ConcurrentQueue q) {
        queue = q;
    }
    public void run() {
        queue.add();
    }
}


// simple thread example, thread simple
class Account {
    int sum = 0;
    Node root;
    Queue<Node> queue = new LinkedList<Node>();
    int max = 10;
    public Account() {
    }
    public Account(Node root) {
        this.root = root;
    }
    public synchronized void increase(int n) {
        sum += n;
        Print.pbl("sum=" + sum);
    }

    public synchronized void printLevel() {
        Node curr = root;
        Queue<Node> q = new LinkedList<Node>();
        if(curr != null) {
            q.add(curr);
            while(q.size() > 0) {
                Node node = q.remove();
                Print.pbl("q.data=" + node.data);
                if(node.left != null)
                    q.add(node.left);
                if(node.right != null)
                    q.add(node.right);
            }
        }
    }

    public void doWork() {
        Random r = new Random();
        Random ran = new Random();
        int n = r.nextInt(100);

//        Print.pbl("random=" + n);
        if(n % 2 == 0) {
            add(new Node(ran.nextInt(100)));
        } else
            remove();
    }


    public synchronized void add(Node n) {
        if(queue.size() < max) {
            Print.pbl("add=" + n.data);
            queue.add(n);
        } else
            Print.pbl("queue is full");
    }
    public synchronized void remove() {
        if(queue.size() > 0) {
            Node n = queue.remove();
            Print.pbl("remove=" + n.data);
            Print.pbl("sleep 3000");

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
        } else
            Print.pbl("queue is empty");
    }
}

class ThreadLinkedList implements Runnable {
    DeleteLinkedList dll;
    public ThreadLinkedList(DeleteLinkedList dll) {
        this.dll = dll;
    }
    public void run() {
        dll.add();
    }
}

class MyThread implements Runnable {
    Account acc;
    public MyThread(Account acc) {
        this.acc = acc;
    }
    public void run() {
//        acc.increase(1);
//        acc.printLevel();
        acc.doWork();
        Ut.l();
    }
}

public class Thread_example {
    public static void main(String[] args) {
//        test0();
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//        test8();
//        test9();
//          test10();
//          test11();
          test12();
    }
    public static void test0() {
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
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new MyThread(acc));
            t.start();
        }

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        Account acc = new Account();
        for(int i=0; i<100; i++) {
            Thread t = new Thread(new MyThread(acc));
            t.start();
        }
        Aron.end();
    }
    public static void test2() {
        Aron.beg();

        DeleteLinkedList dll = new DeleteLinkedList();
        for(int i=0; i<1000; i++) {
            Thread t = new Thread(new ThreadLinkedList(dll));
            t.start();
        }

        dll.sll.print();

        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        ConcurrentQueue queue = new ConcurrentQueue();

        for(int i=0; i<50; i++) {
            Thread t = new Thread(new QueueThread(queue));
            t.start();
        }

        queue.print();

        Aron.end();
    }
    public static void test4() {
        Aron.beg();
        AtomicCount count = new AtomicCount();
        count.print();
    }

    public static void test5() {
        Aron.beg();
        AtomicCount ac = new AtomicCount();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new AtomicCountThread(ac));
            t.start();
        }
    }

    public static void test6() {
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

        LevelPrint lp = new LevelPrint(b1.root);
        lp.print();

        Aron.end();
    }

    public static void test7() {
        Aron.beg();

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7);

        int NUM = 10;
        List<Integer> list = Aron.randomUnique(NUM);
        for(Integer n : list) {
            b1.insert(n + 30);
        }

        int level = 0;
        boolean isLeaf = true;
        Aron.prettyPrint(b1.root, level, isLeaf);
        Aron.binImage(b1.root);

        LevelPrint lp = new LevelPrint(b1.root);
        lp.print();

        Ut.l();
        Print.pbl(b1.root.data);
        Thread t1 = new Thread(new ThreadLevelPrint(b1.root.left));
        t1.start();

        Thread t2 = new Thread(new ThreadLevelPrint(b1.root.right));
        t2.start();
        Ut.l();

        Aron.end();
    }

    static void test8() {
        Aron.beg();

        List<Integer> list = Aron.random(10);
        Aron.printList(list);

        Aron.end();
    }
    static void test9() {
        Aron.beg();

        List<Integer> list = Aron.randomUnique(10);
        Aron.printList(list);

        Aron.end();
    }
    static void test10() {
        Aron.beg();

        MyLock lock = new MyLock();
        for(int i=0; i<3; i++){
            LockThread lt = new LockThread(lock);
            lt.start();
        } 
        
        Aron.end();
    }

    static void test11() {
        Aron.beg();
        Message mq = new Message("my msg");
        Thread t1 = new Thread(new Waiter(mq), "Waiter Thread");
        t1.start();

        Thread t2 = new Thread(new Notifier(mq), "Notifier Thread");
        t2.start();

        Aron.threadInfo();

        Aron.end();
    }
    
    static void test12() {
        Aron.beg();
        Queue<String> queue = new LinkedList<String>(); 
        queue.add("first");
        queue.add("second");

        Producer p = new Producer(queue);
        Thread pt = new Thread(p);
        pt.start();

        for(int i=0; i<2; i++){
            Thread t = new Thread(new Consumer(p));
            t.start();
        } 

        Aron.end();
    }
    
}

