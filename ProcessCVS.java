import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import classfile.*;

// parse CVS file
public class ProcessCVS{
    public static void main(String[] args) {
        test0();
        //test1();
        //writeCrapToFile();
    }

    public static void test0() {
        long ti, tf;
        ti = System.currentTimeMillis();
        //String cvsFile = "/Users/cat/myfile/github/java/text/acl.cvs";
        String cvsFile = "/Users/cat/myfile/github/java/text/big.txt";
        String outFile = "/Users/cat/myfile/github/java/text/acl_out.txt";
        convertCVS(cvsFile, outFile);
        tf = System.currentTimeMillis();
        Print.pbl("Finish. Total time:" + (tf - ti)/1000.00); 
    }
    public static void test1() {
        long ti, tf;
        ti = System.currentTimeMillis();
        //String cvsFile = "/Users/cat/myfile/github/java/text/acl.cvs";
        String cvsFile = "/Users/cat/myfile/github/java/text/big.txt";
        String outFile = "/Users/cat/myfile/github/java/text/acl_out.txt";
        convertCVSList(cvsFile, outFile);
        tf = System.currentTimeMillis();
        Print.pbl("Finish. Total time:" + (tf - ti)/1000.00); 
    }

    public static String leftPad(String str, int max, int len) {
        int diff = max - len;
        if(diff > 0) {
            for(int i=0; i<diff; i++)
                str = " " + str;
        }
        return str;
    }
    public static String rightPad(String str, int max, int len) {
        int diff = max - len;
        if(diff > 0) {
            for(int i=0; i<diff; i++)
                str += " ";
        }
        return str;
    }

    // if str is a string, strim two double quotes. O.W return null
    public static String getString(String str) {
        if(str != null) {
            Pattern pattern = Pattern.compile("\"([^\"]*)\"");
            Matcher matcher = pattern.matcher(str);
            while(matcher.find()) {
                for(int i=1; i<=matcher.groupCount(); i++) {
                    if(matcher.group(i) != null)
                        return matcher.group(i);
                }
            }
        }
        return null;
    }

    public static int getMax(List<String> list) {
        int max = 0;
        for(String s : list) {
            if(getString(s) != null) {
                int l = s.length() - 2;
                if(l > max)
                    max = l;
            } else {
                if(s.length() > max)
                    max = s.length();
            }
        }
        return max;
    }

    public static void convertCVS(String cvsFile, String outFile) {

        // match string or number/decimal
        Pattern pattern = Pattern.compile("(\"[^\"]*\")|([0-9]*\\.?[0-9]+)");
        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        FileWriter fstream = null;
        BufferedWriter out = null;

        try {
            fstream = new FileWriter(outFile);
            out = new BufferedWriter(fstream);

            LineIterator it = FileUtils.lineIterator(new File(cvsFile), "UTF-8");
            while (it.hasNext()) {
                String s = it.next();
                Matcher matcher = pattern.matcher(s);
                int len = 0;
                List<String> row = new ArrayList<String>();
                while(matcher.find()) {
                    for(int i=1; i<= matcher.groupCount(); i++) {
                        if(matcher.group(i) != null && matcher.group(i).length() > 0) {
                            len = matcher.group(i).length();

                            String ss = matcher.group(i);
                            if(getString(ss) != null) {
                                // ss is string 
                                String str1 = ss.replace("\\r\\n", " ");
                                row.add(str1);
                            } else {
                                // ss is number or decimal 
                                row.add(matcher.group(i));
                            }
                        }
                    }
                }
                int max = getMax(row);

                for(int i=0; i<row.size(); i++){
                    String item = row.get(i);
                    String newStr = getString(item);
                    if(newStr != null) {
                        String paddedStr = rightPad(newStr, max, newStr.length());
                        if(i < row.size() - 1)
                            out.write(paddedStr + " ");
                        else
                            out.write(paddedStr);
                    }else{
                        String paddedStr = leftPad(item, max, item.length());
                        if(i < row.size() - 1)
                            out.write(paddedStr + " ");
                        else
                            out.write(paddedStr);
                    }
                }
                out.write("\r\n");
            }

            out.close();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void convertCVSList(String cvsFile, String outFile) {

        // match string or number/decimal
        Pattern pattern = Pattern.compile("(\"[^\"]*\")|([0-9]*\\.?[0-9]+)");
        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        FileWriter fstream = null;
        BufferedWriter out = null;

        try {
            fstream = new FileWriter(outFile);
            out = new BufferedWriter(fstream);

            List<String> list = Aron.readFile(cvsFile);
            for(String s : list) {
                Matcher matcher = pattern.matcher(s);
                int len = 0;
                List<String> row = new ArrayList<String>();
                while(matcher.find()) {
                    for(int i=1; i<= matcher.groupCount(); i++) {
                        if(matcher.group(i) != null && matcher.group(i).length() > 0) {
                            len = matcher.group(i).length();

                            String ss = matcher.group(i);
                            if(getString(ss) != null) {
                                // ss is string 
                                String str1 = ss.replace("\\r\\n", " ");
                                row.add(str1);
                            } else {
                                // ss is number or decimal 
                                row.add(matcher.group(i));
                            }
                        }
                    }
                }
                int max = getMax(row);

                for(int i=0; i<row.size(); i++){
                    String item = row.get(i);
                    String newStr = getString(item);
                    if(newStr != null) {
                        String paddedStr = rightPad(newStr, max, newStr.length());
                        if(i < row.size() - 1)
                            out.write(paddedStr + " ");
                        else
                            out.write(paddedStr);
                    }else{
                        String paddedStr = leftPad(item, max, item.length());
                        if(i < row.size() - 1)
                            out.write(paddedStr + " ");
                        else
                            out.write(paddedStr);
                    }
                }
                out.write("\r\n");
            }

            out.close();
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }
    }
    public static void writeCrapToFile(){
        String fname = "./text/big.txt";
        List<String> list = new ArrayList<String>(); 
        for(int i=0; i<100000; i++){
            list.add("\"dog cat\"" + "," + "12334" + "," + "341.44" + "\n");
        } 
       Aron.writeFile(fname, list);
    }
}

