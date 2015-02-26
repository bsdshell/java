import java.util.*;

public class Try 
{
    public static void main(String[] args)
    {
        test1();
    }
    public static void test1()
    {
        int[][] arr = { {1,2},
                        {3,4},
                        {5,6},
                        {7,8}
                      };
        spiral(arr);

    }
    public static void spiral(int[][] arr)
    {
        final int right=0;
        final int down =1;
        final int left =2;
        final int up   =3;

        int count=0;
        int height=arr.length;
        int width =arr[0].length;
        //turn = 0, 1, 2, 3, 0, 1, 2, 3
        
        int len = height > width ? height: width;
        int[][] tmpArr = new int[len][len];

        for(int c=0; c<len; c++)
        {
            for(int r=0; r<len; r++)
            {
                if(c < height && r < width)
                    tmpArr[c][r] = arr[c][r];
                else
                    tmpArr[c][r] = -1; 
            }
        }

        Aron.printArray2D(tmpArr);
        int r=0;
        int c=0;
        width = len;
        height = len;
        int turn=0;
        while(count < height*width-1)
        {
            if(turn % 4 == right)
            {
                if(r + 1 < width && tmpArr[c][r+1] != -1)
                {
                    System.out.println("["+c+"]["+r+"]="+tmpArr[c][r]);  
                    tmpArr[c][r]=-1;
                    count++;
                    r++;
                }
                else
                    turn++;
            }
            else if(turn % 4 == down)
            {
                if(c + 1 < height && tmpArr[c+1][r] != -1)
                {
                    System.out.println("["+c+"]["+r+"]="+tmpArr[c][r]);
                    tmpArr[c][r]=-1;
                    c++;
                    count++;
                }
                else
                    turn++;
            }
            else if(turn % 4 == left)
            {
                if(r - 1 >=0 && tmpArr[c][r-1] != -1)
                {
                    System.out.println("["+c+"]["+r+"]="+tmpArr[c][r]);
                    tmpArr[c][r]=-1;
                    r--;
                    count++;
                }
                else
                    turn++;
            }
            else if(turn % 4 == up)
            {
                if(c - 1 >= 0 && tmpArr[c-1][r] != -1)
                {
                    System.out.println("["+c+"]["+r+"]="+tmpArr[c][r]);
                    tmpArr[c][r]=-1;
                    c--;
                    count++;
                }
                else
                    turn++;
            }
        }
        
        if(len % 2 == 1 && tmpArr[len/2][len/2] >=0)
            System.out.println("["+c+"]["+r+"]="+tmpArr[len/2][len/2]);
        
    }
}
