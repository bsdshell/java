public class MainDriver 
{
				public static void main(String[] args)
				{
								System.out.println("Java adapter pattern");
								System.out.println("MainDriver.java");
								AdapterTurkey adapter = new AdapterTurkey(new Turkey());
								adapter.quack();
				}
}
