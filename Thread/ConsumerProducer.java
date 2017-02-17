import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Queue; 
import java.util.LinkedList; 
import java.util.concurrent.atomic.AtomicInteger;

import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
//
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
//
import classfile.*; 

 
// consumer and producer, consumer producer problem,
// multiple therad consumer producer 
class MyProducer extends Thread {
    static final int MAXQUEUE = 2;
    private Queue queue = new LinkedList();
    Logger LOGGER;
 
    public MyProducer(Logger LOGGER){
        this.LOGGER = LOGGER;
    }

    @Override
    public void run() {
        try {
            while (true) {
//                Print.pbl("put msglen[" + queue.size() + "]");
                putMessage();
                //sleep(5000);
            }
        } catch (InterruptedException e) {
        }
    }
 
    private synchronized void putMessage() throws InterruptedException {
        while (queue.size() == MAXQUEUE) {
            wait(1000);
        }
        queue.add(new java.util.Date().toString());
//        System.out.println("Put message");
        notify();
        //Later, when the necessary event happens, the thread that is running it calls notify() from a block synchronized on the same object.
    }
    public synchronized String getMessage() throws InterruptedException {
        notify();
        Aron.threadInfo(this);
        Ut.l();

        while (queue.size() == 0) {
            wait(1000);//By executing wait() from a synchronized block, a thread gives up its hold on the lock and goes to sleep.
        }
        String msg = (String) queue.poll();
        
        Print.pbl("msglen[" + queue.size() + "] msg=" + msg);
        return msg ;
    }
}
 
class MyConsumer extends Thread {
    MyProducer producer;
    Logger LOGGER;
    MyConsumer(Logger LOGGER, MyProducer p) {
        this.LOGGER = LOGGER;
        producer = p;
    }
    MyConsumer(MyProducer p) {
        producer = p;
    }
 
    @Override
    public void run() {
        try {
            while (true) {
                String message = producer.getMessage();
                Print.pbl("getmsg[" + message + "]");
                LOGGER.info("getmsg=" + message); 
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ConsumerProducer{
    public static void main(String[] args) {
        Logger LOGGER = Aron.logInit(MyProducer.class.getName(), "/Users/cat/myfile/github/java/text/Logging3.txt");

        MyProducer producer = new MyProducer(LOGGER);
        producer.start();
        
        for(int i=0; i<2; i++){
            new MyConsumer(LOGGER, producer).start();
        } 
    }
}
