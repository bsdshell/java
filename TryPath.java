import java.util.*;
import java.io.*;
import classfile.*;

public class TryPath{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        
        int[][] arr2d = {
            {0, 1, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0},
        };
        Aron.printArray2D(arr2d);
        int height = arr2d.length;
        int width = arr2d[0].length; 
        List<Integer> list = new ArrayList<Integer>(); 
        int n1=0, n2=5;
        list.add(n1);
        allpath(arr2d, n1, n2, list);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    public static void allpath(int[][] arr2d, int n1, int n2, List<Integer> list){
        int height = arr2d.length;
        int width = arr2d[0].length;
        if(n1 < height){
            if(n1 != n2){
                for(int i=0; i<width; i++){
                    if(arr2d[n1][i] == 1){
                        list.add(i);
                        allpath(arr2d, i, n2, list);
                        list.remove(list.size()-1);
                    }
                } 
            }else{
                Aron.printList(list);
            }
        }
    }
} 

