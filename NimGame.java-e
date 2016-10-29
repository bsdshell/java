import java.util.*;
import java.io.*;
import classfile.*;

public class NimGame{
    public static void main(String[] args) {
        test0();
        test1();
    }
    static void test0(){
        Aron.beg();
        int num = 8;
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(num);
        boolean flag = false;
        boolean boo = nim(num, num, flag, list);
        System.out.println("nim[" + boo + "]"); 
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        int num = 1;
        List<Integer> list = new ArrayList<Integer>(); 
        list.add(num);
        boolean flag = false;
        boolean boo = nim(num, num, flag, list);
        System.out.println("nim[" + boo + "]"); 
        Aron.end();
    }
    // Init level = 0 
    public static boolean nim(int n, int prev, boolean flag, List<Integer> list){
        boolean ret = false;
        if(n == 0){
            if(prev == 1 && flag){
                for(Integer item : list){
                    System.out.println("item[" + item + "]"); 
                }
                ret = true;
            }
        }else if(n > 0){
            for(int i=1; i<=3; i++){
                list.add(n-i);
                System.out.println("[" + n + "]->(" + i + ")[" + (n-i) + "] flag[" + flag + "] prev[" + prev + "] i[" + i + "]"); 
                ret = nim(n-i, n, !flag, list);

                if(list.size() > 0)
                    list.remove(list.size()-1);
            }
        }
        return ret;
    } 
}

