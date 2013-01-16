import java.io.*;
import java.lang.String;
import java.util.*;
class longestpalindrom 
{
	public static void main(String args[])
	{
		int r = longest("a");
		System.out.println("r=" + r);
		r = longest("aa");
		System.out.println("r=" + r);
		r = longest("ab");
		System.out.println("r=" + r);
		r = longest("aaa");
		System.out.println("r=" + r);
		r = longest("aba");
		System.out.println("r=" + r);
		r= longest("kkkabcbae");
		System.out.println("r=" + r);
	}
	public static int longest(String str)
	{
		int ret = 0;	
		String pal="";
		int max=1;
		if(str != null)
		{
			int len = str.length();
		
			if(len == 1)
			{
				ret = 1; 
				pal = str;
			}
			else if(len == 2)
			{
				if(str.charAt(0) == str.charAt(1)) 
				{
					ret = 2;
					pal = str;
				}
				else
				{
					ret = 1;
					pal = str.charAt(0) + "";
				}
			}
			else if(len > 2)
			{
				for(int i=1; i<len - 1; i++)
				{
					int c=0;
					for(int k=0; k<len/2; k++)
					{
						if(i-k >= 0 && i+1+k < len && str.charAt(i-k) == str.charAt(i+1+k))
						{
							c = 2*k+2;
							if(c > max)
							{
								max = c;
							  pal = str.substring(i-k, i+1+k+1);
							}
							System.out.println("1c=" + c);
							System.out.println("pal=" + pal);
						}
						else if(i-1-k >= 0 && i+k < len && str.charAt(i-1-k) == str.charAt(i+k))
						{
							c=2*k+2;
							if(c > max)
							{
								max = c;
							  pal = str.substring(i-1-k, i+k+1);
							}
							System.out.println("2c=" + c);
							System.out.println("pal=" + pal);
						}
						else if(i-1-k >=0 && i+1+k < len && str.charAt(i-1-k) == str.charAt(i+1+k))
						{
							c=2*k+3;
							if(c > max)
							{
								max = c;
							  pal = str.substring(i-1-k, i+1+k+1);
							}
							System.out.println("3c=" + c);
							System.out.println("k=" + k);
							System.out.println("i=" + i);
							System.out.println("pal=" + pal);
						}
					}
				}
			}
		}	
		System.out.println("max pal=" + pal);
		return max;
	}
}
