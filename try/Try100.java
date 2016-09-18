import java.io.*;
import java.lang.String;
import java.util.*;

public class Try100{

    public static void main(String[] args) {
        test0();
        test1();
    }

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
    List<String> list = new ArrayList<String>(); 
    static String sortStr(String s) {
        char[] clist = s.toCharArray();
        Arrays.sort(clist);
        return String.valueOf(clist);
    }

    static List<String> anagrams(List<String> list, String input) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        if(list != null && input != null) {

            for(String str : list) {
                String key = sortStr(str);
                List<String> l = map.get(key);
                if(l != null) {
                    l.add(str);
                    map.put(key, l);
                } else {
                    List<String> ll = new ArrayList<String>();
                    ll.add(str);
                    map.put(key, ll);
                }
            }
        }
        return map.get(sortStr(input));
    }

        
        Map<String, String> map = new HashMap<String, String>(); 
        String str;
        
        Map<String, String> map = new HashMap<String, String>();
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println("[" + entry.getKey() + " , " + entry.getValue() + "]");
        } 
        String str;
        
        
        
        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 

        BST b1 = new BST();
        b1.insert(10);
        b1.insert(5);
        b1.insert(15);
        b1.insert(1);
        b1.insert(7); 
        String str;
        stri


        
        List<String> list = new ArrayList<String>();
        List<String> list = new LinkedList<String>();
        List<String> list = new Stack<String>();
        List<String> list = new Vector<String>();
        Queue<String> queue = new ArrayList<String>();
        Queue<String> queue = new PriorityQueue<String>(); 
        List<String> list = new ArrayList<String>(); 
    List<Integer> list = new ArrayList<Integer>(); 
    public static void test0() {
        List<String> list = new ArrayList<String>() {
            {
                add("dog");
                add("god");
                add("nice");
                add("debitcard");
                add("badcredit");
                String str = "";




                
            }
        };
        List<String> l = anagrams(list, "dog");
        if(l != null){
            for(String s : l){
                System.out.println("[" + s + "]");
            }
        }
    }

    public static void test1(){
        List<String> words = new ArrayList<String>();
        words.add("dog");
        words.add("God");
        words.add("Barack");
        words.add("Obama");

        List<String> l = anagrams(words, "dogk");
        if(l != null){
            for(String s : l){
                System.out.println("[" + s + "]");
            }
        }
    }
}
