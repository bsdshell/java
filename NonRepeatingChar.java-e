import java.util.*;
import java.io.*;
import classfile.*;


class Node {
    public Node left;
    public Node right;
    public Node next;
    public Character data;
    public boolean isVisited;
    public Node(Character n) {
        left = right = null;
        data = n;
        isVisited = false;
    }
}


public class NonRepeatingChar{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    static void test0(){
        Aron.beg();
        Character[] arr = {'a', 'b', 'a'}; 

        int len = arr.length;
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Character value = 1;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test1(){
        Aron.beg();
        Character[] arr = {'a', 'b', 'a', 'c'}; 
        int len = arr.length;
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Character value = 9;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }
    static void test2(){
        Aron.beg();
        Character[] arr = {'a', 'b', 'a', 'b', 'e', 'b'}; 
        int len = arr.length;
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Character value = 2;
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test3(){
        Aron.beg();
        Character[] arr = {'a'}; 
        int len = arr.length;
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Character value = 'a';
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    static void test4(){
        Aron.beg();
        Character[] arr = {'a', 'b', 'a'}; 
        int len = arr.length;
        Character value = 'b';
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }
    static void test5(){
        Aron.beg();
        Character[] arr = {'a', 'a', 'a', 'b', 'a'}; 
        int len = arr.length;
        Character value = 'b';
        Character nonRepeating = nonRepeatingChar(arr, len-1);
        Print.p(nonRepeating);
        Test.t(nonRepeating, value);
        Aron.end();
    }

    //[ file=nonrepeatingchar.html title=""
    static Character nonRepeatingChar(Character[] arr, int index){
        List<Node> list =  new LinkedList<Node>();
        if(arr != null){
            Map<Character, Node> map = new HashMap<Character, Node>();

            for(int i=0; i<arr.length; i++){
                if(i <= index){
                    Character ch = arr[i];
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
