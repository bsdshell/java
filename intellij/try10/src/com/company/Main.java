package com.company;

import java.io.Writer;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.charset.StandardCharsets;


public class Main{
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




        Writer
        Class<Main> clz = Main.class;
        for (Method m : clz.getDeclaredMethods()) {
            System.err.println(m.getName());
            for (Parameter p : m.getParameters()) {
                System.err.println("  " + p.getName() + " str=" + p.toString());
            }
        }

    }
    static void print(String str1, int num){
    }
}
