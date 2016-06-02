package com.company;

import java.io.File;

/**
 * Created by cat on 5/7/16.
 */
public class MyClass {
    void print(){
        System.out.print("mycass");

        File file = new File(".");
        String currentDirectory = file.getAbsolutePath();
        System.out.println("Current working directory : "+currentDirectory);
    }
}
