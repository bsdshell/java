import java.util.*;

//Convert numerical number to English spoken words
class ConvertNumberToEnglish
{
    Map<Integer, String> map = new HashMap<Integer, String>();
    public ConvertNumberToEnglish()
    { }
    public void InitMap()
    {
        map.put(0, "[zero]");
        map.put(1, "[one]");
        map.put(2, "[two]");
        map.put(3, "[three]");
        map.put(4, "[four]");
        map.put(5, "[five]");
        map.put(6, "[six]");
        map.put(7, "[seven]");
        map.put(8, "[eight]");
        map.put(9, "[nine]");

        map.put(10, "[ten]");
        map.put(11, "[eleven]");
        map.put(12, "[twelve]");
        map.put(13, "[thirteen]");
        map.put(15, "[fifteen]");
        map.put(16, "[sixteen]");
        map.put(17, "[seventeen]");
        map.put(18, "[eighteen]");
        map.put(19, "[nineteen]");

        map.put(20, "[twenty]");
        map.put(30, "[thirty]");
        map.put(40, "[forty]");
        map.put(50, "[fifty]");
        map.put(60, "[sixty]");
        map.put(70, "[seventy]");
        map.put(80, "[eighty]");
        map.put(90, "[ninety]");

        map.put(100, "[hundred]");
        map.put(1000, "[thousand]");
        map.put(1000000, "[million]");
        map.put(1000000000, "[billion]");
    }
    public void convert(int num)
    {
        System.out.print("{"+num+"}=");
        if(num == 0)
            System.out.print(map.get(num));
        else if(num > 0)
        {
            int[][] array = table(num);
            int len = array.length;
            String s = "";
            for(int c=0; c < array.length; c++)
            {
                s = processRow(array[c], c) + s;
            }
            System.out.print(s);
        }
    }
    public int[][] table(int num)
    {
        int numRow = 0;
        if(num > 0)
            numRow = (int)(Math.log(num)/Math.log(1000)) + 1;

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
    public String processRow(int[] row, int pow)
    {
        String first = "";
        String second = "";
        String third = "";
        String s ="";
        if(row[0] != 0 || row[1] != 0 || row[2] != 0)
        {
            if(row[0] > 0)
            {
                first = map.get(row[0]);
            }
            if(row[1] > 0)
            {
                second = map.get(row[1]*10);
            }
            if(row[2] > 0)
            {
                int r = row[2] % 100;
                third = map.get(r) + map.get(100);
            }
            if(pow > 0)
                s = third + second + first + map.get((int)Math.pow(1000, pow));
            else 
                s = third + second + first;
        }
        return s;
    }
}

public class NumberToWord
{
    public static void main(String[] args)
    {
        System.out.println("Convert Number to English Words");
        ConvertNumberToEnglish con = new ConvertNumberToEnglish();
        con.InitMap();
        con.convert(0);
        System.out.println();
        con.convert(123);
        System.out.println();
        con.convert(20004);
        System.out.println();
        con.convert(200005);
        System.out.println();
        con.convert(123346789);
        System.out.println();
        con.convert(987654321);
        System.out.println();
        con.convert(90000001);
        System.out.println();
        con.convert(100000000);
        System.out.println();
    }
}
