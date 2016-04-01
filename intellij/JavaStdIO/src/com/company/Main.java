package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        //stdioExample();
        HashMap<String, List<String>> map = readFileToMap("src/com/company/input.txt");
        String str = "dog";
    }

    public static void stdioExample() {
        try{


            BufferedReader br =
                    new BufferedReader(new FileReader("src/com/company/input.txt"));
            String input;

            while((input=br.readLine())!=null){
                System.out.println(input);

                String[] array = input.split(":");
                String[] vArray = array[1].split("\\s+");
                List<String> list = new ArrayList<String>(Arrays.asList(vArray));


            }

        }catch(IOException io){
            io.printStackTrace();
        }
    }

    public static HashMap<String, List<String>> readFileToMap(String fileName){
        HashMap<String, List<String>> map = new LinkedHashMap<String, List<String>>();
        try{
            BufferedReader br =
                    new BufferedReader(new FileReader(fileName));
            String input;

            while((input=br.readLine())!=null){
                System.out.println(input);

                String[] array = input.split(":");
                String[] vArray = array[1].trim().split("\\s+");
                List<String> list = new ArrayList<String>(Arrays.asList(vArray));
                if(array.length == 2){
                    map.put(array[0], list);
                }
            }

        }catch(IOException io){
            io.printStackTrace();
        }
        return map;
    }
}
