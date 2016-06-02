import java.io.*;
import java.lang.String;
import java.util.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class  MagicSquareSolver{ 
 public static void main(String[] args) {
        System.out.println("Hello World!");
        MagicSquare mag = new MagicSquare();
        mag.test2();
    }
    static String remove(String str, int k){
        String s = "";
        for(int i=0; i<str.length(); i++){
            if(i != k)
                s += str.charAt(i) + "";
        }
        return s;
    }

    static void perm(String prefix, String str){
        if(str.length() == 0){
            System.out.println(prefix);
        }
        else{
            for(int i=0; i<str.length(); i++){
                perm(prefix + str.charAt(i), remove(str, i));
            }
        }
    }
}
