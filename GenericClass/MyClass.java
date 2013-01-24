public class MyClass 
{
				public static void main(String[] args)
				{
								System.out.println("Hello World!");
								GenericClass<Object1> obj1 = new GenericClass<Object1>();

				}
				class GenericClass<T>
				{
					T value;
					public GenericClass(T value)
					{ this.value = value;}
					public int compareTo(T obj)
					{
						if(obj instanceof Object1)
						{
							
						}
					}
				}
}
