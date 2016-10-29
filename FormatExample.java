import java.util.*;
import java.io.*;
import classfile.*;

public class FormatExample{
    public static void main (String[] args)
	{
		String sendID = "AABB";
        String output = String.format("%0"+(10-sendID.length())+"d%s", 0, sendID);
        System.out.println(output);
	}
} 

