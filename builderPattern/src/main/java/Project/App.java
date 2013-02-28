package Project;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Pizza.Builder builder = new Pizza.Builder();

        Pizza pizza = builder.setSauce("cool")
                             .setTopping("chicken topping")
                             .setDough("My Sauce")
                             .Build();
        pizza.show();


        Pizza pizza1 = builder.setSauce("cool")
                              .setTopping("chicken topping")
                              .Build();
        pizza1.show();
    }
}
