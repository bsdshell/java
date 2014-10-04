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
		int down=Arr.length-1;
		int key=2;
		boolean found = Search2DRecur(Arr, right, down, key);

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
			int down = row-1;
			while(right < col && down >= 0 && !found)
			{
				if(key > Arr[down][right])
						right++;
				else if(key < Arr[down][right])
                        down--;
				else if(key == Arr[down][right])
				{
					found = true;
					System.out.println("found Arr["+down+"]["+right+"]="+Arr[down][right]);
				}
			}
			if(!found)
					System.out.println("not fund key=" + key);
		}
		return found;
	}

	//right = 0;
	//down = row-1; 
	
	public static boolean Search2DRecur(int[][] Arr, int right, int down, int key)
	{
		if(Arr != null && right < Arr[0].length && down >= 0)
		{
			if(key > Arr[down][right])
				return Search2DRecur(Arr, right+1, down, key);			
			else if(key < Arr[down][right])
				return Search2DRecur(Arr, right, down-1, key);			
			else 
				return true;
		}
		return false;
	}
	
}
