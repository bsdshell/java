package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        // write your code here
        stdioExample();
    }

    public static void stdioExample() {
        try{
            BufferedReader br =
                    new BufferedReader(new FileReader("src/com/company/input.txt"));
            String input;

            while((input=br.readLine())!=null){
                System.out.println(input);
            }

        }catch(IOException io){
            io.printStackTrace();
        }
    }
}
