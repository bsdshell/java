import java.io.*;
import java.lang.*;
import java.util.*;

class MaxRepeatingChar 
{
	public static void main(String args[])
	{
		int c = maxrepeating("aacc");
		System.out.println(c);
	}
	public static int maxrepeating(String str)
	{
		int max = 0;
		if( str != null && str.length() > 0)
		{
			int len=str.length();
			int c=1; max=1;
			if(len > 1)
			{
				for(int i=1; i<len; i++)
				{
					if(str.charAt(i-1) == str.charAt(i))
					{ c++; if(c > max) max = c; }
					else
						c=1;
				}
			}
		}
		return max;
	}
}

