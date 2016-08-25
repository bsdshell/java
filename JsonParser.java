import classfile.*;
import java.util.*;

class CharacterIterator implements Iterator<Character>{
    String str;
    int index = 0;
    public CharacterIterator(String str){
        this.str = str;
    }
    public boolean hasNext(){
        return index < str.length();
    }
    public Character next(){
        Character ch = str.charAt(index);
        index++;
        return ch;
    }
}

class MyJSon{
    public Map<String, Object> map = new HashMap<String, Object>();
}

// Json parser
class JObj{
    public String value;
    Map<String, JObj> map = new HashMap<String, JObj>();
    Map<String, ArrayList<JObj>> mapList = new HashMap<String, ArrayList<JObj>>();
    public JObj(String value){
        this.value = value;
    }
}

interface Json{
}

class Value implements Json{
    String str;
    public Value(String str){
        this.str = str;
    }
}
class JObject implements Json{
    JObject obj;
}

class JList implements Json{
    List<Json> list = new ArrayList<Json>();
}


public class JsonParser{
    public static void main(String[] args) {
        //test0();
        // this will affect the [static index]
        //test1(); 

    }
    public static void test00() {
        Aron.beg();
        MyJSon son = new MyJSon();
        List<MyJSon> list = new ArrayList<MyJSon>(); 
        son.map.put("a", "b");
        son.map.put("k", new MyJSon());
        son.map.put("k", list);

        Aron.end();
    }
    public static void test0() {
        Aron.beg();
        String str = "\"do\"";
        char[] arr = str.toCharArray();
        String name = parseName(arr);
        Print.pb(name);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        String str = "{\"a\":\"b\"}";
        CharacterIterator ite = str.iterator(); 

        JObj obj = jsonParser(ite);
        print(obj);
        Aron.end();
    }
    public static void print(JObj obj){
        if(obj != null){
            Print.pb(obj.value);
            for(Map.Entry<String, JObj> entry : obj.map.entrySet()){
                Print.pb(entry.getKey());
                print(entry.getValue());
            }
        }
    }

    // {"dog":"cat"}
    // {"dog":{"cat":"rat"}}
    // {"dog":{"cat":"rat","pig":"cow"}}
    // {"dog":[{"cat":"rat"},{"pig":"cow"}]}
    // k->o1
    // k->{01}
    // k->[{o1, o2}]
    // k->[{01}]
    /**
     * {"dog":"cat"}
     * {"dog":"cat", "cow":"rat"}
     * {"dog":{"cat":"rat"}}
     * {"dog":{"cat":"rat", "cow":"pig"}}
     * {"dog":[{"cat":"rat"}, {"cow":"pig"}]
     * dog->{<cat, rat>, <cow, pig>}
     * dog->[<cat, rat>, <cow, pig>]
     */
    static int index = 0;
    public static JObj jsonParser(Iterator<Character> ite){

        return null;
    }

    static String parseValue(char[] arr){
        return parseName(arr);
    }
    // "ab"
    // ""
    static String parseName(char[] arr){
        String str = "";
        int c = 0;
        while(index < arr.length){
            if(arr[index] != '"')
                str += arr[index];
            else{
                c++;
                if(c == 2)
                 break;
            }

            index++;
        }
        return c == 2? str : null;
    }
}
