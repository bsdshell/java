import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

// nest list 
public class listList
{
    public static void main(String[] args)
    {
        System.out.println("nest List list of list");
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

        for(List<String> strList : listlist)
        {
            int indexlist = listlist.indexOf(strList);
            System.out.println("indexlist=" + indexlist);
            for(String str: strList)
            {
                int index = strList.indexOf(str);
                System.out.println("index="+index);
            }
            System.out.println("");
        }
    }
}
