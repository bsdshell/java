import java.util.*;
import java.io.*;
import classfile.*;

public class TryTry2 {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
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
        rotateRectangle(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        int[][] arr2d = {
            { 1,   2,   3},
            { 5,   6,   7},
            { 9,   10,  11},
        };
        int height = arr2d.length;
        int width = arr2d[0].length; 

        Aron.printArray2D(arr2d);
        rotateRectangle(arr2d);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    // 6:25
    // [1, 2]
    // [3, 4]
    // tmp = 1 
    // arr[0][0] <= arr[1][0] = 3
    // arr[1][0] <= arr[1][1] = 4
    // arr[1][1] <= arr[0][1]  = 2
    // arr[0][1] <= 1
    // 
    // [3, 1]
    // [4, 2]
    //
    // [1, 2, 3]
    // [4, 5, 6]
    // [7, 8, 9]
    // tmp = [0][0] = 1
    // [0][0] <= [2][0] = 7
    // [2][0] <= [2][2] = 9
    // [2][2] <= [0][2] = 3
    // [0][2] <= tmp = 1
    //
    // k=0, i=0 
    // [{7}, 2, {1}]  
    // [ 4,  5,  6]
    // [{9}, 8, {3}]
    //
    // k=0, i=1
    // tmp    <= [0][1] = 2
    // [0][1] <= [1][0] = 4
    // [1][0] <= [2][1] = 8
    // [2][1] <= [1][2] = 6
    // [1][2] <= tmp = 2
    //
    // [7, 4, 1]
    // [8, 5, 2]
    // [9, 6, 3]

    public static void rotateRectangle(int[][] arr) {
        if(arr != null && arr.length > 0) {
            int len = arr[0].length;
            for(int k=0; k<len/2; k++) {
                for(int i=k; i<len-1-k; i++) {
                    int tmp = arr[k][i];
                    arr[k][i] = arr[len-1-i][k];
                    arr[len-1-i][k] = arr[len-1-k][len-1-i];
                    arr[len-1-k][len-1-i] = arr[i][len-1-k];
                    arr[i][len-1-k] = tmp;

                }
            }
        }
    }
}

