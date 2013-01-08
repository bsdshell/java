import java.io.*;
import java.lang.*;
import java.util.*;
class matchparenthesis 
{
	public static void main(String args[])
	{
			System.out.println(valid("([()]{})"));
	}
		
	public static boolean match(String lv, String rv)
	{
		boolean ret = false;
		if( lv.equals("(") && rv.equals(")"))
			ret = true;
		else if( lv.equals("[") && rv.equals("]"))
			ret = true;
		else if( lv.equals("{") && rv.equals("}"))
			ret = true;
		return ret;
	}

	public static boolean valid(String str)
	{
		Stack<String> st = null;
		boolean ret = true;
		if( str != null)
		{ st = new Stack<String>();
			for(int i=0; i<str.length() && ret; i++)
			{
				String ch = Character.toString(str.charAt(i));
				System.out.println("ch="+ch);
				if(ch.equals("(") || ch.equals("[") || ch.equals("{"))
					st.push(ch);
				else
				{ String p = st.pop();
					if(!match(p, ch))
						ret = false;
				}
			}
		}
		if(!st.empty())
			ret = false;
		return ret;
	}
}

