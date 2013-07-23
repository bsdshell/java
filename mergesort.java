import java.io.*;
import java.lang.String;
import java.lang.Math;
import java.util.*;
class mergesort 
{
	public static void main(String args[])
	{
		//int[] Arr = {0, 3, 7, 2, 100, 9, 6};
		int[] Arr = {4};
		int left=0;
		int right=Arr.length-1;
		int mid=(left+right)/2;
		mergesort(Arr, left, right);

		for(int i=0; i<Arr.length; i++)
		{ 
			System.out.println("Arr[" + i + "]=" + Arr[i]);
		}
	}
	public static void mergesort(int[] Arr, int left, int right)
	{
		if(left < right)
		{
			int mid = (left + right)/2;
			mergesort(Arr, left, mid);
			mergesort(Arr, mid+1, right);
			merge(Arr, left, mid, right);
		}
	}
	public static void merge(int[] Arr, int left, int mid, int right)
	{
		if(Arr != null && Arr.length > 1)
		{
			int len = right - left + 1;
			int[] A = new int[len];

			int i=left;
			int j=mid+1;
			int k=0;
			while(i<=mid && j<=right)
			{
				if(Arr[i] < Arr[j])
				{ A[k]=Arr[i]; i++;}
				else 
				{ A[k]=Arr[j]; j++;}
				k++;
			}
			while(i<=mid)
			{	A[k]=Arr[i];i++;k++;}
			while(j<=right)
			{ A[k]=Arr[j];j++;k++;}

			for(int x=0; x<right-left+1; x++)
			{ Arr[left+x]=A[x]; }
		}
	}
	
}
