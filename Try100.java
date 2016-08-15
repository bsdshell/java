import java.io.*;
import java.lang.String;
import java.util.*;

public class Try100{

    public static void main(String[] args) {
        test0();
        test1();
    }

    static String sortStr(String s) {
        char[] clist = s.toCharArray();
        Arrays.sort(clist);
        return String.valueOf(clist);
    }

    static List<String> anagrams(List<String> list, String input) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        if(list != null && input != null) {

            for(String str : list) {
                String key = sortStr(str);
                List<String> l = map.get(key);
                if(l != null) {
                    l.add(str);
                    map.put(key, l);
                } else {
                    List<String> ll = new ArrayList<String>();
                    ll.add(str);
                    map.put(key, ll);
                }
            }
        }
        return map.get(sortStr(input));
    }

        
        Map<String, String> map = new HashMap<String, String>(); 
        String str;
        
        Map<String, String> map = new HashMap<String, String>();
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        String str;
        
        
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        String str;
        stri


        
        List<String> list = new ArrayList<String>();
        List<String> list = new LinkedList<String>();
        List<String> list = new Stack<String>();
        List<String> list = new Vector<String>();
        Queue<String> queue = new ArrayList<String>();
        Queue<String> queue = new PriorityQueue<String>(); 
        List<String> list = new ArrayList<String>(); 
    List<Integer> list = new ArrayList<Integer>(); 
    public static void test0() {
        List<String> list = new ArrayList<String>() {
            {
                add("dog");
                add("god");
                add("nice");
                add("debitcard");
                add("badcredit");
                String str = "";




                
            }
        };
        List<String> l = anagrams(list, "dog");
        if(l != null){
            for(String s : l){
                System.out.println("[" + s + "]");
            }
        }
    }

    public static void test1(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        words.add("God");
        words.add("Barack");
        words.add("Obama");

        List<String> l = anagrams(words, "dogk");
        if(l != null){
            for(String s : l){
                System.out.println("[" + s + "]");
            }
        }
    }
}
