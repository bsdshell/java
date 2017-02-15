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
import java.io.IOException;

import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import classfile.*;

 
// concurrent, thread, atomic integer, atomicinteger  atomic modulo, 
// mod atomic integer
class AtomicModulo{
    public AtomicInteger n = new AtomicInteger(0);
    int len;
    public AtomicModulo(int len){
        this.len = len;
    }
    public int modulo(){
        return n.incrementAndGet() % len;
    }
    public int get(){
        return n.get();
    }
}

class HelloThread implements Runnable {
    private final static Logger LOGGER = Logger.getLogger(Thread_AtomicModulo.class.getName());
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    private AtomicModulo atom;
    public HelloThread(AtomicModulo atom){
        this.atom = atom;
        try{
            fileTxt = new FileHandler("../text/atomic1.txt");
            formatterTxt = new SimpleFormatter();
            LOGGER.setLevel(Level.INFO);
            fileTxt.setFormatter(formatterTxt);
            LOGGER.addHandler(fileTxt);
        }catch(IOException e){
            e.printStackTrace();
        } 

        if(fileTxt != null)
            fileTxt.close();
    }
    public void run(){
        doWork();
    }
    
    public void doWork(){
      while(true){
          int num = atom.n.incrementAndGet();
          Print.pbl("mod=" + (num % atom.len) + " n=" + num + " id=" + Thread.currentThread().getId());
          LOGGER.info("mod=" + (num % atom.len) + " n=" + num + " id=" + Thread.currentThread().getId()); 

          try{
              Thread.sleep(2000); 
          }catch(InterruptedException e) {}
      }
    }
}

public class Thread_AtomicModulo{
    public static void main(String[] args) {
        test0();
    }
    
    static void test0(){
        Aron.beg();

        Print.pbl("Thread_AtomicModulo.java");
        int len = 2;
        AtomicModulo am = new AtomicModulo(len);
        for(int i=0; i<3; i++){
            Thread t = new Thread(new HelloThread(am));
            t.start();
        } 

        Aron.end();
    }
    
    static void test1(){
        Aron.beg();


        Aron.end();
    }
}
