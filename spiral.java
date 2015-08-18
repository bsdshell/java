import java.io.*;
import java.lang.String;
import java.util.*;

class spiral 
{
	public static void main(String args[])
	{
		final int nCol=4; 
		final int nRow=3;
		int[][] Arr = new int[nRow][nCol];
        Integer[][] A = new Integer[nRow][nCol];

		int c=0;
		for(int i=0; i<nRow; i++)
			for(int j=0; j<nCol; j++)
				A[i][j] = Arr[i][j] = c++;

		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				if(Arr[i][j]/10 == 0)
					System.out.print("["+Arr[i][j]+" ] ");
				else
					System.out.print("["+Arr[i][j]+"] ");
			}
			System.out.print("\n");
		}
		//printSpiral2(Arr, nRow, nCol);
        System.out.print("\n");
		//printSpiral3(Arr, nRow, nCol);

        int k=0;
        printSpiralRecursion(Arr, nRow, nCol, k);
        System.out.print("\nprint Snake\n");

        int width = nCol;
        int height = nRow;
        int col = 0;
        int row = 0;
        printSpiralSnake(Arr, width, height);
        //System.out.print("\n new spiral algorithm \n");
        //printSpiralNew(Arr, width, height);
	}
	public static void printSpiral2(int[][] Arr, int nRow, int nCol)
	{
		int min = nCol>nRow?nRow:nCol;

		if(nRow == 1)
		{
			for(int i=0; i<nCol; i++)
				System.out.print("{"+Arr[0][i]+"}");
		}
		else if(nCol == 1)
		{
			for(int i=0; i<nRow; i++)
				System.out.print("{"+Arr[i][0]+"}");
		}
		else 
		{
			for(int k=0; k<(min%2==1?min/2+1:min/2); k++)
			{
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
    
    public static void printSpiral3(int[][] array, int nRow, int nCol)
    {
        if(array != null)
        {
            if(nRow > nCol)
            {
                for(int i=0; i<(nCol%2==1?nCol/2+1:nCol/2); i++)
                {
                    for(int j=i; j<nCol-1-i; j++)
                    {
                        //System.out.print("{"+i+"}{"+j+"}");
                        if(array[i][j] != -1)
                        {
                            System.out.print("["+array[i][j]+"]");
                            array[i][j] = -1;
                        }
                    } 
					System.out.print("\n");
                    for(int j=i; j<nRow-1-i; j++)
                    {
                        //System.out.print("{"+i+"}{"+j+"}");
                        if(array[j][nCol-1-i] != -1)
                        {
                            System.out.print("["+array[j][nCol-1-i]+"]");
                            array[j][nCol-1-i] = -1;
                        }
                    } 
					System.out.print("\n");
                    for(int j=i; j<nCol-1-i; j++)
                    {
                        //System.out.print("{"+i+"}{"+j+"}");
                        if(array[nRow-1-i][nCol-1-j] != -1)
                        {
                            System.out.print("["+array[nRow-1-i][nCol-1-j]+"]");
                            array[nRow-1-i][nCol-1-j] = -1;
                        }
                    }
					System.out.print("\n");
                    for(int j=i; j<nRow-1-i; j++)
                    {
                        //System.out.print("{"+i+"}{"+j+"}");
                        if(array[nRow-1-j][i] != -1)
                        {
                            System.out.print("["+array[nRow-1-j][i]+"]");
                            array[nRow-1-j][i] = -1;
                        }
                    }
					System.out.print("\n");
                }
            }
        }    
    }
    public static void printSpiralRecursion(int[][] array, int nRow, int nCol, int k)
    {
        if(nRow-2*k > 0 && nCol-2*k > 0)
        {
            if(nRow - 2*k == 1)
            {
                for(int i=k; i<nCol-k; i++)
                    System.out.print("["+array[k][i]+"]");
                System.out.print("\n");
            }
            else if(nCol - 2*k == 1)
            {
                for(int i=k; i<nRow-k; i++)
                    System.out.print("["+array[i][k]+"]");
                System.out.print("\n");
            }
            else
            {
                for(int i=k; i<nCol-1-k; i++)         
                {
                    System.out.print("["+array[k][i]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++)         
                {
                    System.out.print("["+array[i][nCol-1-k]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nCol-1-k; i++)
                {
                    System.out.print("["+array[nRow-1-k][nCol-1-i]+"]");
                }
                System.out.print("\n");
                for(int i=k; i<nRow-1-k; i++)
                {
                    System.out.print("["+array[nRow-1-i][k]+"]");
                }
                System.out.print("\n");
                    printSpiralRecursion(array, nRow, nCol, k+1);
            }
        }
    }
    /*
    public static void printSpiralNew(int[][] array, int w, int h)
    {
        int c = 0;    
        int turn = -1;
        while(c < w*h)
        {
            if(c % w == 0 || c % h == 0)
            {
                turn ++;
            }

            if(turn % 4 == 0)
            {
                System.out.print(array[c/w][c%w] + " ");
            }
            else if(turn % 4 == 1)
            {
                System.out.print(array[c%h][w-1-c/h] + " ");
            }
            else if(turn % 4 == 2) 
            {
                System.out.print(array[c/w][w-1-c%w] + " ");
            }
            else if(turn % 4 == 3)
            {
                System.out.print(array[h-1-c%h][c/h] + " ");
            }
            c++;
        }
    }
    */
    public static void printSpiralSnake(int[][] array, int width, int height)
    {
        Set<Integer> hashSet = new HashSet<Integer>();
        if(array != null)
        {
            int c=0, r=0;
            int turn = 0;
            int count = 0;
            boolean print = true;
            while(count < width*height)
            {
                if(print)
                {
                    System.out.print("["+c+","+r+"]");
                    hashSet.add(c*width+r);
                    count++;
                }

                     if(turn % 4 == 0 && r+1 < width && !hashSet.contains(c*width + r + 1))      
                {
                    r++; print = true;
                }
                else if(turn % 4 == 1 && c+1 < height && !hashSet.contains((c+1)*width + r))      
                {
                    c++; print = true;
                }
                else if(turn % 4 == 2 && r-1 >= 0 && !hashSet.contains(c*width + r - 1))      
                {
                    r--; print = true;
                }
                else if(turn % 4 == 3 && c-1 >= 0 && !hashSet.contains((c-1)*width + r))      
                {
                    c--; print = true;
                }
                else 
                {
                    print = false;
                    System.out.println();
                    turn++;
                }
                
            }
        }
    }
}
