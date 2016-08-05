import java.util.*;
import java.io.*;
import classfile.*;

//[ file=throw.html title=""
// User-defined Exception
class BigException extends Exception{
    public BigException(String msg){
        super(msg);
    }
}

class SmallException extends Exception{
    public SmallException(String msg){
        super(msg);
    }
}


public class ExceptionExample{
    public static void main(String[] args) {
        test0();
        test1();
        test2();
    }
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
    
    static void test1(){
        Aron.beg();
        openFile1("text/myfile1.txt");
        Aron.end();
    }
    
    static void test2(){
        Aron.beg();
        sizeMatter(20);
        sizeMatter(1000);
        sizeMatter(-1000);
        Aron.end();
    } 

    static void sizeMatter(int n){
        try{
            if(n > 100){
                throw new BigException("Too big BigException");
            }else if(n < -100){
                throw new SmallException("Too small SmallException");
            }
        }catch(BigException e){
            Print.p(e.getMessage());
        }catch(SmallException e){
            Print.p(e.getMessage());
        }
    }
    static void openFile(String fName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fName));
        String line = null;
        while( (line = br.readLine()) != null){
            Print.pl(line);
        }
        throw new IOException("Yep, throw IOException");
    }

    static void openFile1(String fName) {
        try{
            BufferedReader br = new BufferedReader(new FileReader(fName));
            String line = null;
            while( (line = br.readLine()) != null){
                Print.pl(line);
            }
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
    //]
} 
