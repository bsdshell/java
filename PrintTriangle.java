public class PrintTriangle 
{
    public static void main(String[] args)
    {
        int array[][] = new int[][]{
        { 0, 2, 3, 4, 5 },
        { 0, 0, 1, 2, 9 },
        { 0, 0, 0, 6, 5 },
        { 0, 0, 0, 0, 7 },
        { 0, 0, 0, 0, 0 }
        };
        System.out.println("Hello World!");
        int depth = 0;
        int max = Triangle(array, 0, 0);
        System.out.println("max="+max);
    }
    public static int Triangle(int[][] array, int row, int depth)
    {
        int max = 0;
        if(array != null)
        {
            int height = array.length;
            int width  = array[0] != null ? array[0].length : 0;
            //System.out.println("height="+height);
            //System.out.println("width ="+width);
            if(depth < width)
            {
                for(int i=0; i<width; i++)
                {
                    if(row < height && array[depth][i] != 0 && i != row)
                    {
                        int m = Triangle(array, i, depth+1) + array[depth][i];
                        max = max < m? m : max; 
                        System.out.println("["+depth+"]["+i+"]="+array[depth][i]);
                    }
                }
            }
        }
        return max;
    }
}
