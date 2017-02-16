import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import java.util.stream.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Collections;
//
import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.io.IOException;
//
import classfile.*; 


public class try_search{
    public static void main(String[] args) {
        test0();
    }

    public static  void FileSearch(List<String> list, String pattern){
        Map<String, String> map = new HashMap<>();
        Pattern pat = Pattern.compile(pattern);

        for(String s : list){
            Matcher match = pat.matcher(s);
            if(match.find()){
                Print.pbl(s);
                break;
            }
        }
    }

    public static void test0(){
        Aron.beg();
        
        // immutable list
        List<String> list = Arrays.asList("cat", "dog", "cow");

        FileSearch(list, "at");
        FileSearch(list, "cow");
        
        Aron.end();
    }
} 

