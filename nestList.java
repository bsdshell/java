import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

// nest list 
public class nestList
{
    public static void main(String[] args)
    {
        System.out.println("nest List");
        List<List<String>> listlist = new ArrayList<List<String>>();

        for(int i=0; i<3; i++)
        {
            List<String> list = new ArrayList<String>();
            for(int j=0; j<4; j++)
            {
                list.add("["+j+"]"); 
            }
            listlist.add(list);
        }

        for(List<String> l : listlist)
        {
            for(String str: l)
            {
                System.out.print(str);
            }
            System.out.println("");
        }
    }
}
