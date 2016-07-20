import java.util.*;
import java.io.*;
import classfile.*;

class URLShortener{
    final int base = 52;
    Map<Integer, Character> map = new HashMap<Integer, Character>(); 
    Map<Character, Integer> revmap = new HashMap<Character, Integer>(); 
    public URLShortener(){
        createMap();
    }
    //[ file=shortener.html title=""
    public StringBuilder encodeTo52(int n){
        final int base = 52; 
        StringBuilder sb = new StringBuilder();
        if(n == 0)
           sb.append("0");
        else{
            while(n > 0){
                sb.append(map.get(n % base));
                n /= base;
            }
        }
        return sb.reverse();
    }
    public int decode(StringBuilder sb){
        int sum = 0;
        for(int i=sb.length()-1; i>=0; i--){
            sum += (int)Math.pow(base, revmap.get(new Character(sb.charAt(i))));     
        }
        return sum;
    }
    public void createMap(){
        int count = 0;
        for(int i=0; i<10; i++){
            map.put(count, new Character((char)((int)'0' + i))); 
            revmap.put(new Character((char)((int)'0' + i)), count);
            count++;
        }

        for(int i=0; i<26; i++){
            map.put(count, new Character((char)((int)'a' + i))); 
            revmap.put(new Character((char)((int)'a' + i)), count);
            count++;
        }

        for(int i=0; i<26; i++){
            map.put(count, new Character((char)((int)'A' + i))); 
            revmap.put(new Character((char)((int)'A' + i)), count);
            count++;
        }

        
    }
    //]
    public void printMap(){
        for(Map.Entry<Integer, Character> entry: map.entrySet()){
            System.out.println("[" + entry.getKey() + "] [" + entry.getValue() + "]"); 
        }
    }
}


public class Shortener{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    public int encode(int n){
        return 1;
    }

    static void test0(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(100); 
        System.out.println("100[" + sb.toString() + "]"); 
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(0); 
        System.out.println("0[" + sb.toString() + "]"); 
        Aron.end();
    }

    static void test2(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(9); 
        System.out.println("9[" + sb.toString() + "]"); 
        Aron.end();
    }
    static void test3(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(10); 
        System.out.println("10[" + sb.toString() + "]"); 
        Aron.end();
    }
    static void test4(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(11); 
        System.out.println("11[" + sb.toString() + "]"); 
        Aron.end();
    }

    static void test5(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(1000000); 
        System.out.println("1000000[" + sb.toString() + "]"); 
        Aron.end();
    }
    static void test6(){
        Aron.beg();
        URLShortener urls = new URLShortener();
        StringBuilder sb = urls.encodeTo52(100000000); 
        System.out.println("100000000[" + sb.toString() + "]"); 
        Aron.end();
    }
} 
