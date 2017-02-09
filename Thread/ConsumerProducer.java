import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import classfile.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue; 
import java.util.LinkedList; 
import java.util.concurrent.atomic.AtomicInteger;
 
// consumer and producer, consumer producer problem,
// multiple therad consumer producer 
class MyProducer extends Thread {
    static final int MAXQUEUE = 5;
    private Queue queue = new LinkedList();
 
    @Override
    public void run() {
        try {
            while (true) {
                putMessage();
                //sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }
 
    private synchronized void putMessage() throws InterruptedException {
        while (queue.size() == MAXQUEUE) {
            wait();
        }
        queue.add(new java.util.Date().toString());
        System.out.println("Put message");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }
    public synchronized String getMessage() throws InterruptedException {
        notify();
        Aron.threadInfo();
        Ut.l();

        while (queue.size() == 0) {
            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        String msg = (String) queue.poll();
        
        Print.pbl("msglen[" + queue.size() + "]");
        return msg ;
    }
}
 
class MyConsumer extends Thread {
    MyProducer producer;
    MyConsumer(MyProducer p) {
        producer = p;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                Print.pbl("getmsg[" + message + "]");
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConsumerProducer{
    public static void main(String[] args) {
        MyProducer producer = new MyProducer();
        producer.start();
        
        for(int i=0; i<5; i++){
            new MyConsumer(producer).start();
        } 
    }
}
