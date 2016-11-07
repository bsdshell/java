import java.io.*;
import java.lang.String;
import java.util.*;
class ReverseStrIte
{
	public static void main(String args[])
	{
		int i = 0;
		System.out.println("s3=" + RevStr("ab"));
	}
	public static String RevStr(String str)
	{
		char[] chArr=null;
		if( str != null)
		{
			chArr = str.toCharArray();
			int len = str.length();
			for(int i=0; i<len/2; i++)
			{
				char tmp = chArr[i];
				chArr[i] = chArr[len-1-i];
				chArr[len-1-i] = tmp;
			}
		}
		return new String(chArr);
	}
}
