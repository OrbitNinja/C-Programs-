/* Algorithm
1. Show user three options to pick from main menu
2. If user picks C, will ask user to input new username and passowrd
3. If user picks L, will ask user for existing username and passowrd
4. If none matches database, states that it is not found
5. If user picks Q, program will quit
6. After Log in page, it will display 4 options
7. If user picks D, it will ask user how much money is being deposited
8. If user picks W, it will ask user how much money is being taken out
9. If input exceeds balance it will tell tell the user
10.If user picks R, it will show the balance
11. If user picks Q, it will exit the program
12. The bank menu will loop if user does not pick Q
*/

/*

Purpose : To demonstrate understating of creation, compilation, and program submission process.
Programmer : Tan Do
Version: Nov 23
*/

#include <iostream>
#include<string>
#include<fstream>   //Include this to read and write files


using namespace std;

char mainMenu();             //Function prototypes
char bankingMenu();
void displayBalance();
void createAccount();
int login();
int deposit();
int withdraw();

                            //Global variables
int ID;
int Pass;
float money = 0;
ifstream inFile;
ofstream outFile;

int main()
{
    char MainMenu;          //Variable to hold functions

       MainMenu = mainMenu();

    if (MainMenu == 'L' || MainMenu == 'l') //Lets user login
    {
        login();

    }
   else if (MainMenu == 'C' || MainMenu == 'c') //Lets user make account
    {
        createAccount();
        return main();

    }
    else if (MainMenu == 'Q' || MainMenu == 'q')    //Quits the program
    {
        cout << "Program will exit" << endl;
        void exit();
    }
    else
    {
        cout << "Invalid choice" << endl << endl;    //Input validation

    }

    return 0;
}
                                    //Function definitions
char mainMenu()
{
    char Userchoice;             //Variable to hold user choice

    cout <<"Hello!, Welcome to the computer programmer ATM machine!";
    cout <<"\nPlease pick an option below" << endl << endl;
    cout <<"L -> Login" << endl;
    cout <<"C -> Create account" << endl;
    cout <<"Q -> Quit the program" << endl << endl;
    cout <<"Your choice: ";
    cin >> Userchoice;

    return Userchoice;
}

void createAccount()            //Function to create account
{

    cout <<"Please enter your new ID: ";
    cin >> ID;
    cout <<"Please enter your new password: ";
    cin >> Pass;

    outFile.open("Accounts.txt",ios::out|ios::app); //Opens a file and writes in it

    if (!outFile)                                   //File validation
    {
        cout << "Cannot open file" << endl << endl;
    }
    outFile << ID << " " << Pass << endl;           //Stores user input
    outFile.close();

    cout << "\nThank you! Your account has been created!" << endl << endl;


}

int login()                                     //Function for user login
{
    int Info;

    cout <<"Please enter your ID: ";
    cin >> ID;
    cout <<"Please enter your password: ";
    cin >> Pass;

inFile.open("Accounts.txt");                //Opens a file

if (!inFile)                                 //File validation
{
    cout <<"Cannot open file" << endl << endl;
}
while (inFile >> Info)                      //Reads file and stores the values in a variable
{

}
  if(ID == Info)                            //Checks to see if user input matches with values in file
    {
        if (Pass == Info)
        cout <<"Access granted!" << endl << endl;
        return bankingMenu();
    }
    else
    {
        cout <<"Your ID or Pass is wrong, make a new account if you have not done so" << endl << endl;
    }

inFile.close();

return main();

}


char bankingMenu()                          //After login success, banking menu function
{
    char menuChoice;


    cout <<"Please select an option from the menu below" << endl << endl;
    cout <<"D -> Deposit money" << endl;
    cout<<"W -> Withdraw money" << endl;
    cout <<"R -> Request Balance" << endl;
    cout <<"Q -> Quit" << endl;
    cin >> menuChoice;
      if (menuChoice == 'D' || menuChoice == 'd')              //Based on user input the statements will run
        {
            deposit();
            return bankingMenu();
        }
        else if (menuChoice == 'W' || menuChoice == 'w')
        {
            withdraw();
            return bankingMenu();
        }
        else if (menuChoice == 'R' || menuChoice == 'r')
        {
            displayBalance();
            return bankingMenu();
        }
        else if (menuChoice == 'Q' || menuChoice == 'q')
        {
            cout << "Program will exit" << endl;
            void exit();
        }
        else
        {
            cout <<"Please enter a valid answer" << endl << endl;
            return bankingMenu();
        }

    return menuChoice;
}



int deposit()                                   //Function to hold money deposited
{
    cout <<"Please enter the amount you want to deposit: $";
    cin >> money;

    return money;
}

int withdraw()                                      //Function to take money out of stored value
{
    int moneyOut;
    cout <<"Please enter the amount you want to withdraw: $";
    cin >> moneyOut;
    if (moneyOut <= money)                          //Checks to see if user has enough funds in bank
    {
         money = money - moneyOut;
         cout <<"You have taken out $" << moneyOut << endl;
    }
   else if (moneyOut > money)
    {
        cout <<"Your Balance is too low!, try again" << endl << endl;
        return withdraw();
    }
    else{
    cout << "Invalid , try again" << endl << endl;
    return bankingMenu();
    }
    return money;
}

void displayBalance()                           //Function to show balance in bank
{
    cout <<"Your balance is $" << money << endl;
}
