import java.util.*;
import java.io.*;
import classfile.*;
import org.apache.commons.lang3.StringUtils;

public class TryTry2 {
    public static void main(String[] args) {
        Print.pbl("do");
        String s1 = StringUtils.leftPad("", 3, 'z');
        Print.pbl(s1);
        String s2 = StringUtils.leftPad("bat", 5, 'z');
        Print.pbl(s2);
    }
}

