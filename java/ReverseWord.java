import java.io.*;
import java.lang.String;
import java.util.*;
class ReverseWord
{
	public static void main(String args[])
	{
		int k = 0;
		String s = ReverseWord("", k);
		System.out.println("s=" + s);
	}
	public static String ReverseWord(String str, int k)
	{
		String s = "";
		for(int i = k; i < str.length(); i++)
		{
			if((str.charAt(i)==' ') && !s.equals(""))
			{
				return ReverseWord(str, i+1) + " " + s;
			}
			else if(str.charAt(i) != ' ')
				s = s + Character.toString(str.charAt(i));
		}
		return s;

	}
}
