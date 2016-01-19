import java.io.*;
import java.util.*;
public class Solution 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[][] array2d = new int[3][2];

        System.out.println("array2.length="+array2d.length);
        System.out.println("array2[0].length="+array2d[0].length);

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<2; j++)
                System.out.print("["+array2d[i][j]+"]");
            System.out.println();
        }

        //test1();
        manhattanSolution();

//        test8();
//        test9();
//        test10();
//        test11();
    }

    public static void rotateArray(int[][] array2d){
        if(array2d != null){
            int len = array2d.length;
            for(int k=0; k<len/2; k++){
                int[] tmp = new int[len];
                for(int i=k; i<len-k; i++){
                    tmp[i] = array2d[k][i];
                }

                for(int i=k+1; i<len-k; i++){
                    array2d[i-1][k] = array2d[i][k];
                }

                for(int i=k+1; i<len-k; i++){
                    array2d[len-1-k][i-1] = array2d[len-1-k][i];
                }

                for(int i=len-1-k-1; i>=0; i--){
                    array2d[i+1][len-1-k] = array2d[i][len-1-k];
                }

                for(int i=len-1-k-1; i>=k; i--){
                    array2d[k][i+1] = tmp[i];
                }
            }
        }
    }
    public static void test1()
    {
        int[][] array2d = readFile();
        if( array2d != null){
            int len = array2d.length;
            for(int k=0; k<len; k++){
                for(int j=0; j<len; j++){
                    System.out.print("[" + array2d[k][j] + "] ");
                }
                System.out.println();
            } 
            System.out.println();

            rotateArray(array2d);
            for(int k=0; k<len; k++){
                for(int j=0; j<len; j++){
                    System.out.print("[" + array2d[k][j] + "] ");
                }
                System.out.println();
            } 
        }
    } 

    public static void manhattanSolution(){
        int[][] array2d = null;
        int height = 0;
        int width = 0;
        int k = 0;
        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            int countLine = 1;

            String line = null;
            int h = 0;
            while((line = bufferReader.readLine()) != null){
                String[] array = line.split("\\s+");
                if(countLine == 1){
                    if(array.length > 0){
                        height = Integer.parseInt(array[0]);
                    }
                } else if(countLine > 1 && countLine <= height + 1){

                    if(countLine == 2){
                        width = array.length;
                        array2d  = new int[height][width];
                    }
                    for(int i=0; i<width; i++){
                        array2d[h][i] = Integer.parseInt(array[i]);        
                    }
                    h++;
                }
                else if(countLine == height+2) {
                    k = Integer.parseInt(array[0]);
                }
                countLine++;
            } 
        }
        catch (Exception e) {
        }

        if(array2d != null){
            for(int j=0; j<height; j++){
                for(int i=0; i<width; i++){
                    System.out.print("[" + array2d[j][i] + "] ");
                }
                System.out.println();
            } 

            boolean ret = false; 
            for(int h=0; h<height && !ret; h++){ 
                for(int w=0; w<width && !ret; w++){
                    int num = array2d[h][w];
                    ret = manhattanDist(array2d, h, w, k, num); 
                }
            }
            if(ret)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }


    public static int[][] readFile(){
        int[][] array2d = null;
        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
            int count =0;
            int numRow = 0;
            String line = null;
            int row = 0;
            while((line = bufferReader.readLine()) != null){
                String[] array = line.split("\\s+");
                if(count == 0){
                    if(array.length > 0){
                        numRow = Integer.parseInt(array[0]);
                        array2d  = new int[numRow][numRow];
                    }
                } 
                else{
                    if(numRow != array.length){
                        System.out.print("ERROR"); 
                        return null;
                    }else{
                        for(int i=0; i<array.length; i++){
                            array2d[row][i] = Integer.parseInt(array[i]);        
                        }
                    }
                    row++;
                }
                count++;
            }
        } catch (Exception e) {
        }
        return array2d;
    }


    public static void test8()
    {
        System.out.println("test8");
        int[][] arr = { 
            {1,3,3},
            {0,3,9},
            {0,3,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 3;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                ret = manhattanDist(arr, h, w, k, arr[h][w]); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test11()
    {
        System.out.println("test11");
        int[][] arr = { 
            {0,3,1},
            {0,1,4},
            {7,1,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 4;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattanDist(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test10()
    {
        System.out.println("test10");
        int[][] arr = { 
            {1,3,6},
            {0,4,4},
            {7,9,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 4;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattanDist(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    }

    public static void test9()
    {
        System.out.println("test9");
        int[][] arr = { 
            {1,3,6},
            {0,4,4},
            {7,9,1}
        };

        int height = arr.length;
        int width = arr[0].length;

        int k = 1;
        boolean ret = false; 
        for(int h=0; h<height && !ret; h++){ 
            for(int w=0; w<width && !ret; w++){
                int num = arr[h][w];
                ret = manhattanDist(arr, w, h, k, num); 
                System.out.println("ret =" + ret);
            }
        }
        System.out.println("--ret =" + ret);
    } 

    public static boolean manhattanDist(int[][] arr, int h, int w, int k, int num){
        final int visited = -1000; 
        boolean ret0 = false;
        boolean ret1 = false;
        boolean ret2 = false;
        boolean ret3 = false;
        boolean ret4 = false;
        int height = arr.length;
        int width = arr[0].length;

        if( k == 0){
            ret0 = num == arr[h][w];
        }else if(arr[h][w] != visited){
            int tmp = arr[h][w];
            arr[h][w] =  visited;
            if(w + 1 < width){
                 arr[h][w] = visited;
                 ret1 = manhattanDist(arr, h, w+1,k-1, num);
                 arr[h][w] = tmp;
                 if(ret1)
                     return ret1;
             }

            if(w - 1 >= 0){
                 arr[h][w] = visited;
                 ret2 = manhattanDist(arr,  h, w-1,k-1, num);
                 arr[h][w] = tmp;
                 if(ret2)
                     return ret2;
             }

            if(h - 1 >= 0){
                 ret3 = manhattanDist(arr,  h-1, w, k-1, num);
                 arr[h][w] = tmp;
                 if(ret3)
                     return ret3;
             }

             if(h + 1 < height){
                 ret4 = manhattanDist(arr, h+1, w, k-1, num);
                 arr[h][w] = tmp;
                 if(ret4)
                     return ret4;
             }
        }
        return ret0 || ret1 || ret2 || ret3 || ret4;
    }
}
