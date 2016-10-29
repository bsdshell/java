import java.util.*;
import java.io.*;
import classfile.*;

public class TryTry3{
    public static void main(String[] args) {
        test00_spiral2();
        test01_spiral2();
        test02_spiral2();
        test03_spiral2();
    }
    public static void test0_spiral(){
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
        spiral(arr2d);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test1_spiral(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        Aron.printArray2D(arr2d);
        spiral(arr2d);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test00_spiral2(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
        };
        int k = 0;
        Aron.printArray2D(arr2d);
        spiral2(arr2d, k);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test01_spiral2(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
        };
        int k = 0;
        Aron.printArray2D(arr2d);
        spiral2(arr2d, k);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test02_spiral2(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3,  4},
        };
        int k = 0;
        Aron.printArray2D(arr2d);
        spiral2(arr2d, k);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test03_spiral2(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3},
        };
        int k = 0;
        Aron.printArray2D(arr2d);
        spiral2(arr2d, k);
        Aron.printArray2D(arr2d);
        Aron.end();
    }
    public static void test04_spiral(){
        Aron.beg();
        
        int[][] arr2d = {
            { 1,   2,   3},
            { 5,   6,   7},
            { 9,   10,  11},
            { 13,  14,  15},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        Aron.printArray2D(arr2d);
        spiral(arr2d);
        Aron.printArray2D(arr2d);
        Aron.end();
    }

    public static void spiral(int[][] arr){
        if(arr != null && arr.length > 0){
            int h = arr.length;
            int w = arr[0].length;
            int k = 0;
            int min = Math.min(w, h);
            while(k <= Math.min(w, h)/2){
                if(w- 2*k == 1){
                    for(int i=k; i<h-k; i++){
                        Print.p(arr[i][k]);
                    }
                    break;
                }else if(h - 2*k == 1){
                    for(int i=k; i<w-k; i++){
                        Print.p(arr[k][i]);
                    }
                    break;
                }else if(k < Math.min(w, h)/2){
                    for(int i=k; i<w-1-k; i++){
                        Print.p(arr[k][i]);
                    }
                    for(int i=k; i<h-1-k; i++){
                        Print.p(arr[i][w-1-k]);
                    }
                    for(int i=k; i<w-1-k; i++){
                        Print.p(arr[h-1-k][w-1-i]);
                    }
                    for(int i=k; i<h-1-k; i++){
                        Print.p(arr[h-1-i][k]);
                    }
                }else{
                    break;
                }
                k++;
            }
        }
    }


    
    // [1]
    // [1, 2]
    // [3, 4]
    // [0][0] = 1
    // [0][1] = 2
    // [1][1] = 4
    // [1][0] = 3
    // k = 1
    //
    //
    // [1, 2, 3]
    // [4, 5, 6]
    // [7, 8, 9]
    // [1, 2] [3, 6] [9, 8] [7, 4]
    // [5]
    public static void spiral2(int[][] arr, int k){
        if(arr != null && arr.length > 0){
            int h = arr.length;
            int w = arr[0].length;
            
            if(h - 2*k == 1){
                for(int i=k; i<w-k; i++){
                    Print.p(arr[k][i]);
                }
            }else if(w - 2*k == 1){
                for(int i=k; i<h-k; i++){
                    Print.p(arr[i][k]);
                }
            }else if(k < Math.min(h, w)/2){
                for(int i=k; i<w-1-k; i++){
                    Print.p(arr[k][i]);
                } 
                for(int i=k; i<h-1-k; i++){
                    Print.p(arr[i][w-1-k]);
                } 
                for(int i=k; i<w-1-k; i++){
                    Print.p(arr[h-1-k][w-1-i]);
                } 
                for(int i=k; i<h-1-k; i++){
                    Print.p(arr[h-1-i][k]);
                } 
                spiral2(arr, k+1);
            }
        }
    }
} 

