import java.util.*;
import classfile.*;

public class ExcelColumnNumber{
    public static void main(String[] args) {
        System.out.println("Print all permuation character with repeating character!");
        String s = "ABC";
        char[] array = new char[s.length()];
        int depth = 0;
        Set<Character> map = new LinkedHashSet<Character>();
        //permRepeated(s, array, depth);
        //perm(s, array, depth, map);

        int[] arr = new int[1];
        int num = 20;
        arr[0] = 1;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i, arr, num);

        ExcelSheetRowNumberDirect(1);
        System.out.println("================");
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
    }
    public static void test5() {
        System.out.println("test5");
        String prefix = "";
        int nBits = 1;
        int count = 0;
        int height = 1;
        nBitsBinaryString("", nBits, count, height);
    }
    public static void test6() {
        System.out.println("test6");
        String prefix = "";
        int nBits = 2;
        int count = 0;
        int height = 2;
        nBitsBinaryString("", nBits, count, height);
    }
    public static void test7() {
        System.out.println("test7");
        String prefix = "";
        int nBits = 3;
        int count = 0;
        int height = 4;
        nBitsBinaryString("", nBits, count, height);
    }

    public static void nBitsBinaryString(String prefix, int nBits, int count, int height) {
        if(count == nBits && height == 0)
            System.out.println(prefix);
        else if(height > 0) {
            nBitsBinaryString(prefix + "0", nBits, count, height-1);
            nBitsBinaryString(prefix + "1", nBits, count+1, height-1);
        }
    }
    /*
    public static void permrepeating(String str, String permStr, int k, int h){
        int len = array.length;
        if(permStr.length() == k){
            System.out.println(permStr);
        }
        else{
            for(int i=0; i<len; i++){
                String s = str.charAt(i) + "";
                permrepeating(str, permStr + s, k, h+1);
            }
        }
    }
    */
    public static void test1() {
    }
    public static void test2() {
        ExcelSheetRowNumberDirect(1000000);
    }
    public static void test3() {
        int n = ExcelSheetStringToInteger("A");
        System.out.println("A=" + n);

        n = ExcelSheetStringToInteger("Z");
        System.out.println("Z=" + n);


        n = ExcelSheetStringToInteger("AA");
        System.out.println("AA=" + n);
        n = ExcelSheetStringToInteger("AB");
        System.out.println("AB=" + n);
    }

    public static void test4() {
        String str = ExcelSheetIntergeToString(1);
        System.out.println("1=" + str);

        str = ExcelSheetIntergeToString(2);
        System.out.println("2=" + str);

        str = ExcelSheetIntergeToString(26);
        System.out.println("26=" + str);

        str = ExcelSheetIntergeToString(28);
        System.out.println("28=" + str);
    }

    // 1 -> 0 -> 'A'
    // 2 -> 1 -> 'B'
    // 3 -> 2 -> 'C'
    // 26->25 -> 'Z'
    // 27->26 -> 'AA'

    public static String ExcelSheetIntergeToString(int n) {
        String ret = "";
        char[] array = new char[26];
        for(int i=0; i<26; i++)
            array[i] = (char)((int)'A' + i);

        if( n-1 == 0)
            ret = array[n-1] + "";
        else {
            while(n > 0) {
                int rem = (n-1) % 26;
                n = (n-1) / 26;
                ret = (char)array[rem] + "" + ret;
            }
        }
        return ret;
    }
    // 'A' -> 0 -> 1
    // 'B' -> 1 -> 2
    // 'C' -> 2
    // 'Z' -> 25
    // 'AA'-> 26 ->27
    // (a % m) = x
    // 1 % m = y
    // (a + 1) % m  = x + y
    //
    public static int ExcelSheetStringToInteger(String str) {
        int sum = 0;
        if(str != null) {
            int len = str.length();
            for(int i=0; i<len; i++) {
                int n = str.charAt(len-1-i) - 'A' + 1;
                sum += (int)Math.pow(26, i)*n;
            }
        }
        return sum;
    }

    //Calculate the excel sheet row number directly
    //   s = 26^1 + 26^2 + 26^3 + ... + 26^k
    // 26s = 26^2 + 26^3 + 26^4 + ... + 26^(k+1)
    // 25s = 26^(k+1) - 26
    // 25s + 26 = 26^(k+1)
    // log(25s+26)/log(26) = k+1
    // log(25s+26)/log(26)-1 = k
    public static void ExcelSheetRowNumberDirect(int num) {
        int k = (int)(Math.log(25*num + 26)/Math.log(26)) - 1;
        int diff = num - (int)(Math.pow(26, k+1) - 26)/25;
        int[] arr = new int[26];

        System.out.print("k="+k);
        System.out.print("diff="+diff);

        for(int i=0; i<26; i++)
            arr[i] = 'a'+i;

        int n = diff;
        if(diff == 0)
            n = num;
        while(n > 0) {
            int r = (n-1) % 26;
            System.out.print("["+(char)arr[r]+"]");
            n /= 26;
        }
        System.out.println();
    }
    //print excel sheet row number algorithm based on permutation
    public static void ExcelSheetRowNumber(String s, int num) {
        int[] arr = new int[1];
        arr[0] = 1;
        char[] array = new char[s.length()];
        int depth = 0;
        for(int i=1; i<=s.length(); i++)
            permRepeatedChooseK(s, array, depth, i, arr, num);
    }


    //Given string character array and integer k,
    //print all permutation with repeatation string length k
    public static void permRepeatedChooseK(String s, char[] array, int depth, int k, int[] arr, int num) {
        if(depth == k) {
            if(arr[0] == num)
                System.out.print("<"+num+">");
            System.out.print("{"+arr[0]+"}");
            arr[0]++;
            for(int i=0; i<depth; i++) {
                System.out.print("["+array[i]+"]");
            }
            System.out.println();
        } else {
            for(int i=0; i<s.length(); i++) {
                array[depth] = s.charAt(i);
                permRepeatedChooseK(s, array, depth+1, k, arr, num);
            }
        }
    }
    
    //[ file=headertonumber.html title=""
    static int excelNum(String header){
        int sum = 0;
        if(header != null){
            int len = header.length(); 
            for(int i=0; i<len; i++){
                int n = header.charAt(len-1 - i) - 'A' + 1;
                sum += n*Math.pow(26, i);
            }
        }
        return sum;
    }
    //]

    //[ file=numbertoheader.html title=""
    // 0 -> 'A'
    // 1 -> 'B'
    // 25 -> 'Z'
    // num = 1 -> 'A'
    // num = 26 -> 'A' + 25 = 'Z'
    // num = 27
    // reminder = 0 -> 'A'
    // num = 1
    // reminder = 0 -> 'A'
    // num = 52
    // (52 - 1) % 26 = 25 -> 'Z'
    // 52 / 26 = 2
    //  x = ['A' - 'Z'] - 'A'
    //  x = [0 ... 25]
    //  
    //  n = x + 1
    //  sum = (x + 1)*pow(26, 2) + (x + 1)*pow(26, 1) + (x+1)*pow(26, 0)
    static String numToHeader(int num){
        String str = "";
        while(num > 0){
            int reminder = (num - 1) % 26;
            char ch = (char)(reminder + 'A');
            str = ch + "" + str;
            num = (num - 1) / 26;
        }
        return str;
    }
    //]
}
