import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryMM{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        //String s = "kabcabckFABCFdd";
        String s = "name#778-338-4145dd";

        //Pattern pattern = Pattern.compile("k([a-c]+)|(F([A-C]+)F)");
        //Pattern pattern = Pattern.compile("(k([a-c]+)|([A-C]+))");
        Pattern pattern = Pattern.compile("(\\w+)|#([0-9-]+)");
        Matcher matcher = pattern.matcher(s);
        while(matcher.find()) {
            Print.pbl("groupCount=" + matcher.groupCount());
            Ut.l();
            int gc = matcher.groupCount();
            for(int i=1; i<=gc; i++){
                if(matcher.group(i) != null)
                    Print.pb(matcher.group(i));
            } 
        }

        Aron.end();
    }
    static void test1(){
        Aron.beg();
        String s = "dog\r\ncat";
        String str = s.replace("\r\n", "-");
        Print.pbl("str=" + str);
        Aron.end();
    } 
} 

