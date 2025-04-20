#include "Calculator.h"
#include <iomanip>
#include <iostream>
using namespace std;

/**
 * Constructor for the Calculator class.
 */
Calculator::Calculator()
{
  cout << "+------------------------------+" << endl;
  cout << "| Compound Interest Calculator |" << endl;
  cout << "+------------------------------+" << endl;

  // Get validated input from user
  m_initialPrincipal = getValidDouble("Enter the initial principal amount: $");
  m_monthlyDeposit = getValidDouble("Enter the monthly deposit amount: $");
  m_annualInterestRate = getValidDouble("Enter the annual interest rate (in %): ");
  m_years = getValidInt("Enter the number of years: ");
}

/**
 * Gets a valid integer input from the user.
 * @param prompt The prompt to display to the user.
 * @return The valid integer input.
 */
int Calculator::getValidInt(const string &prompt)
{
  int value;
  while (true)
  {
    cout << prompt;
    cin >> value;
    if (cin.fail() || value <= 0)
    {
      cin.clear();
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      cout << "Invalid input. Please enter a positive real whole number." << endl;
    }
    else
    {
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      return value;
    }
  }
}

/**
 * Gets a valid double input from the user.
 * @param prompt The prompt to display to the user.
 * @return The valid double input.
 */
double Calculator::getValidDouble(const string &prompt)
{
  double value;
  while (true)
  {
    cout << prompt;
    cin >> value;
    if (cin.fail() || value <= 0)
    {
      cin.clear();
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      cout << "Invalid input. Please enter a positive real number." << endl;
    }
    else
    {
      cin.ignore(numeric_limits<streamsize>::max(), '\n');
      return value;
    }
  }
}

/**
 * Displays the reports for the investment calculator.
 */
void Calculator::displayReports()
{
  displayBalanceWithoutDeposits();
  cout << endl;
  displayBalanceWithDeposits();
}

/**
 * Displays the balance and interest without additional monthly deposits.
 */
void Calculator::displayBalanceWithoutDeposits()
{
  double balance = m_initialPrincipal;
  double monthlyRate = m_annualInterestRate / 100 / 12;

  // Create the report header
  cout << "+---------------------------------------------+" << endl;
  cout << "| Balance and Interest (w/o Monthly Deposits) |" << endl;
  cout << "+------+--------------------------+-----------+--------------+" << endl;
  cout << "| Year | Year-End Closing Balance | Year-End Earned Interest |" << endl;
  cout << "|------|--------------------------|--------------------------|" << endl;

  // Loop through each year and calculate the balance and interest
  for (int year = 1; year <= m_years; ++year)
  {
    double yearEndInterest = 0;

    // Even though it's an annual interest rate, it's compounded monthly
    for (int month = 1; month <= 12; ++month)
    {
      double monthlyInterest = balance * monthlyRate;

      // Add the monthly interest to the year-end interest
      yearEndInterest += monthlyInterest;

      // Add the monthly interest to the balance
      balance += monthlyInterest;
    }

    // Display the year, balance, and interest
    cout << fixed << setprecision(2);
    cout << "| " << setw(4) << right << year;
    cout << " | $" << setw(23) << right << balance;
    cout << " | $" << setw(23) << right << yearEndInterest;
    cout << " |" << endl;
  }

  cout << "+------+--------------------------+--------------------------+" << endl;
}

void Calculator::displayBalanceWithDeposits()
{
  double balance = m_initialPrincipal;
  double monthlyRate = m_annualInterestRate / 100 / 12;

  // Create the report header
  cout << "+--------------------------------------------+" << endl;
  cout << "| Balance and Interest (w/ Monthly Deposits) |" << endl;
  cout << "+------+--------------------------+----------+---------------+" << endl;
  cout << "| Year | Year-End Closing Balance | Year-End Earned Interest |" << endl;
  cout << "|------|--------------------------|--------------------------|" << endl;

  // Loop through each year and calculate the balance and interest
  for (int year = 1; year <= m_years; ++year)
  {
    double yearEndInterest = 0;

    // Even though it's an annual interest rate, it's compounded monthly
    for (int month = 1; month <= 12; ++month)
    {
      // Add the monthly deposit to the balance before calculating interest
      balance += m_monthlyDeposit;
      double monthlyInterest = balance * monthlyRate;

      // Add the monthly interest to the year-end interest
      yearEndInterest += monthlyInterest;

      // Add the monthly interest to the balance
      balance += monthlyInterest;
    }

    // Display the year, balance, and interest
    cout << fixed << setprecision(2);
    cout << "| " << setw(4) << right << year;
    cout << " | $" << setw(23) << right << balance;
    cout << " | $" << setw(23) << right << yearEndInterest;
    cout << " |" << endl;
  }

  cout << "+------+--------------------------+--------------------------+" << endl;
}