import java.io.*;
import java.lang.String;
import java.util.*;
class minValueShiftArray 
{
	public static void main(String args[])
	{
		int[] Arr={3, 4, 5, 1, 2};
		int left = 0, right = Arr.length-1;
		int ret = Min(Arr, left, right);
		System.out.println("ret=" + ret);
	}
	public static int Min(int[] Arr, int left, int right)
	{
		int ret=0;
		if( Arr != null)
		{
			if( left == right) //only one element
				ret = Arr[left];
			else if( left+1 == right) // base case: two elements
				ret = (Arr[left]<Arr[right]?Arr[left]:Arr[right]);
			else if( Arr[left] < Arr[right]) // did not shift any position
				ret = Arr[left];
			else  //recursive case
			{
				int mid = (left + right)/2;
				if( Arr[left] > Arr[mid])
					ret = Min(Arr, left, mid);
				else 
					ret = Min(Arr, mid, right);
			}
		}
		else
		{
			System.exit(0);
		}
		return ret;
	}
}
