import classfile.*;
import java.util.*;

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

        //test2();
        test3();
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
        char[] arr = str.toCharArray();
        JObj obj = jsonParser(arr);
        print(obj);
        Aron.end();
    }
    public static void test2() {
        Aron.beg();
        String str = "{\"a\":{\"b\":\"c\"}}";
        char[] arr = str.toCharArray();

        JObj obj = jsonParser(arr);
        print(obj);
        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        //String str = "{\"a\":{\"b\":\"c\",\"b1\":\"c1\"}}";
        String str = "{\"a\":\"b\",\"a1\":\"b1\"}";
        char[] arr = str.toCharArray();

        JObj obj = jsonParser(arr);
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
     * {"dog":["cat":"rat", "cow":"pig"}]
     * dog->{<cat, rat>, <cow, pig>}
     * dog->[<cat, rat>, <cow, pig>]
     */
    static int index = 0;
    public static JObj jsonParser(char[] arr){
        if(arr[index] == '{' || arr[index] == ','){
            index++;
            JObj json = new JObj("");
            String name = parseName(arr);
            if(name == null)
                return null;

            index++;
            if(arr[index] != ':') 
                return null;
            
            index++;
            if(arr[index] == '"')
                // "dog":"cat"
                return json.map.put(name, new JObj(parseName(arr)));
            else{
                // "dog":{}
                return json.map.put(name, jsonParser(arr)); 
            }

        }else if(arr[index] == '}'){
            return jsonParser(arr);
        }

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
