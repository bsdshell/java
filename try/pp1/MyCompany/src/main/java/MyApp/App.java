package MyApp;

import classfile.Aron;
import classfile.Print;
import classfile.Test;
import classfile.Ut;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App{
    public static void main(String[] args) {
        test0();
        test1();
        test3();
    }
    public static void test0(){
        Aron.beg();
        String fileName = "/Users/cat/myfile/github/java/text/acl.cvs";
        readCVS(fileName);
        Aron.end();
    }
    static void test1(){
        Aron.beg();
        //Pattern pattern = Pattern.compile("[0-9]{3}[-]{0,1}[0-9]{3}[-]{0,1}[0-9]{4}");
        Pattern pattern = Pattern.compile("\"[^\"]+\"");
        Matcher matcher = pattern.matcher("\"dog\", \"cat\"");
        Print.pbl("groupCount=" + matcher.groupCount());
        while(matcher.find()) {
            System.out.println(matcher.group());
        }

        Aron.end();
    }
    static void test2(){
        Aron.beg();

//        List<String> animalList = Arrays.asList("dog", "cow", "cat", "squirrel");
//        Aron.printList(animalList);
//        String max11 = animalList.stream().max(Comparator.comparing(String::valueOf)).get();
//        Print.pbl(max11 + " maxlen=" + max11.length());

        Aron.end();
    }

    static void test3(){
        Aron.beg();

        String s = getString("\"abc\"");
        Print.pbl("s=" + s);
        Test.t(s.equals("abc"));

        String s1 = getString("abc");
        Test.t(s1 == null);

        String s2 = getString(null);
        Test.t(s2 == null);

        String s3 = getString("");
        Test.t(s3 == null);

        Aron.end();
    }

    public static String leftPad(String str, int max, int len){
        int diff = max - len;
        if(diff > 0){
            for(int i=0; i<diff; i++)
                str = "=" + str;
        }
        return str;
    }
    public static String rightPad(String str, int max, int len){
        int diff = max - len;
        if(diff > 0){
            for(int i=0; i<diff; i++)
                str += "-";
        }
        return str;
    }

    // if str is a string, strim two double quotes. O.W return null
    public static String getString(String str){
        if(str != null){
            Pattern pattern = Pattern.compile("\"([^\"]*)\"");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()) {
                for(int i=1; i<=matcher.groupCount(); i++){
                    if(matcher.group(i) != null)
                        return matcher.group(i);
                }
            }
        }
        return null;
    }
    public static int getMax(List<String> list){
        int max = 0;
        for(String s : list){
            if(getString(s) != null){
                if(s.length() - 2 > max)
                    max = s.length();
            }else{
                if(s.length() > max)
                    max = s.length();
            }
        }
        return max;
    }
    public static void readCVS(String fileName){
        List<String> list = Aron.readFile(fileName);
        Pattern pattern = Pattern.compile("(\"[^\"]*\")|([0-9]*\\.?[0-9]+)");
        for(String s : list){
            Matcher matcher = pattern.matcher(s);
            int len = 0;
            List<String> row = new ArrayList<String>();
            while(matcher.find()) {
                for(int i=1; i<=matcher.groupCount(); i++){
                    if(matcher.group(i) != null && matcher.group(i).length() > 0){
                        len = matcher.group(i).length();
                        Print.pb(matcher.group(i));
                        row.add(matcher.group(i));
                        Print.pbl("glen=" + len);
                    }
                }
            }

            int max = getMax(row);
            Print.pbl("max=" + max);

            for(String item : row){
                String newStr = getString(item);
                if(newStr != null){
                    Print.pb("newStr=" + newStr, "<");
                    String str1 = newStr.replace("\\r\\n", " ");
                    Print.pb("str1=" + str1, "{");
                    Print.pb(rightPad("str1=" + str1, max, str1.length()));
                }
                else
                    Print.pb(leftPad(item, max, item.length()));

            }
            Ut.l();
        }
    }
}
