import java.io.*;
import java.lang.String;
import java.util.*;

class HashMapIterate  
{
	public static void main(String args[])
	{
		Map<String, String> hashmap = new HashMap<String, String>();
		hashmap.put("key0", "str0");	
		hashmap.put("key1", "str1");	
		hashmap.put("key2", "str2");	
		hashmap.put("key3", "str3");	

		for(String key : hashmap.keySet())
		{
			String value = hashmap.get(key);
			System.out.println("hashmap["+key+","+value+"]");	
		}
	}
}
