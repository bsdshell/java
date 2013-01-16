import java.lang.Character;
public class Trim 
{
				public static void main(String[] args)
				{
								String str = "   hello world  ";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = "";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = "a";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = " ";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = " a";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = "a ";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = " a ";
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");

								str = null;
								System.out.println("["+str+"]");
								System.out.println("["+trim(str)+"]");


				}
				public static String trim(String str)
				{
								String ret = null;
								if(str != null)
								{
												ret = "";
												int i = 0;
												while(str.length() > 0 && str.length() > i && Character.isSpace(str.charAt(i)))
												{
																i++;
												}
												int l = str.length();

												while(l > 0 && Character.isSpace(str.charAt(l-1)))
												{
																l--;
												}
												for(int k = i; k < l; k++)
												{
																ret = ret + str.charAt(k);
												}
								}
								return ret;
				}
}
