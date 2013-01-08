import java.io.*;
import java.lang.String;
import java.util.*;
class  InterTwoSortArr
{
	public static void main(String args[])
	{
		System.out.println("n2=");
		int[] Arr1 = {1, 4, 8, 10};
		int[] Arr2 = {2, 8, 10, 16};
		int[] A = InterTwoSortedArr(Arr1, Arr2);
		for(int i=0; i<A.length; i++)
			System.out.println("A["+i+"]="+A[i]);
	}
	

	public static int[] InterTwoSortedArr(int[] Arr1, int[] Arr2)
	{
		int[] A = null;
		int[] retArr = null;
		int i=0, j=0, c=0;
		if( Arr1 != null && Arr2 != null)
		{
			int len1 = Arr1.length;
			int len2 = Arr2.length;

			A = new int[len1>len2?len1:len2];
			while(i < len1 && j < len2)
			{ if(Arr1[i]<Arr2[j])
					i++; 
				else if(Arr1[i]>Arr2[j])
					j++; 
				else 
				{ A[c]=Arr1[i];
					i++; j++;
					c++;
				}
			}
			
		}
		retArr = new int[c];
		for(i=0; i<c; i++)
			retArr[i]=A[i];
		return retArr;
	}
}
