import java.io.*;
import java.lang.String;
import java.util.*;
class Power 
{
	public static void main(String args[])

	  int[] A={2, 3, 3, 2,3,4};
		Co(A);
	}
	public static boolean  Co(int[] A)
	{
		int c=1;
		int max=1;
		int num=A[0];
		for(int i=0; i<A.length-1; i++)
		{
			if(A[i] == A[i+1])
			{
				c++;
				if(c > max)
				{
					max=c;
					num = A[i];
				} 
			}
			else
			{
				c--;
				if(c=0)
				{
					c=1;
				}
			}
		}
		System.out.println("max=" + max);
		System.out.println("num=" + num);
	}

}
