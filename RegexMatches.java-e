//[ java regular expression example ]//
//[ java regular expression tutorial ]//

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches
{
    public static void main( String args[] ){
    String pattern = "([a-z]+).([a-zA-Z-]+)(/)";
    String[] strArr = {
                    "www.google.com/search?q=goog/nice",
                    "www.google.com/search?q=goog",
                    "www.google.com/search?q=goog",
                    "http://www.google.com/search?q=goog",
                    "http://www.google.msn.ca/search?q=goog",
                    "http://www.google.msn.ca/a/b/c/d"
                    };

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);
        for(int i=0; i<strArr.length; i++)
        {
            Matcher mat = r.matcher(strArr[i]);
            if(mat.find())
            {
                //System.out.println("Found value: " + mat.group(0) );
                System.out.println("Found value: " + mat.group(1) );
                //System.out.println("Found value: " + mat.group(2) );
                //System.out.println("Found value: " + mat.group(3) );
            }
        }
			
   }
}
