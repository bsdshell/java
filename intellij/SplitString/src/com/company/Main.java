package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
    }

    // searchkey: split string, split string separated by white spaces
    public static List<String> splitString(String str) {
        List<String> list = new ArrayList<String>();
        String tmpStr = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                if (tmpStr != "") {
                    list.add(tmpStr);
                    tmpStr = "";
                    count++;
                }
            } else {
                tmpStr += str.charAt(i) + "";
            }
        }
        if (tmpStr != "") {
            list.add(tmpStr);
        }
        return list;
    }
}
