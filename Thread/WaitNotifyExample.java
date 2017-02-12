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
    public static void main(String[] args){
        ThreadB b = new ThreadB();
        b.start();
 
        synchronized(b){
            try{
                System.out.println("Waiting for b to complete...");
                Aron.threadInfo(b);
                b.wait();
                Aron.threadInfo(b);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
 
            System.out.println("Total is: " + b.total);
        }
    }
}
 
class ThreadB extends Thread{
    int total;
    @Override
    public void run(){
        synchronized(this){
            for(int i=0; i<10 ; i++){
                Aron.threadInfo(this);
                try{
                    Thread.sleep(1000);  // sleep two seconds
                }catch(InterruptedException e){
                    e.printStackTrace();
                } 

                total += i;
            }
            notify();
            Aron.threadInfo(this);
        }
    }
}
