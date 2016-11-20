import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryTime{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        XTime.start();
        for(int i=0; i<1000000; i++)
            Print.pbl(i);
            
        XTime.stop();
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

