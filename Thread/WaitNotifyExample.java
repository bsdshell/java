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

// wait and notify example
public class WaitNotifyExample{
        //private final static Logger LOGGER = Logger.getLogger(WaitNotifyExample.class.getName());
        private final static Logger LOGGER = logInit(WaitNotifyExample.class.getName());
        static private SimpleFormatter formatterTxt = new SimpleFormatter();
        static FileHandler fileTxt;

        public static Logger logInit(String name){
            Logger LOGGER = Logger.getLogger(name);
            try{
                fileTxt = new FileHandler("../text/Logging3.txt");
            }catch(IOException e){
                e.printStackTrace();
            } 

            LOGGER.setLevel(Level.INFO);
            LOGGER.addHandler(fileTxt);
            fileTxt.setFormatter(formatterTxt);
            return LOGGER;
        }
        public static void main(String[] args){

//        try{
//            fileTxt = new FileHandler("../text/Logging3.txt");
//        }catch(IOException e){
//            e.printStackTrace();
//        } 
//
//        LOGGER.setLevel(Level.INFO);
//        LOGGER.addHandler(fileTxt);
//        fileTxt.setFormatter(formatterTxt);

        ThreadB b = new ThreadB(LOGGER);
        b.start();
 
        //Aron.threadInfo(b);
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                
                LOGGER.info("logging it"); 
                LOGGER.info(Aron.threadInfo(b)); 
                
                b.wait();
                Print.pbl("get notified");
                Aron.threadInfo(b);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
//        if(fileTxt != null)
//            fileTxt.close();
    }
}
 
class ThreadB extends Thread{
    int total;
    Logger LOGGER;
    public ThreadB(){}
    public ThreadB(Logger LOGGER){
        this.LOGGER = LOGGER;
    }
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<5; i++){
//                Aron.threadInfo(this);
                LOGGER.info(Aron.threadInfo(this)); 
                try{
                    Thread.sleep(1000);  // sleep two seconds
                }catch(InterruptedException e){
                    e.printStackTrace();
                } 

                total += i;
            }
            notify();
//            Aron.threadInfo(this);
        }
    }
}
