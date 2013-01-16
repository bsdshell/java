import java.io.*;
import java.lang.*;
import java.util.*;
class infixTopostfix 
{
	public static void main(String args[])
	{
		System.out.println("cool");
		//tokenize("77+(12+4)x6+(9)");
		//String s = infixToprefix("(1+2)x3");
		//Vector<String> vet = infixToprefix("5x(6+2)-12/4");
		Vector<String> vet = infixToprefix("(1-4)x5");
		for(int i=0; i<vet.size(); i++)
			System.out.println("vet["+i+"]="+vet.get(i));
		int n = evaluate(vet);	
			System.out.println("s="+n);
	}
	public static Vector<String> infixToprefix(String str)
	{
		String p="";
		Vector<String> vet = null;
		Stack<String> st = new Stack<String>();
		ArrayList<String> list = tokenize(str);
		if( str != null)
		{ vet = new Vector<String>();
			for(int i=0; i<list.size(); i++)
			{
				String s=list.get(i);
				System.out.println("["+s+"]");
				if( s.equals("("))
					st.push(s);
				else if( s.equals(")"))
				{ while(!st.empty() && !st.peek().equals("("))	
					{ //p += st.pop();  
						vet.add(st.pop());			}
					if(!st.empty())
					{
						String str1 = st.pop();
						System.out.println("str1="+str1);
					}
				}
				else if( s.equals("+") || 
						s.equals("-") ||
						s.equals("x") ||
						s.equals("/") 
						)
				{
					if(st.empty() || st.peek().equals("("))	
						st.push(s);
					else 
					{
						while(!st.empty() && !st.peek().equals("(") && precedence(s) <= precedence(st.peek()))
							//p += st.pop();
							vet.add(st.pop());
						st.push(s);
					}
				}
				else //operand is found 
				{
					//p += s;
					vet.add(s);
				}
			}
			while(!st.empty())
				//p +=st.pop();
				vet.add(st.pop());
		}
		return vet;
	}	
	public static int eval(String s1, String ope, String s2)
	{
		int ret = 0;
		int n1 = Integer.parseInt(s1);
		int n2 = Integer.parseInt(s2);
		if( ope.equals("+"))
			ret = n1 + n2;
		else if( ope.equals("-"))
			ret = n1 - n2;
		else if(ope.equals("x"))
			ret = n1*n2;
		else if( ope.equals("/"))
			ret = n1/n2;
		else 
			System.out.println("Error operator:"+ope);
		return ret;
	}
	public static int evaluate(Vector<String> vet)
	{
		Stack<String> st = new Stack<String>();
		for(int i=0; i<vet.size(); i++)
		{
			String s=vet.get(i);
			if( s.equals("+") ||
					s.equals("-") ||
					s.equals("x") ||
					s.equals("/")) 
			{
				String A = st.pop();
				String B = st.pop();
				String value = eval(B, s, A) + "";
				st.push(value);
			}
			else
			{
				st.push(s);	
			}
		}	
		int ret = Integer.parseInt(st.pop());
		return ret;
	}
	public static int precedence(String ope)
	{ int ret = 1;
		if(ope.equals("+") || ope.equals("-"))
			ret = 1;
		else if(ope.equals("/") || ope.equals("x"))
			ret = 2;
		return ret;
	}
	public static ArrayList<String> tokenize(String str)
	{
		ArrayList<String> list = new ArrayList<String>();
		if( str != null)
		{
			char[] chArr =  str.toCharArray();	
			String s="";
			for(int i=0; i<chArr.length; i++)
			{
				if('0'<= chArr[i] && chArr[i] <= '9')
					 s += chArr[i];	
				else 
				{ if(!s.equals(""))
					{ list.add(s); s = "";}
					list.add(chArr[i]+"");
				}
			}
			if(!s.equals(""))
				list.add(s); s="";
		}
		for(int i=0; i<list.size(); i++)
		{
			System.out.println(list.get(i));
		}
		return list;
	}
}

