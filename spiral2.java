import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class spiral2{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3},
            { 4,   5,   6},
            { 7,   8,  9},
            { 10,  11,  12},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);

        Aron.end();
    }

    public static void test1(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);

        Aron.end();
    }

    public static void test2(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3},
            { 4,   5,   6},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);

        Aron.end();
    }
    public static void spiral(int[][] arr){
        if(arr != null){
            int h = arr.length;
            int w = arr[0].length;

            for(int k=0; k<h; k++){
                
                if(h - 2*k == 1){
                    for(int i=k; i<w-k; i++)
                        Print.pb(arr[k][i]);

                    break;
                }else if(w - 2*k == 1){
                    for(int i=k; i<h-k; i++)
                        Print.pb(arr[i][k]);

                    break;
                }else{

                    for(int i=k; i<w-1-k; i++)
                        Print.pb(arr[k][i]); 

                    for(int i=k; i<h-1-k; i++)
                        Print.pb(arr[i][w-1-k]);

                    for(int i=k; i<w-1-k; i++)
                        Print.pb(arr[h-1-k][w-1-i]);

                    for(int i=k; i<h-1-k; i++)
                        Print.pb(arr[h-1-i][k]);
                }
            }
        }
    }
} 

