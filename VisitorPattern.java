import java.util.*;
import java.io.*;
import classfile.*;

// gf http://stackoverflow.com/questions/31986332/visitor-vs-servant-vs-command-patterns
interface IMobile{
}

class IPhone implements IMobile{
    public void turnOn(IBluetooth b){
        b.switchOn(this);
    }
}

class Android implements IMobile{
    public void turnOn(IBluetooth b){
        b.switchOn(this);
    }
}

interface IBluetooth{
    public void switchOn(IPhone iphone);
    public void switchOn(Android android);
}

class VisitorBlueTooth implements IBluetooth{
    public void switchOn(IPhone iphone){
    }
    public void switchOn(Android android){
    }
}

public class VisitorPattern{
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

