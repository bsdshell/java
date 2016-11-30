import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryChar{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        char currChar = '1';
        if(Character.isLetterOrDigit(currChar)){
            Print.pbl(currChar);
        }
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

