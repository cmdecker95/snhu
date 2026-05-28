/*
 * Calculator.cpp
 *
 *  Date: 2025-01-25
 *  Author: Christian Decker
 *
 *  Assignment: Debug the original Calculator.cpp, leaving previous code as
 * inline comments.
 *
 *  Legend:
 *  - OLD: the old code, unchanged beyond being commented out
 *  - NEW: the new code, replacing the OLD code above it
 *  - ADD: new-new code, added without replacing previous code
 *
 *  Misc:
 *  - Formatted whitespace to my own taste
 *  - Organized variable declarations
 */

#include <iostream>

using namespace std;

// OLD: void main()
// NEW: define main to return an int representing the error code
int main() {
  // OLD: char answer="Y"
  // NEW: char literals use single quotes
  char answer = 'Y';
  char operation;
  char statement[100];
  // OLD: int op1, op2;
  // NEW: change operands to double for decimal support
  double op1, op2;

  // OLD: while (answer == 'y') {
  // NEW: continue loop if answer is 'y' or 'Y'
  while (answer == 'y' || answer == 'Y') {

    cout << "Enter expression" << endl;

    // OLD: cin >> op2 >> operation >> op1;
    // NEW: switch op1 and op2 to match input order to calculation order
    cin >> op1 >> operation >> op2;

    // OLD: if (operation == "+");
    // NEW: switch to single quotes, add braces for conditional block
    if (operation == '+') {
      // OLD: cout << op1 << " + " << op2 >> " = " << op1 + op2 << endl;
      // NEW: flip '>>' to '<<' for cout
      cout << op1 << " + " << op2 << " = " << op1 + op2 << endl;
    }

    // OLD: if (operation == '-');
    // NEW: add braces for conditional block
    if (operation == '-') {
      // OLD: cout >> op1 << " - " << op2 << " = " << op1 - op2 << endl;
      // NEW: flip '>>' to '<<' for cout
      cout << op1 << " - " << op2 << " = " << op1 - op2 << endl;
    }

    // OLD: if (operation == '*');
    // NEW: add braces for conditional block
    if (operation == '*') {
      // OLD: cout << op1 << " / " << op2 << " = " << op1 * op2 << endl
      // NEW: switch printed operation to match result, end with missing ;
      cout << op1 << " * " << op2 << " = " << op1 * op2 << endl;
    }

    // OLD: if (operation == '/');
    // NEW: add braces for conditional block
    if (operation == '/') {
      // ADD: prevent dividing by zero
      if (op2 == 0) {
        cout << "Cannot divide by zero" << endl;
      } else {
        // OLD: cout << op1 << " * " << op2 << " = " << op1 / op2 << endl;
        // NEW: switch printed operation to match result, end with missing ;
        cout << op1 << " / " << op2 << " = " << op1 / op2 << endl;
      }
    }

    // ADD: continue to accept input until input is valid
    while (true) {
      cout << "Do you wish to evaluate another expression? " << endl;
      cin >> answer;

      // ADD: break only if user input is valid (n/N/y/Y)
      if (answer != 'n' && answer != 'N' && answer != 'y' && answer != 'Y') {
        cout << "Invalid input. Type (y/Y) for yes, or (n/N) for no." << endl;
      } else {
        break;
      }
    }

    // ADD: terminate program if answer set to n/N
    if (answer == 'n' || answer == 'N') {
      cout << "Program Finished" << endl;
      break;
    }
  }

  // ADD: return int from main
  return 0;
}
