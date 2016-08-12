import java.util.*;
import java.io.*;
import classfile.*;

//[ file=lock.html title=""
class MyLock{
    private boolean isLocked = false;

    public synchronized boolean lock(){
        if(!isLocked){
            isLocked = true;
            return isLocked;
        }
        return false;
    }
    public synchronized void unlock(){
        isLocked = false;
        notify();
    }
}
//]

public class LockExample{
    public static void main(String[] args) {
    }
    public static void print(){
    }
    static void test0(){
        Aron.beg();
        Aron.end();
    }
} 
