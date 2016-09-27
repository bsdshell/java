import java.util.HashMap;
import java.util.Map;
import java.util.Hashtable;
import java.util.HashSet;
import java.util.List;
import java.util.*;
import java.lang.Math;

import classfile.*;

public class MaxContinuousList {
    public static void main(String[] args) {
        test8();
        test9();
        test10();
        test11();
        test12();
        test13();
        test14();
        test15();
        test16();
        test17();
        test18();
    }
    static void test8() {
        Aron.beg();
        Integer[] arr = {2, -5, 8, -2, 3};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test9() {
        Aron.beg();
        Integer[] arr = {-1, -5, 8, -4, 5, -2, 3, -2};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test10() {
        Aron.beg();
        Integer[] arr = {-1, -5, 8};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }

    static void test11() {
        Aron.beg();
        Integer[] arr = {6, -5, 8};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test12() {
        Aron.beg();
        Integer[] arr = {3, -4};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test13() {
        Aron.beg();
        Integer[] arr = {-4, 5};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test14() {
        Aron.beg();
        Integer[] arr = {-4};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test15() {
        Aron.beg();
        Integer[] arr = {4};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test16() {
        Aron.beg();
        Integer[] arr = {4, 0};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test17() {
        Aron.beg();
        Integer[] arr = {0, 4};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void test18() {
        Aron.beg();
        Integer[] arr = {-2, 4, 3, -8, 3};
        Aron.printArray(arr);
        System.out.println("max[" + maxList(arr)+ "]");
        Aron.end();
    }
    static void getAllPaths(Node n, Map<Node, Node> map, int num, List<Node> list) {
        if(n.data == num) {
            for(Node node : list) {
                System.out.println("[" + node.data + "]");
            }
            System.out.println("\n---------------------------------");
        } else {
            Node curr = map.get(n);
            while(curr != null) {
                list.add(curr);
                getAllPaths(curr, map, num, list);

                if(list.size() > 0)
                    list.remove(list.size()-1);

                curr = curr.next;
            }
        }
    }

    //[ file=maxlistindex.html title=""
    //
    // only work when not all elem are negative
    //
    // Sun Sep 25 18:03:40 PDT 2016
    // Fix bug: start gets the wrong index
    // 
    static int maxList(Integer[] arr) {
        int tmp_start = 0;
        int end = 0;
        int start = 0;
        int max = 0;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum == 0) {
                tmp_start = i;
            }

            if(sum + arr[i] > 0) {
                int m = Math.max(arr[i], sum + arr[i]);
                if(m > max) {
                    max = m;
                    start = tmp_start;
                    end = i;
                }
                sum += arr[i];
            } else {
                sum = 0;
            }
        }
        Print.p("start[" + start + "]");
        Print.p("end  [" + end + "]");
        return max;
    }
    //]
}
