import java.util.*;
import java.io.*;
import classfile.*;

class Singleton {
    private Vector v;
    private boolean inUse;
    private static Singleton instance = new Singleton();

    private Singleton() {
        v = new Vector();
        inUse = true; //...
    } 

    public static Singleton getInstance() {
        return instance;
    }
}

class Singleton {
    private static Singleton single = new Singleton();
    private Singleton() {
    }
    public static Singleton getInstance() {
        if(single == null) {
            return new Singleton();
        }
        return single;
    }
}

public class TryS1 {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Aron.end();
    }
}

