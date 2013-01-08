import java.io.*;
import java.util.*;
class Rotatenumber 
{
	public static void main(String args[])
	{
		int[] Arr = {5, 6, 7, 8, 9, 10};
		int left = 0, right = Arr.length-1;
		int min = MinRotate(Arr, left, right); 
		System.out.println("min=" + min);

	}

	public static int MinRotate(int[] Arr, int left, int right)
	{
		int ret = 0;
		if(Arr != null && Arr.length > 0)
		{
			int len = Arr.length;	
			int m = (left + right)/2;
			if(right == left)
			{
				ret = Arr[left];
			}
			else if(Arr[left] < Arr[right])
			{
				ret = Arr[left];	
			}
			else if(Arr[left] > Arr[m])
			{
				ret = MinRotate(Arr, left, m);
			}
			else if(Arr[left] < Arr[m])
			{
				ret = MinRotate(Arr, m+1, right);
			}
			else 
			{
				if(Arr[left] < Arr[right])	
					ret = Arr[left];
				else 
					ret = Arr[right];
			}
		}
		return ret;
	}
}
