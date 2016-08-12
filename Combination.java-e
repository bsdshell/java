// print all combination 0 to n-1
public class Combination 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] path = new int[3];
        int row = 0;
        combination(path, row);
        test1();
        test2();
    }
    public static void combination(int[] path, int row)
    {
        if(path != null)
        {
            if(row == path.length)
            {
                for(int r = 0; r < path.length; r++)
                {
                    System.out.print("["+path[r]+"]");
                }
                System.out.println("");
            }
            for(int col=0; col<path.length && row < path.length; col++)
            {
                path[row] = col; 
                combination(path, row+1);
            }
        }
    }
    public static void test1()
    {
        System.out.println("=================================="); 
        int[] path = {1}; 
        int row = 0;
        int len = path.length;
        combination(path, row);
    }
    public static void test2()
    {
        System.out.println("=================================="); 
        int[] path = {1, 2}; 
        int row = 0;
        int len = path.length;
        combination(path, row);
    } 
}
