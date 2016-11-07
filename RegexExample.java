import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;

// regex example, regular expression example
// match, case insensitive, case-insensitive, case-sensitive, group, find
public class RegexExample{
    public static void main(String[] args) {
        test0();
        test1();
    }
    static void test0(){
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
    static void test1(){
        Aron.beg();
        Pattern r = Pattern.compile("captheorem", Pattern.CASE_INSENSITIVE);
        Matcher mat = r.matcher("CAPTHEOREM");
        if(mat.find()) {
            Print.p("found=" + mat.group(0));
        }
        Aron.end();
    }
} 

