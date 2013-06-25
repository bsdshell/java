    RIGHT_CURLY_BRACE,
    LEFT_SQUARE_BRACE,
    RIGHT_SQUARE_BRACE;
}
public class Json 
{
    public static void main(String[] args)
    {
        System.out.println("Hello World Json");
        tokenize("file.txt");

    }
    public static String[] tokenize(String fileName)
    {
        if(fileName != null){
            try
            {
              BufferedReader in = new BufferedReader(new FileReader(fileName));	
                String str;
                while( (str = in.readLine()) != null)
                {
                    System.out.println("str="+str);
                }
                in.close();
                for(int i=0; i<str.length(); i++)
                {
                    System.out.println("char="+str.charAt(i));
                }
            }
            catch(Exception e)
            {
                System.err.println("Error" + e.getMessage());
            }
        }
        return null; 
    }
    public static TOKEN_TYPE type(String token){
        TOKEN_TYPE type = TOKEN_TYPE.LEFT_CURLY_BRACE;
        if(token.equals("{"))
        {
            type = TOKEN_TYPE.LEFT_CURLY_BRACE;
        }
        else if(token.equals("}"))
        {
            type = TOKEN_TYPE.RIGHT_CURLY_BRACE;
        }
        else if(token.equals("["))
        {
            type = TOKEN_TYPE.LEFT_SQUARE_BRACE;
        }
        else if(token.equals("]"))
        {
            type = TOKEN_TYPE.RIGHT_SQUARE_BRACE;
        }

        return type; 
    }
}
