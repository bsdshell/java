import java.util.*;
import java.io.*;
import classfile.*;

public class ExcelNumberBinary{
    public static void main(String[] args) {
        test1();
        test3();

        test0_excel();
        test1_excel();
        test2_excel();

        test0_printExcel();
        test1_printExcel();
        test2_printExcel();
    }
    public static void test0() {
        Aron.beg();
        String str = intToAlphabet(0);
        Print.pb(str);
        Aron.end();
    }
    public static String intToAlphabet(int n) {
            int num = (int)'a' + n;
            char ch = (char)num;
            return "" + ch;
    }
    public static void test1() {
        Aron.beg();
        int num = 16;
        printAllBinary(num);
        Aron.end();
    }
    public static void test3() {
        Aron.beg();
        int num = 17;
        printAllBinary(num);
        Aron.end();
    }

    //[ file=printbin.html title=""
    /**
    * print all binary from zero to num-1 with length log2(num)
    * @param num maximum number 
    */
    public static void printAllBinary(int num) {
        String str = "";
        int binLen = (int)Math.ceil(Math.log(num)/Math.log(2));

        for(int j=0; j<num; j++){
            int n = j;
            for(int i=0; i<binLen; i++){
                if(n % 2 == 0)
                    str = "0" + str;
                else
                    str = "1" + str;

                n = n/2;
            } 
            Print.plb(str);
            str = "";
        } 
    }
    //]


    //[ file=binexcel.html title=""
    // [1 -> 26] = ['A' -> 'Z']
    // [0 -> 25]   ['A' -> 'Z'] 
    public static void excelNumSaveLength(int num) {
        int binLen = 1;
        if(num == 1) 
            binLen = 1;
        else 
            binLen = (int)Math.ceil(Math.log(num)/Math.log(26));

        for(int j=1; j<=num; j++){
            int n = j;
            String str = "";
            for(int i=1; i<=binLen; i++){
                String s = Aron.intToAlphabetUpper((n-1)%26);
                str = s + str;
                n = (n-1)/26;
            } 
            Print.plb(str);
        } 
    }
    //]
    //[ file=excelnum1.html title=""
    // [1 -> 26] = ['A' -> 'Z']
    // [0 -> 25]   ['A' -> 'Z'] 
    public static void printExcel(int num){
        int base = 26;
        for(int i=1; i<=num; i++){
            int x = i;
            String str = "";
            if(x-1 == 0)
                str = 'A' + str;
            else{
                while( x > 0){
                    int r = (x-1) % base;
                    String s = Aron.intToAlphabetUpper(r);
                    str = s + str;
                    x = (x-1) / base;
                }
            }
            Print.plb(str);
        }
    }
    //]

    public static void test0_excel() {
        Aron.beg();
        int num = 26;
        excelNumSaveLength(num);

        Aron.end();
    }
    public static void test1_excel() {
        Aron.beg();
        int num = 1; 
        excelNumSaveLength(num);

        Aron.end();
    }
    public static void test2_excel() {
        Aron.beg();
        int num = 27; 
        excelNumSaveLength(num);
        Aron.end();
    }
    public static void test0_printExcel() {
        Aron.beg();
        int num = 1; 
        printExcel(num);
        Aron.end();
    }
    public static void test1_printExcel() {
        Aron.beg();
        int num = 26; 
        printExcel(num);
        Aron.end();
    }
    public static void test2_printExcel() {
        Aron.beg();
        int num = 27; 
        printExcel(num);
        Aron.end();
    }
}

