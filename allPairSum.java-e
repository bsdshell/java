import java.util.*;
import java.io.*;
import classfile.*;

public class allPairSum{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    public static void test0() {
        Aron.beg();
        Integer[] arr = {1, 2, 3, 4}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 0);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        Integer[] arr = {1, 3, 3, 7}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 2);

        Aron.end();
    }
    public static void test2() {
        Aron.beg();
        Integer[] arr = {1, 4, 4, 7}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 4);

        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        Integer[] arr = {1, 4, 4, 4}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 2);

        Aron.end();
    }

    public static void test4() {
        Aron.beg();
        Integer[] arr = {1, 4, 4, 4, 4}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 4);

        Aron.end();
    }
    public static void test5() {
        Aron.beg();
        Integer[] arr = {1, 4, 4, 4, 4, 4, 7}; 
        int sum = 8;
        List<Integer> list = sum(arr,  sum);
        Aron.printList(list);
        Test.t(list.size(), 6);

        Aron.end();
    }

    //[ file=pairofelements.html title=""
    // [4, 1, 7] 8
    // {4, 7, 1}
    // 4 -> 1
    // 7 -> 1
    // 1 -> 1
    //
    // [4, 4, 1, 7]
    // {4, 4, 7, 1}
    // 4->2
    // 7->1
    // 1->1
    public static List<Integer> sum(Integer[] arr, int sum) {
        List<Integer> list = new ArrayList<Integer>(); 
        if(arr != null){
            int len = arr.length;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>(); 
            for(Integer n : arr){
                if(map.containsKey(n)){
                    Integer v = map.get(n);
                    map.put(sum - n, v.intValue() + 1);
                }else{
                    map.put(sum - n, 1);
                }
            }

            for(Integer n : arr){
                if(map.containsKey(n)){
                    Integer v = map.get(n);
                    if(v != null){
                        if(2*n == sum){
                            if(v.intValue() > 1){
                                if(v.intValue() % 2 == 1){
                                    for(int i=0; i<v.intValue()-1; i++)
                                        list.add(n);
                                }else{
                                    for(int i=0; i<v.intValue(); i++)
                                        list.add(n);
                                }
                                map.remove(n);
                            }
                        }else{
                            list.add(n);
                        }
                    }
                }
            }
            
        }
        return list;
    }
    //]

}

