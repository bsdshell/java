import java.io.*;

class reverseString 
{
	public static void main(String args[])
	{
		String cool="abcd";
		String str = reverse(cool);
		System.out.println("str=" + str);
		String str1 = reverse2(cool);
		System.out.println("str1=" + str1);

	}
	//using StringBuffer
	public static String reverse(String str)
	{
		StringBuffer sb = null;
		if(str != null)
		{
			sb = new StringBuffer(str);
			int len= str.length();
			for(int i=0; i<len/2; i++)
			{
				char c=sb.charAt(i);
				sb.setCharAt(i, sb.charAt(len-1-i));
				sb.setCharAt(len-1-i, c);
			}
		}
		return sb.toString();
	}

	//using char[] 
	public static String reverse2(String str)
	{
	 	String ret=null;	
		if(str != null)
		{
			int len= str.length();
		  char[] charArr = str.toCharArray();	
			for(int i=0; i<len/2; i++)
			{
				char c = charArr[i];
				charArr[i]=charArr[len-1-i];
				charArr[len-1-i]=c;
			}
			ret = new String(charArr);
		}
		return ret;
	}
}
