import java.util.*;
import java.io.*;
import classfile.*;

class Singleton {
    private static Singleton instance;
    private Vector v;
    private boolean inUse;
    private
    Singleton() {
        v = new Vector();
        v.addElement(new Object());
        inUse = true;
    } public
    static Singleton getInstance() {
        if (instance == null) //1
            instance = new
            Singleton(); //2
        return instance; //3
    }
}

public static Singleton
getInstance() {
    if (instance == null) {
        synchronized(Singleton.class) { //1
            if (instance == null) //2
                instance = new Singleton(); //3
        }
    }
    return instance;
}


public static synchronized Singleton getInstance() {
    if (instance == null) //1
        instance = new Singleton(); //2
    return instance; //3
}

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


public class TrySS {
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

