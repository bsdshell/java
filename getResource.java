// getResource() for static class
import java.net.*;
public class getResource 
{
				public static void main(String[] args)
				{
								URL url = Hello.class.getClass().getResource("");
								System.out.println("url="+url);
								System.out.println("Hello World!");
				}
}
