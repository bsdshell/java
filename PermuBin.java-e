import java.io.*;
import java.util.*;

//a1b -> a1b, A1b, a1B, A1B
//permut upper and lower cases

class PermuBin
{
	public static void main(String args[])
	{
		System.out.println("cool");
		Vector<String> v = perm("1");
		for(int i=0; i<v.size(); i++)
			System.out.println(v.get(i));
	}
	public static Vector<String> perm(String str)
	{ Vector<String> v = new Vector<String>();
		Vector<String> vet = new Vector<String>();
		v.add("$");
		if( str != null && str.length() > 0)
		{ 
			for(int j=0; j<str.length(); j++)
			{
				char ch = str.charAt(j);
				for(int i=0; i<v.size(); i++)
				{ String s="";
					if('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z')			
					{ if(j != 0 || i != 0)
						{
							s = v.get(i) + Character.toUpperCase(ch); 
							vet.add(s);
							s = v.get(i) + Character.toLowerCase(ch); 
							vet.add(s);
						}
						else
						{ 
							vet.add(Character.toUpperCase(ch)+"");
							vet.add(Character.toLowerCase(ch)+"");
						}
					}
					else
					{ if(j != 0 || i != 0)
						{ s = v.get(i) + ch; 
							vet.add(s);
						}
						else
						{ s = ch + ""; 
							vet.add(s);
						}
					}
				}
				v.clear();
				for(int i=0; i<vet.size(); i++)
					v.add(vet.get(i));
				vet.clear();
			}
		}
		return v;
	}
}
