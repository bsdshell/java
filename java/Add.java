import java.io.*;
import java.lang.String;
import java.util.*;
class Add 
{
	public static void main(String args[])
	{
		System.out.println("n2=");
		int[] Arr1={9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
		int[] Arr2={9, 7};
		int[] Arr = new int[3];
		Arr = Add(Arr1, Arr2);
		for(int i=0; i<Arr1.length; i++)
			System.out.print(Arr1[i]+" ");
		System.out.println();

		for(int i=0; i<Arr2.length; i++)
			System.out.print(Arr2[i]+" ");
		System.out.println();

		for(int i=0; i<Arr.length; i++)
			System.out.print(Arr[i]+" ");
		System.out.println();
	}
	public static int[] Multiple(int[] Arr1, int[] Arr2)
	{

		return null;
	}
	public static int[] Add(int[] Arr1, int[] Arr2)
	{
		int[] Arr = null;
		int mod=0; int c=0;
		if(Arr1 != null && Arr1 != null)
		{
			int len1 = Arr1.length;
			int len2 = Arr2.length;
			Arr = new int[len1>len2?len1+1:len2+1];
			if(len1 > 0 && len2 > 0 && len1 >= len2)
			{
				for(int i=0; i<len1; i++)
				{
					if(len2-1-i >= 0)
					{
						mod = (c + Arr1[len1-1-i] + Arr2[len2-1-i])%10;
						c = (c + Arr1[len1-1-i] + Arr2[len2-1-i])/10;
					}
					else
					{
						mod = (c + Arr1[len1-1-i])%10;
						c = (c + Arr1[len1-1-i])/10;
					}
					Arr[len1+1-1-i]=mod;
				}
				if(c>0)
					Arr[0]=c;
			}
			else if(len1 > 0 && len2 > 0 && len2 > len1)
			{
				for(int i=0; i<len2; i++)
				{
					if(len1-1-i >= 0)
					{
						mod = (c + Arr1[len1-1-i] + Arr2[len2-1-i])%10;
						c = (c + Arr1[len1-1-i] + Arr2[len2-1-i])/10;
					}
					else
					{
						mod = (c + Arr1[len2-1-i])%10;
						c = (c + Arr1[len2-1-i])/10;
					}
					Arr[len2+1-1-i]=mod;
				}
				if(c>0)
					Arr[0]=c;
			}
		}
		if(c == 0)
		{
			int[] A = new int[Arr.length-1];
			for(int i=1; i<Arr.length; i++)
				A[i-1]=Arr[i];
			Arr=null;
			Arr = new int[A.length];
			for(int i=0; i<A.length; i++)
				Arr[i]=A[i];
		}
		return Arr;
	}
}
