import java.io.*;
import java.lang.String;
import java.util.*;
class Partition 
{
	public static void main(String args[])
	{
		System.out.println("n2=");
		int[] Arr = {1, 7};
		int left = 0;
		int right = Arr.length - 1;
		int piv = partition(Arr, left, right);
		System.out.println("piv=" + piv);
	}
	public static int partition(int[] Arr, int left, int right)
	{
		int ret = -1;
		if(Arr != null)
		{
			int len = Arr.length;
			if(len == 1)
				ret = 0;
			else if(len > 1)
			{
				int i=left;
				int j=len - 1;
				int pivot = Arr[left];
				while(i<j)
				{
					while(Arr[i] <= pivot && i < len-1) i++;
					while(Arr[j] > pivot && j > 0) j--;
					if(i < j)
					{
						int tmp = Arr[i];
						Arr[i] = Arr[j];
						Arr[j] = tmp;
					}
				}
				int t = Arr[left];
				Arr[left] = Arr[j];
				Arr[j] = t;
				ret = j;

				for(int k=0; k<len; k++)
				{
					System.out.println("Arr[" + k + "]=" + Arr[k]);
				}

			}
		}
		return ret;
	}
}
