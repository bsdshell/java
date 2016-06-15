import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams2{

    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
    static void test0(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        words.add("God");
        words.add("Barack");
        words.add("Obama");
        List<String> list = anagrams(words, "dog");
        for(String s : list){
            System.out.println(s);
        }
    }

    static void test1(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        List<String> list = anagrams(words, "d");
        if(list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    static void test2(){
        List<String> words = new ArrayList<String>();
        words.add("");
        List<String> list = anagrams(words, "d");
        if(list != null) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }


    //[file=anagram2.html title=""
    static List<Integer> getPrime(int n){
        int k = 0;
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        int num = 3;
        while(k < n){
            boolean isPrime = true;
            for(Integer p : list){
                if( num % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                list.add(num);
                k++;
            }
            num++;
        }
        return list;
    }

    static Map<String, Integer> primeMap(){
        List<Integer> list = getPrime(26);
        Map<String, Integer> map = new HashMap<String, Integer>();
        char ch = 'a';
        for(Integer p : list){
            map.put(ch + "", p);
            ch += 1;
        }
        return map;
    }

    static Integer getProduct(String str){
        Map<String, Integer> map = primeMap();
        int p = 1;
        for(int i=0; i<str.length(); i++){
            p *= map.get((str.charAt(i) + "").toLowerCase());
        }
        return p;
    }

    static List<String> anagrams(List<String> list, String str){
        Map<Integer, List<String> > map = new HashMap<Integer, List<String>>();

        for(String s : list){
            List<String> l = map.get(getProduct(s));
            if(l != null){
                l.add(s);
                map.put(getProduct(s), l);
            }else{
                List<String> ll = new ArrayList<String>();
                ll.add(s);
                map.put(getProduct(s), ll);
            }
        }
        return map.get(getProduct(str));
    }
    //]
}
