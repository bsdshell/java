import java.util.*;
import java.io.*;
import classfile.*;
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
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
//
import classfile.*; 

public class Tryhh{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        
        String fname = "/Users/cat/myfile/github/java";
        List<String> list = Aron.getCurrentDir(fname);
        Aron.printList(list);

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        String fname = "/Users/cat/myfile/github/java";
        List<String> list = fileList(fname);
        Aron.printList(list);

        Aron.end();
    }

    // get all files from current directory
    // return a list of absoluate paths
    // getcurrent file, 
    public static List<String> getCurrentFiles(String directoryName) {
        List<String> list = new ArrayList<String>(); 
        File directory = new File(directoryName);
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                list.add(file.getAbsolutePath());
            } 
        }
        return list;
    }

    public static List<String> fileList(String directory) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {}
        return fileNames;
    }
} 

