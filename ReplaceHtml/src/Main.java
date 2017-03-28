import classfile.Print;
import classfile.Aron;
import org.apache.commons.io.FilenameUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Print.p("Hello World");
        test0();
        test1();
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

            List<String> bigList = Aron.mergeLists(topList, Aron.mergeLists(middleList, bottomList));
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
        String fName = "/Users/cat/myfile/github/java/text/ht";

        Aron.end();
    }
}
