//[ java regular expression example ]//
//[ java regular expression tutorial ]//

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;

public class ReplaceMultiString {
    public static void main( String args[] ) {
        // java regular, java regex, jregex
        Map<String, String> replacements = new HashMap<String, String>() {
            {
                put(":", "colon");
                put("#", "number_sign");
                put("$", "dollar");
            }
        };

        String input = "$dog";

        String regexp = "\\$";
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile(regexp);
        Matcher match = pattern.matcher(input);

        while(match.find()) {
            match.appendReplacement(sb, replacements.get(match.group()));
        }
        match.appendTail(sb);
        System.out.println(sb.toString());
    }
}
