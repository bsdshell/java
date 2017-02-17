import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class Pi{
    public static void main(String[] args) {
        test0();
        test1();
    }

    public static double calculatePI(int nStep){
       double pi = 1.0;
       for(int i=1; i<nStep; i++){
           if(i % 2 == 1)
               pi += (double)-1/(2*i + 1);
           else
               pi += (double)1/(2*i + 1);
       } 
       Print.pbl(4*pi);
       return 4*pi;
    }
    public static void test0(){
        Aron.beg();
        int nStep = 1000;
        calculatePI(nStep);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

