import classfile.Aron;
import classfile.Print;


// add local jar to Gradle
public class Main{
    public static void main(String[] args) {
        test0();
    }
    static void test0(){
        Aron.beg();

        Print.pbl("How to add local jar file to Gradle, AronLib.jar is in Lib dir");

        Aron.end();
    }
}
