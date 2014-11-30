import java.util.*;
public class PermRepeated 
{
    public static void main(String[] args)
    {
        System.out.println("Print all permuation character with repeating character!");
        String s = "abc";
        char[] array = new char[s.length()];
        int depth = 0;
        Set<Character> map = new LinkedHashSet<Character>();
        //permRepeated(s, array, depth);
        //perm(s, array, depth, map);

        int count=26+26*26 + 26*26*26+1;
        //ExcelSheetRowNumber(count);
        ExcelSheetRowNumber2(s, count);

        System.out.println();
        count=26+26*26 + 26*26*26;
        //ExcelSheetRowNumber(count);
        ExcelSheetRowNumber2(s, count);

        System.out.println();
        count=25;
        ExcelSheetRowNumber2(s, count);
        System.out.println();

        count=26;
        ExcelSheetRowNumber2(s, count);
        System.out.println();
    }


    //Second algorithm to print Excel Sheet Row 
    //
    // Assume the length(s) = k
    // s = a0 + (a1*26^1 + a2*26^2 + ... + a(k-1)*26^k-1) + (26^1 + 26^2 + 2^3 + ... + 26^k-1)
    // s = a0 + (a1+1)*26^1 + (a2+1)^2 + ... + (a(k-1) + 1)*26^k-1
    // a0 = s/26
    // a1 = s-1/26
    // s2 = s-1/26^2
    // s3 = s-1/26^3
    // s(k-1) = s-1/26^k-1
    public static void ExcelSheetRowNumber2(String s, int count)
    {
        int k = (int)(Math.log(25*count+26)/Math.log(26));
        System.out.print("["+count+"]["+k+"]");

        //S = 26^k-26/25
        //25S = 26^k - 26

        if(Math.pow(26, k) - 26 < 25*count)
        {
            k=k+1;
        }

        int index = 0;
        char[] array = new char[k];

        array[index] = (char)('a' + count % 26);
        count = count/26;
        index++;
        while(count-1 >= 26)
        {
            array[index] = (char)('a' + (count-1)%26);
            count = count/26;
            index++;
        }
        if(count - 1 >= 0)
        {
            array[index] = (char)('a'+count-1);
            index++;
        }
        for(int i=0; i<index; i++)
        {
            System.out.print("["+array[i]+"]");
        }
    }

    //Excel sheet row number
    public static void ExcelSheetRowNumber(int count)
    {
        int k = (int)Math.floor(Math.log(25*count+26)/Math.log(26));
        System.out.print("myk=["+k+"]");

        //S = 26^k-26/25
        //25S = 26^k - 26

        if(Math.pow(26, k) - 26 == 25*count)
        {
            
        }
        else if(Math.pow(26, k) - 26 > 25*count)
        {
            k=k-1;    
        }
        else if(Math.pow(26, k) - 26 < 25*count)
        {
            k=k+1;
        }

        System.out.print("2myk=["+k+"]");
        int len = (int)Math.floor(Math.log(count)/Math.log(26))+1;
        char[] array = new char[k];
        int depth = 0;
        for(int i=1; i<=26; i++)
            permRepeatedChooseK(array, depth, i, count);
    }

    //Given string character array and integer k,
    //print all permutation with repeatation string length k 
    static int numCount = 0;
    public static void permRepeatedChooseK(char[] array, int depth, int k, int count)
    {
        if(depth == k)
        {
            if(count == numCount)
            {
                for(int i=0; i<depth; i++)
                {
                    System.out.print("["+array[i]+"]");
                }
                System.out.println();
            }
            numCount++;
        }
        else 
        {
            if(array != null)
            {
                for(int i=0; i<26; i++)
                {
                    array[depth] = (char)('a'+i);
                    permRepeatedChooseK(array, depth+1, k, count);
                }
            }
        }
    }

    public static void permRepeated(String s, char[] array, int depth)
    {
        if(s != null)
        {
            if(s.length() == depth)
            {
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
                    permRepeated(s, array, depth+1);
                }
            }
        }
    }
    public static void perm(String s, char[] array, int depth, Set<Character> map)
    {
        if(s != null)
        {
            if(s.length() == depth)
            {
                for(Character ch: map)
                    System.out.print(ch);
                System.out.println();
            }
            else
            {
                for(int i=0; i<s.length(); i++)
                {
                    Character ch = new Character(s.charAt(i));
                    if(!map.contains(ch))
                    {        
                        map.add(ch);
                        perm(s, array, depth+1, map);
                        map.remove(ch);
                    }
                } 
            }
        }
    }
}
