import java.util.*;
import java.io.*;
import classfile.*;

// Tries with HashMap
class XNode {
    public Map<Character, XNode> map = new HashMap<Character, XNode>();
    public boolean isWord = false;
    public String word;
    public XNode(boolean isWord) {
        this.isWord = isWord;
    }
}

public class TriesMap{
    public static void main(String[] args) {
        test0_insert();
        test1_insert();
        test2_insert();
        test3_insert();
        test4_insert();
        test4_autocomplete();
        test5_autocomplete();
        test5_autocompleteList();
        test6_autocompleteList();
        test7_autocompleteList();
        test8_autocompleteList();
        test9_autocompleteList();
    }

    
    //[ file=triesmap.html title=""
    /**
    * insert str to Tries from the root, if str doesn't exist in Tries
    * set isWord to be true, and assign str to word
    * if str does exist in the tries, do nothing
    *
    * @param root   the root node of Tries, it can't be null
    * @param str    the String is being inserted
    * @param index  index of str, initial value is zero
    *
    * return void
    */
    public static void insert(XNode root, String str, int index) {
        if(index == str.length()) {
            root.isWord = true;
            root.word = str;
        } else {
            char ch = str.charAt(index);
            XNode node = root.map.get(ch);
            if(node == null) {
                node = new XNode(false);
                root.map.put(ch, node);
            }
            insert(node, str, index+1);
        }
    }

    /**
    * check if the str exist in the Tries,
    *
    * @param root the root of Tries
    * @param str  the String to be checked
    * @param index index of str
    *
    * @return true if str exists in the Tries, false otherwise
    */
    public static boolean contains(XNode root, String str, int index) {
        if(index == str.length()) {
            return root.isWord;
        } else {
            if(root.map.containsKey(str.charAt(index))) {
                return contains(root.map.get(str.charAt(index)), str, index + 1);
            } else {
                return false;
            }
        }
    }

    public static XNode autocomplete(XNode root, String partialWord, int index) {
        if(index == partialWord.length()) {
            return root;
        }else {
            XNode node = root.map.get(partialWord.charAt(index));
            if(node != null) {
                return autocomplete(node, partialWord, index + 1);
            }
            return null;
        }
    }
    public static void autocompleteList(XNode node, String partialWord, int index, List<String> list) {
        if(node.isWord)
            list.add(node.word);
        else{
            for(Map.Entry<Character, XNode> entry : node.map.entrySet()){
                if(entry.getValue().isWord)
                    list.add(entry.getValue().word);
                else
                    autocompleteList(entry.getValue(), partialWord, index+1, list);
            } 
        }
    }
    //]

    public static void print(XNode root) {
        if(root != null) {
            if(root.isWord)
                Print.pb(root.word);

            for(Map.Entry<Character, XNode> entry : root.map.entrySet()) {
                print(entry.getValue());
            }
        }
    }

    static void test0_insert() {
        Aron.beg();
        XNode root = new XNode(true);
        String str = "a";
        int index = 0;
        insert(root, str, index);
        Test.t(contains(root, str, index));
        Aron.end();
    }
    static void test1_insert() {
        Aron.beg();
        XNode root = new XNode(true);
        String str = "a";
        int index = 0;
        insert(root, "ab", index);
        Test.f(contains(root, str, index));
        Aron.end();
    }
    static void test2_insert() {
        Aron.beg();
        XNode root = new XNode(true);
        String str = "a";
        int index = 0;
        insert(root, "a", index);
        insert(root, "ab", index);
        insert(root, "abc", index);
        insert(root, "abcd", index);

        Test.t(contains(root, "", index));
        Test.t(contains(root, "a", index));
        Test.t(contains(root, "ab", index));
        Test.t(contains(root, "abcd", index));
        Test.t(contains(root, "abc", index));

        Test.f(contains(root, "abb", index));
        Test.f(contains(root, "abcc", index));
        Aron.end();
    }
    static void test3_insert() {
        Aron.beg();
        XNode root = new XNode(true);
        String str = "a";
        int index = 0;
        insert(root, "abcd", index);

        Test.t(contains(root, "", index));
        Test.f(contains(root, "a", index));
        Test.f(contains(root, "ab", index));
        Test.t(contains(root, "abcd", index));
        Test.f(contains(root, "abc", index));

        Aron.end();
    }
    static void test4_insert() {
        Aron.beg();
        XNode root = new XNode(true);
        String str = "a";
        int index = 0;
        insert(root, "abcd", index);
        insert(root, "a", index);
        insert(root, "abc", index);
        print(root);

        Aron.end();
    }
    static void test4_autocomplete() {
        Aron.beg();

        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        
        String str = "cat";
        XNode node = autocomplete(root, str, index);
        Test.t(node.isWord == true);
        Test.t(node.word.equals(str));

        Aron.end();
    }
    static void test5_autocomplete() {
        Aron.beg();

        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        
        String str = "ca";
        XNode node = autocomplete(root, str, index);
        Test.t(node.isWord == false);

        Aron.end();
    }
    static void test5_autocompleteList() {
        Aron.beg();
        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        insert(root, "qualify", index);
        insert(root, "quart", index);
        insert(root, "quarter", index);
        insert(root, "quantify", index);
        insert(root, "quantifying", index);
        insert(root, "quantified", index);
        insert(root, "quantifies", index);
        insert(root, "quant", index);
        insert(root, "quantitative", index);
        insert(root, "quadratic", index);
        insert(root, "satellite", index);
        insert(root, "beijing", index);
        insert(root, "vienna", index);
        
        String str = "qua";
        XNode node = autocomplete(root, str, index);

        List<String> list = new ArrayList<String>(); 
        autocompleteList(node, str, index, list);
        Print.pbl(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test6_autocompleteList() {
        Aron.beg();
        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        insert(root, "qualify", index);
        insert(root, "quart", index);
        insert(root, "quarter", index);
        insert(root, "quantify", index);
        insert(root, "quantifying", index);
        insert(root, "quantified", index);
        insert(root, "quantifies", index);
        insert(root, "quant", index);
        insert(root, "quantitative", index);
        insert(root, "quadratic", index);
        insert(root, "satellite", index);
        insert(root, "beijing", index);
        insert(root, "vienna", index);
        
        String str = "q";
        XNode node = autocomplete(root, str, index);

        List<String> list = new ArrayList<String>(); 
        autocompleteList(node, str, index, list);
        Print.pbl(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test7_autocompleteList() {
        Aron.beg();
        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        insert(root, "qualify", index);
        insert(root, "quart", index);
        insert(root, "quarter", index);
        insert(root, "quantify", index);
        insert(root, "quantifying", index);
        insert(root, "quantified", index);
        insert(root, "quantifies", index);
        insert(root, "quant", index);
        insert(root, "quantitative", index);
        insert(root, "quadratic", index);
        insert(root, "satellite", index);
        insert(root, "beijing", index);
        insert(root, "vienna", index);
        
        String str = "c";
        Print.pbl(str);
        XNode node = autocomplete(root, str, index);

        List<String> list = new ArrayList<String>(); 
        autocompleteList(node, str, index, list);
        Aron.printList(list);

        Aron.end();
    }
    static void test8_autocompleteList() {
        Aron.beg();
        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        insert(root, "quality", index);
        insert(root, "qualify", index);
        insert(root, "quart", index);
        insert(root, "quarter", index);
        insert(root, "quantify", index);
        insert(root, "quantifying", index);
        insert(root, "quantified", index);
        insert(root, "quantifies", index);
        insert(root, "quant", index);
        insert(root, "quantitative", index);
        insert(root, "quadratic", index);
        insert(root, "satellite", index);
        insert(root, "beijing", index);
        insert(root, "vienna", index);
        
        String str = "";
        Print.pbl(str);
        XNode node = autocomplete(root, str, index);

        List<String> list = new ArrayList<String>(); 
        autocompleteList(node, str, index, list);
        Aron.printList(list);

        Aron.end();
    }
    static void test9_autocompleteList() {
        Aron.beg();
        XNode root = new XNode(true);
        int index = 0;
        insert(root, "", index);
        insert(root, "cat", index);
        insert(root, "quantum", index);
        
        String str = "cat";
        Print.pbl(str);
        XNode node = autocomplete(root, str, index);

        List<String> list = new ArrayList<String>(); 
        autocompleteList(node, str, index, list);
        Aron.printList(list);

        Aron.end();
    }
}

