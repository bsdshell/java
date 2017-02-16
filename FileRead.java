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
import java.io.*;
//
import classfile.*; 

// FileInputStream example, FileOutputStream example, 
// FileInputStream, FileOutputStream, read raw byte[] from file, read binary file
// read chunk file, skip file, seek file, 
class FileRead {
    public static void main(String args[]) {
//        test0();
//        test1();
        test2();
    }
    
    static void test0(){
        Aron.beg();

        try {
            // Open the file that is the first
            // command line parameter

            String fName = "/Users/cat/myfile/github/java/text/file3.txt";
            FileInputStream fstream = new FileInputStream(fName);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                System.out.println (strLine);
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {
            //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        Aron.end();
    }
    static void test1(){
        Aron.beg();

        try {
            String fName = "/Users/cat/myfile/github/java/text/file3.txt";
            File file = new File(fName);

            FileInputStream fstream = new FileInputStream(fName);
            int nbyte = 0;
            //Read File Line By Line
            byte[] arr = new byte[10];
            while ((nbyte = fstream.read(arr)) != -1) {
                for(int i=0; i<nbyte; i++){
                    Print.pbl(arr[i]);
                } 
                String str = new String(arr);
                Print.pbl(str + " size=" + nbyte);
            }
            //Close the input stream
            fstream.close();
        } catch (Exception e) {
            //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
        Aron.end();
    }
    
    static void test2(){
        Aron.beg();
        String currDir = "/Users/cat/myfile/github/java";
        List<String> list = Aron.getCurrentDirs(currDir);
        Aron.printList(list);
        List<String> flist = Aron.getCurrentFiles(currDir);
        Ut.l();
        Aron.printList(flist);

        Aron.end();
    }
}
