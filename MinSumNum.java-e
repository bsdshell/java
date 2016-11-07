import java.util.*;
import java.io.*;
import classfile.*;

public class MinSumNum {
    public static void main(String[] args) {
        test0();
        test1();
        test11();
        test12();
//        test2();
//        test3();
//        test4();
        //test5();
        //test6();
    }

    public static int minSquareTermDY(int n, Map<Integer, Integer> map, List<Integer> list) {
        int min = Integer.MAX_VALUE;
        if(n == 0) {
//            for(Integer e : list) {
//                System.out.print("[" + e + "]");
//            }
//            System.out.println();
            return 0;
        } else if(n > 0) {
            int inx =(int)Math.sqrt(n) + 1;
            for(int i=1; i<= inx; i++) {

                list.add(i);
                Integer value = map.get(n-i*i);
                Integer m = value;
                if(value == null){
                    m = minSquareTermDY(n-(i*i), map, list);
                    if(m < Integer.MAX_VALUE)
                        m += 1;
                }
                min = Math.min(min, m);
                System.out.println("n-i*i=[" + (n-i*i) + "] min[" + min + "]"); 
                
                if(n - i*i < 0)
                    map.put(n-i*i, Integer.MAX_VALUE);
                else
                    map.put(n-i*i, min);

                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
        } 
        return min;
    }
    public static int minSquareTerm(int n, Map<Integer, Integer> map, List<Integer> list) {
        int min = Integer.MAX_VALUE;
        if(n == 0) {
//            for(Integer e : list) {
//                System.out.print("[" + e + "]");
//            }
//            System.out.println();
            return 0;
        } else if(n > 0) {
            int inx =(int)Math.sqrt(n) + 1;
            for(int i=1; i<= inx; i++) {

                list.add(i);
                int m = minSquareTerm(n-(i*i), map, list);
                if(m < Integer.MAX_VALUE)
                    m += 1;

                min = Math.min(min, m);

                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
        } 
        return min;
    }

    public static int minCoin(int s, Integer[] arr, Map<Integer, Integer> map) {
        int min = Integer.MAX_VALUE;
        if(s == 0)
            return 0;
        else if(s > 0) {
            if(arr != null) {
                for(Integer n : arr) {
                    Integer value = map.get(s-n);
                    Integer m = 0;
                    if(value == null){
                        m = minCoin(s-n, arr, map);
                        if(m < Integer.MAX_VALUE)
                            m += 1;
                    }else{
                       m = value;
                    }

                    min = Math.min(min, m);

                    map.put(s-n, min);
                }
            }
        }
        return min;
    }

    static void test0() {
        Aron.beg();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int min = minSquareTerm(4, map, list);
        System.out.println("min=[" + min + "]");
        Aron.end();
    }
    static void test1() {
        Aron.beg();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int min = minSquareTerm(10, map, list);
        System.out.println("min=[" + min + "]");
        Aron.end();
    }
    static void test11() {
        Aron.beg();
        StopWatch sw = new StopWatch();
        sw.start();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int min = minSquareTerm(50, map, list);
        //System.out.println("min=[" + min + "]");

        sw.printTime(); 

        Aron.end();
    }

    static void test12() {
        Aron.beg();
        StopWatch sw = new StopWatch();
        sw.start();

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int min = minSquareTermDY(50, map, list);
        //System.out.println("min=[" + min + "]");

        sw.printTime(); 

        Aron.end();
    }
    static void test2() {
        Aron.beg();
        Integer[] arr = {1, 2}; 
        int s = 3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = minCoin(s, arr, map);
        System.out.println("min[" + min + "]"); 
        Aron.end();
    }

    static void test3() {
        Aron.beg();
        Integer[] arr = {1}; 
        int s = 3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = minCoin(s, arr, map);
        System.out.println("min[" + min + "]"); 
        Aron.end();
    }

    static void test4() {
        Aron.beg();
        Integer[] arr = {3}; 
        int s = 3;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = minCoin(s, arr, map);
        System.out.println("min[" + min + "]"); 
        Aron.end();
    }

    static void test5() {
        Aron.beg();
        Integer[] arr = {2, 5}; 
        int s = 10;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = minCoin(s, arr, map);
        System.out.println("min[" + min + "]"); 
        Aron.end();
    }
    static void test6() {
        Aron.beg();
        Integer[] arr = {2, 5, 100}; 
        int s = 100;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int min = minCoin(s, arr, map);
        System.out.println("min[" + min + "]"); 
        Aron.end();
    }
}
