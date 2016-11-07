interface Shape
{
    public double getArea();
}

class Circle implements Shape
{
    double x;
    double y;
    double radial;
    public Circle(double x, double y, double radial)
    {
        this.x = x;
        this.y = y;
        this.radial = radial;
    }
    public double getArea()
    {
        return 3.14*radial*radial;
    }
}

class Rectangle implements Shape
{
    double topx;
    double topy;
    double bottomx;
    double bottomy;
    public Rectangle(double topx, double topy, double bottomx, double bottomy)
    {
        this.topx = topx;
        this.topy = topy;
        this.bottomx= bottomx;
        this.bottomy= bottomy;
    }
    public double getArea()
    {
        return Math.abs(bottomx - topx)*Math.abs(bottomy - topy);
    }
}


public class MyShape 
{
    public static void main(String[] args)
    {
        Shape s1 = new Circle(3.0, 4.0, 5.0); 
        Shape s2 = new Rectangle(3.0, 4.0, 5.0, 6.0); 
        System.out.println("s1=" + s1.getArea());
        System.out.println("s2=" + s2.getArea());
    }
}
