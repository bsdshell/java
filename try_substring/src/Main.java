import classfile.Aron;
import classfile.Print;
import classfile.Test;
    
public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
    }
    static void test0(){
        Aron.beg();
        String pattern = "ab";
        String inputStr = "aab";
        Test.t(Aron.matchSubtring(pattern, inputStr));

        Aron.end();
    }
    static void test1(){
        Aron.beg();

        String pattern = "a";
        String inputStr = "a";
        Test.t(Aron.matchSubtring(pattern, inputStr));


        Aron.end();
    }
    static void test2(){
        Aron.beg();

        String pattern = "a";
        String inputStr = "b";
        Test.f(Aron.matchSubtring(pattern, inputStr));


        Aron.end();
    }

    static void test3(){
        Aron.beg();

        String pattern = "aaa";
        String inputStr = "bbaabkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkaaa";
        Test.t(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }
    static void test4(){
        Aron.beg();

        String pattern = null;
        String inputStr = "bbaabaaa";
        Test.f(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }

    static void test5(){
        Aron.beg();
        String pattern = null;
        String inputStr = null;
        Test.f(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }
    static void test6(){
        Aron.beg();

        String pattern = "dog";
        String inputStr = "";
        Test.f(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }
    static void test7(){
        Aron.beg();

        String pattern = "g";
        String inputStr = "";
        Test.f(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }
    static void test8(){
        Aron.beg();

        String pattern = "";
        String inputStr = "";
        Test.t(Aron.matchSubtring(pattern, inputStr));
        Aron.end();
    }
}
