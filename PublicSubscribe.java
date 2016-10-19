import java.util.*;
import java.io.*;
import classfile.*;

interface Publisher{
    public void publish(String msg);
}

class News implements Publisher{
    HashSet<Subscriber> set = new HashSet<Subscriber>();
    public void publish(String msg){
        for(Subscriber s : set){
            s.msgList.add(msg);
        }
    }

    public void addSub(Subscriber sub){
        set.add(sub);
    }
}

interface Subscriber{
    public void getPublisher();
}

class User1 implements Subscriber{
    Publisher pub;
    List<String> msgList = new ArrayList<String>();
    public Subscriber(Publisher pub){
        this.pub = pub;
    }
    public void getPublisher(){
        pub.publish();
    }
    public void add(String msg){
        msgList.add(msg);
    }
    public void show(){
        for(String s : msgList){
            Print.p(msg);
        }
    }
}


public class PublicSubscribe{
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

