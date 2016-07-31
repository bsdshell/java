import java.util.*;
import java.io.*;
import classfile.*;

public class ExceptionExample{
    public static void main(String[] args) {
        test0();
    }
    //[ file=throw.html title=""
    // throw IOException and try/catch them
    static void test0(){
        Aron.beg();

        try{
            openFile("text/myfile1.txt");
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

        Aron.end();
    }

    static void openFile(String fName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String line = null;
        while( (line = br.readLine()) != null){
            Print.pl(line);
        }
        throw new IOException("Yep, throw IOException");
    }
    //]
} 
