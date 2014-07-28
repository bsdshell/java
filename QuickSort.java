import java.io.*;
import java.util.*;
class QuickSort 
{
	public static void main(String args[])
	{
		
		System.out.println("test case1:");
		int[] Arr = {100};
		int left = 0;
		int right = Arr.length-1;
		QuickSort(Arr, left, right);
		for(int i=0; i<Arr.length; i++)
			System.out.println("Arr[" + i + "]=" + Arr[i]);

		System.out.println("test case2:");
		int[] Arr1 = {100, 1};
		left = 0;
		right = Arr1.length-1;
		QuickSort(Arr1, left, right);
		for(int i=0; i<Arr1.length; i++)
			System.out.println("Arr1[" + i + "]=" + Arr1[i]);

		System.out.println("test case3:");
		int[] Arr2 = {1, 5};
		left = 0;
		right = Arr2.length-1;
		QuickSort(Arr2, left, right);
		for(int i=0; i<Arr2.length; i++)
			System.out.println("Arr2[" + i + "]=" + Arr2[i]);

		System.out.println("test case4:");
		int[] Arr3 = {100, 1, 3, 9, 6, 5, 7};
		left = 0;
		right = Arr3.length-1;
		QuickSort(Arr3, left, right);
		for(int i=0; i<Arr3.length; i++)
			System.out.println("Arr3[" + i + "]=" + Arr3[i]);


	}

    public static void QuickSort(int[] Arr, int left, int right)
	{
        if(left < right)
        {
            int pivot = Partition(Arr, left, right);
			QuickSort(Arr, left, pivot-1);
			QuickSort(Arr, pivot+1, right);
        }
	}
	public static int Partition(int[] Arr, int left, int right)
	{
		int ret = 0;
		if(Arr != null)
		{
			int len = Arr.length; 
			if(len == 1)
				ret = 0;
			else if(len > 1)
			{
				int pivot = Arr[left];
				int i=left;
				int j=right;
				while(i < j)
				{
					while(i < right && Arr[i] <= pivot ) i++;
					while(j > left && Arr[j] > pivot) j--;
					if(i<j)
					{ int tmp = Arr[i];
						Arr[i] = Arr[j];
						Arr[j] = tmp;
					}
				}
				int t = Arr[left];
				Arr[left] = Arr[j];
				Arr[j] = t;
				ret = j;
			}
		}
		return ret;
	}
}
