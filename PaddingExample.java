import java.util.*;
import java.io.*;
import classfile.*;
import org.apache.commons.lang3.StringUtils;

// padding example 
// use apache common lib
// jar file /Users/cat/myfile/github/JavaLib/commons-lang3-3.5.jar
public class PaddingExample{
    public static void main(String[] args) {
        String s1 = StringUtils.leftPad("", 3, 'z');
        Print.pbl(s1);
        String s2 = StringUtils.leftPad("bat", 5, 'z');
        Print.pbl(s2);
    }
}

