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
        test_isLeapyear();
        test_daysInMonth();
    }
    public static boolean isLeapYear(int year)
    {
        boolean retBool = false;
        if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
            retBool = true;
        return retBool;
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
    public static void test_daysInMonth()
    {
        int[] leapYearArray = {
            2008,
            2012,
            2016,
            2020,
            2024,
            2028,
            2032
        };
        for(int i=0; i< leapYearArray.length; i++){

            int year = leapYearArray[i];
            for(int j=0; j<11; j++){
                int month = j+1;
                System.out.println("daysInMonth="+daysInMonth(month, year));
            }
            System.out.println("");
        }
    }
    public static void test_isLeapyear()
    {
        int[] leapYearArray = {
            2008,
            2012,
            2016,
            2020,
            2024,
            2028,
            2032
        };
        for(int year : leapYearArray)
        {
            boolean isleap = isLeapYear(year);
            System.out.println("isleap="+isleap);
        }
    }
}
