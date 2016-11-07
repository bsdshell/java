import java.util.*;

import classfile.*;

public class CoinChange {
    public static void main(String[] args) {
        /*
        test1();
        test2();
        test3();
        test4();
        test5();
        test8();
        test8_new();
        test10();
        test11();
        test12();
        */
        //test13();

        /*
        test20();
        test7();
        test9();
        test20();
        test21();
        test22();
        */

        //test2();

        test14();
        test15();
        //test23();
    }


    //[file=dynamic.html   title=""
    public static int[][] miniCoinDynamic(int[] coin, int sum) {
        int len = coin.length;
        int[][] array = init(len, sum);

        for(int i=0; i<len; i++) {
            for(int s = 0; s <=sum; s++) {
                if( s - coin[i] >= 0) {
                    int min = Integer.MAX_VALUE;
                    for(int k=0; k <=i; k++)
                        min = Math.min(min, array[k][s-coin[i]]);
                    array[i][s] = min == Integer.MAX_VALUE ? min: min + 1;
                }
            }
        }

        // find the mini value on the most right column
        int min = Integer.MAX_VALUE;
        for(int k=0; k <len; k++)
            min = Math.min(min, array[k][sum]);
        array[len-1][sum] = min;

        return array;
    }

    public static int[][] init(int height, int width) {
        int[][] array = new int[height][width+1];
        for(int i=0; i<height; i++) {
            for(int j=0; j<width+1; j++) {
                if(j == 0)
                    array[i][j] = 0;
                else
                    array[i][j] = Integer.MAX_VALUE;
            }
        }
        return array;
    }
    //]

    //Given coins[k] = {2, 3, 4} and change s = 9
    //Count the number of way for coin change
    //coins[k] is in the each change
    //coins[k] is not in the each change
    //count(coins, k, s) = count(coins, k-1, s) + count(coins, k, s-coins[k])
    public static int count_debug(int[] coin, int s, int k) {
        if( s < 0) {
            System.out.print("<"+s+","+k+">\n");
            return 0;
        } else if( s == 0 ) {
            System.out.print("<"+s+","+k+">\n");
            return 1;
        } else if( s > 0 && k > 0) {
            System.out.print("<"+s+","+k+">->");
            int left = count(coin, s, k-1);

            System.out.print("<"+s+","+k+">->");
            int right= count(coin, s-coin[k-1], k);
            return left + right;
        } else {
            System.out.println();
            return 0;
        }
    }

    public static int miniCointWithPerm(int[] coin, int s) {
        if(s == 0)
            return 0;
        else {
            int min = 100;
            for(int i=0; i<coin.length; i++) {
                if(s - coin[i] >= 0)
                    min = Math.min(min, miniCointWithPerm(coin, s-coin[i]) + 1);
            }
            return min;
        }
    }

    // Given coins[k] = {2, 3, 4} and change s = 9
    // Count the number of way for coin change
    // coins[k] is in the each change
    // coins[k] is not in the each change
    // count(coins, k, s) = count(coins, k-1, s) + count(coins, k, s-coins[k])
    public static int count(int[] coin, int s, int k) {
        if( s < 0)
            return 0;
        else if( s == 0 )
            return 1;
        else if( s > 0 && k > 0) {
            int right= count(coin, s-coin[k-1], k);
            int left = count(coin, s, k-1);
            return left + right;
        } else
            return 0;
    }

    //Coin change algorithm using dynamic programming
    //Use table from bottom up to model the recursion tree
    public static int countdy(int[] coin, int s, int k) {
        int[][] table = new int[s+1][k];
        for(int i=0; i<k; i++)
            table[0][i] = 1;

        System.out.println();

        Aron.printTable(table);

        for(int ss=1; ss<s+1; ss++) {
            for(int kk=0; kk<k; kk++) {
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
    public static void permuCount(int[] coin, int[] arr, int d, int s, int sum) {
        for(int i=0; i<coin.length; i++) {
            if(sum + coin[i] == s) {
                sum += coin[i];
                arr[d] = coin[i];
                for(int j=0; j<=d; j++) {
                    System.out.print("["+arr[j]+"]");
                }
                System.out.println();
            } else if(sum + coin[i] < s) {
                arr[d] = coin[i];
                sum += coin[i];
                permuCount(coin, arr, d+1, s, sum);
                sum -= coin[i];
            }
        }
    }

    public static int minCount_debug(int[] coin, int s, int k) {
        if(s < 0)
            return 100;
        if(s == 0) {
            System.out.print("["+s+"]\n");
            return 0;
        } else if( s > 0 && k <= 0)
            return 100;
        else {
            int min=100;
            for(int i=0; i<k; i++) {
                if(s - coin[i] > 0)
                    System.out.print("["+s+"]->");
                min = Math.min(min, minCount_debug(coin, s-coin[i], k)+1);
            }
            return min;
        }
    }

    //[file=CoinChangeRecursive.html   title=""
    //CoinChange.java
    //Given coin{2, 3, 4} and s = 6
    //Find the minimum number of coins sums up to s
    public static int minCount(int[] coin, int s, int k) {
        int min = Integer.MAX_VALUE;
        if(s == 0)
            min = 0;
        else if(s > 0) {
            // min(s) = min(s-coin[k]) + 1
            for(int i=0; i<k; i++) {
                int childMin = minCount(coin, s-coin[i], k);
                if(childMin != Integer.MAX_VALUE)
                    min = Math.min(min, childMin + 1);
            }
        }
        return min;
    }
    //]


    public static int minCountAllPath(int[] coin, int s, int k, List<Integer> list) {
        int min = Integer.MAX_VALUE;
        if(s == 0){
            Aron.printList(list);
            min = 0;
        }
        else if(s > 0) {
            for(int i=0; i<k; i++) {
                list.add(coin[i]);
                int childMin = minCountAllPath(coin, s-coin[i], k, list);
                if(childMin != Integer.MAX_VALUE)
                    min = Math.min(min, childMin + 1);

                if(list.size() > 0)
                    list.remove(list.size()-1);
            }

        }
        return min;
    }
    //[file=CoinChangeWithHashMap.html   title=""
    // CoinChange.java
    // Given coin{2, 3, 4} and s = 6
    // Find the minimum number of coins sums up to s
    public static int minCountWithDynamic(int[] coin, int s, int k, Map<Integer, Integer> map, List<Integer> list) {
        int min = Integer.MAX_VALUE;
        if(s == 0){
            min = 0;
        }
        else if(s > 0) {
            for(int i=0; i<k; i++) {
                Integer value = map.get(s-coin[i]);
                if(value == null) {
                    value = minCountWithDynamic(coin, s-coin[i], k, map, list);
                    if(value < Integer.MAX_VALUE)
                        value += 1; 
                } 

                min = Math.min(min, value);

                if(s-coin[i] < 0)
                    map.put(s-coin[i], Integer.MAX_VALUE);
                else
                    map.put(s-coin[i], min);

            }
        }
        return min;
    }
    //]

    public static int minCount_Graph(int[] coin, int s, int k, int[] arr) {
        int min = Integer.MAX_VALUE;
        if(s == 0) {
            min = 0;
        } else if(s > 0) {
            // min(s) = min(s-coin[k]) + 1
            int parent = arr[0];
            for(int i=0; i<k; i++) {
                String parentLabel = parent + "[label="+ s +"];";
                System.out.println(parentLabel);

                arr[0] += 1 + i;
                int child = arr[0] ;


                String childLabel = "";
                if( s - coin[i] == 0)
                    childLabel = child + "[label="+ (s-coin[i]) +", style=filled, fillcolor=green]";
                else if(s - coin[i] < 0)
                    childLabel = child + "[label="+ (s-coin[i]) +", style=filled, fillcolor=red]";
                else
                    childLabel = child + "[label="+ (s-coin[i]) +"];";

                System.out.println(childLabel);

                System.out.println(parent + "->" + child + "[label="+ coin[i] +"];");

                int childMin = minCount_Graph(coin, s-coin[i], k, arr);
                if(childMin != Integer.MAX_VALUE) {
                    min = Math.min(min, childMin + 1);
                }
            }
        }
        return min;
    }


    public static void printTable(int[][] arr) {
        if(arr != null) {
            for(int c=0; c<arr.length; c++) {
                for(int r=0; r<arr[0].length; r++) {
                    System.out.print("["+arr[c][r]+"]");
                }
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void test1() {
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

    public static void test2() {
        System.out.println("test1()");
        int[] recoin = {1, 2};
        int[] dycoin = {1};
        int k = recoin.length;
        int s = 3;
        int c = count(recoin, s, k);
        System.out.println("recursion count=["+c+"]");
    }

    public static void test3() {
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

    public static void test4() {
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

    public static void test5() {
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




    public static void test8() {
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

    public static void test8_new() {
        System.out.println("test8_new()");
        int[] recoin = {2, 3, 4, 5, 6};
        int k = recoin.length;
        int s = 15;
        String count = " ";
        int min = miniCointWithPerm(recoin, s);
        System.out.println("min="+min);
        System.out.println();
    }

    public static void test9() {
        System.out.println("test9()");
        final int Num = 10;
        int[] coin = new int[Num];

        for(int i=0; i<Num; i++)
            coin[i] = 3+i;

        int s = 150;
        int[][] table = miniCoinDynamic(coin, s);
        int row = table.length;
        int col = table[0].length;
        System.out.println("min=" + table[row-1][col-1]);
    }

    public static void test10() {
        System.out.println("test10()");
        int[] coin = {1, 2};
        int s = 3;
        int[][] table = miniCoinDynamic(coin, s);
        System.out.println();
        Aron.printTable(table);
    }
    public static void test11() {
        System.out.println("test11()");
        int[] coin = {1, 2, 4};
        int s = 5;
        int[][] table = miniCoinDynamic(coin, s);
        System.out.println();
        Aron.printTable(table);
    }
    public static void test12() {
        System.out.println("test12()");
        int[] coin = {1, 2, 3, 16};
        int s = 17;
        int[][] table = miniCoinDynamic(coin, s);
        System.out.println();
        Aron.printTable(table);
    }

    public static void test6() {
        System.out.println("test6()");
        int[] recoin = {2, 3, 4, 5, 6};
        int[] arr = new int[recoin.length+10];
        int d = 0;
        int s = 15;
        int sum = 0;
        permuCount(recoin, arr, d, s, sum);
        System.out.println();
    }

    public static void test13() {
        System.out.println("test13()");
        final int Num = 4;
        int[] coin = new int[Num];
        for(int i=1; i<Num; i++)
            coin[i] = 2*i;

        int s = 45;
        int[][] table = miniCoinDynamic(coin, s);
        System.out.println();
        // Aron.printTable(table);
    }

    public static void test14() {
        Aron.beg();
        final int Num = 14;
        int[] coin = new int[Num];

        for(int i=0; i<Num; i++)
            coin[i] = 2+i;

        int s = 45;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>(); 
        int min = minCountWithDynamic(coin, s, Num, map, list);
        System.out.println("min[" + min + "]"); 

        Aron.end();
    }
    public static void test15() {
        Aron.beg();
        final int Num = 4;
        int[] coin = new int[Num];
        for(int i=0; i<Num; i++)
            coin[i] = 2+i;

        int s = 20;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> list = new ArrayList<Integer>(); 
        int min = minCountAllPath(coin, s, Num, list);
        System.out.println("min[" + min + "]"); 

        Aron.end();
    }


    public static void test7() {
        System.out.println("test7()");
        int[] coin = {2, 3, 15, 18};
        int k = coin.length;
        int s = 19;
        int min = minCount(coin, s, k);
        System.out.println("min="+min);
        System.out.println();
    }


    public static void test20() {
        System.out.println("test20()");
        int[] coin = {2, 3, 15, 18};
        int k = coin.length;
        int s = 20;
        int min = minCount(coin, s, k);
        System.out.println("min="+min);
        System.out.println();
    }

    public static void test21() {
        System.out.println("test21()");
        int[] coin = {2};
        int k = coin.length;
        int s = 2;
        int min = minCount(coin, s, k);
        System.out.println("min="+min);
        System.out.println();
    }

    public static void test22() {
        System.out.println("test22()");
        int[] coin = {2, 3, 4, 5};
        int k = coin.length;
        int s = 10;
        int min = minCount(coin, s, k);
        System.out.println("min="+min);
        System.out.println();
    }
    public static void test23() {
        int[] coin = {1, 2};
        int k = coin.length;
        int s = 3;
        int[] arr = new int[1];
        arr[0] = 100;
        System.out.println("digraph G {\n");
        int min = minCount_Graph(coin, s, k, arr);
        System.out.println("}\n");

        System.out.println();
    }
}
