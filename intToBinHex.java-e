import java.io.*;
import java.lang.String;
import java.util.*;
class intToBinHex 
{
	public static void main(String args[])
	{
		String bin = intToBinary(1);
		String hex = intToHex2(16);
		System.out.println("bin=" + bin);
		System.out.println("hex=" + hex);
	}
	public static String intToBinary(int num)
	{
		String s = "";
		if(num == 0)
		{
			s = "0";
		}
		else if(num > 0)
		{
			while(num > 0)
			{
				int mod = num%2;
						num = num/2;
						s = mod + s;
			}
		}
		return s;
	}
	public static String intToHex2(int num)
	{
		String s = "";
		char[][] map = { 
			{0, '0'},
			{1, '1'},
			{2, '2'},
			{3, '3'},
			{4, '4'},
			{5, '5'},
			{6, '6'},
			{7, '7'},
			{8, '8'},
			{9, '9'},
			{10, 'A'},
			{11, 'B'},
			{12, 'C'},
			{13, 'D'},
			{14, 'E'},
			{15, 'F'}
		};

		if( num == 0)
			s = map[0][1] + "";
		else if(num > 0)
		{
			while(num > 0)
			{
				int mod = num % 16;
						num = num/16;
						s = map[mod][1] + s;
			}
		}
		return s;
	}
	public static String intToHex(int num)
	{
		String s = "";
		Map<Integer, String>  map = new HashMap<Integer, String>();
		map.put(new Integer(0), "0");
		map.put(new Integer(1), "1");
		map.put(new Integer(2), "2");
		map.put(new Integer(3), "3");
		map.put(new Integer(4), "4");
		map.put(new Integer(5), "5");
		map.put(new Integer(6), "6");
		map.put(new Integer(7), "7");
		map.put(new Integer(8), "8");
		map.put(new Integer(9), "9");
		map.put(new Integer(10), "A");
		map.put(new Integer(11), "B");
		map.put(new Integer(12), "C");
		map.put(new Integer(13), "D");
		map.put(new Integer(14), "E");
		map.put(new Integer(15), "F");

		if(num == 0)
		{
			String hexMod = (String)map.get(new Integer(num));	
			s = hexMod + s;
		}
		else if(num > 0)
		{
			while(num > 0)
			{
				int mod = num%16;
						num = num/16;
						String hexMod = (String)map.get(new Integer(mod));	
						s = hexMod + s;
			}
		}
		return s;
	}
}
