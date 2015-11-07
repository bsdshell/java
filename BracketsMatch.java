public class BracketsMatch 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
        test2();
    }
    public static int[] fun()
    {
        int[] array = {1, 2};
        return array;
    }
    public static void test1()
    {
        System.out.println("test1"); 
        String str = "()";
        int index = 0;
        System.out.println(match(str, index)); 
    } 
    public static void test2()
    {
        System.out.println("test2"); 
        String str = "(}";
        int index = 0;
        System.out.println(match(str, index)); 
    } 
    public static boolean match(String str, int index){
        if(str.charAt(index) == '('){
            match(str, index+1);
        }else{
            if(index-1 < 0)
                return false;
            if(str.charAt(str.length-1-index) == '(' &&  str.charAt(index) != ')')
                return false;
        }
        return true;
    }
}
