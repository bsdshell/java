import java.io.*;
import java.lang.String;
import java.util.*;
class rotate90 
{
	public static void main(String args[])
	{
		System.out.println("n2=");
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
		rotateclockwise90(A);

		System.out.println();
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
			{
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
	//rotate right 90
	public static int[][] rotateclockwise90(int[][] A)
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
	//rotate left 90
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
}
