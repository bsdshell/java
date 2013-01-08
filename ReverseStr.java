import java.io.*;
import java.lang.String;
import java.util.*;
class ReverseStr
{
	public static void main(String args[])
	{
		int i = 0;
		System.out.println("s=" + RevStr("", i));
		System.out.println("s1=" + RevStr("a", i));
		System.out.println("s2=" + RevStr("ab", i));
		System.out.println("s3=" + RevStr("ab ", i));
	}
	public static String RevStr(String str, int i)
	{
		String s="";
		if(str != null)
		{
			if(str.length() == 1)
				s = str;
			else if(str.length() > 1 && i < str.length())
			{
				s = RevStr(str, i+1) + str.charAt(i);
			}
		}
		return s;
	}
}
