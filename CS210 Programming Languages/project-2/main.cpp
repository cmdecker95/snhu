#include <cmath>
#include <iostream>
#include "Calculator.h"
using namespace std;

int main()
{
  bool loop = true;
  char choice;

  while (loop)
  {
    // This constructor will handle input intake and validation
    Calculator calculator;

    // Display the reports
    calculator.displayReports();

    // Prompt the user to continue or quit
    cout << "Continue? (y/n): ";
    cin >> choice;
    if (choice == 'n' || choice == 'N')
    {
      loop = false;
    }
    cout << endl;
  }

  cout << "Thank you for using the compound interest calculator by Airgead Banking!" << endl;
  return 0;
}