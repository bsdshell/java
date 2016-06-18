import java.io.*;
import java.lang.String;
import java.util.*;

public class Try99 {
    public static void main(String[] args) {
        permutation("", "");
        System.out.println("---------------------------------\n"); 
        permutation("", "a");
        System.out.println("---------------------------------\n"); 
        permutation("", "ab");
        System.out.println("---------------------------------\n"); 
        permutation("", "abc");
        System.out.println("---------------------------------\n"); 
    }
    // prefix = ""
    static String remove(String str, int index){
        String s = "";
        for(int i=0; i<str.length(); i++){
            if(i != index)
                s += str.charAt(i) + "";
        }
        return s;
    }
    static void permutation(String prefix, String str){    
        if(str != null){
            if(str.length() == 0){
                System.out.println(prefix);
            }else{
                for(int i=0; i<str.length(); i++){
                    permutation(prefix + (str.charAt(i) + ""), remove(str, i));
                }
            }
        }
    }
}
