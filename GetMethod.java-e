import java.util.*;
import java.io.*;
import classfile.*;
import java.lang.reflect.*;

class GetMethod{
    public void foo() { }
    public String baz() {
        return "";
    }
    //[ file=getmethod.html title=""
    public static void main(String args[]) {
        try {
            Class c = GetMethod.class;
            Method[] m = c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++)
                System.out.println(m[i].toString());
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
    //]
}

