
#ifndef INVESTMENT_CALCULATOR_H_
#define INVESTMENT_CALCULATOR_H_

#include <string>
using namespace std;

class Calculator
{
public:
  // Constructor handles input intake and validation
  Calculator();

  // Display reports
  void displayReports();

private:
  double m_initialPrincipal;
  double m_monthlyDeposit;
  double m_annualInterestRate;
  int m_years;

  // Report display helpers
  void displayBalanceWithoutDeposits();
  void displayBalanceWithDeposits();

  // Input validation helpers
  int getValidInt(const string &prompt);
  double getValidDouble(const string &prompt);
};

#endif // INVESTMENT_CALCULATOR_H_