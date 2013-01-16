import java.io.*;
import java.util.*;
class MergeSortedListToArray
{
	public static void main(String args[])
	{
		int[] Arr1 = {1, 7, 10};
		int[] Arr2 = {3};
		int[] Arr = Merge(Arr1, Arr2);
		for(int i=0; i< Arr.length; i++)
			System.out.println(Arr[i]);
	}

	public static int[] Merge(int[] Arr1, int[] Arr2)
	{
		int[] A=null;
		if( Arr1 != null && Arr2 != null)
		{
			int len1 = Arr1.length;
			int len2 = Arr2.length; 
			A = new int[len1+len2];	
			int i=0, j=0, c=0;
			while(i<len1 || j<len2)
			{
				if(i == len1)
				{	A[c]=Arr2[j]; j++;}
				else if( j == len2)
				{ A[c]=Arr1[i]; i++;}
				else 
				{ if(Arr1[i]<Arr2[j])
					{	A[c] = Arr1[i]; i++;}
					else
					{ A[c] = Arr2[j]; j++;}	
				}
				c++;
			}
		}
		return A;
	}
}
