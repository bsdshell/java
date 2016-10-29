package com;

import classfile.Aron;
import classfile.Print;
import classfile.Ut;
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
//        test3();
//        test0_downloadOneRow();
//        test0_getCityAndAdID();
          test0_downloadOnePage();
    }
    static void test0_downloadOneRow(){
        Aron.beg();

        try{
            String url = "http://www.vansky.com/info/adfree/764474.html";
            String city = "cool city";
            ArrayList<String> lists = downloadOneRow(url, city);
            Aron.printList(lists);
        }
        catch(IOException io){
            io.printStackTrace();
        }

        Aron.end();
    }

    static void test0_getCityAndAdID(){
        Aron.beg();
        //String path = "http://localhost/tiny3/test/2.html";
        String path = "http://www.vansky.com/info/ZFBG08.html?page=1&location=&direct=&title=";
        
        try{
            Print.pbl("path=" + path);
            getCityAndAdID(path); 
        }catch(IOException io){
            io.printStackTrace();
        }
        Aron.end();
    }

    // URL: http://localhost/tiny3/file.html
    static void test0_downloadOnePage(){
        Aron.beg();
        String header = "<html><head><meta charset=\"UTF-8\"></head><body>";
        String tail = "</body></html>";
        String path = "/Users/cat/myfile/github/java/CraiglistProject/src/com/company/resource/html";

        List<String> urlList = new ArrayList<String>(); 

        urlList.add("http://www.vansky.com/info/ZFBG08.html?page=3&location=&direct=&title=");

        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();

        // get multiple pages, and merge to list
        for(String url : urlList){ 
            List<ArrayList<String>> lists = downloadOnePage(url);
            list2d.addAll(lists);
        }

        //Aron.printList2dArr(list2d);

        List<String> htmlList = new ArrayList<String>(); 
        htmlList.add(header);
        for(ArrayList<String> list : list2d){

           // city, name, phone, content
           String oneRow = htmlTemplate(list); 
           Print.pbl(oneRow);
           htmlList.add(oneRow);
           Ut.l();
        }
        htmlList.add(tail);
        
        String fileName = "/Library/WebServer/Documents/tiny3/file.html";
        Aron.writeFile(fileName, htmlList);

        Aron.end();
    } 
    
    static void test3(){
        Aron.beg();
        String header = "<html><head><meta charset=\"UTF-8\"></head><body>";
        String tail = "</body></html>";
        String path = "/Users/cat/myfile/github/java/CraiglistProject/src/com/company/resource/html";
        List<String> urlList= Aron.listFile(path);
        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();

        // get multiple pages, and merge to list
        for(String url : urlList){ 
            List<ArrayList<String>> lists = downloadOnePage(url);
            list2d.addAll(lists);
        }

        //Aron.printList2dArr(list2d);
        List<String> htmlList = new ArrayList<String>(); 
        htmlList.add(header);
        for(ArrayList<String> list : list2d){

           // city, name, phone, content
           String oneRow = htmlTemplate(list); 
           Print.pbl(oneRow);
           htmlList.add(oneRow);
           Ut.l();
        }
        htmlList.add(tail);
        
        String fileName = "/Library/WebServer/Documents/tiny3/file.html";
        Aron.writeFile(fileName, htmlList);

        Aron.end();
    } 
    
//    static List<ArrayList<String>> getHtmlInfo(){
//
//        List<String> htmlRowList = new ArrayList<String>(); 
//        String vanskyURL = "http://www.vansky.com/info/";
//        String vansky = "(adfree\\/\\d{6}\\.html)";
//        String regex = "(a href=\"[^\"]*\\.html\")";
//        String htmlPage = "\"([^\"]*)\"";
//
//        //Pattern htmlPat = Pattern.compile(htmlPage);
//        Pattern htmlPat = Pattern.compile(vansky);
//        Set<String> set = new HashSet<String>();
//
//        String path = "/Users/cat/myfile/github/java/CraiglistProject/src/com/company/resource/vansky.html";
//
//        List<String> list  = Aron.readFile(path);
//        for(String str : list){
//            Matcher htmlMatch = htmlPat.matcher(str);
//                while(htmlMatch.find()){
//                    String fullURL = vanskyURL + htmlMatch.group(1);
//                    set.add(fullURL);
//                }
//        }
//
//        List<String> fullURLList = new ArrayList<String>(set);
//        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();
//        for(String fullURL : fullURLList){ 
//            try{
//                ArrayList<String> htmlRow = downloadOneRow(fullURL);
//                list2d.add(htmlRow);
//                Aron.printList(htmlRow);
//                Ut.l();
//            }
//            catch(IOException io){
//                io.printStackTrace();
//            }
//        }
//        return list2d;
//
//    }
    
    public static String htmlTemplate(ArrayList<String> list){
        String html = "";
        for(String s : list){
            html += "<h1>" + s + "</h1>";
        }
        html += "<br>";
        return html;
    }

    public static List<ArrayList<String>> downloadOnePage(String htmlPath){
        String vanskyURL = "http://www.vansky.com/info/";

        List<ArrayList<String>> list2d = new ArrayList<ArrayList<String>>();

            try{
                List<ArrayList<String>> lists = getCityAndAdID(htmlPath); 
                for(ArrayList<String> list : lists){
                    String adURL = vanskyURL + list.get(1);    
                    Print.pbl("adURL=" + adURL);

                    // add URL and city
                    list2d.add(downloadOneRow(adURL, list.get(0)));
                }

            }
            catch(IOException io){
                io.printStackTrace();
            }

        return list2d;
    }

    // <city, adID>
    // <city, adID>
    public static List<ArrayList<String>> getCityAndAdID(String url) throws IOException{
        List<ArrayList<String>> cityAdList2d = new ArrayList<ArrayList<String>>(); 

        Document doc = Jsoup.connect(url).get();
        Print.p("cityURL=" + url);
        Elements elementList = doc.select("tr.freeAdPadding").select("td.adph-font");
        Elements adFreeList = doc.select("tr.freeAdPadding").select("td.hidden-xs").select("div");
        //<td class="hidden-xs">
        //<div class="adph-font" style="white-space: nowrap;" href="adfree/802548.html" target="_blank">
        //房东
        //</div>
        //<div class="adsContentFont" style="color: #FA7011;">
        //9小时前
        //</div>
        //</td>

        if(elementList == null){
            Print.p("elementList is null");
            System.exit(0);
        }else{
            List<String> list = new ArrayList<String>(); 

            for(int i=0; i<adFreeList.size(); i++){
                if(adFreeList.get(i).hasAttr("href"))
                    list.add(adFreeList.get(i).attr("href"));
            }
            
            if(list.size() == elementList.size()){
                for(int i=0; i<list.size(); i++){
                    Print.pbl(elementList.get(i).text());
                    Print.pbl(list.get(i));
                    ArrayList<String> ll = new ArrayList<String>(); 

                    ll.add(elementList.get(i).text());
                    ll.add(list.get(i));
                    cityAdList2d.add(ll);
                }
            }else{
                Print.pbl("ERROR=" + "Number of cities and Number of ads are not matched");
                System.exit(0);
            }
        }
        return cityAdList2d;
    }
    public static List<String> getAllURL(String htmlPath){
        List<String> fullURLList = new ArrayList<String>(); 
        String vanskyURL = "http://www.vansky.com/info/";
        String particleURL = "(adfree\\/\\d{6}\\.html)";

        Pattern patternRegex = Pattern.compile(particleURL);
        List<String> list  = Aron.readFile(htmlPath);
        for(String str : list){
            Matcher htmlMatch = patternRegex.matcher(str);
                while(htmlMatch.find()){
                    //Print.pbl(htmlMatch.groupCount());
                    //Print.pbl(vanskyURL + htmlMatch.group(1));
                    fullURLList.add(vanskyURL + htmlMatch.group(1));
                }
        }
        return fullURLList;
    }


    /**
    * @param url  http://www.vansky.com/info/adfree/769897.html
    * @param city city in an Ad http://www.vansky.com/info/ZFBG08.html?page=1&location=&direct=&title=  
    * @return [city, name, phone, content]
    */
    public static ArrayList<String> downloadOneRow(String url, String city) throws IOException{
        print("Fetching %s...", url);
        ArrayList<String> htmlList = new ArrayList<String>(); 

        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href]");
        Elements media = doc.select("[src]");
        Elements imports = doc.select("link[href]");
        Elements vanContent = doc.select("div.ctent").select("p:not([class])");
        Element headerContent = doc.select("div.contentheader").select("div.cell-h").first();
        Elements contactConents = doc.select("div.contactrow").select("div.col-md-12");

        Element email = doc.select("div.col-md-7").select("a[href]").first();

        // not working
        //Element addr = doc.select("div.col-md-12").first();
        //
        //<div class="col-md-12">
        //地&nbsp;&nbsp;&nbsp;&nbsp;址： Buckingham Dr.&nbsp;&nbsp;&nbsp;&nbsp;
        //<a href="https://maps.google.ca/maps?q=Buckingham Dr." target="_new">
        //<button class="btn btn-primary"><span class="icon-map2"></span> 看地图 </button></a>
        //</div>
        //
        //<div class="col-md-7">
        //邮&nbsp;&nbsp;&nbsp;&nbsp;箱：
        //<a href="mailto:trabcca@gmail.com">trabcca@gmail.com</a>
        //</div>
        //<tr class="freeAdPadding">
        //<td>
        //<img class="lazy" data-src="/usermedia/43802/160531142105_pic4.JPG" width="56" height="42" />
        //</td>
        //<td style="">
        //<a class=" adsTitleFont" href="adfree/726342.html" target="_blank">
        //列治文south arm区一房一厅出租/租金950每月
        //</strong>
        //</a>
        //<div class="hidden-xs adsContentFont">
        //列治文Ryan Road(South arm 区）一房一厅全卫生间出租
        //独立出入，交通方便，环境安...
        //</div>
        //</td>
        //<td class="adph-font">
        //Richmond
        //</td>
        //<td class="hidden-xs">
        //<div class="adph-font" style="white-space: nowrap;" href="adfree/726342.html" target="_blank">
        //赵同学
        //</div>
        //<div class="adsContentFont" style="color: #FA7011;">
        //46分钟前
        //</div>
        //</td>
        //</tr>

        if(contactConents.size() > 1){
            String name = contactConents.get(0).text();
            String phone = Aron.extractPhoneNumber(contactConents.get(1).text());

            htmlList.add(url);

            String content = "";
            for(Element element: vanContent){
                content += element.text();
            }

            if(email != null)
                htmlList.add(email.text());
            else
                htmlList.add("");

            htmlList.add(city);
            htmlList.add(name);
            htmlList.add(phone);
            htmlList.add(content);
        }
        return htmlList;
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
