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
        System.out.println("count="+count);

        int[][] C = {{0}};
        count = count(C);
        System.out.println("count="+count);

        int[][] D = {{1}};
        count = count(D);
        System.out.println("count="+count);

        int[][] E = {
            {0, 0},
            {0, 0}
        };
        count = count(E);
        System.out.println("count="+count);
        
         int[][] F = {
            {1, 1},
            {1, 1}
        };
        count = count(F);
        System.out.println("count="+count);

        int[][] H = {   {0, 0, 0, 1},
                        {0, 1, 1, 1},
                        {1, 0, 0, 1},
                        {0, 1, 1, 0}
                    };
        count = count(H);
        System.out.println("count="+count);


	}
	static void component(int[][] A, int x, int y)
	{
		if(A != null && A[0] != null && 0 <= x && x < A.length && 0 <= y && y < A[0].length && A[x][y] == 1)
		{
			A[x][y] = 2;
			component(A, x+1, y);	
			component(A, x-1, y);	
			component(A, x, y+1);	
			component(A, x, y-1);	
		}
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
                    if(A[i][j] == 1)
                        s += 1;
                        component(A, i, j);
                }
            }
        }
        return s;
	}

}
