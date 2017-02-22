import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

class Card{
    String type;
}

class Deskcard{
    List<Card> list;
    void add(Card card){
        list.add(card);
    }
    Card removeTop(){
        if(list.size() > 0)
            return list.remove(list.size()-1);
        return null;
    }
}



public class Try444{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void test0(){
        Aron.beg();
        int len = 10;
        int[] arr = new int[len];
        for(int i=0; i<len; i++){
            arr[i] = i;
        } 

        Random r = new Random();
        int last = len-1;
        for(int i=1; i<len; i++){
            int n= r.nextInt(len-i);
            swap(arr, n, len-i);
            Print.pp("n=" + n + "\n");
        } 
        
        Ut.l();
        for(int i=0; i<len; i++){
            Print.pp(arr[i] + " ");
        } 

        Aron.end();
    }
    public static void shuffle(){
        Random r = new Random();
        int num = r.nextInt(52) + 1;
        Print.pp("num=" + num);
    }
    public static void test1(){
        Aron.beg();

        Random r = new Random();
        int n = r.nextInt(1);
        Aron.end();
    }

    public static void delete(Node r, Node n){
        Random ran = new Random();
        // 0 - 9
        int num = ran.nextInt(10);
        Print.p(num); 
    }
} 

