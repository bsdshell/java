import java.util.*;
import java.io.*;
import classfile.*;

public class WordPath{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        List<String> list = new ArrayList<String>();
        Set<String> dict = new HashSet<String>(Arrays.asList("cat", "kat", "kit")); 
        int index = 0;

        String sWord = "cat";
        String eWord = "kit";


        String foundWord = removeWord(sWord, dict, index);
        list.add(foundWord);
        if(!foundWord.equals(eWord)){
            dict.remove(foundWord);
        }
        Print.p(foundWord);


        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        List<String> list = new ArrayList<String>();
        Set<String> dict = new HashSet<String>(Arrays.asList("cat", "kat", "kit", "cit")); 
        int index = 0;

        String sWord = "cat";
        String eWord = "kit";
        listWords(sWord, eWord, list, dict);
        Aron.printList(list);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        List<String> list = new ArrayList<String>();
        Set<String> dict = new HashSet<String>(Arrays.asList("kat", "cat", "cow")); 
        int index = 0;

        String sWord = "cat";
        String eWord = "cow";
        listWords(sWord, eWord, list, dict);
        Aron.printList(list);

        Aron.end();
    }

    // cat -> kat
    public static void listWords(String sWord, String eWord, List<String> list, Set<String> dict){
        int index = 0;
        String foundWord = removeWord(sWord, dict, index);
        if(foundWord.length() > 0){ 
            list.add(foundWord);
            dict.remove(foundWord);
            Print.p("fw=" + foundWord);
            Print.p("eWord=" + eWord);
            if(!foundWord.equals(eWord)){
                listWords(foundWord, eWord, list, dict);
            }else{
                Print.p("size=" + list.size());
                Aron.printList(list);
            }
            dict.add(foundWord);
            list.remove(list.size()-1);
        }
    }

    // index = 0
    public static String removeWord(String sWord, Set<String> dict, int index){
        String ret = "";
        if(index < sWord.length()){
            for(char ch='a'; ch<='z' && ret.length() == 0; ch++){
            //for(char ch='a'; ch<='z'; ch++){
                char[] arr = sWord.toCharArray();
                char tmp = arr[index];
                arr[index] = ch;
                String changeWord = new String(arr); 
                if(dict.contains(changeWord)){
                    return changeWord;
                }
                ret = removeWord(sWord, dict, index+1);
            }
        }
        return ret;
    }
} 

