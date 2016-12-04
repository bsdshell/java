import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TownerHanoi{
    public static void main(String[] args) {
        test0();
    }
    public static void test0(){
        Aron.beg();
        int index = 0;
        int k = 0;
        int max = 1;
        towner(index, k, max);
        Aron.end();
    }

    public static void towner(int index, int k, int max){
        if(k < max){
            for(int i=0; i<3; i++){
                if(i != index){
                    Print.p("[" + i + " k=" + k);
                    towner(i, k+1, max);
                    Print.p("]");
                }
            }
        }
    }

    public static void fun(List<Stack<Integer>> li, int index){
        if(index < li.size()){
            Stack<Integer> s = li.get(index);
            if(!s.empty()){
                Integer n = s.pop();
            }

            while(!s.empty()){
                Print.pbl(s.pop());
            }
        }
    }
    public static boolean isValid(Stack<Integer> s){
        boolean ret = true;
        if(s.size() > 1){
            Integer top = s.pop();
            if(top > s.peek())
                ret = true;
            s.push(top);
        }
        return ret;

    }
    public static void townerHanoi(){
        List<Stack<Integer>> li = new ArrayList<Stack<Integer>>();
        Stack<Integer> s1 = new Stack<Integer>(); 
        Stack<Integer> s2 = new Stack<Integer>(); 
        Stack<Integer> s3 = new Stack<Integer>(); 
        s1.push(3);
        s1.push(2);
        s1.push(1);
        li.add(s1);
        li.add(s2);
        li.add(s3);

        for(Stack<Integer> s : li){
            while(!s.empty()){
                Print.pbl(s.pop());
            }
        }
    }
} 

