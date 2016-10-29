import java.io.*;
import java.lang.String;
import classfile.*; 

class PermRecursive {
    public static void main(String args[]) {
        test0_permutation();
        test1_permutation();
        test2_permutation();
        test0_permutationPrefix();
        test1_permutationPrefix();
        test2_permutationPrefix();
        test3_permutationPrefix();
        //test1();
        //test2();
    }
    
    static void test0_permutation(){
        Aron.beg();
        char[] charArr= {'a'};
        int index = 0;
        permutation(charArr, index);
        Aron.end();
    }
    static void test1_permutation(){
        Aron.beg();
        char[] charArr= {'a', 'b'};
        int index = 0;
        permutation(charArr, index);
        Aron.end();
    }
    static void test2_permutation(){
        Aron.beg();
        char[] charArr= {'a', 'b', 'c'};
        int index = 0;
        permutation(charArr, index);
        Aron.end();
    }
    static void test0_permutationPrefix(){
        Aron.beg();
        String prefix = "";
        String str = "";
        permutationPrefix(prefix, str);
        Aron.end();
    }
    static void test1_permutationPrefix(){
        Aron.beg();
        String prefix = "";
        String str = "a";
        permutationPrefix(prefix, str);
        Aron.end();
    }
    static void test2_permutationPrefix(){
        Aron.beg();
        String prefix = "";
        String str = "ab";
        permutationPrefix(prefix, str);
        Aron.end();
    }
    static void test3_permutationPrefix(){
        Aron.beg();
        String prefix = "";
        String str = "abc";
        permutationPrefix(prefix, str);
        Aron.end();
    }
    public static void test1() {
        char[] charArr= {'a', 'b', 'c'};
        int[] arr = {100};
        int inx = 0;

        System.out.println("digraph G {\n");
        permu_Graph(charArr, inx, arr);
        System.out.println("}\n");
    }
    public static void test2() {
        // Print the content on the console
        //System.out.println ("cool");
        int inx=0;
        char[] charArr= {'a', 'b', 'c'};
        //char[] charArr={};
        //permu(charArr, inx);
        //String s = removeChar("abcde", 2);
        //System.out.println ("s=" + s);

        int[][] array = { {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int col = 0;
        printUpperTriangle(array, col);
    }

    public static void permu(char[] charArr, int inx) {
        if( charArr != null) {
            if(charArr.length == inx) {
                for(int i=0; i<charArr.length; i++)
                    System.out.print(charArr[i]+" ");
                System.out.println();
            } else
                for(int i=inx; i<charArr.length; i++) {
                    char tmp = charArr[i];

//                    charArr[i] = charArr[inx];
//                    charArr[inx] = tmp;
//                    permu(charArr, inx+1);
                    Aron.swap(charArr, i, inx);

                    tmp = charArr[i];
                    charArr[i] = charArr[inx];
                    charArr[inx] = tmp;
                }
        }
    }

    public static void permu_Graph(char[] charArr, int inx, int[] arr) {
        if( charArr != null) {
            if(charArr.length == inx) {
                for(int i=0; i<charArr.length; i++)
                    System.out.print(charArr[i]+" ");
                System.out.println();
            } else {
                for(int i=inx; i<charArr.length; i++) {
                    char tmp = charArr[i];
                    charArr[i] = charArr[inx];
                    charArr[inx] = tmp;

                    permu_Graph(charArr, inx+1, arr);

                    tmp = charArr[i];
                    charArr[i] = charArr[inx];
                    charArr[inx] = tmp;
                }
            }
        }
    }
    public static void printUpperTriangle(int[][] array, int col) {
        for(int row=col; row<array.length; row++) {
            printUpperTriangle(array, col+1);
            System.out.println("[" + col + "][" + row+ "]=" + array[col][row]);
        }
    }

    //[ file=permuteJava.html title=" Generate permutation for n characters"
    // generate all permutation from given char[], e.g. ['a', 'b']
    //
    public static void permutation(char[] arr, int index){
        if(index == arr.length){
            Aron.printArray(arr);
        }else{
            if(arr != null){
                int len = arr.length;
                for(int i=index; i<len; i++){
                    Aron.swap(arr, i, index);
                    permutation(arr, index + 1);
                    Aron.swap(arr, i, index);
                } 
            }
        }
    }
    //]

    
    //[ file=permutationprefix.html title=" Generate all permutation in sorted order"
    // permutations are in sorted ordering in lexicographically
    public static void permutationPrefix(String prefix, String str){
        if(str != null){
            if(str.length() == 0){
                Print.p(prefix);
            }else{
                int len = str.length();
                for(int i=0; i<len; i++){
                    String s = str.charAt(i) + "";
                    permutationPrefix(prefix + s, remove(str, i));
                } 
            }
        }
    }
    public static String remove(String str, int index){
        String s = "";
        for(int i=0; i<str.length(); i++){
            if(i != index)
                s += str.charAt(i) + "";
        } 
        return s;
    }
    //]
}
