import java.util.concurrent.locks.*;
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

class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}



// conditional variable with Lock, ReentrantLock, Conditon
// signal whether one variable is available or not
class ConditionVar{
    private int contents;
    private boolean available = false;
    private Lock aLock = new ReentrantLock();
    private Condition condVar = aLock.newCondition();

    public int get(int who) {
        aLock.lock();
        try {
            while (available == false) {
                try {
                    condVar.await();
                } catch (InterruptedException e) { }
            }
            available = false;
            System.out.println("Consumer " + who + " got: " + contents);
            condVar.signalAll();
        }
        finally {
            aLock.unlock();
            return contents;
        }
    }


    public void put(int who, int value) {
        aLock.lock();
        try {
            while (available == true) {
                try {
                    condVar.await();
                } catch (InterruptedException e) { }
            }
            contents = value;
            available = true;
            System.out.println("Producer " + who + " put: " +
                               contents);
            condVar.signalAll();
        }
        finally {
            aLock.unlock();
        }
    }
}

class ConditionalVariable{
    public static void main(String args[]) {
        test0();
    }
    static void test0(){
        Aron.beg();
        ConditionVar cv = new ConditionVar();
        int c = cv.get(1);
        Print.pbl("c=" + c);
        cv.put(2, 20);
        int c1 = cv.get(1);
        Print.pbl("c1=" + c1);

        Aron.end();
    }
}
