public class CountOccurrences {
    public static void main(String[] args) {
        // write your code here
        test0();
        test1();
        test2();
        test3();
        test4();
    }
    static void test0(){
        System.out.println("---------------------------------\n");
        int num = countOccurrences("a", "a");
        System.out.println("[" + num + "]");
        System.out.println("---------------------------------\n");
    }
    static void test1(){
        System.out.println("---------------------------------\n");
        int num = countOccurrences("aa", "a");
        System.out.println("[" + num + "]");
        System.out.println("---------------------------------\n");
    }
    static void test2(){
        System.out.println("---------------------------------\n");
        int num = countOccurrences("aaa", "aa");
        System.out.println("[" + num + "]");
        System.out.println("---------------------------------\n");
    } 

    static void test3(){
        System.out.println("---------------------------------\n");
        int num = countOccurrences("aacaaa", "aa");
        System.out.println("[" + num + "]");
        System.out.println("---------------------------------\n");
    } 
    static void test4(){
        System.out.println("---------------------------------\n");
        int num = countOccurrences("aaccacc", "ac");
        System.out.println("[" + num + "]");
        System.out.println("---------------------------------\n");
    } 

    //[ file=countoccurrence.html title=""
    // count prefix occurrence
    static int countOccurrences(String str, String pattern){
        int count = 0;
        if(str == null || pattern == null)
            return 0;
        else if(str.length() == 0 || pattern.length() == 0)
            return 0;
        else {
            int start = 0;
            int k = 0;
            int len = pattern.length();
            int i = 0;
            while(i < str.length()){
                if(str.charAt(i) == pattern.charAt(k)){
                    if(k == 0)
                        start = i;
                    k++;
                    if(k == len){
                        count++;
                        k = 0;
                        i = start + 1;
                    }else{
                        i++;
                    }
                }else{
                    k = 0;
                    i = start + 1;
                    start++;
                }
            }
        }
        return count;
    }
    //]

}
