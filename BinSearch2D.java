
//Binary search in two dimension is based on one dimension search
public class BinSearch2D 
{
    public static void main(String[] args)
    {
        Test1();
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

        System.out.println("rhi=["+rhi+"]");
        System.out.println("chi=["+chi+"]");

        boolean ret1 = binSearch2DNew(array, clo, rlo, chi, rhi, key);
        System.out.println("ret1="+ret1);

        boolean ret2 = binSearch2DBetter(array, clo, rlo, chi, rhi, key);
        System.out.println("ret2="+ret2);

        boolean ret3 = binSearchMN(array, clo, rlo, chi, rhi, key);
        System.out.println("ret3="+ret3);
    }
    public static boolean binSearchMN(int[][] array, int collo, int rowlo, int colhi, int rowhi, int key)
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
    public static boolean binSearch2DNew(int[][] array, int collo, int rowlo, int colhi, int rowhi, int key)
    {
        int colmid = (collo + colhi)/2;
        int rowmid = (rowlo + rowhi)/2;
        boolean ret = false;
        if(collo < colhi && rowlo < rowhi)
        {
            if(key < array[colmid][rowmid])
            {
                boolean b2 = binSearch2DNew(array, collo, rowlo, colmid-1, rowmid-1, key);
                boolean bup = binSearch2DNew(array, collo, rowmid, colmid-1, rowhi, key);
                boolean bdown = binSearch2DNew(array, colmid, rowlo, colhi, rowmid-1, key);
                ret = b2 || bup || bdown;
            }
            else if(key > array[colmid][rowmid])
            {
                boolean b3 = binSearch2DNew(array, colmid+1, rowmid+1, colhi, rowhi, key);
                boolean bup = binSearch2DNew(array, collo, rowmid, colmid, rowhi, key);
                boolean bdown = binSearch2DNew(array, colmid+1, rowlo, colhi, rowmid, key);
                ret = b3 || bup || bdown;
            }
            else
            {
                System.out.println("["+colmid+"]["+rowmid+"]key["+key+"]");
                ret = true;
            }
        }
        else if(collo == colhi && rowlo < rowhi)
        {
            if(key < array[colmid][rowmid])
            {
                ret = binSearch2DNew(array, colmid, rowlo, colmid, rowmid-1, key);
            }
            else if(key > array[colmid][rowmid])
            {
                ret = binSearch2DNew(array, colmid, rowmid+1, colmid, rowhi, key);
            }
            else
            {
                System.out.println("["+colmid+"]["+rowmid+"]key["+key+"]");
                ret = true;
            }
        }
        else if(collo < colhi && rowlo == rowhi)
        {
            if(key < array[colmid][rowmid])
            {
                ret = binSearch2DNew(array, collo, rowmid, colmid-1, rowmid, key);
            }
            else if(key > array[colmid][rowmid])
            {
                ret = binSearch2DNew(array, colmid+1, rowmid, colhi, rowmid, key);
            }
            else
            {
                System.out.println("["+colmid+"]["+rowmid+"]key["+key+"]");
                ret = true;
            }
        }
        else if(collo == colhi && rowlo == rowhi)
        {
            ret = key == array[colmid][rowmid];
            if(ret)
                System.out.println("["+colmid+"]["+rowmid+"]key["+key+"]");
        }
        return ret;
    }
    public static boolean binSearch2DBetter(int[][] array, int collo, int rowlo, 
                                                           int colhi, int rowhi, int key)
    {
        if(array != null)
        {
            int colm = (collo + colhi)/2;
            int rowm = (rowlo + rowhi)/2;
            if(collo <= colhi && rowlo <= rowhi)
            {
                if(key < array[colm][rowm])
                {
                    boolean b1 = false, b2 = false, b3 = false;
                    b1 = binSearch2DBetter(array, collo, rowlo,
                                                  colm-1, rowm-1, key);

                    b2 = binSearch2DBetter(array, collo, rowm,
                                                  colm-1,rowhi, key);
                    b3 = binSearch2DBetter(array, colm, rowlo,
                                                  colhi, rowm-1, key);
                    return b1 || b2 || b3;
                }
                else if(key > array[colm][rowm])
                {
                    boolean b1 = false, b2 = false, b3 = false;
                    b1 = binSearch2DBetter(array, colm+1, rowm+1,
                                                  colhi,  rowhi, key);
                    b2 = binSearch2DBetter(array, collo, rowm+1,
                                                  colm,  rowhi, key);
                    b3 = binSearch2DBetter(array, colm+1, rowlo,
                                                  colhi,  rowm, key);
                    return b1 || b2 || b3;
                }
                else
                    return true;
            }
        }
        return false;
    } 

    public static boolean binSearch2D(int[][] array, int rlo, int rhi, int clo, int chi, int key)
    {
        boolean ret = false;
        if( array != null && array.length > 0 && array[0].length > 0)
        {
            int rmid = (rlo + rhi)/2;
            int cmid = (clo + chi)/2;
            if(rhi > rlo && chi > clo)
            {
                if(key < array[rmid][cmid])
                {
                    boolean ret1 = binSearch2D(array, rlo, rmid, clo, chi, key);
                    boolean ret2 = binSearch2D(array, rmid+1, rhi, clo, cmid, key);
                    ret = ret1 || ret2;
                }
                else if(key > array[rmid][cmid])
                {
                    boolean ret1 = binSearch2D(array, rlo, rhi, cmid+1, chi, key);
                    boolean ret2 = binSearch2D(array, rmid+1, rhi, clo, cmid+1, key);
                    ret = ret1 || ret2;
                }
                else
                    ret = true;
            }
            else if(rhi > rlo && chi == clo)
            {
                if(key < array[rmid][cmid])
                {
                    ret = binSearch2D(array, rlo, rmid, cmid, cmid, key);
                }
                else if(key > array[rmid][cmid])
                {
                    ret = binSearch2D(array, rmid+1, rhi, cmid, cmid, key);
                }
                else
                {
                    ret = true;
                }
            }
            else if(rhi == rlo && chi > clo)
            {
                if(key < array[rmid][cmid])
                {
                    ret = binSearch2D(array, rmid, rmid, clo, cmid, key);
                }
                else if(key > array[rmid][cmid])
                {
                    ret = binSearch2D(array, rmid, rmid, cmid+1, chi, key);
                }
                else
                {
                    ret = true;
                }
            }
            else
            {
                if(key == array[rmid][cmid])
                    ret = true;
            }
        }
        return ret;
    }
}
