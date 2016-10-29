import java.io.*;
import java.lang.String;
import java.util.*;
class Reverse {
    public static void main(String args[]) {
        Reverse(" nice! hello world  ");
    }
    public static void Reverse(String str) {
        if(str != null) {
            String s = "";
            Vector<String> vet = new Vector<String>();
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == ' ') {
                    if(!s.equals(""))
                        vet.add(s);
                    s="";
                } else
                    s = s + str.charAt(i) + "";
            }
            if(str.charAt(str.length() - 1) != ' ')
                vet.add(s);

            System.out.println(vet);
            for(int i = 0; i<vet.size(); i++)
                System.out.println(vet.get(vet.size() - 1 - i));
        }
    }
}
