import java.io.*;
import java.lang.String;
import java.util.*;

class MySpiral
{
    final int height=4; 
    final int width=4;
    int[][] Arr = new int[height][width];
    Integer[][] A = new Integer[height][width];

    public MySpiral() 
    { 
        int c=0;
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				A[i][j] = Arr[i][j] = c++;

		for(int i=0; i<height; i++)
		{
			for(int j=0; j<width; j++)
			{
				if(Arr[i][j]/10 == 0)
					System.out.print("["+Arr[i][j]+" ] ");
				else
					System.out.print("["+Arr[i][j]+"] ");
			}
			System.out.print("\n");
		}
    }
    public void printSpiral2(int[][] Arr, int nRow, int nCol)
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

    public void printSpiralRecursion(int[][] array, int nRow, int nCol, int k)
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

    // assume width > height
    public void printSpiral4(int[][] array, int height, int width)
    {
        if(array != null)
        {
            for(int i=0; i < (width%2==1?width/2+1:width/2); i++)
            {
                if(width >= height && height - 2*i == 1)
                {
                    for(int w=i; w < width-i; w++)        
                        System.out.println(array[i][w]); 
                }
                else if(width < height && width - 2*i == 1)
                {
                    for(int h=i; h < height-i; h++)
                        System.out.println(array[h][i]); 
                }
                else 
                {
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

    public void printSpiralSnake(int[][] array, int width, int height)
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
    public void test1()
    {
        System.out.println("test1 printSpiral4()"); 
		printSpiral4(Arr, height, width);
    } 
    public void test2()
    {
        System.out.println("test2 printSpiralSnake()"); 
        printSpiralSnake(Arr, width, height);
    } 
    public void test3()
    {
        System.out.println("test3 printSpiralRecursion()"); 
        int k=0;
        printSpiralRecursion(Arr, height, width, k);
    } 
}


class spiral 
{
	public static void main(String args[])
	{
        MySpiral spiral = new MySpiral();
        spiral.test1();
        spiral.test2();
        spiral.test3();
    }
}
