import java.io.*;

class LongestEmptyArray 
{
	public static void main(String args[])
	{
		// 0 means empty
		// 1 means non-empty 
		int[] Arr = {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0}; 
		System.out.println("cool");
		int max = Longest(Arr);
		System.out.println("max=" + max);
	}
	// go right and go down
	public static int Longest(int[] Arr)
	{
		int max=0;
		if( Arr != null)
		{
			int len = Arr.length;
			int[] A = new int[len];

			if(Arr[0] == 0)
				A[0] = 1;
			else 
				A[0] = 0;

			for( int i=1; i<len; i++)
			{ if(Arr[i] == 0)
					A[i] = A[i-1]+1;	
			}
			
			for(int i=0; i<len; i++)
			{
				if(A[i] > max)
					max = A[i];
			}
		}		
		return max;
	}
}
