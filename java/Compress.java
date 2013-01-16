import java.io.*;
import java.lang.String;
import java.util.*;
class Compress
{
	public static void main(String args[])
	{
		String str="aabba";
		String ret = CompressStr(str);
		System.out.println("str=" + ret);
	}
	public static String CompressStr(String str) 
	{
		String ret="";
		if(str != null && str.length() > 0)
		{
			if(str.length() == 0 || str.length() == 1)
				ret = str;
			else
			{
				int c=1;
				int i=0;
				for(i=0; i<str.length()-1; i++)
				{
					if(str.charAt(i) == str.charAt(i+1))
						c++;
					else
						if(c > 1)
						{
							ret = ret + c	+ str.charAt(i) + ""; 
							c=1;
						}
						else	
							ret = ret + str.charAt(i) + "";
				}
				if(c > 1)
					ret = ret + c	+ str.charAt(i) + "";
				else	
					ret = ret + str.charAt(i) + "";
			}
		}
		return ret;
	}
}
