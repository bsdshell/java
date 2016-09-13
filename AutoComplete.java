import java.util.*;
import java.io.*;
import classfile.*;

public class AutoComplete{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        List<String> list = Arrays.asList("cat", "cow"); 
        Map<String, List<String>> map = autocomplete(list);
        Aron.printMap(map);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        List<String> list = Arrays.asList("cat", "cow", "ban", "ball", "banana", "b"); 
        Map<String, List<String>> map = autocomplete(list);
        Aron.printMap(map);

        Aron.end();
    }

    //[ file=autocomplete.html title=""
    // auto complete, autocomplete
    // 1:01 - 1:34
    //-------------------------------------------------------------------------------- 
    // cat
    // cow
    // c -> [at, ow]
    // ca ->[t]
    // co ->[w] 
    public static Map<String, List<String>> autocomplete(List<String> list){
        Map<String, List<String>> map = new HashMap<>();
        for(String s : list){
            int len = s.length();
            for(int i=0; i<len; i++){
                String prefix = s.substring(0, i);
                String suffix = s.substring(i, len);

                if(prefix.length() > 0){
                    List<String> l = map.get(prefix);
                    if( l != null){
                        l.add(suffix);
                        map.put(prefix, l);
                    }else{
                        List<String> ll = new ArrayList<>();
                        ll.add(suffix);
                        map.put(prefix, ll);
                    }
                }
            }
        }
        return map;
    }
    //]


}

