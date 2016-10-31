import java.util.*;
import java.io.*;
import classfile.*;

public class TryTryMS1{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
    }
    public static void test0(){
        Aron.beg();

        char[][] arr = {
        {'c'}
        }; 
        String word = "c";
        boolean found = findAll(arr, word);
        Test.t(found);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        char[][] arr = {
        {'c', 'a', 't'}
        }; 

        String word = "ca";
        boolean found = findAll(arr, word);
        Test.t(found);
        
        Aron.end();
    }

    public static void test2(){
        Aron.beg();
        char[][] arr = {
        {'c', 'a', 'c'},
        {'b', 'e', 'e'}
        }; 
        String word = "bec";
        boolean found = findAll(arr, word);
        Test.t(found);
        
        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        char[][] arr = {
        {'n', 'a', 'c'},
        {'a', 'b', 'n'},
        {'k', 'a', 'f'},
        }; 
        String word = "banana";
        boolean found = findAll(arr, word);
        Test.t(found);
        
        Aron.end();
    }
    public static void test4(){
        Aron.beg();
        char[][] arr = {
        {'n', 'a', 'c'},
        {'a', 'b', 'n'},
        {'k', 'a', 'f'},
        }; 
        String word = "fbn";
        boolean found = findAll(arr, word);
        Test.t(found);
        
        Aron.end();
    }
    public static void test5(){
        Aron.beg();
        char[][] arr = {
        {'n', 'a', 'f'},
        {'a', 'f', 'n'},
        {'f', 'a', 'f'},
        }; 
        String word = "fff";
        boolean found = findAll(arr, word);
        Test.t(found);
        
        Aron.end();
    }
    // 11:52
    // Assume word.length() > 0
    // 
    // arr = {{'a'}};  i, j = 0
    // 
    public static boolean checkPattern(char[][] arr, String word, int h, int w, int height, int width, int index){
       if(arr != null && arr.length > 0 && arr[0].length > 0 && word != null){
           boolean ret = false;
           if(arr[h][w] != (char)0 && arr[h][w] == word.charAt(index)){
                char tmp = arr[h][w];
                arr[h][w] = (char)0;

                if(index == word.length() - 1){
                    Aron.printArray2D(arr);
                    return true;     
                }else{
                   for(int i=-1; i<=1 && !ret; i++){
                       for(int j=-1; j<=1 && !ret; j++){
                           if((i != 0 || j != 0) && isValid(h+i, w+j, height, width)){
                                ret = checkPattern(arr, word, h + i, w + j, height, width, index + 1);
                           }
                       }
                   }
                   
               }
               arr[h][w] = tmp;
           }
           return ret;
       }
       throw new IllegalArgumentException("arr or word must not be null.");
    }
    public static boolean findAll(char[][] arr, String word){
        int height = arr.length, width= arr[0].length, index = 0;
        boolean found = false;
        for(int h=0; h<height && !found; h++){
            for(int w=0; w<width && !found; w++){
                found = checkPattern(arr, word, h, w, height, width, index);
            }
        } 
        return found;
    }
    
    public static boolean isValid(int cc, int rr, int height, int width){
        return (0 <= cc && cc < height) && (0 <= rr && rr < width);
    }
} 


