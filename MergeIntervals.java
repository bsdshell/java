import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

//[ file=mergeintervals.html title=""
class Interval implements Comparable<Interval>{
    public int begin;
    public int end;
    public Interval(int begin, int end){
        this.begin = begin;
        this.end = end;
    }
    public int compareTo(Interval inter){
        if(this.begin > inter.begin)
           return 1; 
        else if(this.begin == inter.begin)
            return 0;
        else
            return -1;
    }
    public String toString(){
        return "[" + begin + " " + end + "]";
    }
}

public class MergeIntervals{
    public static void main(String[] args) {
        test00();
    }
    static void test00(){
        Aron.beg();
        PriorityQueue<Interval> queue = new PriorityQueue<Interval>();
        Stack<Interval> stack = new Stack<Interval>();
        int[] arr1 = {4, 1, 2, 6, 9};
        int[] arr2 = {5, 1, 4, 9, 10};
        
        for(int i=0; i<arr1.length; i++){
            queue.add(new Interval(arr1[i], arr2[i]));
        }
        if(queue.size() > 0){
            stack.push(queue.remove());
        }
        while(!queue.isEmpty()){
            Interval top = stack.peek();
            Interval inter = queue.remove();
            if(top.end < inter.begin)
                stack.push(inter);
            else{
                stack.peek().end = Math.max(stack.peek().end, inter.end);
            }
        }
        while(!stack.empty()){
            System.out.println("[" + stack.peek().begin + " " + stack.peek().end + "]");
            stack.pop();
        }
        
        Aron.end();
    }
}
//]
