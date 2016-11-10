import java.util.*;
import java.io.*;
import classfile.*;

public class SudokuSolverNew{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        int[][] arr2d = {
                        {0,0,0,2,0,0,0,0,0},
                        {0,0,0,1,0,7,0,0,0},
                        {0,0,6,0,3,0,5,0,0},
                        {0,0,0,0,0,9,0,8,0},
                        {0,0,0,0,2,0,0,0,4},
                        {0,0,0,8,0,0,0,5,0},
                        {0,0,9,0,4,0,3,0,1},
                        {0,0,0,7,0,2,0,0,0},
                        {0,0,0,0,0,8,0,0,6}
                };
        int index = 0;
        int size = 0; 

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(arr2d[i][j] == 0)
                    size++;
            }
        } 

        sudokuSolver(arr2d, index);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }

    // given 2d array and find a solution for the sudoku
    // 9x9 grid contains the number from 1 to 9
    // -------------------------------------------------------------------------------- 
    // each 3x3 grid contains the number from 1 to 9   
    // each row or column contains the number from 1 to 9
    // -------------------------------------------------------------------------------- 
    public static void sudokuSolver(int[][] arr2d, int index){ 
        int c = index / 9;
        int r = index % 9;
        if(index == 81){
            Aron.printArray2D(arr2d);
        }else{
            if(arr2d[c][r] == 0){
                for(int i=1; i<=9; i++){
                    if(checkSquare(arr2d, c, r, i) && checkColRow(arr2d, c, r, i)){
                        arr2d[c][r] = i; 
                        sudokuSolver(arr2d, index+1);
                        arr2d[c][r] = 0;
                    }
                }
            }else
                sudokuSolver(arr2d, index+1);
         }
    }

    public static boolean checkSquare(int[][] arr2d, int col, int row, int testNum){
        int ic = col/3;
        int ir = row/3;
        for(int c=0; c<3; c++){
            for(int r=0; r<3; r++){
                if(arr2d[c + ic*3][r + ir*3] == testNum) 
                    return false;
            }
        } 
        return true;
    }
    public static boolean checkColRow(int[][] arr2d, int c, int r, int testNum){
        for(int i=0; i<9; i++){
            if(arr2d[c][i] == testNum || arr2d[i][r] == testNum)
                return false;
        }
        return true;
    }
    
} 

