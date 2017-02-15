import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.io.*;
import classfile.*;
import java.util.stream.*;

import java.util.logging.Level;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


// logger, logging example, logger example, java logger
public class LoggerExample{
    private final static Logger LOGGER = Logger.getLogger(LoggerExample.class.getName());
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    public static void main(String[] args) {
        try{
            test0();
        }catch(IOException e){
        }
    }
    public static void test0() throws IOException {
        Aron.beg();

        fileTxt = new FileHandler("./text/Logging.txt");
        formatterTxt = new SimpleFormatter();
        LOGGER.setLevel(Level.INFO);
        fileTxt.setFormatter(formatterTxt);
        LOGGER.addHandler(fileTxt);

        LOGGER.info("Logging an INFO-level message {0}");
        

        Aron.end();
    }
    public static void test1(){
        Aron.beg();
        Aron.end();
    }
} 

