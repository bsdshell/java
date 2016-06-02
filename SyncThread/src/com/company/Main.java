package com.company;

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

public class Main {
    public static void main(String[] args) {
        Account acc = new Account();
        for(int i=0; i<10; i++) {
            Thread t = new Thread(new SimpleThread(acc));
            t.start();
        }
    }
}
//]
