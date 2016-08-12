import java.util.regex.Pattern;
import java.util.regex.Matcher;

// 411-114-3475 whatever  415-3354567 what 665335-9987 cool 6653334467
public class RegexPhone {
    public static void main(String[] args) {
			
				//Pattern pattern = Pattern.compile("[0-9]{3}[-]{0,1}[0-9]{3}[-]{0,1}[0-9]{4}");
				Pattern pattern = Pattern.compile("[0-9]{3}[-]?[0-9]{3}[-]?[0-9]{4}");
				Matcher matcher = pattern.matcher("334-4467777 yes... 334666-4456 415-333-9674 whatever 4264491569");
				while(matcher.find())
				{
					System.out.println(matcher.group());
				}
    }
}

/* output
334-4467777
334666-4456
415-333-9674
4264491569
*/
