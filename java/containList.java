import java.util.List;
import java.util.ArrayList;


public class containList
{
	public static void main(String[] args)
	{
		ArrayList<String> mylist = new ArrayList<String>();
		mylist.add("cool");
		mylist.add("dog");
		mylist.add("apple");
		
		if(mylist.contains("dog"))
		{
			System.out.println("mylist contains dog");
		}
		else
		{
			System.out.println("mylist does not contains dog");
		}
	}
}

