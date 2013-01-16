import java.io.*;
import java.lang.String;
import java.util.*;
class Search2DMatrix 
{
	public static void main(String args[])
	{
		int[][] Arr = new int[1][3];
		gen2D(Arr);
		int right=0;
		int up=Arr.length-1;
		int key=2;
		boolean found = Search2DRecur(Arr, right, up, key);

		if(found)
			System.out.println("found key=" + key);
		else 
			System.out.println("not found key="+key);
	}

	public static void gen2D(int[][] Arr)
	{
		int row, col;
		if(Arr != null)
		{
			row = Arr.length;
			col = Arr[0].length;
			Arr[0][0] = 0;
			Random r = new Random();
			for(int i=0; i<row; i++)
			{
				int ran = r.nextInt(3); 
				for(int j=0; j<col; j++)
				{
					if(i-1>=0 && j-1>=0)
					Arr[i][j] = Arr[i-1][j]+ Arr[i][j-1]+ran;
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
	public static boolean Search2D(int[][] Arr, int key)
	{
		int row, col;
		boolean found=false;
		if(Arr != null)
		{
			row = Arr.length;
			col = Arr[0].length;

			int right = 0;
			int up = row-1;
			while(right < col && up >= 0 && !found)
			{
				if(key > Arr[up][right])
						right++;
				else if(key < Arr[up][right])
							up--;
				else if(key == Arr[up][right])
				{
					found = true;
					System.out.println("found Arr["+up+"]["+right+"]="+Arr[up][right]);
				}
			}
			if(!found)
					System.out.println("not fund key=" + key);
		}
		return found;
	}

	//right = 0;
	//up = row-1; 
	
	public static boolean Search2DRecur(int[][] Arr, int right, int up, int key)
	{
		if(Arr != null && right < Arr[0].length && up >= 0)
		{
			if(key > Arr[up][right])
				return Search2DRecur(Arr, right+1, up, key);			
			else if(key < Arr[up][right])
				return Search2DRecur(Arr, right, up-1, key);			
			else 
				return true;
		}
		return false;
	}
	
}
