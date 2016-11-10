import java.util.*;
import java.io.*;
import classfile.*;

public class TryCoin{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        List<Integer> coinList = new ArrayList<>(Arrays.asList(1, 2, 3));
        
        List<Integer> list = new ArrayList<>();
        int s = 10;
        coinChange(coinList, s, list);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    // given a list of coins and an Integer, find the number of combinations of coins are added up the s
    // assume s > 0 and all face value of coins are greater than zero
    public static void coinChange(List<Integer> coinList, Integer s, List<Integer> list){
        if(s == 0)
            Aron.printList(list);    
        else if (s > 0){
            for(Integer n : coinList){
                list.add(n);
                coinChange(coinList, s-n, list); 
                list.remove(list.size()-1);
            }
        }
    }
} 

