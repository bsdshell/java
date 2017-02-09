import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import classfile.*;
 
// consumer and producer, consumer producer problem,
// multiple therad consumer producer 
class MyProducer extends Thread {
    static final int MAXQUEUE = 5;
    private Vector messages = new Vector();
 
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
        while (messages.size() == MAXQUEUE) {
            wait();
        }
        messages.addElement(new java.util.Date().toString());
        System.out.println("put message");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }
 
    // Called by Consumer
    public synchronized String getMessage() throws InterruptedException {
        notify();
        Aron.threadInfo();

        while (messages.size() == 0) {
            wait();//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        String message = (String) messages.firstElement();
        messages.removeElement(message);
        return message;
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
                System.out.println("Got message: " + message);
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
        
        for(int i=0; i<3; i++){
            new MyConsumer(producer).start();
        } 
    }
}
