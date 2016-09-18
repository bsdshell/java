import java.util.*;
import java.io.*;
import classfile.*;

public class TryCountChar {
    public static void main(String[] args) {
        test0();
        test2();
    }
    public static void test0() {
        Aron.beg();
        String str = "produced";
        int num = countChar(str, 'o'); 
        Print.p(num);
        Aron.end();
    }
    static void test2(){
        Aron.beg();
        List<String> list = readFile("./Try1.java");
        int count = 0;
        for(String s : list){
            count += countChar(s, 'a');
        }
        Print.p(count);

        Aron.end();
    } 
    public static List<String> readFile(String fileName) {
        List<String> list = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            String str;
            while((str = in.readLine()) != null) {
                list.add(str.trim());
            }
            in.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
        return list;
    }
    public static int countChar(String str, char ch){
        int c = 0;
        for(int i=0; i<str.length(); i++){
            if(ch == str.charAt(i))
                c++;
        } 
        return c;
    }
}

