import java.util.*;
import java.io.*;

public class RepeatedWord{
    public static void main(String[] args) {
        String str = "dog cat dog"; 
        System.out.println(firstRepeatedWord(str));
    }
    static String firstRepeatedWord(String s) {
        Set<String> set = new HashSet<String>();
        String deli = "[ .\\t;:,-]+";
        String[] words = s.split(deli);
        int len = words.length; 
        for (int j = 0; j < len; j++) {
            if (!set.contains(words[j])) {
                set.add(words[j]);
            }else {
                return words[j];
            }
        }
        return null;
    }

    static int[] mergeArrays(int[] a, int[] b) {
        int totalSize = a.length + b.length;
        int[] array = new int[totalSize];
        
        int i = 0;
        int j = 0;
        
        int index = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                array[index] = a[i];
                i++;
            } else {
                array[index] = b[j];
                j++;
            }
            index++;
        }

        while (i < a.length) {
            array[index] = a[i];
            index++;
            i++;
        }
        
        while (j < b.length) {
            array[index] = b[j];
            index++;
            j++;
        }
        return array;
    }

} 
