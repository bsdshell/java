import java.util.*;
import java.io.*;
import classfile.*;

public class TryPermutation {
    public static void main(String[] args) {
//        test0();
          test1();
          test2();
          test3();
          test00();
          test01();
          test02();
          test03();
          test04();
    }
    public static void test0() {
        Aron.beg();
        String prefix = "";
        String str =""; 
        permutation(prefix, str); 
        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        String prefix = "";
        String str ="a"; 
        permutation(prefix, str); 
        Aron.end();
    }
    public static void test2() {
        Aron.beg();
        String prefix = "";
        String str ="ab"; 
        permutation(prefix, str); 
        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        String prefix = "";
        String str = "abc";
        permutation(prefix, str); 
        Aron.end();
    }

    // 3:17
    // a[bc] a + p(bc)
    // b[ac] b + p(ac)
    // c[ab] c + p(ab)
    //            abc
    //       bc   ac      ab
    //    c    b c  a    b   a
    // Init: prefix = ""
    public static void permutation(String prefix, String str) {
        if(str != null) {
            if(str.length() == 0) {
                Print.pbl(prefix);
            }else if(str.length() > 0){
                for(int i=0; i<str.length(); i++) {
                    String s = str.charAt(i) + "";
                    permutation(prefix + s, remove(str, i));
                }
            }
        }
    }
    private static String remove(String str, int index) {
        String ret = "";
        for(int i=0; i<str.length(); i++){
            if(i != index)
                ret += str.charAt(i);
        } 
        return ret;
    }
    
    private static List<String> rem(List<String> list, int index) {
        list.remove(index);
        List<String> newList = list.subList(0, list.size()); 
        return newList;
    }
    static void test4(){
        Aron.beg();
        List<String> list = new ArrayList<>(); 
        list.add("a");
        list.add("b");
        list.add("c");
        List<String> newList = rem(list, 0); 
        Aron.printList(newList);
        Aron.end();
    }
    static void test5(){
        Aron.beg();
        List<String> list = new ArrayList<>(); 
        list.add("a");
        list.add("b");
        list.add("c");

        list.subList(0, 1).clear(); 
        Aron.printList(list);
        Ut.l();

        List<String> list1 = new ArrayList<>(); 
        list1.add("a");
        list1.add("b");
        list1.add("c");

        list1.subList(2, 3).clear(); 
        Aron.printList(list1);

        Aron.end();
    }
    
    static void test00(){
        Aron.beg();
        StringBuffer sb = new StringBuffer("abc");
        sb.deleteCharAt(1);
        Print.p(sb.toString());
        Aron.end();
    }
    static void test01(){
        Aron.beg();
        StringBuffer sb = new StringBuffer("abc");
        sb.deleteCharAt(1);
        Print.p(sb.toString());

        String str = "abc";
        StringBuffer sb1 = new StringBuffer(str);
        String strRev =  sb1.reverse().toString();
        Print.p(strRev);

        Aron.end();
    }
    static void test02(){
        Aron.beg();
        String str = "abce";
        StringBuffer sb1 = new StringBuffer(str);
        String strRev =  sb1.reverse().toString();
        for(int i=0; i<sb1.length(); i++){
            String subStr = sb1.substring(i);
            Print.p(subStr);
        } 

        Aron.end();
    }
    static void test03(){
        Aron.beg();
        String str = "To_give_a_sneak_peek";
        StringBuffer sb1 = new StringBuffer(str);
        Print.p(str);
        for(int i=0; i<sb1.length(); i++){
            String prefix = sb1.substring(0, i);
            String suffix= sb1.substring(i, sb1.length());
            Print.p(prefix + " " + suffix);
        } 

        Aron.end();
    }
    static void test04(){
        Aron.beg();
        String str = "To_give_a_sneak_peek";
        StringBuffer sb1 = new StringBuffer(str);
        Print.p(str);
        for(int i=0; i<sb1.length(); i++){
            StringBuffer tmp =  new StringBuffer(sb1.toString()); 
            StringBuffer sb2 = tmp.deleteCharAt(i);
            Print.p(sb2.toString());
        } 

        Aron.end();
    }
}

