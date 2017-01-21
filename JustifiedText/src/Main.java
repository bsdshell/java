import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test0();
    }

    // Justify text in buffer
    //
    // Assumption:
    // 1. number of space between words are equal.
    // 2. pack the number of space between words are greedy
    // if the input length is less than the minimum length of justified buffer size, return error message
    //
    static String justify(String text, int length) {
        String ret = "";
        if (text != null) {
            String[] arr = text.split("\\s+");
            List<String> list = new ArrayList<String>();
            int ml = 0;

            // ml = number of non-whitespace characters
            for (String s : arr) {
                String str = s.trim();
                if (str.length() > 0) {
                    ml += str.length();
                    list.add(str);
                }
            }

            int minGap = list.size() - 1;

            // minlen = number of non-whitespace characters + number of gaps
            // e.g. text = " dog cat  "
            // minlen = 3 + 1 + 3 = 7 = length(dog) + 1(space) + length(cat)
            int minLen = ml + minGap;

            if (minLen <= length) {
                int diff = length - minLen;
                int numSpace = 0;
                if (minGap > 0)
                    numSpace = diff / minGap;

                for (int i = 0; i < list.size(); i++) {
                    if (i < list.size() - 1) {
                        ret += list.get(i) + makeSpace(numSpace + 1);
                    } else {
                        ret += list.get(i);
                    }
                }
            } else {
                System.out.print("ERROR: length is too small for the text");
            }
        } else {
            System.out.print("ERROR: text can not be null");
        }
        return ret;
    }

    static String makeSpace(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s += " ";
        }
        return s;
    }

    static void test0() {
        String str = justify(" dog cat ", 20);
        System.out.print("[" + str + "]");
    }
}
