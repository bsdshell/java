import java.util.*;
import java.io.*;
import classfile.*;

// gx http://stackoverflow.com/questions/31986332/visitor-vs-servant-vs-command-patterns 
interface IMobile{
}

class IPhone implements IMobile{
    String name;
    public IPhone(String name){
        this.name = name;
    }
    public void turnOn(IBluetooth b){
        b.switchOn(this);
    }
}

class Android implements IMobile{
    String name;
    public Android(String name){
        this.name = name;
    }
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
        Print.pbl(iphone.name);
    }
    public void switchOn(Android android){
        Print.pbl(android.name);
    }
}

public class TryVisitorPattern{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();

        IPhone iphone = new IPhone("iPhone");
        Android android = new Android("android");
        VisitorBlueTooth visitor = new VisitorBlueTooth();
        visitor.switchOn(iphone);
        visitor.switchOn(android);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

