import java.util.*;
import java.io.*;
import classfile.*;

interface Maybe<T>{
}

class Just implements Maybe<String>{
    public Just(String s){
    }
}

class Nothing implements Maybe{
    public Nothing(){}
}

public class TryMaybe{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

