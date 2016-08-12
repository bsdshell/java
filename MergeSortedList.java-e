import java.io.*;
import java.util.*;
class MergeSortedList 
{
	public static void main(String args[])
	{
		int[] Arr1 = new int[10]; 
		Arr1[0] = 5; 
		Arr1[1] = 6; 
		Arr1[2] = 7; 
		Arr1[3] = 8; 
		Arr1[4] = 9; 
		Arr1[5] = 10; 
		int[] Arr2 = {11, 20, 30, 40};
		int[] Arr = Merge(Arr1, Arr2);
		for(int i=0; i< Arr.length; i++)
			System.out.println(Arr[i]);
	}

	public static int[] Merge(int[] Arr1, int[] Arr2)
	{
		int[] ret=null;
		if(Arr1 !=null && Arr2 !=null) 
		{
			int i=Arr1.length-5, j=Arr2.length-1, k=Arr1.length-1;	
			while(j !=-1)
			{
				System.out.println("i=" + i + "  " + "j=" + j);
				if(i == -1)
				{
					Arr1[k] = Arr2[j]; j--;
				}
				else if(Arr1[i] > Arr2[j])
				{
					Arr1[k] = Arr1[i]; i--;
				}
				else 
				{
					Arr1[k] = Arr2[j]; j--;
				}
				k--;
					
			}
		}
		return Arr1;
	}
}
