import java.io.*;
import java.lang.String;
import java.util.*;
class Compress2
{
	public static void main(String args[])
	{
		String str="aaaaa";
		String ret = Compress2(str);
		System.out.println("str=" + ret);
	}
	public static String Compress2(String str) 
	{
		String ret="";
		if(str != null)
		{
			int len=str.length();
			if(len > 0)
			{ int c=1; int i=0;
				for(i=0; i<len-1; i++)
				{ if(str.charAt(i) == str.charAt(i+1))
						c++;
					else 
					{
						if(c>1)
							ret = ret + c + str.charAt(i);
						else 
							ret = ret + str.charAt(i);
						c=1;
					}
				}
				if(c>1)
					ret = ret + c + str.charAt(i);
				else 
					ret = ret + str.charAt(i);
			}
		}
		return ret;
	}
}
