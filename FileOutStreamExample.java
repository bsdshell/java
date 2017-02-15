import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

// FileOutStream example, outputstream, output stream, write raw data to file,
// filetream filestream, stream file, write byte[] to file,
public class FileOutStreamExample {
    public static void main(String[] args) {
        test0();
    }
    public static void test0() {
        Aron.beg();

        File file = new File("./text/raw1.txt");
        String content = "write byte[] array to file";

        try (FileOutputStream fop = new FileOutputStream(file)) {
            // if file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        }

        Aron.end();
    }
}

