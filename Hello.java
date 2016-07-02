import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("---------------------------------\n"); 
        Integer[][] arr = new Integer[10][10];
        Aron.printArray2D(arr);
        test0();
    }
    static void test0(){
        System.out.println("---------------------------------\n");
        SLL s = new SLL();
        s.append(3);
        System.out.println("---------------------------------\n");
    }
}
