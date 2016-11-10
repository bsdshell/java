import java.util.*;
import java.io.*;
import classfile.*;

public class ConnectedIslandNew{
    public static void main(String[] args) {
//        test0();
//        test1();
//        test2();
        test_count8_0();
        test_count8_1();
        test_count8_2();
        test_count8_3();
    }
    public static void test0(){
        Aron.beg();
        int[][] arr2d = {
            { 0,   0,   0,  1},
            { 1,   1,   0,  1},
            { 0,   1,   0,  1},
            { 0,   1,   1,  0},
        };
          
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count(arr2d, i, j, height, width);
                max = num > max ? num : max;
            }
        } 
        Print.pbl(max);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        for(int j=-1; j<=1; j++){
            for(int i=-1; i<=1; i++){
                Print.pbl(j + " " + i);
            } 
        }
        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        int[][] arr2d = {
            { 0,   0,   1,  0},
            { 0,   0,   0,  0},
            { 0,   0,   0,  0},
            { 1,   1,   0,  1},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count(arr2d, i, j, height, width);
                max = num > max ? num : max;
            }
        } 
        Test.t(max, 2);
        Aron.end();
    }
    public static void test_count8_0(){
        Aron.beg();
        int[][] arr2d = {
            { 0,   0,   1,  0},
            { 0,   0,   0,  0},
            { 0,   0,   0,  0},
            { 1,   1,   0,  1},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count8(arr2d, i, j, height, width);
                max = num > max ? num : max;
            }
        } 
        Test.t(max, 2);
        Aron.end();
    }
    public static void test_count8_1(){
        Aron.beg();
        int[][] arr2d = {
            { 0,   0,   1,  0},
            { 1,   1,   0,  0},
            { 1,   1,   0,  0},
            { 1,   1,   0,  1},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count8(arr2d, i, j, height, width);
                Print.pbl(num);
                max = num > max ? num : max;
            }
        } 
        Test.t(max, 7);
        Aron.end();
    }
    public static void test_count8_2(){
        Aron.beg();
        int[][] arr2d = {
            { 0,   0,   1,  1},
            { 0,   1,   0,  0},
            { 0,   0,   0,  1},
            { 1,   1,   0,  0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count8(arr2d, i, j, height, width);
                Print.pbl(num);
                max = num > max ? num : max;
            }
        } 
        Test.t(max, 3);
        Aron.end();
    }
    public static void test_count8_3(){
        Aron.beg();
        int[][] arr2d = {
            { 1,   0,   1,  1},
            { 0,   1,   0,  0},
            { 1,   0,   1,  1},
            { 0,   1,   0,  0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int h = 0, w = 0;
       
        int max = 0;
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                int num = count8(arr2d, i, j, height, width);
                Print.pbl(num);
                max = num > max ? num : max;
            }
        } 
        Test.t(max, 8);
        Aron.end();
    }

    // *connected_island* *island*
    public static int count(int[][] arr, int h, int w, int height, int width){
        if(arr[h][w] == 1){
            arr[h][w] = 2;
            int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
            if(h + 1 < height)
                n1 = count(arr, h+1, w, height, width);
            if(h - 1 >= 0)
                n2 = count(arr, h-1, w, height, width);
            if(w + 1 < width)
                n3 = count(arr, h, w+1, height, width);
            if(w - 1 >= 0)
                n4 = count(arr, h, w-1, height, width);

            return n1 + n2 + n3 + n4 + 1;
        }
        return 0;
    }

    //
    // east, west, north, south, east/noth, north/west, west/south, south/east
    // 8 direction *8direction* *9direction* *9direct* 
    public static int count8(int[][] arr, int h, int w, int height, int width){
        int s = 0;
        if(arr[h][w] == 1){
            arr[h][w] = 2;
            for(int hh=-1; hh<=1; hh++){
                for(int ww=-1; ww<=1; ww++){
                    if(hh != 0 || ww != 0){
                        if(
                            (h + hh >= 0 && h+hh < height) && 
                            (w + ww >= 0 && w+ww < width) 
                            ) 
                        s +=count8(arr, h+hh, w+ww, height, width); 
                    }
                }
            }
            s += 1;
        }
        return s;
    }
} 

