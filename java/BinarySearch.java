import java.io.*;
import java.lang.String;
import java.util.*;
class BinarySearch 
{
	public static void main(String args[])
	{
		int[] Arr = {1, 2, 3, 5};
		int left = 0;
		int right = Arr.length - 1;
		int key = 1;
		boolean ret = BinSearch(Arr, left, right, key);
		System.out.println(ret);
	}
	public static boolean BinSearch(int[] Arr, int left, int right, int key)
	{
		boolean ret = false;
		if(Arr != null)
		{
			int middle = (left + right)/2;
			if(key < Arr[middle])
			{
				if(left <= middle - 1)
					ret = BinSearch(Arr, left, middle - 1, key);
			}
			else if(key > Arr[middle])
			{
				if(middle + 1 <= right)
					ret = BinSearch(Arr, middle + 1, right, key);
			}
			else 
				ret = true;
		}
		return ret;
	}
}
