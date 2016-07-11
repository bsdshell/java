import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.List;
import java.util.*;
import java.lang.Math;

import classfile.*;

public class MaxContinuousList{
    public static void main(String[] args){
        test8();
        test9();
        test10();
        test11();
    }
    static void test8(){
        Aron.beg();
        int[] arr = {2, -5, 8, -2, 3};
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test9(){
        Aron.beg();
        int[] arr = {-1, -5, 8, -4, 5, -2, 3, -2};
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test10(){
        Aron.beg();
        int[] arr = {-1, -5, 8};
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }

    static void test11(){
        Aron.beg();
        int[] arr = {6, -5, 8};
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void getAllPaths(Node n, Map<Node, Node> map, int num, List<Node> list){
        if(n.data == num){
            for(Node node : list){
                System.out.println("[" + node.data + "]");
            }
            System.out.println("\n---------------------------------"); 
        }else{
                Node curr = map.get(n);
                while(curr != null){
                    list.add(curr);
                    getAllPaths(curr, map, num, list);

                    if(list.size() > 0)
                        list.remove(list.size()-1);

                    curr = curr.next;
                }
        }
    }
    //[ file=maxlistindex.html title=""
    // begin_index and end_index
    static int maxList(int[] arr){
        int max = -1;
        int start = 0;
        int end = 0;
        if(arr != null && arr.length > 0){
            max = arr[0];
            int sum = arr[0];
            for(int i=1; i<arr.length; i++){
                    sum += arr[i];
                    if(sum < 0){
                        sum = 0;
                        if(i + 1 < arr.length)
                            start = i + 1;
                    }

                    if( max < Math.max(sum, arr[i])){
                        max = Math.max(sum, arr[i]);
                        end = i;
                    }
            }
            System.out.println("start[" + start + "]");
            System.out.println("end  [" + end + "]");
        }
        return max;
    }
    //]
}
