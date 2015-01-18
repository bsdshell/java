// print all combination 0 to n-1
public class Combination 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        int[] path = new int[3];
        int row = 0;
        combination(path, row);
    }
    public static void combination(int[] path, int row)
    {
        if(path != null)
        {
            for(int col=0; col<path.length && row < path.length; col++)
            {
                path[row] = col; 
                combination(path, row+1);
            }
            if(row == path.length)
            {
                for(int r = 0; r < path.length; r++)
                {
                    System.out.print("["+path[r]+"]");
                }
                System.out.println("");
            }
        }
    }
}
