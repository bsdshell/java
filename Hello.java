import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import classfile.*;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> list = new ArrayList<String>(); 
        list.add("dog");
        Aron.printList(list);
    }
}
