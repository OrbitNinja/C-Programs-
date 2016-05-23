
/**
 * Write a description of class Subscription here.
 * 
 * @author Tan Do
 * @version Thursday Feb 11
 */
public class Subscription
{
    private final double A;         // instance variables to use inside of class
    private final double B;
    private final int C;
    private double Hours; 
    
    /**
     * no-args constructor to set base price and hour
     */
    public Subscription()
    {
        A = 25.99;
        B = 35.95;
        C = 49;
        Hours = 0; 
        
    }
   
    
    /**
     * This method will get the user to set number of hours they use 
     * @param - user will set hours
     */
    
    public void setNumHours(double TotalHours)
    {
        if (Hours >= 0) 
        {
            Hours = TotalHours; 
        }
        else 
        {
            Hours = 0;
        }
    }
    
    /**
     * This method will use base price of package A and calculate the monthly bill
     * @return - returns bill amount 
     */
    public double BillA()
    {
        double total = 0;
        double ExtraHour; 
        
        if (Hours <= 25)       //Statement calculates bill based on hour used
        {
            total = A; 
        }
        else if (Hours > 25)
        {
            ExtraHour = Hours - 25; 
            total = A + (ExtraHour * .48);
        }
        
        return total; 
        
        
    }
    
     /**
     * This method will use base price of package B and calculate the monthly bill
     * @return - returns the bill amount 
     */
    
    public double BillB()
    {
     
        double total = 0;
        double ExtraHour; 
        
        if (Hours <= 45)      //Statement calculates bill based on hour used
        {
            total = B; 
        }
        else if (Hours > 45)
        {
            ExtraHour = Hours - 45; 
            total = B + (ExtraHour * .65);
        }
        
       return total; 
        
    }
    
      /**
     * This method will use base price of package C and calculate the monthly bill
     * Package C is always the same due to having ulimited hours
     * @return - returns the bill amount 
     */
    public int BillC()
    {
        int total = 0; 
        total = C;
        return total; 
        
    }
    /**
     * get method to get hours input by user
     * @return - returns number of hours 
     */
    
    public double getHours()
    {
        return Hours;
    }
    
    /**
     * toString() method to show base package price
     * @return - returns the string 
     */
    
    public String toString()
    {
       return A + " " + B + " " + C;
    }

   
}
  
  
    
    
  
