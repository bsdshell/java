class Complex 
{
    public double real;
    public double imaginary;

    public static Complex FromCartestianFactory(double real, double imaginary)
    {
        return new Complex(real, imaginary);
    }
    public static Complex FromPolarFactory(double modulus, double angle)
    {
        return new Complex(modulus*Math.cos(angle), modulus*Math.sin(angle));
    }
    private Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }
}

public class Factory
{
    public static void main(String[] args)
    {
        System.out.println("Factory class example");
        Complex c1 = Complex.FromCartestianFactory(1, 1);
        System.out.println("c1=("+c1.real+","+c1.imaginary+")");

        Complex c2 = Complex.FromPolarFactory(3.14/4, 3.14/4);
        System.out.println("c2=("+c2.real+","+c2.imaginary+")");
    }
}
