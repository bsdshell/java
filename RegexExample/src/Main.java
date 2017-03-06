import classfile.Print;
import classfile.Aron;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;

// regex example, regular expression example
// match, case insensitive, case-insensitive, case-sensitive, group, find
// *jregex* *j_regex_example_many*
public class Main {
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
        test_split0();
        test_split1();
        test_split2();
    }
    static void test0() {
        Aron.beg();
        String pattern = "([a-z]+).([a-zA-Z-]+)(/)";
        String[] strArr = {
                "www.google.com/search?q=goog/nice",
                "www.google.com/search?q=goog",
                "http://www.google.msn.ca/search?q=goog",
                "http://www.google.msn.ca/a/b/c/d"
        };

        Pattern r = Pattern.compile(pattern);
        for(int i=0; i<strArr.length; i++) {
            Matcher mat = r.matcher(strArr[i]);
            if(mat.find()) {
                Print.p("found=" + mat.group(0));
            }
        }

        Aron.end();
    }
    static void test1() {
        Aron.beg();
        Pattern r = Pattern.compile("captheorem", Pattern.CASE_INSENSITIVE);
        Matcher mat = r.matcher("CAPTHEOREM");
        if(mat.find()) {
            Print.p("found=" + mat.group(0));
        }
        Aron.end();
    }
    static void test2() {
        Aron.beg();
        //Pattern pattern = Pattern.compile("[0-9]{3}[-]{0,1}[0-9]{3}[-]{0,1}[0-9]{4}");
        Pattern pattern = Pattern.compile("[0-9]{3}[-]?[0-9]{3}[-]?[0-9]{4}");
        Matcher matcher = pattern.matcher("334-4467777 yes... 334666-4456 415-333-9674 whatever 4264491569");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
        Aron.end();
    }
    static void test3() {
        Aron.beg();

        // match number
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("334-4467777 yes... 334666-4456 415-333-9674 whatever 4264491569");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
        Aron.end();
    }
    static void test4() {
        Aron.beg();

        // match number and group
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher("334-4467777 yes... 334666-4456 415-333-9674 whatever 4264491569");
        while(matcher.find()) {
            System.out.println(matcher.group());
        }
        Aron.end();
    }
    static void test5() {
        Aron.beg();

        // match number
        Pattern pattern = Pattern.compile("[A-Z]+");
        Matcher matcher = pattern.matcher("This is case insensitive PREPOSITION");
        while(matcher.find()) {
            Print.pbl(matcher.group());
        }
        Aron.end();
    }
    static void test6() {
        Aron.beg();

        // match number
        Pattern pattern = Pattern.compile("[a-zA-Z0-9_]+");
        Matcher matcher = pattern.matcher("This is case_INSENSITIVE PREPOSITION");
        while(matcher.find()) {
            Print.pbl(matcher.group());
        }
        Aron.end();
    }
    static void test7() {
        Aron.beg();

        // excluding a,n, and space
        Pattern pattern = Pattern.compile("[^an ]+");
        Matcher matcher = pattern.matcher("This is banana");
        while(matcher.find()) {
            Print.pbl(matcher.group());
        }
        Aron.end();
    }
    static void test8() {
        Aron.beg();

        // excluding all vowels
        Pattern pattern = Pattern.compile("[a-z&&[^youiea]]+");
        Matcher matcher = pattern.matcher("show all the words which do not contains vowel");
        while(matcher.find()) {
            Print.pbl(matcher.group());
        }
        Aron.end();
    }
    static void test9() {
        Aron.beg();

        // POSIX character classes \p{Lower}+ => [a-z]+
        Pattern pattern = Pattern.compile("\\p{Lower}+");
        Matcher matcher = pattern.matcher("show all the words which do not contains vowel");
        while(matcher.find()) {
            Print.pbl(matcher.group());
        }
        Aron.end();
    }

    // grouping
    static void test10() {
        Aron.beg();
        //import java.util.regex.Matcher;
        //import java.util.regex.Pattern;
        String str = "\"dog cat\" 3241.10 ";
        Pattern pattern = Pattern.compile("(\"[^\"]*\")|([0-9]*\\.?[0-9]+)");
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            for(int i=1; i<= matcher.groupCount(); i++) {
                if(matcher.group(i) != null && matcher.group(i).length() > 0) {
                    String ss = matcher.group(i);
                    Print.pbl(ss);
                }
            }
        }


        Aron.end();
    }

    public static void test11() {
        Aron.beg();

        // match boundary word, match word, match words, match word only
        // boundary word, boundary words only, boundary only, word boundary
        String[] arr = {
                "dog",
                "cat",
                "key-value"
        };
        Pattern pattern = Pattern.compile("(?<=^|\\s)[a-z]+(?=\\s|$)");
        Aron.printArray(arr);
        for(String s : arr) {
            Matcher matcher = pattern.matcher(s);
            if(matcher.find()) {
                Print.pbl("match word=" + matcher.group());
            }
        }
        Print.pbl("Does not match key-value");

        Aron.end();
    }
    /**
     * split string with special char, e.g. "{" -> escape "\\{"
     * or use Character Group: [{]
     */
    public static void test_split0() {
        Aron.beg();

        String str = "The fun()  { dog it now }; ";
        List<String> list = Aron.split(str, "\\{");
        Aron.printList(list);
        // [The fun()  ][ dog it now }; ]

        Aron.end();
    }


    /**
     * split string to different tokens with multiple delimiters
     * Character Group: [{};{}]
     */
    public static void test_split1() {
        Aron.beg();

        String str = "The fun()  { dog it now }; ";
        List<String> list = Aron.split(str, "[{};()]+");
        Aron.printList(list);
        // [The fun][  ][ dog it now ][ ]

        Aron.end();
    }

    /**
     * split string with multiple delimiters such as [ .,?!]
     */
    public static void test_split2() {
        Aron.beg();
        String str = "This is a sentence.  This is a question, right?  Yes!  It is.";
        String delims = "[ .,?!]+";
        List<String> list = Aron.split(str, delims);
        Aron.printList(list);
        // [This][is][a][sentence][This][is][a][question][right][Yes][It][is]
        Aron.end();
    }
}
