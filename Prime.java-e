import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector; 
import classfile.*;

public class Prime {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        long startTime = System.currentTimeMillis();
        Prime(100000);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.println("diff=" + diff);
    }
    

    //Find all the primes from 2 to n
    public static void Prime(int n) {
        boolean[] prime = new boolean[n];
        for(int i=0; i<n; i++)
            prime[i] = true;

        for(int i=2; i<n; i++) {
            for(int j=2; j<i && prime[i]; j++) {
                if(prime[j] && (i % j) == 0)
                    prime[i] = false;
            }
        }
        for(int i=2; i<n; i++) {
            System.out.println("[" + i + "]=" + prime[i]);
        }
    }

    // generate n primes
    public static List<Integer> nPrime(int n) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        int count = 1;
        int num = 3;
        while(count <= n) {
            boolean isPrime = true;
            for(Integer p : list) {
                if(num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                list.add(num);
                count++;
            }
            num++;
        }
        return list;
    }
    //[ file=allprime.html title=""
    // generate all prime are up to n
    public static List<Integer> allPrime(int n) {
        List<Integer> list = new ArrayList<Integer>();
        if(n > 1) {
            list.add(2);
            for(int i=3; i<=n; i++) {
                boolean isPrime = true;
                for(int j=0; j<list.size() && isPrime; j++) {
                    if(i % list.get(j) == 0)
                        isPrime = false;
                }
                if(isPrime)
                    list.add(i);
            }
        }
        return list;
    }
    //]

    //[file=checkprime.html title=""
    public static boolean prime(int d, int n) {
        if(n == 2)
            return true;
        else if(n % d == 0)
            return false;
        else if(d*d <= n)
            return prime(d+1, n);
        else
            return true;
    }
    public static boolean isPrimeLoop(int n) {
        if( n == 2)
            return true;
        for(int d=2; d*d <= n; d++) {
            if(n % d == 0)
                return false;
        }
        return true;
    }
    //]
}
