import java.util.*;
import java.io.*;
import classfile.*;

public class Main{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();
        MyClass c = new MyClass();
        MyClass2 c2 = new MyClass2();
        c.display(c2);

        Aron.end();
    }

}
