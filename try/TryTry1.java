import java.util.*;
import java.io.*;
import classfile.*;

public class TryTry1{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }
    public static void test0(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {1, 0, 1, 1},
            {1, 0, 0, 0},
            {1, 0, 0, 1},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int max = 0; 

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                int m = connectedComponent(arr2d, h, w, height, width);
                Print.p("m=" + m);
                if(m > max)
                    max = m;
            }
        } 
        Test.t(max, 4);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int max = 0; 

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                int m = connectedComponent(arr2d, h, w, height, width);
                Print.p("m=" + m);
                if(m > max)
                    max = m;
            }
        } 
        Test.t(max, 2);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        
        int[][] arr2d = {
            {1, 1, 1, 1},
            {1, 1, 1, 1},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int max = 0; 

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                int m = connectedComponent(arr2d, h, w, height, width);
                Print.p("m=" + m);
                if(m > max)
                    max = m;
            }
        } 
        Test.t(max, 8);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int max = 0; 

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                int m = connectedComponent(arr2d, h, w, height, width);
                Print.p("m=" + m);
                if(m > max)
                    max = m;
            }
        } 
        Test.t(max, 0);

        Aron.end();
    }

    // 6:06pm 6:23
    // [0, 0]
    // [1, 1]
    // 
    // [1] -> 1 
    //
    // [0, 1]   c1 = 0, c2 = 0, c3 = 1, c4 = 0 => 2
    // [0, 1]
    public static int connectedComponent(int[][] arr, int h, int w, int height, int width){
        if(arr[h][w] == 1){
            arr[h][w] = 2;
            int c1 = 0, c2 = 0, c3 = 0, c4 = 0; 
            if(w + 1 < width)
                c1 = connectedComponent(arr, h, w + 1, height, width);

            if(w - 1 >= 0)
                c2 = connectedComponent(arr, h, w - 1, height, width);

            if(h + 1 < height)
                c3 = connectedComponent(arr, h + 1, w, height, width);

            if(h - 1 >= 0)
                c4 = connectedComponent(arr, h - 1, w, height, width);

            return c1 + c2 + c3 + c4 + 1;
        }
        return 0;
    } 
} 

