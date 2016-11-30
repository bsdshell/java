package MyApp;

import classfile.Aron;

import java.util.ArrayList;
import java.util.List;


public class App{
    public static void main(String[] args) {
//        test00_tokenize();
//        test0_tokenize();
//
//        test1_tokenize();
//
//        test11_tokenize();
//        test2_tokenize();
//        test22_tokenize();
//        test3_tokenize();
//        test4_tokenize();

        test0_tokenize2();
    }
    static void test00_tokenize(){
        Aron.beg();
        String str = "<a>b";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test0_tokenize(){
        Aron.beg();
        String str = "<a>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test11_tokenize(){
        Aron.beg();
        String str = "<b>c</b>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test1_tokenize(){
        Aron.beg();
        String str = "<a>b</a>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test2_tokenize(){
        Aron.beg();
        String str = "<na>da</na>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test22_tokenize(){
        Aron.beg();
        String str = "<name>a</name>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test3_tokenize(){
        Aron.beg();
        String str = "<name>david</name><addr>abc</addr>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    static void test4_tokenize(){
        Aron.beg();
        String str = "<name>david</name>"
                +"<addr>abc"
                +"<phone>cc</phone>"
                +"<dog>dog</dog>"
                +"</addr>";
        List<String> list = tokenize(str);
        Aron.printList(list);

        Aron.end();
    }
    public static char lookAhead(String str, int index){
        return str.charAt(index + 1);
    }

    //[ file=tokenizestr.html title=""
    /**
     * tokenize xml file like format.
     * read character one by one and feed it to state machine.
     * if token is found, add to a list. Otherwise terminate
     * the process and return null.
     * for example, <name>david</name> => [<name>, david, </name>]
     *
     * @param strChar xxx
     *
     * @return list of tokens if all tokens are valid, otherwise return null
     */
    public static List<String> tokenize(String strChar){
        List<String> list = new ArrayList<String>();
        int state = 0;
        int curr = state;
        String str = "";
        boolean isValid = true;
        for(int i=0; i<strChar.length() && isValid; i++){
            if(curr == 0){
                if(str.length() > 0){
                    list.add(str);
                    str = "";
                }

                if(strChar.charAt(i) == '<'){
                    str += strChar.charAt(i);
                    curr = 1;
                }else if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                    curr = 2;
                    if(i + 1 < strChar.length() && lookAhead(strChar, i) == '<'){
                        curr = 0;
                    }
                }else{
                    isValid = false;
                }
            }else if(curr == 2){
                if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                    curr = 2;
                    if(i + 1 < strChar.length() && lookAhead(strChar, i) == '<'){
                        curr = 0;
                    }
                }else{
                    isValid = false;
                }
            }else if(curr == 1){
                if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                    curr = 3;
                }
                else if(strChar.charAt(i) == '/'){
                    str += strChar.charAt(i);
                    curr = 4;
                }else{
                    isValid = false;
                }
            }else if(curr == 3){
                if(strChar.charAt(i) == '>'){
                    str += strChar.charAt(i);
                    curr = 5; // final
                    curr = 0;
                }else if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                    curr = 3;
                }else{
                    isValid = false;
                }
            }else if(curr == 4){
                if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                    curr = 7;
                }else{
                    isValid = false;
                }

            }else if(curr == 7){
                if('a' <= strChar.charAt(i) && strChar.charAt(i) <= 'z'){
                    str += strChar.charAt(i);
                }else if(strChar.charAt(i) == '>'){
                    str += strChar.charAt(i);
                    curr = 8; // final
                    list.add(str);
                    str = "";
                    curr = 0;
                }else{
                    isValid = false;
                }
            }
        }

        if(curr == 2){
            if(str.length() > 0){
                list.add(str);
                str = "";
            }
        }

        return isValid ? list : null;
    }
    //]

    // gx /Users/cat/myfile/github/math/StateMachine2.png
    public static List<String> tokenize2(String strChar){
        List<String> list = new ArrayList<String>();
        int state = 0;
        int curr = state;
        String str = "";
        boolean isValid = true;
        int len = strChar.length();
        for(int i=0; i<len && isValid; i++){
            char currChar = strChar.charAt(i);
            if(currChar != ' '){
                if(curr == 0){
                    if(currChar == '['){
                        list.add(currChar + "");
                        curr = 1;
                    }
                }else if(curr == 1){
                    if(currChar == '['){
                        list.add(currChar + "");
                    }else if(currChar == ']'){
                        curr = 3;
                        list.add(currChar + "");
                    }else if(Character.isLetterOrDigit(currChar)){
                        curr = 2;
                        str += currChar + "";
                        if(i < len - 1){
                            if(lookAhead(strChar, i) == ']' || lookAhead(strChar, i) == '['){
                                list.add(str);
                                str = "";
                            }
                        }
                    }
                }else if(curr == 2){
                    if(Character.isLetterOrDigit(currChar)){
                        str += currChar + "";
                        if(i < len - 1){
                            if(lookAhead(strChar, i) == ']' || lookAhead(strChar, i) == '['){
                                list.add(str);
                                str = "";
                            }
                        }
                    }else if(currChar == ']'){
                        curr = 3;
                        list.add(currChar + "");
                    }else if(currChar == '['){
                        curr = 1;
                        list.add(currChar + "");
                    }
                }else if(curr == 3){
                    if(currChar == ']')
                        list.add(currChar + "");
                }
            }
        }
        return list;
    }
    static void test0_tokenize2(){
        Aron.beg();
        String str = "[ 1 ]";
        List<String> list = tokenize2(str);
        Aron.printList(list, "(" );

        Aron.end();
    }
}
