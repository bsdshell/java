import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

interface IDocument{
    void accept(IVisitor visitor);
}

class Html implements IDocument{
    void accept(IVisitor visitor){
        visitor.accept(this);
    }
}

class Text implements IDocument{

}

interface IVisitor{
    public void visitor(Html html);
}


public class main{
    public static void main(String[] args) {
        test0();
        test1();
    }
    public static void test0(){
        Aron.beg();
        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

