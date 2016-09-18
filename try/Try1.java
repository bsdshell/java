import java.io.*;
import java.lang.String;
import java.util.*;

public class Try1 {
    public static void main(String[] args) {

//        List<Integer> list = Arrays.asList(1, 2, 3);
        //
        //        List<ArrayList<Integer>> list2d = new ArrayList<ArrayList<Integer>>();
        //        List<ArrayList<Integer>> list2d = new ArrayList<ArrayList<Integer>>();
        //
//        List<Node> list = new ArrayList<Node>();
//

        List<String> list = new ArrayList<String>();
        List<String> list = new LinkedList<String>();
        List<String> list = new Stack<String>();
        List<String> list = new Vector<String>();
        Queue<String> queue = new ArrayList<String>();
        Queue<String> queue = new PriorityQueue<String>();

        class MyClass {
            public MyClass() {
            }
//        ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
//
//        List<Integer> list = Arrays.asList(1, 2, 3);

            public print() {
            }
        }

        import classfile.*;

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
//
//        test10();
//        test11();
//        test12();
//        test13();
        test14();
        String str;
        str.codePointCount(int beginIndex, int endIndex)
    }
    static void test3() {
        Aron.beg();
        Integer[] arr = {2, 0, 3, 0};
        partition(arr);
//        static void test4(){
//        Aron.beg();
//        Integer[] arr = {2, 0, 3};
        Aron.printArray(arr);
        Aron.end();
        String str;
    }
    static void test3() {
        Aron.beg();
        Integer[] arr = {2, 0, 3, 0};
        partition(arr);
//        static void test4(){
//        Aron.beg();
//        Integer[] arr = {2, 0, 3};
        Aron.printArray(arr);
        Aron.end();
        String str;
    }


    static void test4() {

        for(int k=0; k &lt height; k++) {
            for(int w=k; w &lt width-1-k; w++)
                array[k][w] (left to right)
                for(int h=k; h &lt height-1-k; h++)
                    array[h][width - 1 - k] (top to bottom)
                    for(int w=k; w &lt width-1-k; w++)
                        array[width-1-w][height - 1 - k] (right to left)
                        for(int h=k; h &lt height-1-k; h++)
                            array[height - 1 -h][k] (bottom to top)
                        }
        Aron.beg();
        Integer[] arr = {2, 0, 3};
        partition(arr);
        Aron.printArray(arr);
        Aron.end();
        String str = new String("dog");

        List<String> list = new ArrayList<String>();
        list.forEach(Consumer<? super E> action)
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    }
    static void test5() {
        Aron.beg();
        Integer[] arr = {0, 0, 2, 0, 0, 3, 2, 0, 3};
        partition(arr);
        Aron.printArray(arr);
        Aron.end();
        String str;
    }

    static void test6() {
        Aron.beg();
        Integer[] arr = {0, 0, 0, 0, 0};
        Aron.printArray(arr);
        Aron.end();
        String str;
        public String concat(String str)
        public String concat(String str)
        str.for(int xxx=0; xxx<10; xxx++) {
        }
        str.ArrayList<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
        String str;
        public int lastIndexOf(String str)
        String str;
        public String concat(String str)
        str.c
        List<String> list = new String<String>();
        for(String s : list) {
            Print.pl(s);
        }

        list.codePointCount(int beginIndex, int endIndex)
        List<Integer> list3 = new ArrayList<Integer>();
    }

    static void test7() {
        Aron.beg();
        Integer[] arr = {2, 3};
        Aron.printArray(arr);
        Aron.end();
str.border-left-color:
        str.codePointCount(int beginIndex, int endIndex)
        String str33 = null;
        str33.compare(String s1, String s2)

        List<String> list4 = new ArrayList<String>();
        list4.
    }


    static void partition(Integer[] arr) {
        if(arr != null) {
            int len = arr.length;
            int nonzero = len-1;
            for(int i=len-1; i >= 0; i--) {
                if(arr[i] == 0) {
                    int tmp = arr[i];
                    arr[i] = arr[nonzero];
                    arr[nonzero] = tmp;
                    nonzero--;
                }
            }
        }
    }
    static void test2() {
        Aron.beg();
        String str = "abc";
        String revStr = reverseW(str);
        System.out.println("[" + revStr + "]");
        System.out.println("[" + reverseWord(str) + "]");

        StringBuilder sb = new StringBuilder(str);
        sb.lastIndexOf(String str, int fromIndex)
        System.out.println("[" + sb.reverse() + "]");
        Aron.end();
    }

    public static void test0() {
        List<Integer> list = new ArrayList<Integer>();
        Aron.printList(list);
        String dir = "/Users/cat/myfile";
        listFileDir(dir);
    }
    public static String reverseWord(String str) {
        String ret = "";
        if(str != null) {
            for(int i=0; i<str.length(); i++) {
                ret = str.charAt(i) + ret;
            }
        }
        return ret;
        String str;
    }
    public static String reverseW(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(char c)
        sb.lastIndexOf(String str, int fromIndex)

        sblastIndexOf()
        sb.lastIndexOf(String str, int fromIndex)
        sb.lastIndexOf(String str)
        sb.append(str);
        int len = sb.length();
        for(int i=0; i<len/2; i++) {
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(len - 1 - i));
            sb.setCharAt(len - 1 - i, ch);
        }
        return sb.toString();
    }

    public static void test1() {
        String str = "123";
        str.indexOf(String str)
        str.substring(int beginIndex)

        for(int i=0; i< str.length(); i++) {
            String prefix = str.substring(0, i);
            String suffix = str.substring(i);
            System.out.println("[" + prefix + "]");
            System.out.println("[" + suffix + "]");
        }
    }

    public static List<String> listDir(String directoryName) {
        List <String> list = new ArrayList<String>();
        File directory = new File(directoryName);
        StringBuilder st = new StringBuilder();
        list.

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isDirectory()) {
                System.out.println(file.getName());
                list.add(file.getName());
            }
        }
        return list;
    }

    public static List<String> listFileDir(String directoryName) {
        List<String> list = new ArrayList<String>();
        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                listFileDir(file.getAbsolutePath());
                list.add(file.getAbsolutePath());
            }
        }
        return list;
    }

    static void test10() {
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        sll.append(4);
        sll.append(7);
        Aron.printSLL(sll.head);
        Aron.line();

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test11() {
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(1);
        Aron.printSLL(sll.head);
        Aron.line();

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test12() {
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        sll.append(4);
        Aron.printSLL(sll.head);
        Aron.line();

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }
    static void test13() {
        Aron.beg();
        SingleLinkedList sll = new SingleLinkedList();
        Aron.printSLL(sll.head);
        Aron.line();

        Node head = insert(sll.head, 3);
        Aron.printSLL(head);

        Aron.end();
    }

    static void test14() {
        Aron.beg();
        List<String> list1 =  listDir(".");
        List<String> list2 =  listFileDir(".");
        Aron.printlnList(list1);
        Aron.line();
        Aron.printlnList(list2);

        Aron.end();
    }

    //[ file=insertsortedlist.html title=""
    // Insert node to a sorted list
    public static Node insert(Node node, int n) {
        Node head = node;
        Node curr = node;
        Node prev = null;
        while(curr != null && n > curr.data) {
            prev = curr;
            curr = curr.next;
        }

        if(curr != null) {
            if(prev != null) {
                // 3, [2]<-[4]  >  [2]<-{3}<-[4]
                prev.next = new Node(n);
                prev.next.next = curr;
            } else {
                // {1} [2] > {1}<-[2]
                head = new Node(n);
                head.next = curr;
            }
        } else {
            // [2] {3}  > [2]<-{3}
            if(prev != null) {
                prev.next = new Node(n);
            } else {
                // {3}
                head = new Node(n);
            }
        }
        return head;
    }
    //]
}
