package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        //test1();
        test2();
    }
    static boolean checkRowCol(int[][] array, int initSum){
        int height = array.length;
        for(int j=0; j<height; j++){
            int vs = 0;
            int hs = 0;
            for(int i=0; i<height; i++){
                vs += array[j][i];
                hs += array[i][j];
            }
            if(initSum != vs || initSum != hs)
                return false;
        }
        return true;
    }
    static boolean checkDiagonal(int[][] array, int initSum){
        int len   = array.length;
        int maind  = 0;
        int minord = 0;

        for(int i=0; i<len; i++){
            maind += array[i][i];
            minord += array[len-1-i][i];
        }
        return initSum == maind && initSum == minord;
    }

    static void perm(List<Integer> prefix, List<Integer> list, int len){
        if(list.size() == 0){
            int[][] array = new int[len][len];
            for(int i=0; i<prefix.size(); i++){
                int c = i / len;
                int r = i % len;
                array[c][r] = prefix.get(i);
            }

            int initSum = 0;
            for(int i=0; i< len; i++){
                initSum += array[0][i];
            }
            if(checkDiagonal(array, initSum) && checkRowCol(array, initSum) == true){
                for(int i=0; i<len; i++){
                    for(int j=0; j<len; j++){
                        System.out.print("[" + array[i][j] + "]");
                    }
                    System.out.println();
                    if(i == len-1)
                        System.out.println();

                }
                // print array
            }
            //System.out.println();
        }
        else{
            for(int i=0; i<list.size(); i++){
                Integer num = list.remove(i);
                prefix.add(num);
                perm(prefix, list, len);
                list.add(num);
                prefix.remove(prefix.size()-1);
            }
        }
    }
    static void test1(){
        int len = 3;
        Integer[] array = new Integer[len*len];
        for(int i=0; i<len*len; i++)
            array[i] = i+1;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        List<Integer> prefix = new ArrayList<Integer>();
        perm(prefix, list, len);
    }

    static void test2(){
        MagicSquare m = new MagicSquare();

        int len = 2;
        Integer[] array = new Integer[len*len];
        for(int i=0; i<len*len; i++)
            array[i] = i+1;
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(array));
        List<Integer> prefix = new ArrayList<Integer>();
        m.perm2(prefix, list);
    }

}
