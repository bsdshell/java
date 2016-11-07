import java.util.*;
import java.io.*;
import classfile.*;

public class TryRArr{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test0(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
            { 13,  14,  15, 16},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        Aron.printArray2D(arr2d);
        Aron.line();

        rotate(arr2d);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
            { 13,  14,  15, 16},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
            { 13,  14,  15, 16},
            { 17,  18,  19, 20},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3},
            { 4,   5,   6},
            { 7,   8,  9},
            { 10,  11,  12},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test4(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test5(){
        Aron.beg();
        int[][] arr2d = {
            {1},
            {2},
            {3},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test6(){
        Aron.beg();
        int[][] arr2d = {
            {1, 2},
            {3, 4},
            {5, 6},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test7(){
        Aron.beg();
        int[][] arr2d = {
            {1},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        spiral(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }

    public static void rotate(int[][] array){
        int len = array.length;
        for(int k=0; k<len/2; k++){
            for(int i=k; i<len-1-k; i++){
                int tmp = array[k][i];
                array[k][i] = array[len-1-i][k];
                array[len-1-i][k] = array[len-1-k][len-1-i];
                array[len-1-k][len-1-i] = array[i][len-1-k];
                array[i][len-1-k] = tmp;
            }
        }
    }

    // /Users/cat/myfile/github/java/TryRArr.java
    public static void spiral(int[][] arr){
        int height = arr.length;
        int width= arr[0].length;
        int min = Math.min(width, height);
        int k = 0;
        while(k < width){
            // [2, 1]
            // horizonal 
            if(height - 2*k == 1){
                for(int i=k; i<width-k; i++)
                    Print.p(arr[k][i]); // horizontal

                break;
            }
            else if(width - 2*k == 1){
                for(int i=k; i<height-k; i++)
                    Print.p(arr[i][k]); // vertical 

                break;
            }
            else{
                for(int i=k; i<width-1-k; i++)
                    Print.p(arr[k][i]);
                for(int i=k; i<height-1-k; i++)
                    Print.p(arr[i][width-1-k]);
                for(int i=k; i<width-1-k; i++)
                    Print.p(arr[height-1-k][width-1-i]);
                for(int i=k; i<height-1-k; i++)
                    Print.p(arr[height-1-i][k]);
            }
            k++;
        }
    }

} 

