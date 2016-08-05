import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.*;

import classfile.*;
/**
 * Example program to list links from a URL.
 */
public class Try101 {
    public static void main(String[] args) throws IOException {
        //Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        //String url = "https://vancouver.craigslist.ca/van/roo/5713465798.html";
        //String url = "https://vancouver.craigslist.ca/rch/roo/5704455405.html";
        String url = "https://vancouver.craigslist.ca/rch/roo/5689790425.html";
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
