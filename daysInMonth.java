public class daysInMonth 
{
    public static void main(String[] args)
    {
        System.out.println("determining the numbers of day in a month");

        int month = 2; 
        int year = 2100;
        for(int i=0; i < 12; i++)
        {
            month = i + 1;
            int days = daysInMonth(month, year);
            System.out.println("days="+days);
        }
    }
    public static boolean isLeapYear(int year)
    {
        return (year % 4 == 0 || year % 100 == 0 && year % 400 == 0? false : true);
    }
    public static int daysInMonth(int month, int year)
    {
        int days=0;
        if(month == 2)
        {
            days = 28 + (isLeapYear(year)? 1 : 0);
        }
        else 
        {
            days = 30 + ((month-1) % 7 % 2 == 0? 0 : 1);
        }
        return days;
    }
}
