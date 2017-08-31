import java.util.*;
import java.io.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

// enum acts like a class, enum example
enum Environment {
    PROD("https://prod.domain.com:1088/"), 
    SIT("https://sit.domain.com:2019/"), 
    DEV("https://dev.domain.com:21323/");
    String str;
 
    private String url;
 
    Environment(String envUrl) {
        this.url = envUrl;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}

public class EnumCode{
    public static void main(String[] args) {
        
        for(Environment env : Environment.values()){
            System.out.println(env.getUrl());
            System.out.println("Const=" + env.PROD.getUrl());
        }
        System.out.println("kkConst=" + Environment.PROD.getUrl());
        
    }
}
