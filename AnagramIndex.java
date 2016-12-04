import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// amazon test anagram amazontest amazon_test
public class AnagramIndex{
    public static void main(String[] args) {
        test0();
        test1();
    }
    static void test0(){
        Aron.beg();

        String haystack = "abdcghbaabcdij";
        String needle = "bcda";
        List<Integer> list = getAnagramIndices1(haystack, needle);
        Print.pbl(list);
        Aron.end();
    }

    static void test1(){
        Aron.beg();

        String haystack = "bbbababaaabbbb";
        String needle = "ab";
        List<Integer> list = getAnagramIndices1(haystack, needle);
        Print.pbl(list);

        Aron.end();
    }

    public static List<Integer> getAnagramIndices1(String haystack, String needle) {
        List<Integer> list = new ArrayList<Integer>(); 
        int len = needle.length();
        int hlen = haystack.length();
        String sortNeedle = Aron.sortStr(needle);
        for(int i=0; i<hlen; i++){
            if(len  + i <= hlen){
                String subStr = haystack.substring(i, len + i); 
                String s1 = Aron.sortStr(subStr);
                if(s1.equals(sortNeedle)){
                    list.add(i);
                }
                Print.pbl(subStr);
            }
        }
        return list;
    }
} 


