import java.io.*;
import java.lang.String;
import java.util.*;

//read file
class readFile {

    public static void main(String args[]) {
        readFile("/tmp/file33/file.txt");
    }
    public static void readFile(String fileName) {
        try {
            // searchkey: read file line by line
            BufferedReader in = new BufferedReader(new FileReader(fileName));

            String str;
            while((str = in.readLine()) != null) {
                System.out.println(str);
            }
            in.close();
        } catch(IOException io) {
            io.printStackTrace();
        }
    }
}
