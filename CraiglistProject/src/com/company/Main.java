package com.company;

import classfile.Aron;
import classfile.Print;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    public static void main(String[] args) {
	// write your code here
        test0();
    }
    static void test0(){
        Aron.beg();
        List<String> urllist = new ArrayList<String>();
        String url = "https://vancouver.craigslist.ca/";
        List<String> fullURLList = new ArrayList<String>(); 

        String regex = "(a href=\"[^\"]*\\.html\")";
        String htmlPage = "\"([^\"]*)\"";

        Pattern p = Pattern.compile(regex);
        Pattern htmlPat = Pattern.compile(htmlPage);

        String path = "/Users/cat/myfile/github/java/CraiglistProject/src/com/company/resource/van.html";
        List<String> list  = Aron.readFile(path);
        for(String str : list){
            Matcher m = p.matcher(str);
            //Print.plb(str);
            //Print.plb(m.groupCount());
            while(m.find()){
                Print.plb(m.group());
                urllist.add(m.group());
                Matcher htmlMatch = htmlPat.matcher(m.group());
                while(htmlMatch.find()){
                    Print.plb(htmlMatch.groupCount());
                    fullURLList.add(url + htmlMatch.group(1));
                }
            }
        }
        Aron.printlnList(fullURLList);

        for(String fullURL : fullURLList){ 
            try{
                downloadContent(fullURL);
            }
            catch(IOException io){
                io.printStackTrace();
            }
        }

        Aron.end();
    }

    public static void downloadContent(String url) throws IOException{
        print("Fetching %s...", url);

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        Elements bodyContent = doc.select("#postingbody");

        for (Element content : bodyContent) {
            Print.p(content);
            Print.p(content.text());
        }

        print("\nMedia: (%d)", media.size());
        for (Element src : media) {
            if (src.tagName().equals("img"))
                print(" * %s: <%s> %sx%s (%s)",
                src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"),
                trim(src.attr("alt"), 20));
            else
                print(" * %s: <%s>", src.tagName(), src.attr("abs:src"));
        }

        print("\nImports: (%d)", imports.size());
        for (Element link : imports) {
            print(" * %s <%s> (%s)", link.tagName(),link.attr("abs:href"), link.attr("rel"));
        }

        print("\nLinks: (%d)", links.size());
        for (Element link : links) {
            print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
        }

        //--------------------------------------------------------------------------------
        boolean isFirst = true;
        String fullName = ""; 
        String imgName = ""; 
        String fullPathImg= ""; 
        Elements img = doc.getElementsByTag("img");
        for (Element el : img) {

            String src = el.absUrl("src");
            Print.p("src="+src);
            String[] arr = src.split("_");

            if(isFirst){
                fullName = arr[2]; 
                isFirst = false;
            }
            Print.p("fullName=" + fullName);
            if(arr.length == 3){
                imgName = arr[1] + "_" + fullName;
                fullPathImg = arr[0] + "_" + imgName;
                Print.p("fullPathImg=" + fullPathImg);
            }else{
                Print.p("Invalid image path format src=" + src);
            }

            Aron.printArray(arr);

            String folderPath = "/Users/cat/try/imgimg/";
            Aron.saveImage(fullPathImg, folderPath, imgName);

        }
        //--------------------------------------------------------------------------------
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }

    private static String trim(String s, int width) {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
