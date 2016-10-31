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

     public synchronized void addNodeSync(){
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
        Aron.line();
    }

    public void addNodeNonSync(){
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
        Aron.line();
    }
}

class SimpleThread implements Runnable{
    Account acc;
    public SimpleThread(Account acc){
        this.acc = acc;
    }
    public void run(){
        //acc.deposit(1);
        acc.addNodeSync();
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
        Account acc = new Account();
        for (int i = 0; i < 4; i++) {

            StopWatch sw = new StopWatch();
            sw.start();

            Thread t = new Thread(new SimpleThread(acc));
            t.start();

            sw.stop();
        }

    }
}
//]
