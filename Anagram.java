import java.util.*;
import java.math.BigInteger;

class Node
{
    String s;
    public Node(String s)
    {this.s = s;}
}
public class Anagram 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        test1();
    }
    
    public static void test1()
    {
        System.out.println("test1()");
        List<String> list = new ArrayList<String>(){{add("dog"); add("god"); add("nice"); add("debitcard"); add("badcredit");}};
        Map<BigInteger, List<String>> wordMap = findAnagram(list);
        for(BigInteger big: wordMap.keySet())
        {
            List<String> wordlist = wordMap.get(big);
            System.out.println(big);
            for(String word: wordlist)
            {
                System.out.println(word);
            }
            System.out.println();
        }
    }
    public static List<Integer> genePrima(int count)
    {
        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        Integer curr=3;
        int c=0;
        while(c < count) 
        {
            boolean isPrime = true;
            for(Integer p : list)
            {
                if(curr % p == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
            {
                list.add(curr);
                c++;
            }
            curr = curr + 1;
        }
        return list;
    }
    public static Map<Character, BigInteger> generate()
    {
        Map<Character, BigInteger> map = new HashMap<Character, BigInteger>();
        List<Integer> plist = genePrima(25);
        
        char ch = 'a';
        for(int i=0; i<26; i++)
        {
            Character chara = new Character(ch);
            BigInteger big = BigInteger.valueOf((plist.get(i).intValue()));
            map.put(chara, big);
            ch = (char)(ch + 1);
        }
        return map;
    }
    public static Map<BigInteger, List<String>> findAnagram(List<String> list)
    {
        Map<Character, BigInteger> map = generate(); 
        Map<BigInteger, List<String>> wordMap = new HashMap<BigInteger, List<String>>();
        for(String word:list)
        {
            BigInteger product = BigInteger.valueOf(1);
            for(int i=0; i<word.length(); i++)
            {
                char ch = word.charAt(i);
                if(map.containsKey(ch))
                     product = product.multiply(map.get(ch));
            }
            if(wordMap.containsKey(product))
            {
                List<String> wordList = wordMap.get(product);
                wordList.add(word);
                wordMap.put(product, wordList);
            }
            else
            {
                List<String> wordList = new ArrayList<String>();
                wordList.add(word);
                wordMap.put(product, wordList);
            }
            product = BigInteger.valueOf(1);
        }            
        return wordMap;
    }
}
