import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class try_Generandom{
    public static void main(String[] args) {
        test0();
    }
    public static void test0(){
        Aron.beg();

        String fName = "/Users/cat/myfile/github/java/text/random.txt";
        List<Integer> list = Aron.random(1000);
        List<String> slist = new ArrayList<String>(); 
        for(Integer n : list)
            slist.add(n + " ");

        Aron.writeFile(fName, slist);

        Aron.end();
    }
} 

