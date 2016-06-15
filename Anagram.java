import java.util.*;
import java.math.BigInteger;

final class Better {
    public  static List<Integer> genePrima(int count) {
        List<Integer> list = new LinkedList<Integer>();
        list.add(2);
        Integer prime=3;
        int c=0;
        while(c < count) {
            boolean isPrime = true;
            for(Integer p : list) {
                if(prime % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                list.add(prime);
                c++;
            }
            prime = prime + 1;
        }
        return list;
    }
    public  static Map<Character, BigInteger> generate() {
        Map<Character, BigInteger> map = new HashMap<Character, BigInteger>();
        List<Integer> plist = genePrima(25);

        char ch = 'a';
        for(int i=0; i<26; i++) {
            Character chara = new Character(ch);
            BigInteger big = BigInteger.valueOf((plist.get(i).intValue()));
            map.put(chara, big);
            ch = (char)(ch + 1);
        }
        return map;
    }
    public  static Map<BigInteger, List<String>> findAnagram(List<String> list) {
        Map<Character, BigInteger> map = generate();
        Map<BigInteger, List<String>> wordMap = new HashMap<BigInteger, List<String>>();
        for(String word:list) {
            BigInteger product = BigInteger.valueOf(1);
            for(int i=0; i<word.length(); i++) {
                char ch = word.charAt(i);
                if(map.containsKey(ch))
                    product = product.multiply(map.get(ch));
            }
            if(wordMap.containsKey(product)) {
                List<String> wordList = wordMap.get(product);
                wordList.add(word);
                wordMap.put(product, wordList);
            } else {
                List<String> wordList = new ArrayList<String>();
                wordList.add(word);
                wordMap.put(product, wordList);
            }
            product = BigInteger.valueOf(1);
        }
        return wordMap;
    }
}

final class Basic {
    public static List<Integer> getPrime(int n) {
        int k = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        int num = 3;
        while(k < n) {
            boolean isPrime = true;
            for(Integer p : list) {
                if( num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                list.add(num);
                k++;
            }
            num++;
        }
        return list;
    }

    //[ file=anagrambasic.html title=""
    public static Map<String, Integer> primeMap() {
        List<Integer> list = getPrime(26);
        Map<String, Integer> map = new HashMap<String, Integer>();
        char ch = 'a';
        for(Integer p : list) {
            map.put(ch + "", p);
            ch += 1;
        }
        return map;
    }

    public static Integer getProduct(String str) {
        Map<String, Integer> map = primeMap();
        int p = 1;
        for(int i=0; i<str.length(); i++) {
            p *= map.get((str.charAt(i) + "").toLowerCase());
        }
        return p;
    }

    public static List<String> anagrams(List<String> list, String str) {
        Map<Integer, List<String> > map = new HashMap<Integer, List<String>>();

        for(String s : list) {
            List<String> l = map.get(getProduct(s));
            if(l != null) {
                l.add(s);
                map.put(getProduct(s), l);
            } else {
                List<String> ll = new ArrayList<String>();
                ll.add(s);
                map.put(getProduct(s), ll);
            }
        }
        return map.get(getProduct(str));
    }
    //]
}

public class Anagram {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        test0();
        test1();
        test2();
        test3();
    }

    public static void test0() {
        System.out.println("test1()");
        List<String> list = new ArrayList<String>() {
            {
                add("dog");
                add("god");
                add("nice");
                add("debitcard");
                add("badcredit");
            }
        };
        Map<BigInteger, List<String>> wordMap = Better.findAnagram(list);
        for(BigInteger big: wordMap.keySet()) {
            List<String> wordlist = wordMap.get(big);
            System.out.println(big);
            for(String word: wordlist) {
                System.out.println(word);
            }
            System.out.println();
        }
    }

    public static void test1(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        words.add("God");
        words.add("Barack");
        words.add("Obama");
        List<String> list = Basic.anagrams(words, "dog");
        for(String s : list){
            System.out.println(s);
        }
    }

    public static void test2(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        List<String> list = Basic.anagrams(words, "d");
        if(list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    public static void test3(){
        List<String> words = new ArrayList<String>();
        words.add("");
        List<String> list = Basic.anagrams(words, "d");
        if(list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
