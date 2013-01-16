import java.io.*;
import java.lang.String;
import java.util.*;
class Majority 
{
	public static void main(String args[])
	{
	  int[] A={2, 3, 2}; 
		System.out.println(majority(A));
	}
	public static boolean majority(int[] A)
	{
		boolean ret = false;
		if( A != null)
		{
			int len = A.length;
			if(len == 1)
				ret = true;
			else if(len > 1)
			{
				int c=1;
				int mj=0;
				for(int i=1; i<len; i++)
				{
					if(A[mj] == A[i])
					 c++; 
					else
					{ c--;
						if(c == 0)
						{ mj = i; c=1;}
					}
				}
				int count=0;
				for(int i=0; i<len; i++)
				{
					if(A[mj] == A[i])
						count++;
				}
				if(count > len/2)
					ret = true;
			}
		}
		return ret;
	}
}

