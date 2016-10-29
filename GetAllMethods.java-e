import java.io.*;
import java.lang.String;
import java.util.*;
import java.lang.reflect.*;

import classfile.*;

// get all methods, all method, method signature
public class GetAllMethods{
    public static void main(String[] args) {
        //Method method = Test.getClass().getMethod();
        //Parameter para = new CachingParameter();

//        Class<String> clz = String.class;
//        for (Method m : clz.getDeclaredMethods()) {
//           System.err.println(m.getName());
//           for (Parameter p : m.getParameters()) {
//              System.err.println("  " + p.getName());
//           }
//        }

        Class<GetAllMethods> clz = GetAllMethods.class;
        for (Method m : clz.getDeclaredMethods()) {
           System.err.println(m.getName());
           for (Parameter p : m.getParameters()) {
              System.err.println("  " + p.getName());
           }
        }

        for(Method m : GetAllMethods.class.getMethods()) {
            Class<?>[] parameterTypes = m.getParameterTypes();
            for(Class<?> t : parameterTypes){
              System.out.println("type:" + t.getName());
            }
            Class<?> returnType = m.getReturnType();
            // funny stuff goes here
        }
    }
    static void print(String str1, int num){
    }
    static void test0(){
        Aron.beg();
        Aron.end();
    }
} 
