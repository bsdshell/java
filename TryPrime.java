import java.util.*;
import java.io.*;
import classfile.*;

public class TryPrime{
    public static void main(String[] args) {
        test00();
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        List<Integer> list = prime(10); 
        Aron.printList(list);
        Aron.end();
    }
    public static void test00(){
        Aron.beg();
        List<Integer> list = prime(2); 
        Aron.printList(list);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        List<Integer> list = nprime(10); 
        Aron.printList(list);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        List<Integer> list = nprime(1); 
        Aron.printList(list);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        List<Integer> list = nprime(2); 
        Aron.printList(list);

        Aron.end();
    }
    public static List<Integer> nprime(int n){
        List<Integer> list = new ArrayList<>();

        if(n >= 1){
            list.add(2);
            int k = 1;
            int i = 3;
            while(k < n){
                boolean isPrime = true;
                for(Integer p : list){
                    if( i % p == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime){
                    list.add(i);
                    k++;
                }
                i++;
            } 
            
        }
        return list;
    }
    public static List<Integer> prime(int n){
        List<Integer> list = new ArrayList<>();

        if(n >= 2){
            list.add(2);
            for(int i=3; i<=n; i++){
                boolean isPrime = true;
                for(Integer p : list){
                    if( i % p == 0){
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime)
                    list.add(i);
            } 
            
        }
        return list;
    }
} 

