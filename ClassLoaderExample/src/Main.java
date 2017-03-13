import classfile.Print;
import classfile.Aron;

import java.util.List;


/**
 * class loader example, load all jar file paths, jar path, loader jar, jar loader
 * class file path, class path, all class file, all class paths
 * systemloader, system loader, system class loader, systemclass loader,
 * systemclassloader, loader system, loader class system
 *
 */
public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
    }
    static void test0(){
        Aron.beg();

        List<String> list = Aron.systemClassLoader();
        Aron.printListLn(list);

        Aron.end();
    }
}
