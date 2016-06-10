import java.io.*;
import java.lang.String;
import java.util.*;

//[file=nonsynthread.html title=""
public class HelloThread implements Runnable{
    public int num;
    public HelloThread(int num){
        this.num = num;
    }
    public void run(){
        for(int i=0; i<10; i++){
            this.num += 1;
            System.out.println("num=[" + num + "]");
        }
    }

    public static void main(String[] args) {
        Thread[] array = new Thread[10];
        for(int i=0; i<10; i++){
            array[i] = new Thread(new HelloThread(1)); 
            array[i].start();
        }
    }
}
//]
