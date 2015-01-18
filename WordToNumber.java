import java.util.*;
class ConvertWordToNumber
{
    Map<String, Integer> map = new HashMap<String, Integer>();
    public ConvertWordToNumber()
    {
        InitMap();
    }
    public void InitMap()
    {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        map.put("ten", 10);
        map.put("eleven", 11);
        map.put("twelve", 12);
        map.put("thirteen", 13);
        map.put("fourteen", 14);
        map.put("fifteen", 15);
        map.put("sixteen", 16);
        map.put("seventeen", 17);
        map.put("eighteen", 18);
        map.put("nineteen", 19);

        map.put("twenty", 20);
        map.put("thirty", 30);
        map.put("forty", 40);
        map.put("fifty", 50);
        map.put("sixty", 60);
        map.put("seventy", 70);
        map.put("eighty", 80);
        map.put("ninety", 90);

        map.put("hundred", 100);
        map.put("thousand", 1000);
        map.put("million", 1000000);
        map.put("billion", 1000000000);
    }
    public int Convert(String englishWord)
    {
        String[] array = englishWord.split(" ");    
        int sum = 0; int s = 0;
        if(array != null)
        {   
            for(int i=0; i<array.length; i++)
            {
                Integer n = map.get(array[i]);            
                System.out.print("{"+n+"}");
                if(n == 1000 || n == 1000000 || n == 1000000000)
                {
                    s *= n;
                    sum += s;
                    s = 0;
                }
                else if( n == 100)
                {
                    s *= n;
                }
                else
                {
                    s += n;
                }
            }
            sum += s;
        }
        return sum;
    }
}

public class WordToNumber 
{
    public static void main(String[] args)
    {
        System.out.println("Convert English spoken number to numerical number");
        ConvertWordToNumber num = new ConvertWordToNumber();
        String words = "nine million five thousand two hundred twelve";
        int n =  num.Convert(words);
        System.out.println();
        System.out.println(words);
        System.out.println("["+n+"]");

        words = "one";
        n =  num.Convert(words);
        System.out.println("["+n+"]");

        System.out.println();
        words = "one thousand";
        System.out.println(words);
        n =  num.Convert(words);
        System.out.println("["+n+"]");

        System.out.println();
        words = "two hundred twelve ";
        System.out.println(words);
        n =  num.Convert(words);
        System.out.println("["+n+"]");

        System.out.println();
        words = "seven million twelve thousand four hundred twenty nine";
        System.out.println(words);
        n =  num.Convert(words);
        System.out.println("["+n+"]");

        System.out.println();
        words = "zero";
        System.out.println(words);
        n =  num.Convert(words);
        System.out.println("["+n+"]");


    }
}
