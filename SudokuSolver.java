import java.util.*;

//unique solution
//{3,0,0,2,0,0,0,0,0},
//{0,0,0,1,0,7,0,0,0},
//{7,0,6,0,3,0,5,0,0},
//{0,7,0,0,0,9,0,8,0},
//{9,0,0,0,2,0,0,0,4},
//{0,1,0,8,0,0,0,5,0},
//{0,0,9,0,4,0,3,0,1},
//{0,0,0,7,0,2,0,0,0},
//{0,0,0,0,0,8,0,0,6}

class Sudoku {
    final int gridSize = 9;
    int[][] array;
    int[][] board = {
                    //{0,0,0,0},
                    //{0,0,0,0},
                    //{0,0,0,0},
                    //{0,0,0,0}
        
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

    /*
    int[][] board = {
                    {3,0,0,2,0,0,0,0,0},
                    {0,0,0,1,0,7,0,0,0},
                    {7,0,6,0,3,0,5,0,0},
                    {0,7,0,0,0,9,0,8,0},
                    {9,0,0,0,2,0,0,0,4},
                    {0,1,0,8,0,0,0,5,0},
                    {0,0,9,0,4,0,3,0,1},
                    {0,0,0,7,0,2,0,0,0},
                    {0,0,0,0,0,8,0,0,6}
        
                    //{0,0,0,2,0,0,0,0,0},
                    //{0,0,0,1,0,7,0,0,0},
                    //{0,0,6,0,3,0,5,0,0},
                    //{0,0,0,0,0,9,0,8,0},
                    //{0,0,0,0,2,0,0,0,4},
                    //{0,0,0,8,0,0,0,5,0},
                    //{0,0,9,0,4,0,3,0,1},
                    //{0,0,0,7,0,2,0,0,0},
                    //{0,0,0,0,0,8,0,0,6}
            };
            */

    int numEmpty;
    public Sudoku() {
        array = new int[gridSize*gridSize][2];
        numEmpty = findEmptyNumber();
    }
    public void printBoard() {
        System.out.println();
        for(int c=0; c<gridSize; c++) {
            for(int r=0; r<gridSize; r++) {
                System.out.print("["+board[c][r]+"]");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void solver(int k) {
        if(k == numEmpty) {
            printBoard();
        }
        else {
            int c = array[k][0];
            int r = array[k][1];
            for(int i=1; i<=gridSize; i++) {
                if(checkColRow(c, r, i) && checkSquare(c, r, i)) {
                    board[c][r] = i;
                    solver(k+1);
                    board[c][r] = 0;
                }
            }
        }
    }

    public void solver_Graph(int k, int[] arr) {
        if(k == numEmpty) {
            //printBoard();
            int hc = arr[0]/4;
            int hr = arr[0]%4;
            String childStr = "\"[" + hc + "," + hr + "]\"";
            String childLabel = childStr + "[style=filled, fillcolor=green];";
            System.out.println(childLabel);
        }
        else {
            int c = array[k][0];
            int r = array[k][1];
            int ec = arr[0]/4;
            int er = arr[0]%4;
            String parentStr = "\"[" + ec + "," + er + "]\"";
            int parent = arr[0];
            for(int i=1; i<=gridSize; i++) {
                arr[0] += 1;
                int child = arr[0];
                int hc = arr[0]/4;
                int hr = arr[0]%4;
                String childStr = "\"[" + hc + "," + hr + "]\"";
                System.out.println(parentStr +"->"+ childStr); 
                if(checkColRow(c, r, i) && checkSquare(c, r, i)) {
                    board[c][r] = i;
                    solver_Graph(k+1, arr);
                    board[c][r] = 0;
                }
            }
        }
    }


    public int findEmptyNumber() {
        int count = 0;
        for(int c=0; c<gridSize; c++) {
            for(int r=0; r<gridSize; r++)
                if(board[c][r] == 0) {
                    array[count][0]=c;
                    array[count][1]=r;
                    count++;
                }
        }
        return count;
    }

    public boolean checkColRow(int c, int r, int num) {
        for(int i=0; i<gridSize; i++) {
            if(board[c][i] == num || board[i][r] == num)
                return false;    
        }
        return true;
    }
    
    public boolean checkSquare(int col, int row, int num) {
        int blockSize = (int)Math.sqrt(gridSize);
        int qcol = col/blockSize;
        int qrow = row/blockSize;
        for(int c = 0; c<blockSize; c++) {
            for(int r = 0; r<blockSize; r++) {
                if(board[qcol*blockSize+c][qrow*blockSize+r] == num)
                    return false;
            }
        }
        return true;
    }
}

public class SudokuSolver {
    public static void main(String[] args) {
        Sudoku s = new Sudoku();
        StopWatch sw = new StopWatch();
        sw.start();
        int k=0;
        //s.solver(k);
        int[] arr = {0};
        System.out.println("digraph G {\n");
        //s.solver_Graph(k, arr);
        s.solver(k);
        sw.stop();

        System.out.println("time=" + sw.getElapsedTimeSecs());
        System.out.println("}\n");
    }
}
