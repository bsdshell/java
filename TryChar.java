import java.util.*;
import java.io.*;
import classfile.*;

public class TryChar{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        //char ch = Aron.intToChar(Aron.charToInt('a') + 0);
        int n = Aron.charToInt('a');
        Print.p("[" + n + "]");


        int dig = Character.digit('b', 10);
        Print.p("[" + dig + "]");

        int ucode = Character.getNumericValue('\u216c');
        Print.p("[" + ucode + "]");

        int n1 = Character.getNumericValue('a');
        char char1 = 'a' + 0;
        Print.p("a=[" + n1 + "]");
        Print.p("char1=[" + char1 + "]");


        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

