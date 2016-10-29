import java.io.*;
import java.lang.String;
import java.util.*;
class BinarySearchIteration 
{
	public static void main(String args[])
	{
		int[] Arr = {1, 2, 3, 5};
		int left = 0;
		int right = Arr.length - 1;
		int key = 5;
		int ret = BinSearch(Arr, left, right, key);
		System.out.println(ret);
	}
	public static int BinSearch(int[] Arr, int left, int right, int key)
	{
        int ret = -1;
        while(left <= right && ret == -1)
        {
            //int mid = (left + right)/2;
            int mid = left + (right - left)/2;
            if(Arr[mid] == key)
                ret = mid; 
            else if(Arr[mid] < key)
                left = mid + 1;
            else 
                right = mid -1; 
        }
		return ret;
	}
}
