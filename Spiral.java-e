import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class MySpiral {
    final int height=4;
    final int width=4;
    int[][] Arr = new int[height][width];
    Integer[][] A = new Integer[height][width];

    public MySpiral() {
        int c=0;
        for(int i=0; i<height; i++)
            for(int j=0; j<width; j++)
                A[i][j] = Arr[i][j] = c++;

        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                if(Arr[i][j]/10 == 0)
                    System.out.print("["+Arr[i][j]+" ] ");
                else
                    System.out.print("["+Arr[i][j]+"] ");
            }
            System.out.print("\n");
        }
    }
    public void printSpiral2(int[][] Arr, int nRow, int nCol) {
        int min = nCol>nRow?nRow:nCol;
        if(nRow == 1) {
            for(int i=0; i<nCol; i++)
                System.out.print("{"+Arr[0][i]+"}");
        } else if(nCol == 1) {
            for(int i=0; i<nRow; i++)
                System.out.print("{"+Arr[i][0]+"}");
        } else {
            for(int k=0; k<(min%2==1?min/2+1:min/2); k++) {
                for(int j=k; j<nCol-1-k; j++)
                    System.out.print("{"+Arr[k][j]+"}");
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++)
                    System.out.print("{"+Arr[i][nCol-1-k]+"}");
                System.out.print("\n");
                for(int j=k; j<nCol-1-k; j++)
                    System.out.print("{"+Arr[nRow-1-k][nCol-1-j]+"}");
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++)
                    System.out.print("{"+Arr[nRow-1-i][k]+"}");
                System.out.print("\n");
            }
        }

    }

    public void printSpiralRecursion(int[][] array, int nRow, int nCol, int k) {
        if(nRow-2*k > 0 && nCol-2*k > 0) {
            if(nRow - 2*k == 1) {
                for(int i=k; i<nCol-k; i++)
                    System.out.print("["+array[k][i]+"]");
                System.out.print("\n");
            } else if(nCol - 2*k == 1) {
                for(int i=k; i<nRow-k; i++)
                    System.out.print("["+array[i][k]+"]");
                System.out.print("\n");
            } else {
                for(int i=k; i<nCol-1-k; i++) {
                    System.out.print("["+array[k][i]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++) {
                    System.out.print("["+array[i][nCol-1-k]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nCol-1-k; i++) {
                    System.out.print("["+array[nRow-1-k][nCol-1-i]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++) {
                    System.out.print("["+array[nRow-1-i][k]+"]");
                }
                System.out.print("\n");
                printSpiralRecursion(array, nRow, nCol, k+1);
            }
        }
    }

    // assume width > height
    public void printSpiral4(int[][] array, int height, int width) {
        if(array != null) {
            for(int i=0; i < (height > width? height: width); i++) {
                if(width >= height && height - 2*i == 1) {
                    for(int w=i; w < width-i; w++)
                        System.out.println(array[i][w]);
                    return;
                } else if(width < height && width - 2*i == 1) {
                    for(int h=i; h < height-i; h++)
                        System.out.println(array[h][i]);
                    return;
                } else {
                    for(int w=i; w < width-1-i; w++)
                        System.out.println(array[i][w]);

                    for(int h=i; h < height-1-i; h++)
                        System.out.println(array[h][width - 1 - i]);

                    for(int w=i; w < width-1-i; w++)
                        System.out.println(array[height - 1 - i][width - 1 - w]);

                    for(int h=i; h < height-1-i; h++)
                        System.out.println(array[height - 1 - h][i]);
                }
            }
        }
    }

    public void printSpiralSnake(int[][] array, int width, int height) {
        Set<Integer> hashSet = new HashSet<Integer>();
        if(array != null) {
            int c=0, r=0;
            int turn = 0;
            int count = 0;
            boolean print = true;
            while(count < width*height) {
                if(print) {
                    System.out.print("["+c+","+r+"]");
                    hashSet.add(c*width+r);
                    count++;
                }
                if(turn % 4 == 0 && r+1 < width && !hashSet.contains(c*width + r + 1)) {
                    r++;
                    print = true;
                } else if(turn % 4 == 1 && c+1 < height && !hashSet.contains((c+1)*width + r)) {
                    c++;
                    print = true;
                } else if(turn % 4 == 2 && r-1 >= 0 && !hashSet.contains(c*width + r - 1)) {
                    r--;
                    print = true;
                } else if(turn % 4 == 3 && c-1 >= 0 && !hashSet.contains((c-1)*width + r)) {
                    c--;
                    print = true;
                } else {
                    print = false;
                    System.out.println();
                    turn++;
                }
            }
        }
    }
    public void test1() {
        System.out.println("test1 printSpiral4()");
        printSpiral4(Arr, height, width);
    }
    public void test2() {
        System.out.println("test2 printSpiralSnake()");
        printSpiralSnake(Arr, width, height);
    }
    public void test3() {
        System.out.println("test3 printSpiralRecursion()");
        int k=0;
        printSpiralRecursion(Arr, height, width, k);
    }


}


class Spiral {
    public static void main(String args[]) {
        MySpiral spiral = new MySpiral();
        spiral.test1();
        spiral.test2();
        spiral.test3();

        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();

        test00_spiral2();
        test01_spiral2();
        test02_spiral2();
        test03_spiral2();
    }
    public static void test1() {
        System.out.println("test1");
        int[][] array = {
            {1,2,3}
        };
        int k=0;
        spiralArray(array, k);
    }
    public static void test2() {
        System.out.println("test1");
        int[][] array = {
            {1,2,3},
            {4,5,6}
        };
        int k=0;
        spiralArray(array, k);
    }

    public static void test3() {
        System.out.println("test3");
        int[][] array = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12}
        };
        int k=0;
        spiralArray(array, k);
    }

    public static void test4() {
        System.out.println("test4");
        int[][] array = {
            {1}
        };
        int k=0;
        spiralArray(array, k);
    }
    public static void test5() {
        System.out.println("test5");
        int[][] array = {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {10,11,12},
            {13,14,15}
        };
        int k=0;
        spiralArray(array, k);
    }
    public static void test6() {
        System.out.println("test6");
        int[][] array = {
            {1,2,3,4},
            {5,6,7,8}
        };
        Aron.printArray2D(array);
        System.out.println("-----------------");
        int k=0;
        spiralArray(array, k);
    }
    public static void test7() {
        System.out.println("test7");
        int[][] array = {
            {1,2},
            {5,6}
        };
        Aron.printArray2D(array);
        System.out.println("-----------------");
        int k=0;
        spiralArray(array, k);
    }

    public static void test8() {
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
        };
        Aron.printArray2D(arr2d);
        int k = 0;
        spiralArray(arr2d, k);
        Aron.printArray2D(arr2d);

        Aron.end();
    }
    public static void test9() {
        Aron.beg();
        int[][] arr2d = {
            { 1,   2,   3,  4},
            { 5,   6,   7,  8},
            { 9,   10,  11, 12},
            { 13,   14,  15, 16},
            { 17,   18,  19, 20},
        };
        Aron.printArray2D(arr2d);
        int k = 0;
        spiralArray(arr2d, k);
        Aron.printArray2D(arr2d);

        Aron.end();
    }

    public static void spiralArray(int[][] array, int k) {
        if(array != null && array.length > 0) {
            int hlen= array.length;
            int wlen= array[0].length;

            if(hlen - 2*k == 1) {
                for(int i=k; i<wlen-k; i++) {
                    Print.p(array[k][i]);
                }
            } else if(wlen -2*k ==1) {
                for(int i=k; i<hlen-k; i++) {
                    Print.p(array[i][k]);
                }
            } else if(k < hlen/2 && k < wlen/2) {
                for(int w=k; w<wlen-1-k; w++) {
                    Print.p(array[k][w]);
                }
                for(int h=k; h<hlen-1-k; h++) {
                    Print.p(array[h][wlen-1-k]);
                }
                for(int w=k; w<wlen-1-k; w++) {
                    Print.p(array[hlen-1-k][wlen-1-w]);
                }
                for(int h=k; h<hlen-1-k; h++) {
                    Print.p(array[hlen-1-h][k]);
                }
                spiralArray(array, k+1);
            }
        }
    }

    //[ file=spiralbest.html title="" 
    //
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
    //
    // last update 
    // Tue Sep 27 02:24:44 PDT 2016
    // best working version
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
    //]
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
}
