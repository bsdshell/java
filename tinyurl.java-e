import java.io.*;
import java.lang.*;
import java.util.*;

class turl
{
	int count;
	int maxurl;
	Map<Integer, String> charMap = new HashMap<Integer, String>();
	Map<String, String> urlMap = new HashMap<String, String>();
	Map<String, String> biurlMap = new HashMap<String, String>();

	public turl(int max)
	{ maxurl = max;
		count = 0;	

		for(int i=0; i<26; i++)
		{ char ch = (char)((int)'a' + i);
			charMap.put(i, Character.toString(ch));
		}
	}
	public String generate(String url)
	{
		String ret="";
		int c = count;
		if(!urlMap.containsKey(url))
		{
			String code="";
			if( c == 0)
				code="a";
			else 
				while(c > 0)
				{
					int m = c%26;
					c = c/26;
					String s = charMap.get(m);
					code = s + code;
				}
			urlMap.put(url, code);
			biurlMap.put(code, url);
			if(count < maxurl);
			count++;
			ret = code;
		}
		else 
			ret = urlMap.get(url);
		return ret;
	}
	public String geturl(String code)
	{
		return biurlMap.get(code);	
	}
}
class tinyurl 
{
	public static void main(String args[])
	{
			String s="";
			turl t = new turl(26*26);
			Random r = new Random();
			for(int j=0; j<26*26; j++) 
			{
				s="";
				for(int i=0; i < 10; i++)
				{
					int ran = r.nextInt(10);
					s += Integer.toString(ran);
				}
				String code = t.generate(s);
				System.out.println("code="+code + "->"+s);
			}
	}
}

