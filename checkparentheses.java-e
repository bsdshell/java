import java.io.*;
import java.lang.String;
import java.util.*;
class  checkparentheses 
{
	public static void main(String args[])
	{
		String str="{[][}]";
		boolean ret = checkparentheses(str);

		System.out.println("ret="+ret);
	}

	public static boolean checkparentheses(String str)
	{
			Stack<String> st = new Stack<String>();	
			Map<String, String> map = new HashMap<String, String>();
			map.put(")", "(");
			map.put("]", "[");
			map.put("}", "{");
			boolean ret = true;
			if( str != null)
			{
				for(int i=0; i<str.length() && ret; i++)
				{
					String chstr = str.charAt(i) + "";
					if(chstr.equals("(") ||
							chstr.equals("[") || 
							chstr.equals("{"))
					{
						st.push(chstr);
					}
					else
					{ if(st.empty())
							ret = false;
						else 
						{ String p = st.pop();
							String mp = map.get(str.charAt(i)+"");
							if( p.equals(mp))
								ret = true;
							else
								ret = false;
						}
					}
				}
			}
			if(!st.empty())
				ret = false;
			return ret;
	}
}
