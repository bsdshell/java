import java.util.*;
import java.io.*;
import classfile.*;

class TryM2{
  public static void main(String[] args) {
    List<String> list = Arrays.asList("cat", "cow");
    Map<String, List<String>> map = BuildMap(list);
    test0();
  }
  static void test0(){
      Aron.beg();
      List<String> list = new ArrayList<>();
      Map<String, List<String>> map = new HashMap<>(); 
      map.put("dog", list);

      List<String> ll = map.get("dog");
      ll.add("cat");
      map.put("cat", ll);

      Aron.end();
  }

  public static Map<String, List<String>> BuildMap(List<String> list){
    Map<String, List<String>> map = new HashMap<>();
    if(list != null){
      for(String s : list){
        int len = s.length();
        for(int i=0; i<len; i++){
          String prefix = s.substring(0, i);
          String suffix = s.substring(i, len);
          List<String> ll = map.get(prefix);

          if(ll != null){
            ll.add(suffix);
            map.put(prefix, ll);
          }else{
            List<String> l = new ArrayList<>();
            l.add(suffix);
            map.put(prefix, l);
          }
          
        }
      }
    }
    return map;
  }
}
