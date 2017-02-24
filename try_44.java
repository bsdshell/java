import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class try_44 {
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0() {
        Aron.beg();

        try {
            FileInputStream fstream = new FileInputStream("./text/file99.txt");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                // Print the content on the console
                Print.pbl(strLine);
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {
            //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        String file = "./text/file99.txt";
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            for(String line; (line = br.readLine()) != null;){
                System.out.println("[" + line + "]");
            }
        }catch(IOException io){
        }

        Aron.end();
    }
}

