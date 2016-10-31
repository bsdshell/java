import java.util.*;
import java.io.*;
import classfile.*;

public class TryChar1{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        char ch = Aron.intToChar(65);
        int num = Aron.charToInt('A');
        Print.p("ch=" + (ch + ""));
        Print.p("num=" + num);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

