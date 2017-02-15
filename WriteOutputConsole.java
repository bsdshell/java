import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.io.output.TeeOutputStream;

import classfile.*;

public class WriteOutputConsole {
    public static void main(String[] args) {
//        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();
        String fName = "./text/myfile3.txt";
        String content = "This is my file";
        Aron.writeFileBoth(fName, content);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();
        
        String fName = "./text/file33.txt";
        List<String> list = Arrays.asList("cat\n", "dog\n", "cow\n");

        Aron.writeFileBoth(fName, list);

        Aron.end();
    }
}

