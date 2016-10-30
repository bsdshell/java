import java.util.*;
import java.io.*;
import classfile.*;

public class ExeCommand{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        String output = Aron.executeCommand("ls");
        Print.pbl(output);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

