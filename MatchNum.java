import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class MatchNum{
    public static void main(String[] args) {
        test0();
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
    public static void test0(){
        Aron.beg();
        String str = "12";
        boolean isNum = isNumeric(str);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        String str = "1200";
        boolean isNum = isNumeric(str);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test2(){
        Aron.beg();
        String str = "0";
        boolean isNum = isNumeric(str);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test3(){
        Aron.beg();
        String str = "a";
        boolean isNum = isNumeric(str);
        Test.t(isNum == false);

        Aron.end();
    }
    public static void test4(){
        Aron.beg();
        String str = "0314";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == false);

        Aron.end();
    }
    public static void test5(){
        Aron.beg();
        String str = "0";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == true);
        Aron.end();
    }
    public static void test6(){
        Aron.beg();
        String str = "-123";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test7(){
        Aron.beg();
        String str = "0";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test8(){
        Aron.beg();
        String str = "+12";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == true);

        Aron.end();
    }
    public static void test9(){
        Aron.beg();
        String str = "+";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == false);

        Aron.end();
    }
    public static void test10(){
        Aron.beg();
        String str = "-";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == false);

        Aron.end();
    }
    public static void test11(){
        Aron.beg();
        String str = "+-";
        boolean isNum = isNumeric(str);
        Print.pbl("isNum=" + isNum);
        Test.t(isNum == false);

        Aron.end();
    }

    // is positive Integer from [-n -1 0 1 n] 
    public static boolean isNumeric(String str){
        //return str.matches("[1-9][0-9]+");
        return str.matches("[-+]?[1-9][0-9]*|0");
    }
} 

