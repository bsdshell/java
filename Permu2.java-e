import java.io.*;
import java.lang.String;
import java.util.*;
class Permu2
{
	public static void main(String args[])
	{
		per("abcd");
	}
	public static void per(String str)
	{
		Vector<String> vet = new Vector<String>();
		if(str != null)
		{
			int len = str.length();
			if(len > 0)
			{
				vet.add(str.charAt(0) + "");
				Vector<String> vet2 = new Vector<String>();
				for(int j = 1; j < len; j++)
				{
					for(int i = 0; i < vet.size(); i++)
					{
						Vector<String> vet1 = new Vector<String>();
						vet1 = Combin2(vet.get(i), str.charAt(j) + "");	

						for(int k=0; k<vet1.size(); k++)
							vet2.add(vet1.get(k));
					}	
					vet.clear();

					for(int x=0; x<vet2.size(); x++)
						vet.add(vet2.get(x));
					vet2.clear();

				}
				for(int i = 0; i < vet.size(); i++)
				{
					System.out.println(vet.get(i));
				}
			}
		}	
	}

	public static Vector<String>  Combin2(String str, String ch)
	{
		Vector<String> vet = new Vector<String>();
		for(int i = 0; i < str.length() + 1; i++)
		{
			StringBuffer sb = new StringBuffer(str);
			sb.insert(i, ch);
			vet.add(sb.toString());
		}
		return vet;
	}
	public static Vector<String>  Combin(String str, String ch)
	{
		Vector<String> vet = new Vector<String>();
		int i = 0;
		for(i = 0; i < str.length() + 1; i++)
		{
			String s = "";
			for(int j = 0; j < str.length(); j++)
			{
				if(i == j)
					s = s + ch; 
				s = s + str.charAt(j);
			}	
			if(i == str.length())
				s = s+ch;
			System.out.println (s);
		}
		return vet;
	}
}
