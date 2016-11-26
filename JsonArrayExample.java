import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Iterator;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;
import classfile.*;

/*
gx https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple/1.1
<!-- https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple -->
<dependency>
    <groupId>com.googlecode.json-simple</groupId>
    <artifactId>json-simple</artifactId>
    <version>1.1</version>
</dependency>
*/


// *j-json-example-array-object*   *json-example*
public class JsonArrayExample{
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        test0();
        Ut.l();
        test1();
        Ut.l();
        test2();
        Ut.l();
        test3();
        Ut.l();
        test4();
    }
    static void test0(){
        Aron.beg();

        JSONParser parser = new JSONParser();
        try {
            // *j-json-read-file*
            Object obj = parser.parse(new FileReader("/Users/cat/myfile/github/java/text/file1.txt")); 
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("Name");
            String author = (String) jsonObject.get("Author");
            JSONArray companyList = (JSONArray) jsonObject.get("Company List");
 
            System.out.println("Name: " + name);
            System.out.println("Author: " + author);
            System.out.println("\nCompany List:");
            Iterator<String> iterator = companyList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Aron.end();
    }
    static void test1(){
        Aron.beg();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/cat/myfile/github/java/text/jsonobj.txt")); 
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("name");
            Print.pbl("name=" + name);
            JSONObject jsonObj = (JSONObject)jsonObject.get("obj");
            String age = (String)jsonObj.get("age");
            Print.pbl(age);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aron.end();
    }

    static void test2(){
        Aron.beg();

        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/cat/myfile/github/java/text/jsonArray.txt")); 
 
            JSONObject jsonObject = (JSONObject) obj;
 
            String name = (String) jsonObject.get("name");
            Print.pbl("name=" + name);
            JSONObject jsonObj = (JSONObject)jsonObject.get("product");
            String age = (String)jsonObj.get("age");
            Print.pbl(age);
            JSONArray jsonArray = (JSONArray)jsonObject.get("array"); 

            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                Print.pbl(iterator.next().get("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aron.end();
    } 

    static void test3(){
        Aron.beg();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/cat/myfile/github/java/text/jsonObjObj.txt")); 
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray)jsonObject.get("product"); 
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                Print.pbl(iterator.next().get("id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Aron.end();
    } 

    static void test4(){
        Aron.beg();
        listAllCategories();
        Aron.end();
    } 

    public static void listAllCategories(){
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("/Users/cat/myfile/github/java/text/json_product.txt")); 
 
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonArray = (JSONArray)jsonObject.get("products"); 
            Iterator<JSONObject> iterator = jsonArray.iterator();
            while (iterator.hasNext()) {
                JSONObject currJson = iterator.next(); 
                Print.pbl(currJson.get("id"));
                Print.pbl(currJson.get("name"));
                Print.pbl(currJson.get("category"));
                Ut.l();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

