public class longestPalindromGood{

    public static void main(String[] args) {
        mytest_1();
        mytest_2();
        mytest_3();
        mytest_4();
        mytest_5();
        mytest_6();
        mytest_7();
    }

    public static void mytest_1(){
        longestPalindrome("a");
    }

    public static void mytest_2(){
        longestPalindrome("aa");
    }

    public static void mytest_3(){
        longestPalindrome("ab");
    }

    public static void mytest_4(){
        longestPalindrome("aba");
    }

    public static void mytest_5(){
        longestPalindrome("abba");
    }

    public static void mytest_6(){
        longestPalindrome("abbaab");
    }

    public static void mytest_7(){
        longestPalindrome("abbaabcc");
    }

    public static void longestPalindrome(String str){
        String newStr = addChar(str);
        int len = newStr.length();

        int[] p = new int[newStr.length()];

            int maxlen = 0;
            int center = 0;
            for (int i = 0; i < len; i++) {

                int lReflection = 2 * center - i;
                int left = center - maxlen;
                int right = center + maxlen;
                if (center - maxlen < lReflection && lReflection < center) {
                    // contain the
                    if (left < lReflection - p[lReflection] && lReflection + p[lReflection] < center) {
                        p[i] = p[lReflection];
                    } else {
                        int dist = right - i < i - left ? right - i : i - left;
                        while (i - dist >= 0 && i + dist <= len - 1 && newStr.charAt(i + dist) == newStr.charAt(i - dist)) {
                            if (dist >= maxlen) {
                                maxlen = dist;
                                p[i] = dist;
                                center = i;
                            }
                            p[i] = dist;
                            dist++;
                        }
                    }
                } else {
                    int k = 1;
                    while (i + k <= len - 1 && i - k >= 0 && newStr.charAt(i - k) == newStr.charAt(i + k)) {
                        p[i] = k;
                        if (k >= maxlen) {
                            maxlen = k;
                            center = i;
                        }
                        k++;
                    }
                }
            }

        for (int i = 0; i < len; i++) {
            System.out.println("p[" + i + "]=" + p[i] + "=[" + newStr.charAt(i) + "]");
        }
        System.out.println("");
    }

    public static String addChar(String str){
        String newStr = "";
        if(str != null) {
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if (i < len - 1)
                    newStr += str.charAt(i) + "#";
                else
                    newStr += str.charAt(i);
            }
            System.out.println(newStr);
        }
        return newStr;
    }
}
