import java.util.*;
public class ExcelRowNumber 
{
    public static void main(String[] args)
    {
        System.out.println("Print all permuation character with repeating character!");
        String s = "ABC";
        char[] array = new char[s.length()];
        int depth = 0;
        Set<Character> map = new LinkedHashSet<Character>();
        //permRepeated(s, array, depth);
        //perm(s, array, depth, map);

        int[] arr = new int[1];
        int num = 20;
        arr[0] = 1;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i, arr, num);

        ExcelSheetRowNumberDirect(1);
        System.out.println("================");
        test2();
    }
    public static void test1()
    {
    }
    public static void test2()
    {
        ExcelSheetRowNumberDirect(1000000);
    }


    //Calculate the excel sheet row number directly
    //   s = 26^1 + 26^2 + 26^3 + ... + 26^k
    // 26s = 26^2 + 26^3 + 26^4 + ... + 26^(k+1)  
    // 25s = 26^(k+1) - 26 
    // 25s + 26 = 26^(k+1)
    // log(25s+26)/log(26) = k+1
    // log(25s+26)/log(26)-1 = k
    public static void ExcelSheetRowNumberDirect(int num)
    {
        int k = (int)(Math.log(25*num + 26)/Math.log(26)) - 1;
        int diff = num - (int)(Math.pow(26, k+1) - 26)/25;
        int[] arr = new int[26];

        System.out.print("k="+k);
        System.out.print("diff="+diff);

        for(int i=0; i<26; i++)
            arr[i] = 'a'+i;

        int n = diff;
        if(diff == 0)
            n = num;
        while(n > 0)
        {
            int r = (n-1) % 26;
            System.out.print("["+(char)arr[r]+"]");
            n /= 26;
        }
        System.out.println();
    }
    //print excel sheet row number algorithm based on permutation
    public static void ExcelSheetRowNumber(String s, int num)
    {
        int[] arr = new int[1];
        arr[0] = 1;
        char[] array = new char[s.length()];
        int depth = 0;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i, arr, num);
    }


    //Given string character array and integer k,
    //print all permutation with repeatation string length k 
    public static void permRepeatedChooseK(String s, char[] array, int depth, int k, int[] arr, int num)
    {
        if(depth == k)
        {
            if(arr[0] == num)
                System.out.print("<"+num+">");
            System.out.print("{"+arr[0]+"}");
            arr[0]++;
            for(int i=0; i<depth; i++)
            {
                System.out.print("["+array[i]+"]");
            }
            System.out.println();
        }
        else 
        {
            for(int i=0; i<s.length(); i++)
            {
                array[depth] = s.charAt(i);
                permRepeatedChooseK(s, array, depth+1, k, arr, num);
            }
        }
    }
}
