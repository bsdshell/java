import java.util.*;

public class AllUniqueSubPalindrome 
{
    public static void main(String[] args)
    {
        System.out.println("Palindrome With Space");
        int count = allUniqueSubPalindrome("aabaa");
        System.out.println("------------------------------------------------");
        System.out.println("count=" + count);
        count = allUniqueSubPalindrome("a");
        System.out.println("------------------------------------------------");
        System.out.println("count=" + count);
        count = allUniqueSubPalindrome("aa");
        System.out.println("------------------------------------------------");
        System.out.println("count=" + count);

        System.out.println("count=" + count);
        boolean b = isPalindrome("abc");
        System.out.println("abc=" + b);
         b = isPalindrome("aba");
        System.out.println("aba=" + b);
        b = isPalindrome("a");
        System.out.println("a=" + b);
        b = isPalindrome("ab");
        System.out.println("ab=" + b);
        b = isPalindrome("aabbccee");
        System.out.println("aabbccee=" + b);
        System.out.println("================================================");
        List<String> list = allSubString("abcdefg");
    } 
    public static boolean isPalindrome(String str) {
        boolean ret = true; 
        if( str != null){
            int len = str.length();
            for(int i=0; i<len/2 && ret; i++){
                if(str.charAt(i) != str.charAt(len-1-i)){
                    ret = false; 
                }
            }
        }
        return ret;
    }

    public static List<String> allSubString(String str) {
        List<String> list = new ArrayList<String>(); 
        int len = str.length();
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                String substr = str.substring(i, j+1);
                list.add(substr);
            }
        }
        return list;
    }
    public static int allUniqueSubPalindrome(String str) {
        Set<String> set = new HashSet<String>();
        if(str != null){
            int len = str.length();
            for(int i=0; i<len; i++){
                for(int j=i; j<len; j++){
                    String substr = str.substring(i, j+1);
                    if(!set.contains(substr) && isPalindrome(substr)){
                        set.add(substr);
                    }
                }
            }
        }
        return set.size();
    }
}
