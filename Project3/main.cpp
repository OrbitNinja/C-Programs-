/*Algorithm
1. An 3x3 2-D array will be declared
2. The array will have values 1-9 randomly
3. Will check each number to see if it is unique or not
4. If it is unique than it will show in the display
5. Displays array than checks if it is a magic square or not
6. Loops until magic square is found

*/

/*
Project: Magic Square
Purpose: To demonstrate understanding of the creation, compilation, and program submission process
Programmer: Tan Do
Version: Nov 30
*/

#include <iostream>
#include<algorithm>
#include<time.h>
#include<cstdlib>               //Includes these for random numbers to work


using namespace std;

bool magicSquare();             //Declare Prototypes
bool checkUnique(int);
                                //Declare global so functions can access it
const int Max_row = 3;          //Will make the square 3 by 3
const int Max_col = 3;
int square[Max_row][Max_col];

int main()
{
    srand(time(NULL));  //Make numbers all random
    int Row;
    int Col;
    int temp = 0;

   do{
    for(Row = 0; Row < Max_row; Row++)
    {
        //Loop to print the magic square array
        for(Col = 0; Col < Max_col; Col++)

        {

            do
            {
                temp = rand() % 9 + 1;
            }
            while (!checkUnique(temp));

            square[Row][Col] = temp;
            cout << square[Row][Col] << "\t ";


        }
        cout << endl;
    }

    cout << endl;
   magicSquare();
                                   //This will see if all the sums of row, column and diagonal is the same
   }
   while(magicSquare());

return 0;
    }



//Function definitions
bool magicSquare()
{
    int total[3];   //Accumulator
    int secDiag;    //To calculate the second diagonal
    bool flag = false;

do{
    for(int row = 0; row < Max_row; row++) //Get each value in array
    {
        total[0] = 0;
        for (int col = 0; col < Max_col; col++) //Sums a row
            total[0] += square[row][col];



    }

    for(int col = 0; col < Max_col; col++) //Get each value in array
    {
        total[1] = 0;
        for (int row = 0; row < Max_row; row++) //Sum Column
            total[1] += square[row][col];

    }


    for (int row = 0; row < Max_row; row++) //Gets the row
    {
        total[2]= 0;
        for(int col = 0; col < Max_col; col++) //Gets the column
        {
            if(row == col)                     //Check if the matrix is even
            {
                total[2] += square[row - 2][col - 2];  //Calculates the main diagonal
                total[2] += square[row - 1][col - 1];
                total[2] += square[row][col];

            }
        }

    }

    for (int row = 0; row < Max_row; row++)    //Gets the row
    {
        secDiag= 0;
        for(int col = 0; col < Max_col; col++) //Gets the column
        {
            if(row == col)                     //Check if the matrix is even
            {

                secDiag += square[row][0];
                secDiag += square[row - 1][0 + 1];      //Calculates the secondary diagonal
                secDiag += square[row - 1][0 - 1];

            }
        }

    }


    //Compares if it is a magic square
    if(total[0] == total[1] && total[0] == total[2] && total[1] == total[2])
    {
        cout << "It is a magic square!" << endl;
        return true;
    }

}while(flag);

   if (total[0] != total[1] && total[0] != total[2] && total[1] != total[2])
    {
         cout <<"It is not a magic square!" << endl << endl;
        return false;
    }

}

bool checkUnique(int check)             //Function to check for unique number
{
    for(int i = 0; i < Max_row; i++)        //Checks every row and column
    {
        for(int a = 0; a < Max_col; a++)
        {
            if(square[i][a] == check)       //If equal the function is false
            {
                return false;
            }
        }
    }
    return true;                            //True if every number is unique

}

