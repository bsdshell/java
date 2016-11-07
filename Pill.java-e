import java.util.*;
import java.io.*;
import classfile.*;

public class Pill{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();
        int x = 4;
        int y = 5;
        pill(x, y);
        Aron.end();
    }
    static void pill(int x, int y){
        if(x > 0 && y > 0){
            System.out.println("[" + x + " " + (y-1) + "]"); 
            pill(x, y-1);
            System.out.println("[" + (x-1) + " " + y + "]"); 
            pill(x-1, y);
        }
    }
} 
