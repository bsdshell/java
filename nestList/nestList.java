import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

// nest map
public class nestList 
{
				public static void main(String[] args)
				{
								System.out.println("Hello World!");
                                Map<String, Object> map = new HashMap<String, Object>();
                                Map<String, Object> innerMap = new HashMap<String, Object>();
                                map.put("0",innerMap);
				}
}
