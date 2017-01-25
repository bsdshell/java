import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

// graph with weight
// maximum path in graph, max path in graph, max path tree, 
// maximum graph in tree, maxpath, path tree
//
// gx /Library/WebServer/Documents/zsurface/image/maxpath.png
public class MaxPath{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
    }

    // gx /Library/WebServer/Documents/zsurface/image/maxpath.png
    public static void test0(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 3, 0},
            {0, 0, 7, 3},
            {0, 0, 0, 6},
            {0, 0, 0, 0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int n1 = 0; 
        int n2 = 3;
        int max = mathPathGraph(arr2d, n1, n2, width);
        Test.t(max == 14);
    
        Aron.end();
    }

    // gx /Library/WebServer/Documents/zsurface/image/maxpath2.png
    public static void test1(){
        Aron.beg();

        int[][] arr2d = {
            {0, 3, 7, 7, 0},
            {0, 0, 9, 2, 4},
            {0, 0, 0, 20,0},
            {0, 0, 0, 0, 9},
            {0, 0, 0, 0, 0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int n1 = 0; 
        int n2 = 4;
        int max = mathPathGraph(arr2d, n1, n2, width);
        Test.t(max == 41);

        Aron.end();
    }

    public static void test2(){
        Aron.beg();

        int[][] arr2d = {
            {0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int n1 = 0; 
        int n2 = 0;
        int max = mathPathGraph(arr2d, n1, n2, width);
        Test.t(max == 0);

        Aron.end();
    }

    public static void test3(){
        Aron.beg();

        int[][] arr2d = {
            {0, 3},
            {0, 0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        int n1 = 0; 
        int n2 = 1;
        int max = mathPathGraph(arr2d, n1, n2, width);
        Test.t(max == 3);

        Aron.end();
    }

    // gx /Library/WebServer/Documents/zsurface/image/maxpath.png
    public static int mathPathGraph(int[][] arr, int n1, int n2, int width){
        int max = 0;
        if(n1 != n2){
            for(int i=0; i<width; i++){
                if(n1 != i){
                    if(arr[n1][i] > 0){
                        int m = mathPathGraph(arr, i, n2, width) + arr[n1][i]; 
                        max = Math.max(max, m);
                    }
                }
            } 
        }
        return max;
    }

    // max path in tree, max path tree, maxpath binarytree
    public static int maxPathTree(Node r){
        if(r != null){
            int left = maxPathTree(r.left);
            int right = maxPathTree(r.right);
            return Math.max(left, right) + r.data;
        }
        return 0;
    }
} 

