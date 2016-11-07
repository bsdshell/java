import java.util.*;
import java.io.*;
import classfile.*;

// Find the minimum distance between two given words
public class MinimumDistanceWord{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
    }
    static void test0(){
        Aron.beg();
        String[] arr = {"a", "b", "c", "b", "a", "e"}; 
        String word1 = "a";
        String word2 = "b";
        int dist = minimumDistance(arr, word1, word2);
        Test.t(dist == 1);

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        String[] arr = {"a", "b", "c", "e"}; 
        String word1 = "a";
        String word2 = "e";
        int dist = minimumDistance(arr, word1, word2);
        Test.t(dist == 3);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        String[] arr = {"a", "b", "a", "e"}; 
        String word1 = "e";
        String word2 = "a";
        int dist = minimumDistance(arr, word1, word2);
        Test.t(dist == 1);

        Aron.end();
    }
    static void test3(){
        Aron.beg();
        String[] arr = {"a", "b", "a", "e"}; 
        String word1 = "a";
        String word2 = "e";
        int dist = minimumDistance(arr, word1, word2);
        Test.t(dist == 1);

        Aron.end();
    }
    static void test4(){
        Aron.beg();
        String[] arr = {"a", "b", "a", "e"}; 
        String word1 = "a";
        String word2 = "a";
        int dist = minimumDistance(arr, word1, word2);
        Test.t(dist == 0);

        Aron.end();
    }
    //[ file=minidistanceword.html title=""
    static int minimumDistance(String[] wordArray, String word1, String word2){
        int minDistance = Integer.MAX_VALUE;
        if(word1 != null && word2 != null){
            int index1 = -1;
            int index2 = -1;
            for(int i=0; i<wordArray.length; i++){
                if(word1.equals(wordArray[i]))
                    index1 = i; 
                
                if(word2.equals(wordArray[i]))
                    index2 = i;

                if(index1 != -1 && index2 != -1){
                    int dist = Math.abs(index1 - index2);
                    minDistance = Math.min(dist, minDistance);
                }
            }
        }
        return minDistance;
    }
    //]
} 
