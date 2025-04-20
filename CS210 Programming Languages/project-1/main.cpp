#include <string>
#include <iostream>
#include "time.h"

using namespace std;

void displayMenu();

int main() {

  // The user can input one of four commands:
  // 1 - Add one hour
  // 2 - Add one minute
  // 3 - Add one second
  // 4 - Exit
  // Anything else will display the menu again
  enum Command { ADD_HOUR = '1', ADD_MINUTE = '2', ADD_SECOND = '3', EXIT = '4' };
  Command command;
  
  int hours;
  int minutes;
  int seconds;

  // Get user input for initial time
  initializeTime(&hours, &minutes, &seconds);

  // Display the initial time before displaying the menu,
  // which is a liberty taken by the author of this code
  // in order to provide better UX.
  displayTime(hours, minutes, seconds);
  displayMenu();

  while (true) {
    string input;
    cin >> input;
    command = static_cast<Command>(input[0]);

    switch (command) {

      // Add one hour, wrapping around to 0 after 23
      case ADD_HOUR:
        addHour(&hours);
        displayTime(hours, minutes, seconds);
        displayMenu();
        break;

      // Add one minute, wrapping around to 0 after 59
      // while also incrementing the hour if necessary
      case ADD_MINUTE:
        addMinute(&hours, &minutes);
        displayTime(hours, minutes, seconds);
        displayMenu();
        break;

      // Add one second, wrapping around to 0 after 59
      // while also incrementing the minute if necessary
      case ADD_SECOND:
        addSecond(&hours, &minutes, &seconds);
        displayTime(hours, minutes, seconds);
        displayMenu();
        break;

      // Exit the program
      case EXIT:
        cout << "Goodbye!" << endl;
        return 0;

      // Make no changes if the command is invalid
      default:
        displayMenu();
        break;
    }
  }

  // Technically, this return statement is unnecessary,
  // but it is included for clarity and posterity.
  return 0;
}

void displayMenu() {
  cout << endl << "Menu:" << endl;
  cout << "1 - Add one hour" << endl;
  cout << "2 - Add one minute" << endl;
  cout << "3 - Add one second" << endl;
  cout << "4 - Exit" << endl;
}