import java.io.*;
import java.lang.String;
import java.util.*;
class MaxDiff 
{
	public static void main(String args[])
	{
		System.out.println("n2=");
		int[] A={56, 44, 8, 59, 120, 9, 121, -6, -10, 90, -11};
		int max = MaxDiff(A);	
		System.out.println("max=" + max);
	}
	public static int MaxDiff(int[] A)
	{
		int maxdiff=0;
		if( A != null)
		{
			int len = A.length;
			if(len > 1)
			{ int min = 0;
				maxdiff = A[1] - A[0];
				for(int i=1; i<len; i++)
				{
					if(A[i] < A[min])
						min=i;
					else
					{ int diff = A[i]-A[min];
						if(diff > maxdiff)
							maxdiff = diff;
					}

				}
			}
		}
		return maxdiff;
	}
}
