package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
    }

    public static void test1() {
        System.out.println("\ntest1");
        StringBuffer strbuf = new StringBuffer("abbbcc");
        StringBuffer sb = removeDuplicateStr(strbuf);
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
    }

    public static void test2() {
        System.out.println("\ntest2");
        StringBuffer strbuf = new StringBuffer("a");
        StringBuffer sb = removeDuplicateStr(strbuf);
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
    }

    public static void test3() {
        System.out.println("\ntest3");
        StringBuffer strbuf = new StringBuffer("aaa");
        StringBuffer sb = removeDuplicateStr(strbuf);
        for (int i = 0; i < sb.length(); i++) {
            System.out.println(sb.charAt(i));
        }
    }

    public static void test4() {
        System.out.println("\ntest4");
        String str = " ab c ";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }

    public static void test5() {
        System.out.println("\ntest5");
        String str = "a";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }

    public static void test6() {
        System.out.println("\ntest6");
        String str = " a ";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }

    public static void test7() {
        System.out.println("\ntest7");
        String str = " a";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }

    public static void test8() {
        System.out.println("\ntest8");
        String str = " ab c";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }

    public static void test9() {
        System.out.println("\ntest9");
        String str = " ab c ";
        List<String> list = splitString(str);
        for (String item : list) {
            System.out.println("item=" + item);
        }
    }


    public static List<String> splitString(String str) {
        List<String> list = new ArrayList<String>();
        String tmpStr = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (tmpStr != "") {
                    list.add(tmpStr);
                    tmpStr = "";
                    count++;
                }
            } else {
                tmpStr += str.charAt(i) + "";
            }
        }
        if (tmpStr != "") {
            list.add(tmpStr);
        }
        return list;
    }

    public static StringBuffer removeDuplicateStr(StringBuffer sb) {
        StringBuffer buffer = new StringBuffer();
        if (sb.length() > 1) {
            int first = 0;
            int second = 1;
            while (second < sb.length()) {
                if (sb.charAt(first) != sb.charAt(second)) {
                    buffer.append(sb.charAt(first));
                    first = second;
                }
                second++;
            }
            buffer.append(sb.charAt(sb.length() - 1));
        } else {
            return sb;
        }
        return buffer;
    }
}
