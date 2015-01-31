class Node
{
	public Node left;
	public Node right;
	public int data;
}

public class CoinChange 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        
        //test1();
        //test2();
        //test3();
        //test4();
        //test5();
        //test6();
        test8();
        test8_new();
    }

    
    //Given coins[k] = {2, 3, 4} and change s = 9 
    //Count the number of way for coin change 
    //coins[k] is in the each change
    //coins[k] is not in the each change 
    //count(coins, k, s) = count(coins, k-1, s) + count(coins, k, s-coins[k]) 
    public static int count_debug(int[] coin, int s, int k)
    {
        if( s < 0)
        {
            System.out.print("<"+s+","+k+">\n");
            return 0;
        }
        else if( s == 0 ) 
        {
            System.out.print("<"+s+","+k+">\n");
            return 1;
        }
        else if( s > 0 && k > 0)
        {
            System.out.print("<"+s+","+k+">->");
            int left = count(coin, s, k-1);

            System.out.print("<"+s+","+k+">->");
            int right= count(coin, s-coin[k-1], k);
            return left + right;
        }
        else 
        {
            System.out.println();
            return 0;
        }
    }

    public static int height(Node node)
    {
        if(node != null)
        {
            int l = 0, r = 0;
            if(node.left != null)
                l = height(node.left) + 1;
            if(node.right != null)
                r = height(node.right) + 1;
            return Math.max(l, r);
        }
        return 0;
    }
    public static int miniCointWithPerm(int[] coin, int s)
    {
        if(s == 0)
            return 0;
        else
        {
            int min = 100;
            for(int i=0; i<coin.length; i++)
            {
                if(s - coin[i] >= 0)
                    min = Math.min(min, miniCointWithPerm(coin, s-coin[i]) + 1);
            }
            return min;
        }
    }

    //Given coins[k] = {2, 3, 4} and change s = 9 
    //Count the number of way for coin change 
    //coins[k] is in the each change
    //coins[k] is not in the each change 
    //count(coins, k, s) = count(coins, k-1, s) + count(coins, k, s-coins[k]) 
    public static int count(int[] coin, int s, int k)
    {
        if( s < 0)
            return 0;
        else if( s == 0 ) 
            return 1;
        else if( s > 0 && k > 0)
        {
            int left = count(coin, s, k-1);
            int right= count(coin, s-coin[k-1], k);
            return left + right;
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

        System.out.println();

        Aron.printTable(table);

        for(int ss=1; ss<s+1; ss++)
        {
            for(int kk=0; kk<k; kk++)
            {
                int left  = kk-1 >= 0? table[ss][kk-1]:0;
                 
                if(kk-1 >= 0)
                    System.out.print("["+ss+"]["+(kk-1)+"]=["+left+"]\n");
                else
                    System.out.print("["+ss+"]["+(kk-1)+"]=["+0+"]\n");

                int right = ss-coin[kk] >= 0?  table[ss-coin[kk]][kk]:0;
                int col = ss-coin[kk];

                if(ss-coin[kk] >= 0)
                    System.out.print("["+col+"]["+kk+"]=["+right+"]\n");
                else
                    System.out.print("["+col+"]["+kk+"]=["+0+"]\n");

                System.out.println();

                table[ss][kk] = left + right; 
            }
        }

        printTable(table);
        
        return table[s][k-1];
    }

    //Print out all the coins which adds up to s
    public static void permuCount(int[] coin, int[] arr, int d, int s, int sum)
    {
        for(int i=0; i<coin.length; i++)
        {
            if(sum + coin[i] == s)
            {
                sum += coin[i];
                arr[d] = coin[i];
                for(int j=0; j<=d; j++)
                {
                    System.out.print("["+arr[j]+"]");
                }
                System.out.println();
            }
            else if(sum + coin[i] < s)
            {
                arr[d] = coin[i];
                sum += coin[i];
                permuCount(coin, arr, d+1, s, sum);
                sum -= coin[i];
            }
        }
    }
    
    public static int minCount_debug(int[] coin, int s, int k)
    {
        if(s < 0)
            return 100;
        if(s == 0) 
        {
            System.out.print("["+s+"]\n");
            return 0;
        }
        else if( s > 0 && k <= 0) 
            return 100;
        else
        {
            int min=100;
            for(int i=0; i<k; i++)
            {
                if(s - coin[i] > 0)
                    System.out.print("["+s+"]->");
                min = Math.min(min, minCount_debug(coin, s-coin[i], k)+1);
            }
            return min;
        }

    }

    //Given coin{2, 3, 4} and s = 6
    //Find the minimum number of coins sums up to s 
    public static int minCount(int[] coin, int s, int k)
    {
        if(s < 0)
            return 100;
        if(s == 0) 
        {
            return 0;
        }
        else if( s > 0 && k <= 0) 
            return 100;
        else
        {
            int min = 100;
            for(int i=0; i<k; i++)
            {
                min = Math.min(min, minCount(coin, s-coin[i], k)+1);
            }
            return min;
        }
    }

    public static void printTable(int[][] arr)
    {
        if(arr != null)
        {
            for(int c=0; c<arr.length; c++)
            {
                for(int r=0; r<arr[0].length; r++)
                {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
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
        System.out.println("test4()");
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
        System.out.println("test5()");
        int[] recoin = {2, 3, 4};
        int[] dycoin = {2, 3, 4};
        int k = recoin.length;
        int s = 10;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println();
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");
    }

    public static void test6()
    {
        System.out.println("test6()");
        int[] recoin = {2, 3, 4, 5, 6};
        int[] arr = new int[recoin.length+10];
        int d = 0;
        int s = 15;
        int sum = 0;
        permuCount(recoin, arr, d, s, sum);
        System.out.println();
    }

    public static void test7()
    {
        System.out.println("test6()");
        int[] recoin = {2, 3, 4, 5, 6};
        int k = recoin.length;
        int s = 15;
        String count = " ";
        int min = minCount(recoin, s, k);
        System.out.println("min="+min);
        System.out.println();
    }

    public static void test8()
    {
        System.out.println("test8()");
        int[] recoin = {2, 3, 4, 5, 6};
        int[] dycoin= {2, 3, 4, 5, 6};
        int k = recoin.length;
        int s = 15;
        int c = count(recoin, s, k);
        int dc = countdy(dycoin, s, k);
        System.out.println();
        System.out.println("recursion count=["+c+"]");
        System.out.println("dynamic   count=["+dc+"]");
    }

    public static void test8_new()
    {
        System.out.println("test8_new()");
        int[] recoin = {2, 3, 4, 5, 6};
        int k = recoin.length;
        int s = 15;
        String count = " ";
        int min = miniCointWithPerm(recoin, s);
        System.out.println("min="+min);
        System.out.println();
    }
}
