import java.util.*;
import java.io.*;
import java.math.*;

public class Solution{
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] threeArray = line.split("\\s+");
//        int N = Integer.valueOf(threeArray[0]);
//        int M = Integer.valueOf(threeArray[1]);
//        
//        long[] array = new long[N+1];
//        
//        for (int i = 0; i < M; i++) {
//            line = sc.nextLine();
//            threeArray = line.split(" ");
//            int a = Integer.valueOf(threeArray[0]);
//            int b = Integer.valueOf(threeArray[1]);
//            int k = Integer.valueOf(threeArray[2]);
//
//            AddNum(array, a,k,N);
//            AddNum(array, b + 1 , -k , N);
//        }
//
//        long maximum = -1;
//        for(int i = 1  ; i <= N ; i++){
//            maximum = Math.max(maximum , SumNum(array, i));
//        }
//        System.out.println(maximum);
//    }
//    public static void AddNum(long[] array, int num , int val , int max){
//        while(num <= max){
//            array[num] += val;
//            num += (num & -num);
//        }
//    }
//    static long SumNum(long[] array, int num){
//        long s = 0;
//        while(num > 0 ){
//            s += array[num];
//            num -= (num & -num);
//        }
//        return s;
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] threeArray = line.split("\\s+");
        int N = Integer.valueOf(threeArray[0]);
        int M = Integer.valueOf(threeArray[1]);
        
        long[] array = new long[N+1];
        
        for (int i = 0; i < M; i++) {
            line = sc.nextLine();
            threeArray = line.split(" ");
            int a = Integer.valueOf(threeArray[0]);
            int b = Integer.valueOf(threeArray[1]);
            int k = Integer.valueOf(threeArray[2]);

            //AddNum(array, a,k,N);
            //AddNum(array, b + 1 , -k , N);

            while(a <= N){
                array[a] += k;
                a += (a & -a);
            }

            int bb = b + 1;
            while(bb <= N){
                array[bb] += -k;
                bb += (bb & -(bb));
            }


        }

        long maximum = -1;
        for(int i = 1  ; i <= N ; i++){
            maximum = Math.max(maximum , SumNum(array, i));
        }
        System.out.println(maximum);
    }
    public static void AddNum(long[] array, int num , int val , int max){
        while(num <= max){
            array[num] += val;
            num += (num & -num);
        }
    }
    static long SumNum(long[] array, int num){
        long s = 0;
        while(num > 0 ){
            s += array[num];
            num -= (num & -num);
        }
        return s;
    }
} 
