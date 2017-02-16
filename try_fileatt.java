import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

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

public class try_fileatt{
	public static void main(String[] args) throws IOException {

         String fName = "/Users/cat/myfile/github/java";
         List<String> list = Aron.getCurrentFiles(fName); 

         for(String s : list){
             Path file = Paths.get(s);

             Print.pbl("name=" + s);
             BasicFileAttributes basicAttr = Files.readAttributes(file, BasicFileAttributes.class);
             FileTime creationTime = basicAttr.creationTime();
             System.out.println(creationTime);

             FileTime lastAccessTime = basicAttr.lastAccessTime();
             System.out.println(lastAccessTime);
             FileTime lastModifiedTime = basicAttr.lastModifiedTime();
             System.out.println(lastModifiedTime);
            
             Ut.l();
         }
	}
}
