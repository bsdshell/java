public class PatternMatch 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
    }
    //"ab?"
    //Generate table for "ab?" pattern
    public static boolean match(String pattern, String str)
    {
        Map<Integer, Map<String, Integer>> map = new HashMap<Integer, Map<String, Character>>();

        /*
        for(int i=0; i<pattern.length(); i++)
        {
            char currChar = pattern.charAt(i);
            char nextChar = '0';
            if(i+1 < pattern.length())
                char nextch = pattern.charAt(i+1);
            //if(nextChar == '?')
            //else


        }
        */
    }
}
