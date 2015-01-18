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

class Sudoku 
{
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(9);
    int[][] array;
    int[][] board = {
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

    int numEmpty;
    public Sudoku()
    {
        array = new int[81][2];
        for(int i=1; i<=9; i++)
            map.put(i, 0);
        numEmpty = findEmptyNumber();
    }
    public void printBoard()
    {
        System.out.println();
        for(int c=0; c<9; c++)
        {
            for(int r=0; r<9; r++)
            {
                System.out.print("["+board[c][r]+"]");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void solver(int k)
    {
        //System.out.print("<"+k+"><numE="+numEmpty+">");
        if(k == numEmpty)
        {
            printBoard();
        }
        else
        {
            int c = array[k][0];
            int r = array[k][1];
            for(int i=1; i<=9; i++)
            {
                if(checkColRow(c, r, i) && checkSquare(c, r, i))
                {
                    board[c][r] = i;
                    solver(k+1);
                    board[c][r] = 0;
                }
            }
        }
    }
    public int findEmptyNumber()
    {
        int count = 0;
        for(int c=0; c<9; c++)
        {
            for(int r=0; r<9; r++)
                if(board[c][r] == 0)
                {
                    array[count][0]=c;
                    array[count][1]=r;
                    count++;
                }
        }
        return count;
    }
    public boolean checkColRow(int c, int r, int num)
    {
        for(int i=0; i<9; i++)
        {
            if(board[c][i] == num || board[i][r] == num)
                return false;    
        }
        return true;
    }
    public boolean checkSquare(int col, int row, int num)
    {
        int qcol = col/3;
        int qrow = row/3;
        for(int c = 0; c<3; c++)
        {
            for(int r = 0; r<3; r++)
            {
                if(board[qcol*3+c][qrow*3+r] == num)
                    return false;
            }
        }
        return true;
    }
}

public class SudokuSolver 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        Sudoku s = new Sudoku();
        int k=0;
        s.solver(k);
    }
}
