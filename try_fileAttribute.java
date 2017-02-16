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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

//
import classfile.*; 

public class try_fileAttribute{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        String file = "/Users/cat/myfile/github/java";
        Path path = Paths.get(file);
        BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

        System.out.println("creationTime: " + attr.creationTime());
        System.out.println("lastAccessTime: " + attr.lastAccessTime());
        System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

        System.out.println("isDirectory: " + attr.isDirectory());
        System.out.println("isOther: " + attr.isOther());
        System.out.println("isRegularFile: " + attr.isRegularFile());
        System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
        System.out.println("size: " + attr.size());

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

