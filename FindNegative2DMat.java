import java.io.*;
import java.lang.String;
import java.util.*;
class FindNegative2DMat 
{
	public static void main(String args[])
	{
			int[][] Arr = new int[3][4];
			gen2D(Arr);
			int s = FindNegative(Arr);
			System.out.println("s=" + s);
	}

	public static void gen2D(int[][] Arr)
	{
		int row, col;
		if(Arr != null)
		{
			row = Arr.length;
			col = Arr[0].length;
			Arr[0][0] = -2;
			Random r = new Random();
			for(int i=0; i<row; i++)
			{
				int ran = r.nextInt(3); 
				for(int j=0; j<col; j++)
				{
					if(i-1>=0 && j-1>=0)
					Arr[i][j] = Arr[i-1][j]+ Arr[i][j-1]+ran + 5;
					else if(j-1>=0)
						Arr[i][j] = Arr[i][j-1]+ran;
					else if(i-1>=0)
						Arr[i][j] = Arr[i-1][j]+ran;

					System.out.print(String.format("%10s", Arr[i][j]));
				}
				System.out.println();
			}
		}
	}
	public static int FindNegative(int[][] Arr)
	{
		int sum=0;
		if(Arr != null)
		{
			int nRow = Arr.length;
			int nCol = Arr[0].length; 

			int down = 0;
			int left = nCol-1;

			while(down < nRow && left >=0)
			{
				if(Arr[down][left] < 0)
				{
					sum = sum + left + 1;
					down++;
				}
				else 
					left--;
			}
		}
		return sum;
	}
}
