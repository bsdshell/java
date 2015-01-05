import java.io.*;
import java.lang.String;
import java.util.*;
class BinarySearch 
{
	public static void main(String args[])
	{
	    Test1();	
	    Test2();	
	    Test3();	
	}
	public static boolean BinSearch(int[] arr, int left, int right, int key)
	{
		boolean ret = false;
		if(arr != null && left <= right)
		{
			int middle = (left + right)/2;
			if(key < arr[middle])
			{
                ret = BinSearch(arr, left, middle - 1, key);
			}
			else if(key > arr[middle])
			{
                ret = BinSearch(arr, middle + 1, right, key);
			}
			else 
				ret = true;
		}
		return ret;
	}

    public static void Test1()
    {
        int[] arr = {1, 2, 3, 5};
		int left = 0;
		int right = arr.length - 1;
		int key = 1;
		boolean ret = BinSearch(arr, left, right, key);
		System.out.println(ret);
    }

    public static void Test2()
    {
        int[] arr = {1};
		int left = 0;
		int right = arr.length - 1;
		int key = 1;
		boolean ret = BinSearch(arr, left, right, key);
		System.out.println(ret);
    }

    public static void Test3()
    {
        int[] arr = {2};
		int left = 0;
		int right = arr.length - 1;
		int key = 1;
		boolean ret = BinSearch(arr, left, right, key);
		System.out.println(ret);
    }
}
