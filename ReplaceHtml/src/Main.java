import classfile.Print;
import classfile.Aron;
import classfile.Test;
import classfile.Ut;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

final class XAron{
    public static FilenameUtils filenameUtils;
}



public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
//        test0();
//        test1();
//        test2();

        test3();
    }

    static void test0() {
        Aron.beg();

        //  <!-- Column 2 start -->
        //  <ul>
        //  middle
        //  </ul>
        //  <!-- Column 2 end -->


        Pattern patternStart = Pattern.compile("<!-- Column 2 start -->");
        Pattern patternEnd = Pattern.compile("<!-- Column 2 end -->");


        String fName = "/Users/cat/myfile/github/java/text/ht";
        List<String> fileList = Aron.getCurrentFiles(fName);
        for (String name : fileList) {
            Print.pbl("name=" + name);

            List<String> lineList = Aron.readFileWithWhiteSpace(name);
            List<String> topList = new ArrayList<String>();
            List<String> middleList = new ArrayList<String>();
            List<String> bottomList = new ArrayList<String>();
            int flag = 0;
            for (int i = 0; i < lineList.size(); i++) {
                Matcher matcherStart = patternStart.matcher(lineList.get(i));
                Matcher matcherEnd = patternEnd.matcher(lineList.get(i));

                if (matcherStart.find()) {
                    Print.pbl(matcherStart.group());
                    Print.pbl(lineList.get(i));
                    flag = 1;
                }else if(matcherEnd.find()){
                    flag = 2;
                }else{
                    if(flag == 0){
                        topList.add(lineList.get(i) + "\n");
                    }else if(flag == 1){
                        middleList.add("middle" + "\n");
                    }else if(flag == 2){
                        bottomList.add(lineList.get(i) + "\n");
                    }
                }
            }
            middleList.add(0, "<!-- Column 2 start -->\n          <ul>" + "\n");
            middleList.add("</ul>\n<!-- Column 2 end -->" + "\n");

            List<String> bigList = Aron.mergeListsDuplicate(topList, Aron.mergeListsDuplicate(middleList, bottomList));
            Aron.printListLn(bigList);
            Aron.line();

            String newName = FilenameUtils.getFullPath(name) + "new/" + FilenameUtils.getName(name);

            Print.pbl("newName" + newName);
            Aron.writeFile(newName, bigList);

        }
        Aron.end();
    }
    static void test1(){
        Aron.beg();

        List<String> list1 = new ArrayList<>(Arrays.asList("cat", "dog", "cow"));
        List<String> list2 = new ArrayList<>(Arrays.asList("cat1", "dog1", "cow1"));

        List<String> list3 = new ArrayList<>(Arrays.asList("do the follows", "different from", "exchange for", "dog"));
        List<String> list4 = new ArrayList<>(Arrays.asList("withdraw", "negotiation", "withdrawal-none", "dog"));

        List<String> bigList = Aron.mergeListsDuplicate(list3, list4);
        Aron.printList(bigList);
        Ut.l();
        List<String> bigList1 = Aron.mergeListsUnique(list3, list4);
        Aron.printList(bigList1);

        Aron.end();
    }
    static void test2(){
        Aron.beg();
        // immutable list
        List<String> list1 = Arrays.asList("cat1", "dog1", "cow1");
        List<String> list2 = Arrays.asList("cat2", "dog2", "cow2");
        List<String> list = take(0, list1);
        Aron.printList(list);
        Test.t(list.size() == 0);

        List<String> biglist = take(1, list1);
        Aron.printList(biglist);
        Test.t(biglist.size() == 1);

        List<String> biglist1 = take(3, list1);
        Aron.printList(biglist1);
        Test.t(biglist1.size() == 3);

        List<String> biglist2 = take(4, list1);
        Aron.printList(biglist2);
        Test.t(biglist2.size() == 3);


        Aron.end();
    }
    static void test3(){
        Aron.beg();
        // immutable list
        List<String> list1 = Arrays.asList("cat1", "dog1", "cow1");
        List<String> list2 = Arrays.asList("cat2", "dog2", "cow2");

        List<String> bigList = drop(0, list1);
        Test.t(bigList.size() == 3);

        List<String> bigList1 = drop(1, list1);
        Test.t(bigList1.size() == 2);

        List<String> bigList2 = drop(3, list1);
        Test.t(bigList2.size() == 0);

        List<String> bigList3 = drop(4, list1);
        Test.t(bigList3.size() == 0);

        Aron.end();
    }

    static <T> List<T> take(int n, List<T> list){
        if(n <= list.size())
            return list.subList(0, n);
        else
            return list;

    }
    static <T> List<T> drop(int n, List<T> list){
        if(n <= list.size()){
            return list.subList(n, list.size());
        }else{
            return new ArrayList<T>();
        }
    }

    static String getName(String fileName){
        return FilenameUtils.getName(fileName);
    }
}
