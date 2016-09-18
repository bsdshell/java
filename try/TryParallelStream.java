import java.util.*;
import java.io.*;
import classfile.*;

public class TryParallelStream {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        Random ran = new Random();
        double total = 0.0;
        final int max = 1000000;
        Double[] arr = new Double[max];
        for(int i=0; i<max; i++){
            double num = ran.nextDouble();
            arr[i] = num;
        } 


        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Aron.end();
    }
}

