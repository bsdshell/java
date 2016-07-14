//package com.company;
import classfile.*;

//[ file=synthread.html title=""
class Account{
    int balance = 0;
    public Account(){
    }
    public synchronized void deposit(int n){
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
}

class SimpleThread implements Runnable{
    Account acc;
    public SimpleThread(Account acc){
        this.acc = acc;
    }
    public void run(){
        acc.deposit(1);
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

public class Main {
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
        Aron.beg();
        TestJoin t1 = new TestJoin();
        TestJoin t2 = new TestJoin();
        TestJoin t3 = new TestJoin();

        t1.start();
        try{
            t1.join(1500);
        }catch(Exception e){
        }

        t2.start();
        t3.start();

        Aron.end();
    }
}
//]
