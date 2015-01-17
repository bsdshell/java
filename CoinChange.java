public class CoinChange 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    
    //Given coins[k] = {2, 3, 4} and change s = 9 
    //Count the number of way for coin change 
    //coins[k] is in the each change
    //coins[k] is not in the each change 
    //count(coins, k, s) = count(coins, k-1, s) + count(coins, k, s-coins[k]) 
    public static int count(int[] coin, int s, int k)
    {
        if( s == 0 && k >= 0)
        {
            System.out.println("{"+s+","+k+"}");
            return 1;
        }
        else if( s > 0 && k == 0)
        {
            System.out.println("{"+s+","+k+"}");
            return 0;
        }
        else if( s > 0 && k > 0)
        {
            System.out.println("{"+s+","+k+"}");
            return (count(coin, s, k-1) + count(coin, s-coin[k-1], k));
        }
        else 
            return 0;
    }

    //Coin change algorithm using dynamic programming
    //Use table from bottom up to model the recursion tree
    public static int countdy(int[] coin, int s, int k)
    {
        int[][] table = new int[s+1][k];        
        for(int i=0; i<k; i++)
            table[0][i] = 1;

        for(int i=1; i<s+1; i++)
            for(int j=0; j<k; j++)
                table[i][j] = 0;

        for(int ss=1; ss<s+1; ss++)
        {
            for(int kk=0; kk<k; kk++)
            {
                int left  = kk-1 >= 0? table[ss][kk-1]:0;
                int right = ss-coin[kk] >= 0?  table[ss-coin[kk]][kk]:0;
                table[ss][kk] = left + right; 
            }
        }

        for(int c=0; c<=s; c++)
        {
            for(int r=0; r<k; r++)
            {
                System.out.print("["+table[c][r]+"]");
            }
            System.out.println();
        }
        return table[s][k-1];
    }

    public static void test1()
    {
        System.out.println("test1()");
        int[] recoin = {1};
        int[] dycoin = {1};
        int k = recoin.length;
        int s = 0;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");

    }

    public static void test2()
    {
        System.out.println("test1()");
        int[] recoin = {1};
        int[] dycoin = {1};
        int k = recoin.length;
        int s = 1;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");

    }

    public static void test3()
    {
        System.out.println("test1()");
        int[] recoin = {1, 2};
        int[] dycoin = {1, 2};
        int k = recoin.length;
        int s = 3;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");

    }

    public static void test4()
    {
        System.out.println("test1()");
        int[] recoin = {1, 2, 3};
        int[] dycoin = {1, 2, 3};
        int k = recoin.length;
        int s = 4;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");

    }

    public static void test5()
    {
        System.out.println("test2()");
        int[] recoin = {1, 2, 3, 7, 9, 8, 6};
        int[] dycoin = {1, 2, 3, 7, 9, 8, 6};
        int k = recoin.length;
        int s = 20;
        int c = count(recoin, s, k);
        int dc = count(dycoin, s, k);
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");
    }
}
