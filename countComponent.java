import java.util.*;
public class countComponent 
{
	public static void main(String[] args)
	{
        //test case 
        // A = null
        // A = {};
        // A = {{0}};
        // A = {{1}};
        // A = general case
		System.out.println("Hello World!");
        
        int[][] A = null; 
        int count = count(A);
        System.out.println("count="+count);

        int[][] B = {};
        count = count(B);
        System.out.println("count=0="+count);

        int[][] C = {{0}};
        count = count(C);
        System.out.println("count=1="+count);

        int[][] D = {{1}};
        count = count(D);
        System.out.println("count=0="+count);

        int[][] E = {
            {0, 0},
            {0, 0}
        };
        count = count(E);
        System.out.println("count=1="+count);
        
         int[][] F = {
            {0, 1},
            {1, 0}
        };
        count = count(F);
        System.out.println("count=2="+count);

        int[][] H = {   {1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 1, 1},
                        {0, 1, 1, 1}
                    };
        int col=0, row=0;
        int num=0;
        count = DFSCount(H, col, row);
        System.out.println("count=2="+count);

        int[][] G = {   {0, 1, 1, 1},
                        {1, 1, 0, 1},
                        {0, 1, 0, 1},
                        {0, 0, 0, 0}
                    };

	}
	static void component(int[][] A, int x, int y)
	{
		if(A != null && A[0] != null)
		{
            if(A[x][y] == 0)
            {
                A[x][y] = 2;
                if(x+1 < A.length)
                    component(A, x+1, y);	
                if(x-1 >= 0)
                    component(A, x-1, y);	
                if(y+1 < A.length)
                    component(A, x, y+1);	
                if(y-1 >= 0)
                    component(A, x, y-1);	
            }
		}
	}
    static int DFSCount(int[][] A, int col, int row)
    {
        int c0=0, c1=0, c2=0, c3=0, c4=0;
        if(A != null)
        {
            if(A[col][row] == 0)
            {
                component(A, col, row);
                c0++;
            }
            else if(A[col][row] == 1)
            {
                A[col][row] = 2;
                if(col+1 < A.length)
                    c1 = DFSCount(A, col+1, row);
                if(col-1 >= 0)
                    c2 = DFSCount(A, col-1, row);
                if(row+1 < A.length)
                    c3 = DFSCount(A, col, row+1);
                if(row-1 >= 0)
                    c4 = DFSCount(A, col, row-1);
            }
        }
        return c0 + c1 + c2 + c3 + c4;
    }
	static int  count(int[][] A)
	{
        int s=0;
        if(A != null)
        {
            for(int i=0; i<A.length; i++)   
            {
                for(int j=0; j<A.length; j++)
                {
                    if(A[i][j] == 0)
                    {
                        component(A, i, j);
                        s += 1;
                    }
                }
            }
        }
        return s;
	}
}
