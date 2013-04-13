//<enum>enum class example</enum>
enum MyType
{
    NUM(3),
    ROW(4);
    int value;
    MyType(int value){this.value=value;}
    int Value(){return this.value;}
}

public class EnumExample 
{
    public static void main(String[] args)
    {
        System.out.println(MyType.NUM.Value());
        System.out.println(MyType.ROW.Value());
    }
    
}
