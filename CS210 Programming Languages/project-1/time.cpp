#include "time.h"
#include <iostream>

using namespace std;

/**
 * A safe way to handle input, ensuring the user enters an integer.
 */
int inputInt() {
  int input;

  while (true) {
    cin >> input;

    // If the input is an integer, return it
    if (!cin.fail()) return input;

    // If the input is not an integer, clear the error and try again
    cin.clear();
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cout << "Invalid input. Please try again: ";
  }
}

/**
 * Initializes the time using user input for hours, minutes, and seconds.
 *
 * @param hours int* the current hour
 * @param minutes int* the current minute
 * @param seconds int* the current second
 */
void initializeTime(int *hours, int *minutes, int *seconds) {
  // Temporary variables for time, used to constrain the range of input
  int tempHours;
  int tempMinutes;
  int tempSeconds;

  cout << "Enter the current time:" << endl;

  // Get hours
  cout << "Hours   (0-23): ";
  tempHours = inputInt();
  *hours = tempHours % 24;

  // Get minutes
  cout << "Minutes (0-59): ";
  tempMinutes = inputInt();
  *minutes = tempMinutes % 60;

  // Get seconds
  cout << "Seconds (0-59): ";
  tempSeconds = inputInt();
  *seconds = tempSeconds % 60;
}

/**
 * Display a number as a two-digit string.
 *
 * @param number int the number to display
 */
string displayTwoDigits(int number) {
  if (number >= 10) return to_string(number);  
  return "0" + to_string(number);
}

/**
 * Displays the current time.
 *
 * Example Input:
 * - hours = 12
 * - minutes = 34
 * - seconds = 56
 *
 * Example Output:
 * +-------------------+
 * | 12H   12:34:56 PM |
 * | 24H   12:34:56    |
 * +-------------------+
 *
 * @param hours the current hour
 * @param minutes the current minute
 * @param seconds the current second
 */
void displayTime(int hours, int minutes, int seconds) {
  // Bound time values, assuming overflow resets to 0.
  // Although we do this when initializing the time and when
  // adding time, we should do it here as well to ensure the
  // time is always displayed correctly.
  hours %= 24;
  minutes %= 60;
  seconds %= 60;

  cout << "+-------------------+" << endl;

  // Display the time in 12-hour format
  cout << "| 12H   " << displayTwoDigits(hours % 12);
  cout << ":" << displayTwoDigits(minutes);
  cout << ":" << displayTwoDigits(seconds);
  cout << " " << (hours >= 12 ? "PM" : "AM") << " |" << endl;

    // Display the time in 24-hour format
  cout << "| 24H   " << displayTwoDigits(hours);
  cout << ":" << displayTwoDigits(minutes);
  cout << ":" << displayTwoDigits(seconds);
  cout << "    |" << endl;

  cout << "+-------------------+" << endl;
}

/**
 * Adds one hour to the current time, wrapping around to 0 after 23.
 *
 * @param hours int* the current hour
 */
void addHour(int *hours) {
  *hours = (*hours + 1) % 24;
}

/**
 * Adds one minute to the current time, wrapping around to 0 after 59.
 * Also increments the hour if necessary.
 *
 * @param hours int* the current hour
 * @param minutes int* the current minute
 */
void addMinute(int *hours, int *minutes) {
  ++*minutes;

  // Increment the hour if necessary
  if (*minutes == 60) {
    *minutes = 0;
    addHour(hours);
  }
}

/**
 * Adds one second to the current time, wrapping around to 0 after 59.
 * Also increments the minute if necessary.
 *
 * @param hours int* the current hour
 * @param minutes int* the current minute
 * @param seconds int* the current second
 */
void addSecond(int *hours, int *minutes, int *seconds) {
  ++*seconds;
  
  // Increment the minute if necessary
  if (*seconds == 60) {
    *seconds = 0;
    addMinute(hours, minutes);
  }
}