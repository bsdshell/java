import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class ReverseStrings{
    public static void main(String args[]) {
        test0();
    }
    static void test0(){
        Aron.beg();
        String str = "dog and cat hello world";
        reverseString(str);
        Aron.end();
    }
    public static void reverseString(String str){
        StringBuilder sb = new StringBuilder(str);
        StringBuilder word = new StringBuilder();
        if(str != null){
            int len = str.length();
            for(int i=0; i<len/2; i++){
                char tmp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(len-1-i));
                sb.setCharAt(len-1-i, tmp);
            }
            Print.pbl(sb.toString());
            String s = "";
            for(int i=0; i<len; i++){
                if(sb.charAt(i) != ' '){
                    word.append(sb.charAt(i));
                }else{
                    Print.pbl(word.reverse());
                    word.delete(0, word.length()); 
                }
            } 
            if(word.length() > 0)
                Print.pbl(word.reverse());
        }
    }
}
