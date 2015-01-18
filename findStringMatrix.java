public class findStringMatrix 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");

        int[][] array = {
            {0, 0},
            {0, 1}
        };
        int[] source = {0, 0};
        /*
        int[][] array = {
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},

            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }
        */
        int count = 0;
        for(int row=0; row < array.length; row++){
            for(int col=0; col< array.length; col++){
               count = countString(array, source, row, col, 0); 
            }
        }
        System.out.println("count="+count);
    }
    public static int countString(int[][] array, int[] source, int row, int col, int sourceIndex)
    {
        if(col < array.length && row < array.length)
        {
            if(sourceIndex == source.length)
            {
                return 1;
            }
            else
            {
                if(array[row][col] == source[sourceIndex])
                {
                    int horizonal_right     = countString(array, source, row, col+1, sourceIndex+1);
                    int horizonal_left      = countString(array, source, row, col-1, sourceIndex+1);
                    int vertical_down       = countString(array, source, row+1, col, sourceIndex+1);
                    int vertical_up         = countString(array, source, row-1, col, sourceIndex+1);
                    int diagonal_main_up    = countString(array, source, row+1, col+1, sourceIndex+1);
                    int diagonal_main_down  = countString(array, source, row-1, col-1, sourceIndex+1);
                    int diagonal_minor_up   = countString(array, source, row-1, col+1, sourceIndex+1);
                    int diagonal_minor_down = countString(array, source, row+1, col-1, sourceIndex+1);
                    return horizonal_right + horizonal_left + vertical_down + vertical_up + diagonal_main_up + diagonal_main_down + diagonal_minor_up + diagonal_minor_down;
                }
            }
        }
        else
        {
            return 0;
        }
        return 0;
    }
}
