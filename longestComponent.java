public class longestComponent 
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
        int count = longest(A);
        System.out.println("longest="+count);

        int[][] B = {};
        count = longest(B);
        System.out.println("longest="+count);

        int[][] C = {{0}};
        count = longest(C);
        System.out.println("longest="+count);

        int[][] D = {{1}};
        count = longest(D);
        System.out.println("longest="+count);

        int[][] E = {
            {0, 0},
            {0, 0}
        };
        count = longest(E);
        System.out.println("longest="+count);
        
         int[][] F = {
            {1, 1},
            {1, 1}
        };
        count = longest(F);
        System.out.println("longest="+count);

        int[][] H = {   {0, 1, 1, 1},
                        {0, 1, 1, 1},
                        {1, 0, 0, 1},
                        {0, 1, 1, 0}
                    };
        count = longest(H);
        System.out.println("longest="+count);


	}
	static int component(int[][] A, int x, int y)
	{
		if(A != null && A[0] != null && 0 <= x && x < A.length && 0 <= y && y < A[0].length && A[x][y] == 1)
		{
			A[x][y] = 2;
			int up = component(A, x+1, y);	
			int down = component(A, x-1, y);	
			int right = component(A, x, y+1);	
			int left = component(A, x, y-1);	
            return right + left + down + up + 1;
		}
        return 0;
	}
	static int  longest(int[][] A)
	{
        int max = 0;
        if(A != null)
        {
            for(int i=0; i<A.length; i++)   
            {
                for(int j=0; j<A.length; j++)
                {
                    int count = component(A, i, j);
                    if(count > max)
                        max = count;
                }
            }
        }
        return max;
	}

}
