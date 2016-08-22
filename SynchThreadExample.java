import classfile.*;
import java.lang.management.ManagementFactory;

//[ file=synthread.html title=""
class Account{
    int balance = 0;
    public Account(){
    }
    //public synchronized void deposit(int n){
    public void deposit(int n){
        for(int i=0; i<3; i++) {
            balance += n;
            System.out.println("acc=[" + balance + "]");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void addNode(){
//    public void addNode(){
        SingleLinkedList sll = new SingleLinkedList();
        for(int i=0; i<5; i++){
            sll.append(i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
        Aron.printSLL(sll.head);
    }
}

class SimpleThread implements Runnable{
    Account acc;
    public SimpleThread(Account acc){
        this.acc = acc;
    }
    public void run(){
        acc.deposit(1);
        //acc.addNode();
    }
}

class TestJoin extends Thread{
    public void run(){
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("[id=" + getId() + " name=" + getName() + "]["+i+"]");
        }
    }
}

public class SynchThreadExample{
    public static void main(String[] args) {
        //test0();
        test1();
    }

    static void test0(){
        Account acc = new Account();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new SimpleThread(acc));
            t.start();
        }
    }
    static void test1(){
        Account acc = new Account();
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(new SimpleThread(acc));
            t.start();
        }
    }
}
//]

//public class ExampleClass {
//class LongRunningThread extends Thread {
//    private int n;
//    public LongRunningThread(int n) {
//        this.n = n;
//    }
//    public void run() {
//        ArrayList l = new ArrayList();
//        for (int i = 0; i < n; i++) {
//            l.add(new Object());
//        }
//        long time = ManagementFactory.getThreadMXBean().getThreadCpuTime(this.getId());
//        System.out.println("Long running thread " + this.getId() + " execution time: " + time);
//    }
//}
//
//class MyThread extends Thread {
//    int n;
//    public MyThread(int n) {
//        this.n = n;
//    }
//    public void run() {
//        ArrayList l = new ArrayList();
//        for (int i = 0; i < n; i++) {
//            l.add(new Object());
//        }
//        long time = ManagementFactory.getThreadMXBean().getThreadCpuTime(this.getId());
//        System.out.println("My thread " + this.getId() + " execution time: " + time);
//    }
//}
//
//public static void main(String [] args) {
//        System.out.println("Cpu time supported? " + ManagementFactory.getThreadMXBean().isThreadCpuTimeSupported());
//    System.out.println("Cpu time enabled? " + ManagementFactory.getThreadMXBean().isThreadCpuTimeEnabled());
//    for (int i = 1; i < 10; ++i) {
//        new LongRunningThread(i*1000000).start();
//    }
//
//    for (int i = 1; i < 10; ++i) {
//        new MyThread(i*100).start();
//    }
//}
//
//
//Output:
//Cpu time supported? true
//Cpu time enabled? true
//My thread 18 execution time: 0
//My thread 26 execution time: 0
//My thread 20 execution time: 0
//My thread 22 execution time: 0
//My thread 24 execution time: 0
//My thread 21 execution time: 0
//My thread 25 execution time: 0
//My thread 19 execution time: 0
//My thread 23 execution time: 0
//Long running thread 9 execution time: 15600100
//Long running thread 10 execution time: 15600100
//Long running thread 11 execution time: 46800300
//Long running thread 12 execution time: 31200200
//Long running thread 14 execution time: 78000500
//Long running thread 13 execution time: 78000500
//Long running thread 17 execution time: 124800800
//Long running thread 15 execution time: 140400900
//Long running thread 16 execution time: 109200700
