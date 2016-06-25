import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Stack;

public class SplitExpression{

    public static void main(String[] args) {
        test0();
    }

    //[ file=splitexp.html title=""
    public static List<String> splitExpr(String exp){
        List<String> list = new ArrayList<String>();

        StringTokenizer stoken = new StringTokenizer(exp, "+-/* ", true);
        while(stoken.hasMoreTokens()){
            String token = stoken.nextToken();
            list.add(token);
            //System.out.println(token);
        }
        return list;
    }
    //]
    
    public static int evaluate(List<String> list){
        Stack<Integer> stack = new Stack<Integer>(); 
        for(String token : list){
            if(token == "+" || token == "/" || token == "-" || token == "*"){
                int value = 0;
                int first = Integer.parseInt(stack.top());
                stack.pop();
                int second = Integer.parseInt(stack.top());
                stack.pop();
                if( token == "+")
                    value = first + second; 
                else if ( token == "-")
                    value = second - first;
                else if ( token == "*")
                    value = first * second;
                else if( token == "/")
                    value = second / first;
                stack.push(value + "");
            }else{
                stack.push(token);
            }
        }
    } 

    static void test0(){
        System.out.println("---------------------------------\n");
        String exp = "512 + 4 × + 3 −";
        List<String> list = splitExpr(exp);
        Aron.printList(list);
        System.out.println("---------------------------------\n");
    }
}
