public class PermutationPrefix 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        permute("", "12345");
    }
    public static void permute(String prefix, String s)
    {
        if(s.length() == 0)
            System.out.println(prefix);
        else
        {
            for(int i=0; i< s.length(); i++)
            {
                permute(prefix + (s.charAt(i) + ""), remove(s, i));
            }
        }
    }
    public static String remove(String s, int index)
    {
        String ret = "";
        for(int i=0; i<s.length(); i++)
        {
            if(i != index)
                ret += s.charAt(i) + "";
        }
        return ret;
    }
    public static void permute2(String s)
    {
        
    }
}
