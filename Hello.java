public class Hello
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        String s = "abc";
        for(int i=0; i<s.length(); i++)
        {
            System.out.println(s.substring(i,i+1));
        }
    }
}
