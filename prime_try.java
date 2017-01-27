import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class prime_try{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
    public static void test0(){
        Aron.beg();

        List<Integer> list = printPrime(1); 
        Aron.printList(list);
        Test.t(list.get(0) == 2);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();

        List<Integer> list = printPrime(5); 
        Aron.printList(list);
        Test.t(list.get(0) == 2);
        Test.t(list.get(1) == 3);
        Test.t(list.get(2) == 5);
        Test.t(list.get(3) == 7);
        Test.t(list.get(4) == 11);

        Aron.end();
    }
    
    static void test2(){
        Aron.beg();
        
        List<Integer> list = printAllPrime(5); 
        Aron.printList(list);
        Test.t(list.get(0) == 2);
        Test.t(list.get(1) == 3);
        Test.t(list.get(2) == 5);

        Aron.end();
    } 

    public static List<Integer> printPrime(int n){
        List<Integer> list = new ArrayList<Integer>(); 
        if(n > 0){
            list.add(2);
            int count = 1;
            int num = 3;
            while(count < n){

                boolean isPrime = true;
                for(int i=0; i<list.size(); i++){
                    if(num % list.get(i) == 0)
                        isPrime = false;
                }
                if(isPrime){
                    list.add(num);
                    count++;
                }
                num++;
            }
        }
        return list;
    }

    public static List<Integer> printAllPrime(int n){
        List<Integer> list = new ArrayList<Integer>(); 
        if(n >= 2){
            list.add(2);
            for(int i=3; i<=n; i++){
                boolean isPrime = true;
                for(int j=0; j<list.size() && isPrime; j++){
                    if(i % list.get(j) == 0)
                        isPrime = false;
                }
                if(isPrime)
                    list.add(i);
            }
        }
        return list;
    }
} 

