import java.io.*;   //to read a file
import java.util.*; //For scanner
/**
 * This will be the main() and will promot the user to enter the file name
 * and output the results 
 * 
 * @author Tan Do
 * @versio 3/4/2016
 */
public class Driver
{
  public static void main(String[] args) throws IOException
  {
      Scanner input = new Scanner(System.in); //Creates scanner 
      WordSearch text = new WordSearch();  //Creates new instance 
      
      String fileName;      //variable for user input 
      String line;         //Variable for reading text document 
      String search;        //Variable to search for a word 
      
      int length;           //Variable to hold the length of text
      int found = 0;   //This holds the number of times the word is found
      int lineNumber = 1;   //Sets line number
      
      ArrayList<Integer> linesWithMatches = new ArrayList<Integer>(); //creates new changable array list to hold line number
      
      System.out.print("Enter the file name: ");
      fileName = input.nextLine();
      
      System.out.println("\nPlease enter the word you are trying to find: ");
      search = input.nextLine();
      
      System.out.println("\n"); //puts a space between for easier reading  
      
      Scanner dataFile = new Scanner(new File(fileName));  //Finds the file 
      
   
      do
      {
        line = dataFile.nextLine();   //Reads though the document
          
        length = line.length(); 
        text.setLength(length); 
          
        System.out.println(line);   
        
        text.setWords(search, line);
        text.setPlace(search, line);
        
        found += text.getNumWords();
          
        if (text.getNumWords() > 0) 
        {
            linesWithMatches.add(lineNumber);
        }
        lineNumber++;
        
        }while (dataFile.hasNext());  //opens and reads through a file 
      
      
      System.out.println("\nYour file has " + text.getLength() + " words");
      
     String lines = " ";  //Seperates the line
      for (int i = 0; i < linesWithMatches.size(); i++) 
     {
         lines += linesWithMatches.get(i);
         
         if (i != linesWithMatches.size() - 1) 
         {
             lines += ", ";
         }
      }
      
      
      System.out.println("\n" + found + " words has been found"); 
      System.out.println("\nThe words are found in lines " + lines);
      
      dataFile.close(); //Closes the file
  }
  
}
