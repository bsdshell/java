import java.io.*;

class staircasewalk
{
	public static void main(String args[])
	{
		System.out.println("cool");

		int[][] Arr = new int[4][3];
		int ret = staircase1(Arr);

		int nRow = 4, nCol=3;
		for(int i=0; i<nRow; i++)
		{
			for(int j=0; j<nCol; j++)
				System.out.print(Arr[i][j]+" ");
			System.out.println();
		}
	}
	// go right and go down
	public static int staircase(int[][] Arr)
	{
		int ret=0;
		if( Arr != null)
		{
			int nRow = Arr.length;
			int nCol = Arr[0].length;
			for(int i=0; i<nRow; i++)
				Arr[i][0]=1;	
			for(int j=0; j<nCol; j++)
				Arr[0][j]=1;	

			for(int i=1; i<nRow; i++)
				for(int j=1; j<nCol; j++)
				{
						if(i == 2 && j == 1) // object in [2][1]
							Arr[i][j]=0;
						else 
							Arr[i][j] = Arr[i-1][j] + Arr[i][j-1];
				}

			ret = Arr[nRow-1][nCol-1];
		}
		return ret;
	}

	//go right, go down and diagonal
	public static int staircase1(int[][] Arr)
	{
		int ret=0;
		if( Arr != null)
		{
			int nRow = Arr.length;
			int nCol = Arr[0].length;
			for(int i=0; i<nRow; i++)
				Arr[i][0]=1;	
			for(int j=0; j<nCol; j++)
				Arr[0][j]=1;	

			for(int i=1; i<nRow; i++)
				for(int j=1; j<nCol; j++)
				{
						if(i == 2 && j == 1) // object in [2][1]
							Arr[i][j]=0;
						else 
							Arr[i][j] = Arr[i-1][j] + Arr[i][j-1] + Arr[i-1][j-1];
				}

			ret = Arr[nRow-1][nCol-1];
		}
		return ret;
	}
}
