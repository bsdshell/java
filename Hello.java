import java.io.*;
import java.lang.String;
import java.util.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("foldr (-) 1 [2, 3, 4] = " + foldr(2));
        System.out.println("foldl (-) 1 [2, 3, 4] = " + foldl(4));
    }

    //[file = foldjava.html title=""
    // foldr (-) 1 [2, 3, 4]  output = 2 
    public static int foldr(int n){
        if(n == 4){
            return n - 1;
        }
        else{
            return n - foldr(n + 1);
        }
    }
    // foldl (-) 1 [2, 3, 4] output = -8 
    public static int foldl(int n){
        if(n == 2){
            return 1 - n;
        }else{
            return foldl(n-1) - n;
        }
    }
    //]
}
