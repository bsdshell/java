import java.util.*;
import java.io.*;
import classfile.*;


public class NonRepeatingChar{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
    }

    static void test0(){
        Aron.beg();
        Integer[] arr = {1}; 
        int len = arr.length;
        Integer nonRepeating = nonRepeatingChar(arr, len-1);
        Integer value = 1;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test1(){
        Aron.beg();
        Integer[] arr = {1, 2, 1, 4, 9, 2, 4, 6, 7, 7}; 
        int len = arr.length;
        Integer nonRepeating = nonRepeatingChar(arr, len-1);
        Integer value = 9;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Integer[] arr = {1, 2, 1}; 
        int len = arr.length;
        Integer nonRepeating = nonRepeatingChar(arr, len-1);
        Integer value = 2;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test3(){
        Aron.beg();
        Integer[] arr = {1, 2, 1, 1, 2, 4, 1}; 
        int len = arr.length;
        Integer nonRepeating = nonRepeatingChar(arr, len-1);
        Integer value = 4;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test4(){
        Aron.beg();
        Integer[] arr = {1, 2, 1, 2}; 
        int len = arr.length;
        Integer value = null;
        Integer nonRepeating = nonRepeatingChar(arr, len-1);
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    //[ file=nonrepeatingchar.html title=""
    static Integer nonRepeatingChar(Integer[] arr, int index){
        List<Node> list =  new LinkedList<Node>();
        if(arr != null){
            Map<Integer, Node> map = new HashMap<Integer, Node>();

            for(int i=0; i<arr.length; i++){
                if(i <= index){
                    Integer ch = arr[i];
                    if(!map.containsKey(ch)){
                        Node node = new Node(ch);
                        list.add(node);
                        map.put(ch, node);
                    }else{
                        Node vNode = map.get(ch);
                        if(vNode != null){
                            list.remove(vNode);
                            map.put(ch, null);
                        }
                    }
                }else{
                    break;
                }
            }
        }
        if(list.size() > 0)
            return list.get(0).data;
        else
            return null;
    }
    //]
} 
