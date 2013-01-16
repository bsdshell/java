import java.io.*;
import java.lang.String;
import java.util.*;
class multipleArrayNumber 
{
	public static void main(String args[])
	{
		int[] Arr={1, 2, 3, 4};
		int[] retArr = new int[Arr.length];

		retArr = doMultiply(Arr);

		for(int i=0; i<retArr.length; i++)
				System.out.println("retArr["+i+"]=" + retArr[i]);
	}
	public static int[] doMultiply(int[] input)
	{
		int[] leftArr = null;
		int[] rightArr = null;
		if(input != null)
		{
			int len = input.length;
			leftArr = new int[len];
			rightArr = new int[len];
			if(len>1)
			{
				leftArr[0] = input[0];
				for(int i=1; i<len-1; i++)
					leftArr[i] = leftArr[i-1]*input[i];

				rightArr[len-1]=input[len-1];
				for(int i=len-2; i>0; i--)
					rightArr[i] = rightArr[i+1]*input[i];

				for(int i=0; i<len-2; i++)
					leftArr[i] = leftArr[i]*rightArr[i+2];
				
				for(int i=len-1; i>0; i--)
					leftArr[i]=leftArr[i-1];

				leftArr[0]=rightArr[1];
			}
		}
		return leftArr;
	}
	public static int[] multiple(int[] Arr)
	{
		int[] leftArr = null;
		int[] rightArr = null;
		if(Arr != null)
		{
			int len = Arr.length;
			leftArr = new int[len];
			rightArr = new int[len];
			if(len>1)
			{
				leftArr[0] = Arr[0];
				for(int i=1; i<len-1; i++)
					leftArr[i] = leftArr[i-1]*Arr[i];

				rightArr[len-1]=Arr[len-1];
				for(int i=len-1-1; i>0; i--)
					rightArr[i] = rightArr[i+1]*Arr[i];

				for(int i=0; i<len-2; i++)
					leftArr[i] = leftArr[i]*rightArr[i+2];
				
				for(int i=len-1; i>0; i--)
					leftArr[i]=leftArr[i-1];

				leftArr[0]=rightArr[1];
			}
		}
		return leftArr;
	}
}
