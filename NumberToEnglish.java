import java.util.*;

class ConvertNumberToEnglish
{
    Map<Integer, String> map = new HashMap<Integer, String>();
    public ConvertNumberToEnglish()
    { }
    public void InitMap()
    {
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");

        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");

        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "fourty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");

        map.put(100, "thundred");
        map.put(1000, "thousand");
        map.put(1000000, "million");
        map.put(1000000000, "billion");
    }
    public int[][] table(int num)
    {
        int numRow = (int)(Math.log(num)/Math.log(1000)) + 1;
        int[][] array = new int[numRow][3];
        int col = 0;
        while(num > 0)
        {
           int r = num % 1000; 
           num /= 1000;
           int row = 0;
           while(r > 0)
           {
                int rr = r % 10;
                r /= 10;
                array[col][row] = rr;
                row++;
           }
           col++;
        }
        return array;
    }
    public void processRow(int[] row, int pow)
    {
        if(row != null)
        {
            int sum = row[1]*10 + row[0];
            if(row[2] > 0)
            {
                System.out.print(map.get(row[2]) + " " + map.get(100));
            }
            if(sum > 0)
            {
                String sumStr = map.get(sum);
                if(sumStr != null)
                    System.out.print("["+sumStr+"]");
                else
                {
                    String first = "";
                    String second = "";
                    if(row[0] > 0)
                        first = map.get(row[0]);
                    if(row[1] > 0)
                        second = map.get(row[1]*10);
                    System.out.print("["+second+"] " + first);
                }
            }
            if(pow > 0)
                System.out.print(map.get((int)Math.pow(1000, pow)));
        }
    }
}

public class NumberToEnglish 
{
    public static void main(String[] args)
    {
        System.out.println("Convert Number to English spoken words");
        ConvertNumberToEnglish con = new ConvertNumberToEnglish();
        con.InitMap();
        //int[][] array = con.table(1234567);
        int[][] array = con.table(12123);
        for(int c=0; c < array.length; c++)
        {
            con.processRow(array[c], c);
            System.out.println();
        }
        System.out.println();
    }
}
