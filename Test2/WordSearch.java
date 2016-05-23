import java.io.*;   //Used to use string methods 
import java.util.*; 
/**
 * This program will search though a text document based on the user input
 * using a brute force approach
 * 
 * @author Tan Do
 * @version 3/4/2016
 */
public class WordSearch
{
    private int numberOfWords;  //finds how many words indicated by user in text document
    private int length;         //finds the length of the text
    private int linePlace;      //Finds the line where word is found
    
    
   /**
   * This constructor sets the default vaules for length and number of words 
   * 
   */ 
    public WordSearch()
    {
        numberOfWords = 0;
        length = 0;
        linePlace = 0;
    }
    
   /**
    * Overloaded constructor that will sent the length of the document input by the user
    * 
    * @param - an integer that will take in the length of the document
    */
   public WordSearch(int textLength)
   {
       if (length > 0)
       {
           length = textLength;
       }
       else
       {
           length = 0;
       }
   }
    
   /**
    * This set method sets the length based on how many words are in 
    * a text document 
    * 
    * @param - integer representing how many words are in a text document
    */ 
   public void setLength(int textLength)
   {
       length = textLength; 
   }
   
   /**
    * This get method gets the length in order to display how many words 
    * there are in a text document 
    * 
    * @return - returns the value of length in the form of integer
    */
   public int getLength()
   {
      return length; 
   }
   
   /**
    * This set methods sets the words that will be needed to be found
    * based on what the user inputs on what word to find 
    * 
    * @param - boolean representing if the word indicated by user is found
    * @param - wordInput string representing what word to search for
    * @param - text string representing what text will be used to search through
    */
   public void setWords(String wordInput, String text)
   {
        int lengthInput = wordInput.length();  //This will get the length of the user word input 
        
        numberOfWords = 0;                     //local function to re-ititialize words
        
         for(int i = 0 ; i < length - lengthInput; i++)   //Loop through the text document
      {  
                boolean match = true;                       //If match is found than set boolean to true 
                
        for (int counter = 0 ; counter < lengthInput; counter++)  //Loop through user input
         { 
            if (text.charAt(i + counter)  !=  wordInput.charAt(counter))
             {
                match = false;                              //If user input does not match a word in a document match equls false
             }
          }
          
          if (match)                        //Adds number of words found if match equals true 
        {
            numberOfWords++;
        }
      }
   }
   
   /**
    * This get method will return the vaule of how many times the word matches
    * what the user is searching for
    * 
    * @return - returns the value of number of words found
    */
   public int getNumWords()
   {
      return numberOfWords;
   }
   
   /**
    * This set method will set the line postion of where the word is found
    * 
    * @param - word will be a string that takes in the word the user is searching for
    * @param - text will be a string that takes in the document that it will be searching through
    */
   public void setPlace(String word, String text)
   {
       int lengthInput = word.length();  //This will get the length of the user word input  
       int lineHolder = 0;
       
          for (int counter = 0 ; counter < lengthInput; counter++) //Loop through user input
         { 
        
            for(int i = 0 ; i < length; i++)   //Loop through the text document
           {
            
            if (text.charAt(i)  == word.charAt(counter))
             {
               linePlace++;                 //Adds line if match is found
             }
 
          }
        
        }
   }
   
   /**
    * This get method will get the line number place and returns it
    * 
    * @return - returns the line place in the form of an integer 
    */
   
   public int getPlace()
   {
      return linePlace;
       
   }
 
}


