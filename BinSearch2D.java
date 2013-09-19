
//Binary search in two dimension is based on one dimension search
public class BinSearch2D 
{
    public static void main(String[] args)
    {
        System.out.println("binary search in two dimension");
        
        int[][] array = {{1, 10, 20, 21},
                         {5, 15, 25, 100},
                         {11,17, 30, 101},
                         {12,18, 31, 102}};
        int key = 25;
        int rlo = 0;
        int rhi = array.length-1;
        int clo = 0;
        int chi = array[0].length-1;
        boolean ret = binSearch2D(array, rlo, rhi, clo, chi, key);
        System.out.println("ret="+ret);
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
