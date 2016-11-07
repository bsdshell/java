import java.io.*;
import java.lang.String;
import java.util.*;
class RemoveSpace 
{
	public static void main(String args[])
	{
		System.out.println("n=");
		String str = RemoveSpace(" ");
		System.out.println("str=[" + str + "]");
	}
	public static String RemoveSpace(String str)
	{
		String s="";
		if( str != null)
		{
			int len = str.length();
			if(len == 1)
			{ if(str.charAt(0) != ' ')	s = str; }
			else if( len > 1)
			{ String w="";
				if(str.charAt(0) != ' ')
					w = str.charAt(0) + "";
				for(int i=1; i<len; i++)
				{ if(str.charAt(i) != ' ')
						w = w + str.charAt(i);
					else if(str.charAt(i-1) != ' ')
					{ if(s.equals(""))
						{ s = w; w="";}
						else 
						{
							s = s + " " + w;
							w = "";
						}
					}
				}
				if(!w.equals(""))
					s = s + " " + w;
			}
		}
		return s;
	}
}
