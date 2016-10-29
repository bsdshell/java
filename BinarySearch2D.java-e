
//Binary search in two dimension is based on one dimension search
public class BinarySearch2D 
{
    public static void main(String[] args)
    {
        Test1();
        Test2();
    }

    public static void printArray(int[][] array, int height, int width)
    {
        for(int col=0; col<=height; col++)
        {
            for(int row=0; row<=width; row++)
            {
                System.out.print("["+array[col][row]+"]");
            }
            System.out.println();
        }
    }
    public static void Test1()
    {
        System.out.println("Binary search in two dimension");
        int[][] array = {{1,  100, 200, 201},
                         {5,  105, 205, 1000},
                         {11, 107, 300, 1001},
                         {13, 108, 302, 1002},
                         {104,301, 305, 1003}};
        int key = 201;
        int rlo = 0;
        int rhi = array[0].length-1;
        int clo = 0;
        int chi = array.length-1;
        printArray(array, chi, rhi);

        boolean ret2 = BinSearch2D(array, clo, rlo, chi, rhi, key);
        System.out.println("ret2="+ret2);

        boolean ret3 = binSearchMN(array, clo, rlo, chi, rhi, key);
        System.out.println("ret3="+ret3);
    }

    public static void Test2()
    {
        System.out.println("Binary search in two dimension");
        int[][] array = {{203}};
        int key = 203;
        int rlo = 0;
        int rhi = array[0].length-1;
        int clo = 0;
        int chi = array.length-1;
        printArray(array, chi, rhi);

        boolean ret2 = BinSearch2D(array, clo, rlo, chi, rhi, key);
        System.out.println("ret2="+ret2);

        boolean ret3 = binSearchMN(array, clo, rlo, chi, rhi, key);
        System.out.println("ret3="+ret3);
    }

    //Binary search from top right corder, eliminate row/column algorithm 
    //Complexity O(m+n)
    public static boolean binSearchMN(int[][] array, int collo, int rowlo, 
                                                     int colhi, int rowhi, int key)
    {
        int width = rowhi - rowlo + 1;
        int height = colhi - collo + 1;
        int col = collo;
        int row = rowhi;
        for(int i=0; i<width+height; i++)
        {
            if(key < array[col][row])
            {
                if(row > rowlo)
                    row--;
            }
            else if(key > array[col][row])
            {
                if(col < colhi)
                    col++;
            }
            else 
                return true;
        }
        return false;
    }
    
    //Binary search: eliminate one quandrant in each step
    //Complexity O(lg(m)+lg(n))
    public static boolean BinSearch2D(int[][] array, int collo, int rowlo, 
                                                     int colhi, int rowhi, int key)
    {
        boolean ret = false;
        if(array != null)
        {
            int colm = (collo + colhi)/2;
            int rowm = (rowlo + rowhi)/2;
            if(collo <= colhi && rowlo <= rowhi)
            {
                if(key < array[colm][rowm])
                {
                    boolean b1 = BinSearch2D(array, collo, rowlo,
                                                  colm-1, rowm-1, key);
                    boolean b2 = BinSearch2D(array, collo, rowm,
                                                  colm-1,rowhi, key);
                    boolean b3 = BinSearch2D(array, colm, rowlo,
                                                  colhi, rowm-1, key);
                    ret = b1 || b2 || b3;
                }
                else if(key > array[colm][rowm])
                {
                    boolean b1 = BinSearch2D(array, colm+1, rowm+1,
                                                  colhi,  rowhi, key);
                    boolean b2 = BinSearch2D(array, collo, rowm+1,
                                                  colm,  rowhi, key);
                    boolean b3 = BinSearch2D(array, colm+1, rowlo,
                                                  colhi,  rowm, key);
                    ret = b1 || b2 || b3;
                }
                else
                    ret = true;
            }
        }
        return ret;
    } 
}
