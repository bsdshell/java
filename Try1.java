import java.io.*;
import java.lang.String;
import java.util.*;


public class Try1 {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        //test1();
        test4();
    }

    public static void test1(){
        List<Integer> list = geneNPrime(10); 
        Aron.printList(list);
    }

    public static void test2(){
        List<Integer> list = allPrimes(10); 
        Aron.printList(list);
    }

    public static void test3(){
        List<Integer> list = allPrimes(1); 
        Aron.printList(list);
    }

    public static void test4(){
        for(int i=0; i<10; i++){
            boolean isS = squareNumber(i); 
            System.out.println("isS[" + i + "]=" + isS);
        }
    }


    public static boolean squareNumber(int n){
        int sq = Math.sqrt(n);
        List<Integer> list = Aron.geneNPrime(n);

        for(int i=0; i<list.size(); i++){
            Integer p = list.get(i); 

            int count = 0;
            while(n > 1 && (n % p == 0)) {
                n = n/p;
                count++;
            }
            if(count > 0 && count % 2 != 0)
                return false;
        }
        return true;
    }

    public static List<Integer> allPrimes(int num){
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);

        for(int n=3; n<=num; n++){
            boolean isPrime = true;
            for(int j=0; j<list.size() && isPrime; j++){
                if(list.get(j) < n && n % list.get(j) == 0)
                   isPrime = false; 
            }
            if(isPrime)
                list.add(n);
        }
        return list;
    }
    public static List<Integer> geneNPrime(int numPrime){
        List<Integer> list = new ArrayList<Integer>();
        if(numPrime == 0)
            return list;

        list.add(2);
        int num = 3;
        int count = 1;
        while(count < numPrime ){
            boolean isPrime = true;
            for(int i=0; i<list.size() && isPrime; i++){
                if(num % list.get(i) == 0)
                    isPrime = false;
            }    
            if(isPrime){
                list.add(num);
                count++;
            }
            num++;
        }
        return list;
    }
}
