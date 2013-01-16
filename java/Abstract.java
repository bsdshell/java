import java.io.*;

abstract class Abst
{
	int n;
 	public Abst()
	{
	}
	abstract void face();
	public void print()
	{
		System.out.println("print");
	}
}

class myclass extends Abst
{
	void face()
	{
		System.out.println("face");
	}
}


class Abstract
{
	public static void main(String args[])
	{
		myclass a = new myclass();
		a.face();
		a.print();
	}
}
