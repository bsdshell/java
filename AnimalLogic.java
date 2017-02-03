import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class AnimalLogic{
    public static void main(String[] args) {
        test0();
        test1();
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
} 

