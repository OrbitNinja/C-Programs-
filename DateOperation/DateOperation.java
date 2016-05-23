
/**
 * This class will be used in many applications that deals with dates. This class will implement date 
 * operations that may be used and will also hold an starting date. 
 * 
 * @author Tan Do
 * @version 4/20/2016
 */
public class DateOperation
{
    // instance variables
    private int dateDay;
    private int dateMonth;
    private int dateYear; 
    private String dateNow; 
    private String monthDay []; 
    private String dateFormat; 

    /**
     * Constructor for objects of class DateOperation
     */
    public DateOperation()
    {
        // initialise instance variables
        dateDay = 0;
        dateMonth = 0;
        dateYear = 0;
        dateNow = "UNKOWN";
        dateFormat = "UNKOWN";
        monthDay = new String []{"January","February","March","April","May","June","July","August","September","October","November","December"};
    }

    /**
     * This is a second overloaded constructor that will accpet vaules to change the fields 
     * 
     * @param int day - this will take in the day of the month 
     * @param int month - this will take in the month number 
     * @param int year - this will take in the year in integer form
     * @param int monthWord - this will take in an integer starting from 0 to 11, number is based on month in array
     */
    public DateOperation(int day, int month, int year, int monthWord)
    {
        dateDay = day;
        dateMonth = month; 
        dateYear = year;
        dateNow = dateMonth + "/" + dateDay + "/" + dateYear;
        monthDay = new String [monthWord];
    }

    /**
     * This is a copy constructor that will make a new instance of the DateOperation class using 
     * an exitisting instance that is used as a parameter
     * This initialized the fields of the new instance
     * 
     * @param int month - this is the date's month number
     * @param int day - this is the day of the month 
     * @param int year - this is the current year of the month and day 
     */
    public DateOperation(int month, int day, int year)
    {
        this.dateDay = day;
        this.dateMonth = month;
        this.dateYear = year;
        this.dateNow = month + "/" + day + "/" + year;

    }

    /**
     * This method will set the month, day, and year for the starting date
     * 
     * @param int day - this will take in the starting day
     * @param int month - this will take in the starting month number 
     * @param int year - this will take in the starting year 
     */
    public void setDate(int day, int month, int year)
    {

        if(day <= 31)
        {
            dateDay = day;
        }

        if(month <= 12)
        {
            dateMonth = month; 
        }

        if(year > 2000)
        {
            dateYear = year; 
        }

        dateNow = dateMonth + "/" + dateDay + "/" + dateYear;
    }

    /**
     * This method simply returns the starting date to be used for display in Driver class
     * 
     * @return String - returns the starting date in string form 
     */
    public String getStartingDate()
    {
        return dateNow;
    }

    /**
     * This method will get the starting date and will convert it to 
     * long version or short version of a date
     * January 2, 2015 or 3/15/2015
     * 
     * @param char format - this will take in take in the starting date and formats it
     * to long or short version 
     */
    public String getDate(char format)
    {
        int temp = (dateMonth - 1); //holds temp number to search through array

        if(format == 'Y')
        {
            dateFormat = monthDay[temp] + " " + dateDay + ", " + dateYear;
        }

        return dateFormat; 
    }

    /**
     * This method calculates the leap year based on the year provided 
     * 
     * @returns boolean - returns true if leap year otherwise false 
     */
    public boolean leapYear()
    {
        boolean result; 

        if(dateYear % 4 == 0 && dateYear % 100 != 0)
        {
            result = true; 
        }

        else if(dateYear % 400 == 0)
        {
            result = true;
        }
        else
        {
            result = false; 
        }

        return result; 
    }

    /**
     * This method will see how many days are between the starting date and the given new date 
     * 
     * @param DateOperation newDate - this is a reference variable to make a new date using DateOperation object 
     * @return int - returns the number of days in between the two dates 
     */
    public int daysBetween(DateOperation newDate)
    {
        int day = 0; 
        int temp = 0;
        int daysBetween = 0;

        if(dateYear < newDate.dateYear)
        {
            if(dateMonth < newDate.dateMonth)
            {
                while(dateDay <= newDate.dateDay)
                {
                    day++;
                }
                temp = (newDate.dateMonth - dateMonth) * (31 - day);
                daysBetween = ((newDate.dateYear - dateYear) * (365 - day)) + temp; 

            }
            else if(dateMonth == newDate.dateMonth || dateMonth > newDate.dateMonth)
            {
                while(dateDay <= newDate.dateDay)
                {
                    day++;
                }
                daysBetween = (newDate.dateYear - dateYear) * (365 - day);
            }
        }

        else if (dateMonth < newDate.dateMonth)
        {
            while(dateDay <= newDate.dateDay)
            {
                day++;
            }
            daysBetween = (newDate.dateMonth - dateMonth) * (31 - day);
        }
        else
        {
            daysBetween = newDate.dateDay - dateDay;
        }

        return daysBetween; 
    }

    /**
     * This method will add number of days, based on vaule, to the starting date
     * 
     * @param int numDays - this will take in the vaule of how many days will be added 
     */
    public DateOperation add(int numDays)
    {
        DateOperation date = new DateOperation(this.dateMonth, this.dateDay + numDays, this.dateYear);

        int day = date.dateDay + numDays;

        if (day > 31)
        {
            date.dateMonth++;
            date.dateDay = 31 - day; 
            if(date.dateMonth > 12)
            {
                date.dateYear++;
                date.dateMonth = 12 - dateMonth; 
            }

        }

        return date;
    }

    /**
     * This method will subtract number of days, based on vaule, to the starting date
     * 
     * @param int numDays - this will take in the vaule of how many days will be added 
     */
    public DateOperation subtract(int numDays)
    {
        DateOperation date = new DateOperation(this.dateMonth, this.dateDay - numDays, this.dateYear);

        int day = date.dateDay;

        if (day < date.dateDay)
        {
            date.dateMonth--;
            date.dateDay = 31 - day; 
            if(date.dateMonth <= 1 )
            {
                date.dateYear--;
                date.dateMonth = 12 - dateMonth; 
            }

        }

        return date;
    }

    /**
     * This method will compare if two dates are the same are not
     * 
     * @param DateOperation inDate - this is a reference variable to the object, will accecpt in a new date object 
     * @return Boolean - returns true or false based on dates 
     */
    public boolean equals(DateOperation inDate)
    {
        return dateNow.equals(inDate.dateNow);
    }

    /**
     * This method will compare two dates to see if they are in the same year
     * 
     * @param DateOperation inDate - this is a reference variable to the object, will accecpt in a new date object 
     * @return int - returns a number which see's if it is equal or not, or which is higher
     */
    public int compareTo(DateOperation inDate)
    {
        int result; 
        if (dateYear == inDate.dateYear)
        {
            result = 1; 
        }
        else if(dateYear > inDate.dateYear)
        {
            result = 0;

        }
        else
        {
            result = -1;
        }

        return result; 
    }

    /**
     * This method is a textual representation of the class 
     * 
     * @return String - returns the textual represention to display for the user 
     */
    public String toString()
    {
        return "Date: " + dateNow; 
    }

}

