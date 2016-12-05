import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class SortArray{
    public static void main(String[] args) {
        String[] arr = {"techie", "dangling", "cat", "scene", "ancestor", "scene", "descend", "descended", "sibling", "dangling"}; 
        List<String> list = sortArray(arr);
        Aron.printList(list);
    }
    public static List<String> sortArray(String[] arr){
        Arrays.sort(arr);
        return Arrays.asList(arr);
    }

    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

