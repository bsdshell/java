import java.io.*;

interface myinter 
{
	public void face();
	public void print();
}

class myclass implements myinter 
{
	public void face()
	{
		System.out.println("face");
	}
	public void print()
	{
		System.out.println("print");
	}
}


class Interface 
{
	public static void main(String args[])
	{
		myclass a = new myclass();
		a.face();
		a.print();
	}
}
