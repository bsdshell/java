import java.util.*;

public class ListAndSet 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
        test2();
        test3();
        test4();
    }
    public static Set<Integer> clone(Set<Integer> set)
    {
        Set<Integer> s = new LinkedHashSet<Integer>(); 
        for(Integer ele: set)
            s.add(ele);

        return s;
    }
    public static void test1()
    {
        System.out.println("test1"); 
        int[] list = {1, 2};
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2)); 
        System.out.println(match(list, set));

    } 
    public static void test2()
    {
        System.out.println("test2"); 
        int[] list = {1, 4, 2};
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2)); 
        System.out.println(match(list, set));

    } 
    public static void test3()
    {
        System.out.println("test3"); 
        int[] list = {2, 4, 3, 1, 2};
        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3)); 
        System.out.println(match(list, set));
    } 
    public static void test4()
    {
        System.out.println("test4"); 
        int[] list = {2, 4, 3, 1, 2};
        Set<Integer> set = new HashSet<Integer>(); 
        System.out.println(match(list, set));
    } 
    public static boolean match(int[] list, Set<Integer> set)
    {
        Set<Integer> set1 = clone(set);
        if( list != null && set != null)
        {
            if(set1.isEmpty())
                return true;

            boolean start = false;
            for(int ele: list)
            {
                if(set1.contains(ele))
                {
                    set1.remove(ele);
                    start = true; 
                }
                else{
                    if(start)
                        set1 = clone(set);           
                    start = false;
                }

                if(set1.isEmpty())
                    return true;
            }
        }
        return false;
    }
}
