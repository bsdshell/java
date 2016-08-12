import java.io.*;
import java.util.*;

//quick sort algorithm
class QuickSort 
{
	public static void main(String args[])
	{
        Test1();
        Test2();
        Test3();
        Test4();
        Test5();
	}
    public static void Test1()
    {
        System.out.println("test case1:");
		int[] Arr = {100};
		int left = 0;
		int right = Arr.length-1;
		QuickSort(Arr, left, right);
		for(int i=0; i<Arr.length; i++)
			System.out.println("Arr[" + i + "]=" + Arr[i]);
    }
    public static void Test2()
    {
        System.out.println("test case2:");
		int[] Arr1 = {100, 1};
		int left = 0;
		int right = Arr1.length-1;
		QuickSort(Arr1, left, right);
		for(int i=0; i<Arr1.length; i++)
			System.out.println("Arr1[" + i + "]=" + Arr1[i]);
    }
    public static void Test3()
    {
		System.out.println("test case3:");
		int[] Arr2 = {1, 5};
		int left = 0;
		int right = Arr2.length-1;
		QuickSort(Arr2, left, right);
		for(int i=0; i<Arr2.length; i++)
			System.out.println("Arr2[" + i + "]=" + Arr2[i]);
    }
    public static void Test4()
    {
        System.out.println("test case4:");
		int[] Arr3 = {100, 1, 7, 6};
		//int[] Arr3 = {100, 1, 3, 9, 6, 5, 7};
		//int[] Arr3 = {9, 1, 2, 4};
		int left = 0;
		int right = Arr3.length-1;
		QuickSort(Arr3, left, right);
		for(int i=0; i<Arr3.length; i++)
			System.out.println("Arr3[" + i + "]=" + Arr3[i]);
    }

    public static void Test5()
    {
        System.out.println("test case5:");
		int[] Arr3 = {1, 7, 5};
		int left = 0;
		int right = Arr3.length-1;
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

    public static void swap(int[] arr, int left, int right)
    {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
    public static int Partition(int[] arr, int left, int right)
    {
        int prev = left;
        if(arr != null)
        {
            int pivot = arr[right];
            prev = left;
            for(int i=left; i<=right; i++)
            {
                if(arr[i] < pivot)
                {
                    swap(arr, i, prev);
                    prev++;    
                }
            }
            swap(arr, prev, right);
        }
        return prev;
    }
    //partition
	public static int Partition2(int[] Arr, int left, int right)
	{
		int ret = 0;
		if(Arr != null)
		{
			int len = right - left + 1; 
			if(len == 1)
				ret = left;
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
