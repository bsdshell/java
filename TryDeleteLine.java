import java.util.*;
import java.io.*;
import classfile.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class TryDeleteLine {
    public static void main(String[] args) {
        //test0();
        test1();
    }
    public static void test0() {
        Aron.beg();

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        String fName = "/Library/WebServer/Documents/zsurface/html/";
        List<String> list = Aron.listFile(fName);
        for(String name : list){
            if(Aron.match("\\.html$", name)){
                Print.plb(name);
                List<String> list1 = Aron.readFile(name);
                for(String s:list1){
                    Print.p(s);
                }
            }
        }
        Aron.end();
    }
}

