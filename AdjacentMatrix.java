public class AdjacentMatrix 
{
    public static void main(String[] args)
    {
        System.out.println("AdjacentMatrix");
        int array[][] = new int[][]{
        { 0, 2, 3, 4, 5 },
        { 0, 0, 1, 2, 9 },
        { 0, 0, 0, 6, 5 },
        { 0, 0, 0, 0, 7 },
        { 0, 0, 0, 0, 0 }
        };
        int row = 0;
        int max = findMinPath(array, row);
        System.out.println("max=" + max);
    }
    static int findMinPath(int[][] array, int row)
    {
        int max = 0;
        if(array != null)
        {
            int height = array.length;
            int width  = array[0] != null ? array[0].length : 0;
            //System.out.println("height=" + height);
            //System.out.println("width=" + width);

            if(row < height)
            {
                int currMax = 0;
                for(int col=0; col < width; col++)
                {
                    if(array[row][col] != 0)
                    {
                        System.out.println("("+row+")"+array[row][col]+"->("+col+")");
                        int subMax = findMinPath(array, col) + array[row][col];
                        if(subMax > currMax) 
                            currMax = subMax;
                    }
                }
                //System.out.println("max=" + currMax);
                max = currMax;
            }
        }
        return max;
    }
}
