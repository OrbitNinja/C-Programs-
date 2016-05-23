/*
Program: Search and sort college books
Programmer: Tan Do
Purpose: Understand creating, compilation, and program submission process
Version: Dec. 9 2015
*/

/*Note: It seems like linear search would be faster and a selection search is faster*/

#include <iostream>
#include<iomanip>
#include<time.h>
#include<cstdlib>


void display();             //Declare Prototypes
int linearySearch();
int binarySearch();
void bubbleSort();
void selectionSort();

using namespace std;

//Global array to use with all functions

string bookTitle[] = {"Starting out with C++", "Java Programming", "Software Structures", "Design and Analysis of Algorithms",
                      "Computer Graphics", "Artificial Intelligence: A Modern Approach", "Probability and Statistics", "Cognitive Science",
                      "Modern Information Retrieval", "Speech and Language Processing"
                     };

int bookID[] = {1101, 1211, 1333, 1456, 1567, 1642, 1699, 1755, 1800, 1999};

double bookPrice[] = {112.32, 73.25, 54.00, 67.32, 135.00, 173.22, 120.00, 42.25, 32.11, 123.75};

//Global array to be used with sorting function

int randArray[1000];

int main()
{
    int choice;

    do
    {
        cout << "1.  Linear Search" << endl;            //Display menu
        cout << "2.  Binary Search" << endl;
        cout << "3.  Bubble sort"   << endl;
        cout << "4.  Selection sort" << endl;
        cout << "5.  Quit" << endl << endl;
        cout << "Please select a option: ";
        cin >> choice;
        cout << endl;

        switch (choice)                 //Statement runs based on user input of choice
        {
        case 1:
            linearySearch();
            break;
        case 2:
            binarySearch();
            break;
        case 3:
            bubbleSort();
            break;
        case 4:
            selectionSort();
            break;
        case 5:
            void exit();
            break;
        default:                                                 //Input validation
            cout <<"Not a valid answer, try again" << endl << endl;
            break;
        }
    }
    while(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5);    //Input validation


    return 0;
}
//Function Definitions
int linearySearch()    // Will perform a linear search based on user input
{
    int BookInput;      //Declare variables
    int numBooks;
    float total;
    int counter = 0;
    bool flag = false;

    cout << "*****Linear Search*****" << endl << endl;
    display();                                          //Function call to display all the books with computer science

    cout << endl;

    cout <<"What book would you like to purchase?(Book ID) ";
    cin >> BookInput;
    cout <<"How many books would you like? ";
    cin >> numBooks;

    const clock_t Start_time = clock();                 //Starts elapsed time

    while (!flag && counter < 10)    //Loop to look through the array
    {
        if (bookID[counter] == BookInput) //If book ID is found within array
        {
            cout <<"\nBook ID: " << bookID[counter] << endl;
            cout <<"Book Title: " << bookTitle[counter] << endl;
            cout <<"Book price $" << bookPrice[counter] << endl << endl;
            total = bookPrice[counter] * numBooks;
            cout <<"Your total will be $" << total << endl;

            flag = true;                   //Stops loop if ID is found
        }

        counter++;                         //Used to look through array for the book ID

    }
    if (!flag)         //input validation
    {
        cout <<"Book ID not found, try again" << endl << endl;
        return linearySearch();

    }
    cout << "Time elapsed: " << float(clock() - Start_time) << " ms" << endl; //Ends counting time

    return BookInput;


}

int binarySearch()              //Used for a binary search
{
    int middle;                 //Declare Variable to use for binary search
    int first = 0;              //First element in array
    int last = 10-1;            //Last element in array
    bool flag = false;

    int BookInput;              //Other variables
    int numBooks;
    float total;

    const clock_t Start_time = clock();         //Starts elapsed time

    cout << "*****Binary Search*****" << endl << endl;
    display();                  //Function call to display information

    cout << endl;
    cout <<"What book would you like to purchase?(Book ID) ";
    cin >> BookInput;
    cout <<"How many books would you like? ";
    cin >> numBooks;

    while(!flag && first <= last)               //If statement is true, runs loop
    {
        middle = (first + last) / 2;            //Finds middle of array

        if (bookID[middle] == BookInput)        //If middle equals to user input
        {
            flag = true;
            cout <<"\nBook ID: " << bookID[middle] << endl;
            cout <<"Book Title: " << bookTitle[middle] << endl;
            cout <<"Book price $" << bookPrice[middle] << endl << endl;
            total = bookPrice[middle] * numBooks;
            cout <<"Your total will be $" << total << endl;

        }
        else if (bookID[middle] > BookInput)    //If input is greater than middle, searches bottom half

        {
            last = middle - 1;

        }


        else                                    //If input is less than middle, searches top half

        {

            first = middle + 1;

        }


    }

    if(bookID[middle] != BookInput)            //Input Validation
    {
        cout <<"Book ID not found, try again!" << endl << endl;
        return binarySearch();
    }

    cout << "Time elapsed: " << float(clock() - Start_time) << " ms" << endl; //Ends counting time

    return BookInput;
}

void bubbleSort()                //To sort with a bubble method
{
    srand(time(NULL));           //For numbers to be all random
    bool flag;                  //Variables for sorting
    int temp;

    cout <<"Unsorted numbers" << endl;
    cout << "------------------" << endl;
    for (int counter = 0; counter < 1000; counter++)      //Used to put random numbers into array
    {
        randArray[counter] = rand() % 500 + 1;
        cout << randArray[counter] << " ";
    }

    const clock_t Start_time = clock();             //Start elapsed time

    do
    {
        flag = false;
        for (int counter = 0; counter < 999; counter++)     //Used to look through the array from the beginning and compares it to the next one
        {

            if(randArray[counter] > randArray[counter + 1])
            {

                temp = randArray[counter];                      //function to compare
                randArray[counter] = randArray[counter + 1];
                randArray[counter + 1] = temp;

                flag = true;                                    //Stops loop

            }

        }

    }
    while(flag);

    cout << endl;
    cout <<"Sorted numbers" << endl;
    cout << "------------------" << endl;

    for (int counter = 0; counter < 1000; counter++)        //Will Print the sorted values
    {
        cout << randArray[counter] << " ";
    }
    cout << endl;
    cout << "Time elapsed: " << float(clock() - Start_time) << " ms" << endl;  //Ends counting time

}

void selectionSort()             //To sort with a selection method
{
    int lowIndex, lowestVaule;      //Variable for selection sort

    cout <<"Unsorted numbers" << endl;
    cout << "------------------" << endl;

    for (int counter = 0; counter < 1000; counter++)         //Used to put random numbers into array
    {
        randArray[counter] = rand() % 500 + 1;
        cout << randArray[counter] << " ";
    }

    const clock_t Start_time = clock();                 //Starts elapsed time

    for (int counter = 0; counter < 999; counter++)          //Function to look through the arrays
    {
        lowIndex = counter;                                   //To hold the lowest value
        lowestVaule = randArray[counter];
        for (int Index = counter + 1; Index < 1000; Index++)
        {
            if (randArray[Index] < lowestVaule)
            {
                lowestVaule = randArray[Index];                    //Compares first value to second, second to third, and so on
                lowIndex = Index;
            }
        }
        randArray[lowIndex] = randArray[counter];               //Put lowest value first and highest last
        randArray[counter] = lowestVaule;

    }
    cout << endl;
    cout <<"Sorted numbers" << endl;
    cout << "------------------" << endl;

    for (int counter = 0; counter < 1000; counter++)        //Will Print the sorted values
    {
        cout << randArray[counter] << " ";
    }
    cout << endl;
    cout << "Time elapsed: " << float(clock() - Start_time) << " ms" << endl;  //Ends counting time


}

void display()                  //Displays the information for the books
{

    cout <<"Book ID \tBook Title \t\t\t\t\tBook Price" << endl;
    cout <<"-------- \t----------- \t\t\t\t\t-----------" << endl;
    for (int counter = 0; counter < 10; counter++)
    {
        cout << bookID[counter] << "\t" << bookTitle[counter] << "\t" << setw(35) << "$" << bookPrice[counter] << endl;
    }

}
