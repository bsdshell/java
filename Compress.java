import java.io.*;
import java.lang.String;
import java.util.*;
import classfile.*;

class Compress {
    public static void main(String args[]) {
        test0();        
        test00();        
        test1();        
        test2();        
        test3();        
        test4();        
        test5();        
        test6();        
        test7();        
        test8();        
        test9();        
        test10();        
        test11();        
    }
    //[ file=compressstr.html title=""
    public static String CompressStr(String str) {
        String ret="";
        if(str != null && str.length() > 0) {
            if(str.length() == 0 || str.length() == 1)
                ret = str;
            else {
                int c=1;
                int i=0;
                for(i=0; i<str.length()-1; i++) {
                    if(str.charAt(i) == str.charAt(i+1))
                        c++;
                    else{
                        if(c > 1) {
                            ret = ret + str.charAt(i) + c + "";
                            c=1;
                        }else{
                            ret = ret + str.charAt(i) + "";
                        }
                    } 
                }

                if(c > 1)
                    ret = ret + c	+ str.charAt(i) + "";
                else
                    ret = ret + str.charAt(i) + "";
            }
        }
        return ret;
    }

    public static String compress(String str) {
        int c = 1;
        String retStr = "";
        int i=0;
        for(; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                c++;
            } else {
                if(c == 1)
                    retStr += str.charAt(i) + "";
                else if(c > 1)
                    retStr += str.charAt(i) + "" + c;

                c = 1;
            }
        }

        if(c == 1)
            retStr += str.charAt(i) + "";
        else if(c > 1)
            retStr += str.charAt(i) + "" + c;

        return retStr;
    }
    public static String compress2(String str) {
        int c = 1;
        String retStr = "";
        str += "0";
        for(int i=0; i<str.length()-1; i++) {
            if(str.charAt(i) == str.charAt(i+1)) {
                c++;
            } else {
                if(c == 1)
                    retStr += str.charAt(i) + "";
                else if(c > 1)
                    retStr += str.charAt(i) + "" + c;

                c = 1;
            }
        }

        return retStr;
    }
    //]
    
    static void test0(){
        Aron.beg();
        String str="aabba";
        String ret = CompressStr(str);
        System.out.println("aabba[" + ret + "]"); 
        Aron.end();
    }

    static void test00(){
        Aron.beg();
        String str="a";
        String ret = CompressStr(str);
        System.out.println("a[" + ret + "]"); 
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        String str="aabba";
        String ret = compress(str);
        System.out.println("aabba[" + ret + "]"); 
        Aron.end();
    }

    static void test2(){
        Aron.beg();
        String str="a";
        String ret = compress(str);
        System.out.println("a[" + ret + "]"); 
        Aron.end();
    }

    static void test3(){
        Aron.beg();
        String str="aa";
        String ret = compress(str);
        System.out.println("aa[" + ret + "]"); 
        Aron.end();
    }

    static void test4(){
        Aron.beg();
        String str="ab";
        String ret = compress(str);
        System.out.println("ab[" + ret + "]"); 
        Aron.end();
    }
    static void test5(){
        Aron.beg();
        String str="aabbb";
        String ret = compress(str);
        System.out.println("aabbb[" + ret + "]"); 
        Aron.end();
    }
    static void test6(){
        Aron.beg();
        String str="aabbba";
        String ret = compress(str);
        System.out.println("aabbba[" + ret + "]"); 
        Aron.end();
    }

    static void test7(){
        Aron.beg();
        String str="a";
        String ret = compress2(str);
        System.out.println("compress2 a[" + ret + "]"); 
        Aron.end();
    }
    static void test8(){
        Aron.beg();
        String str="aa";
        String ret = compress2(str);
        System.out.println("compress2 aa[" + ret + "]"); 
        Aron.end();
    }
    static void test9(){
        Aron.beg();
        String str="abbb";
        String ret = compress2(str);
        System.out.println("compress2 abbb[" + ret + "]"); 
        Aron.end();
    }
    static void test10(){
        Aron.beg();
        String str="aabbbc";
        String ret = compress2(str);
        System.out.println("compress2 aabbbc[" + ret + "]"); 
        Aron.end();
    }

    static void test11(){
        Aron.beg();
        String str="";
        String ret = compress2(str);
        System.out.println("compress2 empty_str[" + ret + "]"); 
        Aron.end();
    }
}
