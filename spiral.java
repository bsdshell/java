import java.io.*;
import java.lang.String;
class spiral 
{
	public static void main(String args[])
	{
		final int nCol=2; 
		final int nRow=5;
		int[][] Arr = new int[nRow][nCol];

		int c=0;
		for(int i=0; i<nRow; i++)
			for(int j=0; j<nCol; j++)
				Arr[i][j] = c++;

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
		printspiral2(Arr, nRow, nCol);

	}
	public static void printspiral2(int[][] Arr, int nRow, int nCol)
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
}
