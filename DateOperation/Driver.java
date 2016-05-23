import java.util.*;
/**
 * This class will hold the main, which will test each method in the DateOperation class 
 * And will print them on the screen
 * 
 * @author Tan Do
 * @version 4/20/2016
 */
public class Driver
{

    public static void main(String [] args)
    {
        //reference variable to DateOperation class
        DateOperation d1 = new DateOperation();
        DateOperation d2 = new DateOperation(10,9,2020);

        d1.setDate(7,9,2020);

        d2.setDate(12,9,2020);

        System.out.print("\n*****************************************************");
        System.out.print("\n" + d1.toString());
        System.out.print("\nFormated date: " +  d1.getDate('Y'));

        System.out.print("\n*****************************************************");
        System.out.print("\n" + d1.toString());
        System.out.print("\nLeap year?: " + d1.leapYear());

        System.out.print("\n*****************************************************");
        System.out.print("\nStarting date: " + d1.getStartingDate());
        System.out.print("\nOther Date: " + d2.getStartingDate());
        System.out.print("\nDays between the dates: " + d1.daysBetween(d2)); 

        System.out.print("\n*****************************************************");
        System.out.print("\nStarting date: " + d1.getStartingDate());
        System.out.print("\nAdding 5 days " +  d1.add(5));

        System.out.print("\n*****************************************************");
        System.out.print("\nStarting date: " + d1.getStartingDate());
        System.out.print("\nSubtracting 5 days " +  d1.subtract(5));

        System.out.print("\n*****************************************************");
        System.out.print("\n" + d1.toString());
        System.out.print("\n" + d2.toString());
        System.out.print("\nAre the dates the same?: " + d1.equals(d2));

        System.out.print("\n*****************************************************");
        System.out.print("\n" + d1.toString());
        System.out.print("\n" + d2.toString());
        System.out.print("\nWill compare the two years");
        if(d1.compareTo(d2) == 1)
        {
            System.out.print("\nThe years are the same");
        }
        else if(d1.compareTo(d2) == 0)
        {
            System.out.print("\nThe first date year is higher");
        }
        else if(d1.compareTo(d2) == -1)
        {
            System.out.print("\nThe second date year is higher");
        }

    }
}
