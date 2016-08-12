import java.io.*;
import java.lang.String;
import java.util.*;
class RotateMatrix90 
{
	public static void main(String args[])
	{
		System.out.println("n2=");
        test1();
		System.out.println();
        test2();
        System.out.println();
        test3();
        System.out.println();
        test4();
	}

	//rotate matrix clockwise 90
	public static int[][] rotateMatrixClockwise90(int[][] A)
	{
		if(A != null)
		{
			int nRow = A.length;
			int nCol = A[0].length;
			for(int k=0; k<nRow/2; k++)
				for(int i=k; i<nRow-1-k; i++)
				{
					int tmp = A[k][i];
					A[k][i] = A[nRow-1-i][k];
					A[nRow-1-i][k] = A[nRow-1-k][nRow-1-i];
					A[nRow-1-k][nRow-1-i] = A[i][nRow-1-k];
					A[i][nRow-1-k] = tmp;
				}
		}
		return A;
	}

	//rotate matrix counterclockwise 90
	public static int[][] rotatecounterclockwise90(int[][] A)
	{
		if( A != null)
		{
			int nRow = A.length;
			int nCol = A[0].length;
			for(int k=0; k<nRow/2; k++)
			{
				for(int i=k; i<nRow-1-k; i++)
				{
					int tmp = A[k][nRow-1-i];
					A[k][nRow-1-i] = A[nRow-1-i][nRow-1-k];
					A[nRow-1-i][nRow-1-k]=A[nRow-1-k][i];
					A[nRow-1-k][i]=A[i][k];
					A[i][k]=tmp;
				}
			}
		}
		return A;
	}

    //Rotate matrix counterclosewise 90 recursively 
    public static void rotatecounterclockwise90Recursion(int[][] arr, int depth)
    {
        if(arr != null)
        {
            int len = arr.length;
            for(int i=depth; i<len-1-depth; i++)
            {
                int tmp = arr[depth][i];
                arr[depth][i] = arr[len-1-i][depth];
                arr[len-1-i][depth] = arr[len-1-depth][len-1-i];
                arr[len-1-depth][len-1-i] = arr[i][len-1-depth];
                arr[i][len-1-depth] = tmp;
            }
            if(len - 2*depth > 1)
                rotatecounterclockwise90Recursion(arr, depth+1);
        }
    }

    //Rotate matrix clockwise 90 recursively 
    public static void rotateClockWise90Recursion(int[][] arr, int depth)
    {
        if(arr != null)
        {
            int len = arr.length;
            for(int i=depth; i<len-1-depth; i++)
            {
                int tmp = arr[depth][len-1-i];
                arr[depth][len-1-i] = arr[len-1-i][len-1-depth];
                arr[len-1-i][len-1-depth] = arr[len-1-depth][i];
                arr[len-1-depth][i] = arr[i][depth];
                arr[i][depth] = tmp;
            }
            if(len - 2*depth > 1)
                rotateClockWise90Recursion(arr, depth+1);
        }
    }

    public static void test1()
    {
        Random ran = new Random();
		int nRow = 4;
		int nCol = 4;
		int[][] A = new int[nRow][nCol];
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				A[i][j] = ran.nextInt(10);
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}

        int depth = 0;
		rotatecounterclockwise90Recursion(A, depth);
		System.out.println();
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}
    }

    public static void test2()
    {
        Random ran = new Random();
		int nRow = 4;
		int nCol = 4;
		int[][] A = new int[nRow][nCol];
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				A[i][j] = ran.nextInt(10);
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}

        int depth = 0;
		rotateClockWise90Recursion(A, depth);
		System.out.println();
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}
    }
    public static void test3()
    {
        Random ran = new Random();
		int nRow = 4;
		int nCol = 4;
		int[][] A = new int[nRow][nCol];
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				A[i][j] = ran.nextInt(10);
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}

		rotatecounterclockwise90(A);
		System.out.println();
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}

    }
    public static void test4()
    {
        Random ran = new Random();
		int nRow = 4;
		int nCol = 4;
		int[][] A = new int[nRow][nCol];
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				A[i][j] = ran.nextInt(10);
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}

		rotateMatrixClockwise90(A);
		System.out.println();
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
				System.out.print("["+A[i][j]+"]");
			}
			System.out.println();
		}
    }
}
