import java.util.Scanner;
/**
 * Write a description of class Driver here.
 * 
 * @author Tan Do
 * @version Due by Thursday Feb 11
 */
public class Driver
{
   public static void main(String [] args)
   {
       Scanner input = new Scanner(System.in); //reads input 
       
       Subscription User;        //reference variable for the packages
       double Hours; 
       double TotalA = 0;           //Total will hold values for the bills 
       double TotalB = 0;
       int TotalC = 0;
       char Choice;             //This will hold user choice to loop
       char Contuine = 'Y';
       
       String Round = String.valueOf(TotalA);       //This will turn them into strings 
       String Round2 = String.valueOf(TotalB);      //To set decimal place
       String Round3 = String.valueOf(TotalC);
       
   
       //Begin loop
       while(Contuine == 'Y' || Contuine == 'y')
       {
     
       System.out.println("Plan A: $25.99 a month for 25 hours, every ");
       System.out.println("extra hour cost .48 cents extra");
       
       System.out.println("\nPlan B: $35.95 a month for 45 hours, every ");
       System.out.println("extra hour cost .65 cents extra");
       
       System.out.println("\nPlan C: $49 a month, with unlimited hours");
       
       System.out.print("\nPlease pick your Subscription package: ");
       Choice = input.next().charAt(0);
       
       System.out.print("How many hours did you use?: ");
       Hours = input.nextDouble();
       
    
       switch (Choice)
       {
           case 'a':
           case 'A':
           User = new Subscription(); 
           User.setNumHours(Hours);
   
           TotalA = User.BillA();
           TotalB = User.BillB();
           TotalC = User.BillC();
           
           if (TotalA == TotalB && TotalA == TotalC)
        {
           System.out.println("Your monthly bill is $" +  TotalA + ", you have used " + Hours + " hours");
           System.out.println("This package will cost the same as other packages");
        }
        else if(TotalA > TotalB)
        {
             System.out.println("Your monthly bill is $" + TotalA + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package B, by $" + (TotalA-TotalB));
        }
        else if (TotalA > TotalC)
        {
             System.out.println("Your monthly bill is $" + TotalA + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package C, by $" + (TotalA-TotalC));
        }
        else 
        {
            System.out.println("Your monthly bill is $" + TotalA + ", you have used " + Hours + " hours");
        }
     
           break; 
           
           case 'b':
           case 'B':
           User = new Subscription(); 
           User.setNumHours(Hours);
           
           TotalB = User.BillB();
           TotalA = User.BillA();
           TotalC = User.BillC();
           
             if (TotalB == TotalA && TotalB == TotalC)
        {
           System.out.println("Your monthly bill is $" + TotalB + ", you have used " + Hours + " hours");
           System.out.println("This package will cost the same as other packages");
        }
        else if(TotalB > TotalA)
        {
             System.out.println("Your monthly bill is $" + TotalB + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package B, by $" + (TotalB-TotalA));
        }
        else if (TotalB > TotalC)
        {
             System.out.println("Your monthly bill is $" + TotalB + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package C, by $" + (TotalB-TotalC));
        }
        else 
        {
            System.out.println("Your monthly bill is $" + TotalB + ", you have used " + Hours + " hours");
        }
           
           
           
       
           break;
           
           case'c':
           case 'C':
           User = new Subscription();
           User.setNumHours(Hours);
           
           TotalC = User.BillC();
           TotalB = User.BillB();
           TotalA = User.BillA();
           
                 if (TotalC == TotalA && TotalC == TotalB)
        {
           System.out.println("Your monthly bill is $" + TotalC + ", you have used " + Hours + " hours");
           System.out.println("This package will cost the same as other packages");
        }
        else if(TotalC > TotalA)
        {
             System.out.println("Your monthly bill is $" + TotalC + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package B, by $" + (TotalC-TotalA));
        }
        else if (TotalC > TotalB)
        {
             System.out.println("Your monthly bill is $" + TotalC + ", you have used " + Hours + " hours");
            System.out.println("You would save more on package C, by $" + (TotalC-TotalB));
        }
        else 
        {
            System.out.println("Your monthly bill is $" + TotalC + ", you have used " + Hours + " hours");
        }
           
           
           
           break;
           
       }
       
       System.out.print("Enter y to calculate again q to stop: ");
       Contuine = input.next().charAt(0);
    }
    //end of loop
    System.out.println("\n\nThank you, Goodbye");
       
   }

}
