import java.util.*;
import java.io.*;
import classfile.*;

public class ConnectedIsland {
    public static void main(String[] args) {
        test0();
        test1();
        test2();
        test3();
        test4();
        //test0_maxWords();
        test1_maxWords();
        test2_maxWords();
        test3_maxWords();
        test4_maxWords();
        test5_maxWords();

        test00_maxWords();
        test01_maxWords();
        test02_maxWords();
    }

    //[file=connectedisland.html title=""
    // 2:41 - 3:12
    //--------------------------------------------------------------------------------
    // [0, 1, 1, 0]
    // [0, 1, 0, 0]
    // [1, 0, 0, 1]
    // [1, 0, 1, 0]
    //
    //--------------------------------------------------------------------------------
    // w = 0, h = 0, width = 4, height = 4
    // arr[0][0] = 0
    // arr[0][1] = 1
    // arr[0][2] = 1
    // arr[0][3] ret
    // arr[0][1] = 2 ret
    // arr[-1][1] = ret
    // w = 0, h = 0
    public static int countConnection(int[][] arr, int w, int width, int h, int height) {
        if(arr != null) {
            if(arr[h][w] == 1) {
                arr[h][w] = 2;
                int right = 0, left = 0, up = 0, down = 0;
                if(w + 1 < width)
                    right =countConnection(arr, w+1, width, h, height);
                if(w - 1 >= 0)
                    left = countConnection(arr, w-1, width, h, height);
                if(h - 1 >= 0)
                    up =   countConnection(arr, w, width, h-1, height);
                if(h + 1 < height)
                    down = countConnection(arr, w, width, h+1, height);

                return right + left + up + down + 1;
            }
        }
        return 0;
    }
    public static int maxConnection(int[][] arr) {
        int max = 0;
        if(arr != null) {
            int height = arr.length;
            int width = arr[0].length;
            for(int h=0; h<height; h++) {
                for(int w=0; w<width; w++) {
                    int m = countConnection(arr, w, width, h, height);
                    if(m > max)
                        max = m;
                }
            }
        }
        return max;
    }
    //]
    public static void test0() {
        Aron.beg();

        int[][] arr2d = {
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {1, 0, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 0, 1},
        };
        int max = maxConnection(arr2d);
        Test.t(max, 5);

        Aron.end();
    }
    public static void test1() {
        Aron.beg();

        int[][] arr2d = {
            {0}
        };
        int max = maxConnection(arr2d);
        Test.t(max, 0);

        Aron.end();
    }
    public static void test2() {
        Aron.beg();

        int[][] arr2d = {
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
            {0, 0, 0, 0},
        };
        int max = maxConnection(arr2d);
        Test.t(max, 0);

        Aron.end();
    }
    public static void test3() {
        Aron.beg();

        int[][] arr2d = {
            {0, 1, 1, 0},
            {0, 1, 1, 0},
        };
        int max = maxConnection(arr2d);
        Test.t(max, 4);

        Aron.end();
    }
    public static void test4() {
        Aron.beg();

        int[][] arr2d = {
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 1},
        };
        int max = maxConnection(arr2d);
        Test.t(max, 10);

        Aron.end();
    }

    public static boolean isWord(String s) {
        String[] arr = {
            "a",
            "b",
            "e",
            "ill",
            "ball",
            "app",
            "ban",
            "cat",
            "banana",
            "ancestor",
            "scene",
            "descend",
            "descended",
            "sibling",
            "dangling"
        };
        Set<String> set = new HashSet<>(Arrays.asList(arr));
        return set.contains(s);
    }
    public static void test0_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b', 'a', 'n', 'a'},
            {'a', 'p', 'e', 'n'},
            {'a', 'p', 'p', 'a'},
            {'d', 'a', 'n', 'g'},
            {'a', 'p', 'k', 'k'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test1_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'a'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test2_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'a', 'b'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test3_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'a', 'p', 'p'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test4_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b', 'a', 'n'},
            {'a', 'n', 'a'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test5_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b', 'e', 'e'},
            {'a', 'l', 'i'},
            {'l', 'n', 'l'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<String> set = new HashSet<>();
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        int w = 0, h = 0;

        maxWords(set, uniqueSet, word, arr, h, height, w, width);
        Aron.printSet(set);
//        for(int h=0; h<height; h++){
//            for(int w=0; w<width; w++){
//                Aron.printSet(set);
//            }
//        }
        Aron.end();
    }
    public static void test00_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b'},
            {'e'},
        };
        //public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int w, int h, int width, int height){
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];
        //int w = 0, h = 0;

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                Set<String> set = new HashSet<>();
                maxWords(set, uniqueSet, word, arr, h, height, w, width);
                Aron.printSet(set);
            }
        }
        Aron.end();
    }
    public static void test01_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b', 'i', 'e', 'f'},
            {'e', 'k', 'l', 'l'},
        };
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                Set<String> set = new HashSet<>();
                maxWords(set, uniqueSet, word, arr, h, height, w, width);
                Aron.printSet(set);
            }
        }

        Aron.end();
    }
    public static void test02_maxWords() {
        Aron.beg();
        Character[][] arr = {
            {'b', 'i', 'p', 'f'},
            {'e', 'k', 'p', 'l'},
            {'k', 'a', 'l', 'l'},
        };
        Set<Integer> uniqueSet = new HashSet<>();
        StringBuffer word = new StringBuffer();

        int height = arr.length;
        int width = arr[0].length;
        boolean[][] visited = new boolean[height][width];

        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                Set<String> set = new HashSet<>();
                maxWords(set, uniqueSet, word, arr, h, height, w, width);
                Aron.printSet(set);
            }
        }

        Aron.end();
    }


    //
    // 3:23 4:49 5:19
    // word = "";
    public static void maxWords(Set<String> set, Set<Integer> uniqueSet, StringBuffer word, Character[][] arr, int h, int height, int w, int width) {
        word.append(arr[h][w]);
        int index = h*width + w;
        if(!uniqueSet.contains(index)) {
            uniqueSet.add(index);

            if(isWord(word.toString()))
                set.add(word.toString());

            if(w + 1 < width) {
                maxWords(set, uniqueSet, word, arr, h, height, w + 1, width);
            }

            if(w - 1 >= 0) {
                maxWords(set, uniqueSet, word, arr, h, height, w - 1, width);
            }

            if(h + 1 < height) {
                maxWords(set, uniqueSet, word, arr, h + 1, height, w, width);
            }

            if(h - 1 >= 0) {
                maxWords(set, uniqueSet, word, arr, h - 1, height, w, width);
            }

            if(w + 1 < width && h + 1 < height) {
                maxWords(set, uniqueSet, word, arr, h + 1, height, w + 1, width);
            }

            if(w - 1 >= 0 && h - 1 >= 0) {
                maxWords(set, uniqueSet, word, arr, h - 1, height, w - 1, width);
            }

            if(h + 1 < height && w - 1 >= 0) {
                maxWords(set, uniqueSet, word, arr, h + 1, height, w - 1, width);
            }

            if(h - 1 >= 0 && w + 1 < width) {
                maxWords(set, uniqueSet, word, arr, h - 1, height, w + 1, width);
            }
            uniqueSet.remove(h*width + w);
        }
        if(word.length() > 0)
            word.deleteCharAt(word.length()-1);
    }
}

