import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

public class TryParseXML{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        String str = "/Users/cat/myfile/github/java/text/filex.txt";

        validate(str);
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
    public static boolean validate(String fname){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fname));
            String line = null;
            while( (line = br.readLine()) != null){
                Print.pbl(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return true;
    }

    public static void buildTree(Iterator<String> ite){
        if (ite.hasNext()){

            Pattern r = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
            Matcher mat = r.matcher("CAPTHEOREM");
            if(mat.find()) {
                Print.p("found=" + mat.group(0));
            }
     
            if(ite.next().equals("[")){
                    
            }
        }else{

        }
        
        
        
    }
} 

