import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

class MyNode{
    String data;
    int count;
    public MyNode(String data, int count){
        this.data = data;
        this.count = count;
    }
}

public class AnimalLogic{
    public static void main(String[] args) {
//        test0();
//        test1();
        //test2();
        test11();
//        test3();
//        test4();
//        test5();
    }

    public static void test11(){
        Aron.beg();
        String[] arr = {"dog", 
                        "cat", 
                        "cow", 
                        "dog", 
                        "cat", 
                        "cow", 
                        "dog", 
                        "dog", 
                        "rat", 
                        "pig", 
                        "cow", 
                        "rat", 
                        "pig"}; 

        Map<Map<String, String>, Map<String, Integer>> map = createMap(arr); 

        for(Map.Entry<Map<String, String>, Map<String, Integer>> entry : map.entrySet()){
            Map<String, String> key = entry.getKey(); 
            Map<String, Integer> value = entry.getValue(); 
            for(Map.Entry<String, String> keyEntry : key.entrySet()){
                Print.pp(keyEntry.getKey() + " " + keyEntry.getValue() + "=>");

                for(Map.Entry<String, Integer> valueEntry: value.entrySet()){
                    Print.pb(valueEntry.getKey() + "->" + valueEntry.getValue());
                }
                Print.pp("\n");
            }
        } 

        Aron.end();
    }


    public static Map<Map<String, String>, Map<String, Integer>> createMap(String[] arr){
        Map<Map<String, String>, Map<String, Integer>> map = new HashMap<Map<String, String>, Map<String, Integer>>(); 
        for(int i=0; i<arr.length - 2; i++){
            Map<String, String> key = new HashMap<String, String>(); 
            Map<String, Integer> value = new HashMap<String, Integer>(); 
            key.put(arr[i], arr[i+1]); 
            value.put(arr[i+2], 1);

            Map<String, Integer> v = map.get(key); 
            if(v == null){
                map.put(key, value);
            }else{
                Integer n = v.get(arr[i+2]);
                if(n == null){
                    v.put(arr[i+2], 1);
                }else{
                    n++;
                    v.put(arr[i+2], n);
                }
            }
        }
        return map;
    }
    public static void test0(){
        Aron.beg();

        Map<String, Integer> map = new HashMap<String, Integer>(); 
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-z]+(?=\\s|$)");

        String fileName = "text/myfile.txt";
        List<String> list = getWords(fileName); 

        for(String s : list){
            List<String> pairList = pair(s); 
            for(String k : pairList){
                if(map.containsKey(k)){
                    int count = map.get(k);
                    count++;
                    map.put(k, count);
                }else{
                    map.put(k, 1);
                }
            }
        }
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        
        Aron.printList(list);

        Aron.end();
    }
    public static List<String> pair(String s){
        List<String> list = new ArrayList<String>(); 
        if(s.length() > 1){
            for(int k=0; k < s.length(); k++){
                for(int i=0; i < s.length()-(1 + k); i++){
                    list.add(s.substring(i, i+(2 + k)));
                }
            }
        }
        return list;
    }

    // read a text file capture all words
    // word: non-whitespace char 
    public static List<String> getWordsNonWhiteSpace(String fileName){
        Pattern pattern = Pattern.compile("(?<=^|\\s)\\S+(?=\\s|$)");
        
        List<String> wordList = new ArrayList<String>(); 
        List<String> list = Aron.readFile(fileName);
        for(String s : list){
            String[] arr = s.split("\\s+");
            for(String str : arr){
                Matcher matcher = pattern.matcher(str.toLowerCase());
                if(matcher.find()){
                    wordList.add(matcher.group());
                }
            }
        }
        return wordList;
    }

    // read a text file capture all words
    // word: a-z char
    public static List<String> getWords(String fileName){
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-z]+(?=\\s|$)");
        
        List<String> wordList = new ArrayList<String>(); 
        List<String> list = Aron.readFile(fileName);
        for(String s : list){
            String[] arr = s.split("\\s+");
            for(String str : arr){
                Matcher matcher = pattern.matcher(str.toLowerCase());
                if(matcher.find()){
                    wordList.add(matcher.group());
                }
            }
        }
        return wordList;
    }
    public static void test1(){
        Aron.beg();
        
        String[] arr = {
            "dog",
            "cat",
            "key-value"
        };
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-z]+(?=\\s|$)");
        for(String s : arr){
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()){
                Print.pbl("match word=" + matcher.group());
            }
        }

        Aron.end();
    }

    public static void test2(){
        Aron.beg();
                
        String fileName = "text/textfile.txt";
        List<String> list = getWordsNonWhiteSpace(fileName);
        Aron.printList(list);

        Aron.end();
    }

    public static void test3(){
        Aron.beg();
        String s = "abc";                
        int len = s.length();

            // "abc" [ "" -> "abc"]
            //       [ "a" -> "bc"]
            //       [ "ab"-> "c" ]
            for(int j=0; j<len-1; j++){
                    String prefix = s.substring(0, j);
                    String suffix = s.substring(j, len);
                    Print.pbl("prefix=" + prefix);
                    Print.pbl("suffix=" + suffix);
            }

        Aron.end();
    }

    // return investable map: <k, v> => <v, k>
    // v = 1, 2, ... , n
    public static Map<Integer, String> inverseMap(Map<String, Integer> map){

        Map<Integer, String> revMap = new HashMap<Integer, String>(); 
        int k = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Integer n = entry.getValue();
            
            Print.pbl(entry.getKey() + "->" + entry.getValue());
            int init = k;
            while(k < init + n){
                revMap.put(k, entry.getKey());
                k++;
            }
        } 
        return revMap;
    }
    public static void test5(){
        Aron.beg();

        Map<String, Integer> map = new HashMap<String, Integer>(); 
        map.put("invert", 1);
        map.put("investable", 2);
        map.put("inverse", 1);
        map.put("definite", 1);
        map.put("definitely", 3);
        map.put("define", 3);
        map.put("be defined", 3);

        Map<Integer, String> revMap = inverseMap(map); 

        for(Map.Entry<Integer, String> entry : revMap.entrySet()){
            Print.pbl(entry.getKey() + " , " + entry.getValue());
        } 

        Aron.end();
    }

    public static void test4(){
        Aron.beg();
        String s = "abc";                
        
        Map<String, Integer> map = new HashMap<String, Integer>(); 
        Map<Integer, String> revMap = new HashMap<Integer, String>(); 
        map.put("invert", 1);
        map.put("investable", 2);
        map.put("inverse", 1);
        map.put("definite", 1);
        map.put("definitely", 3);
        map.put("define", 3);
        map.put("be defined", 3);

        int k = 1;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Integer n = entry.getValue();
            
            Print.pbl(entry.getKey() + "->" + entry.getValue());
            int init = k;
            while(k < init + n){
                revMap.put(k, entry.getKey());
                k++;
            }
        } 
        
        for(Map.Entry<Integer, String> entry : revMap.entrySet()){
            Print.pbl(entry.getKey() + " , " + entry.getValue());
        } 

        // 1 -> k1
        // 2 -> k2
        // 3 -> k2

        Aron.end();
    }
} 

