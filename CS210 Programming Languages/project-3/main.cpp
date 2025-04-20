#include <iostream>
#include "ItemFreqMap.h"
using namespace std;

/*
 * Runs the "Corner Grocer Item Frequency Program"
 *
 * @author Christian Decker
 * @date 2025-02-23
 */
int main() {

    const string FILENAME = "CS210_Project_Three_Input_File.txt";
    ItemFreqMap itemFreqMap(FILENAME);

    // Menu loop
    int choice;
    do {
      cout << "Menu:\n";
      cout << "1. Look up item frequency\n";
      cout << "2. Print all item frequencies\n";
      cout << "3. Print histogram of item frequencies\n";
      cout << "4. Exit\n";
      cout << "Enter your choice: ";
      cin >> choice;

      // Handle menu choice
      switch (choice) {
        case 1: {
          string item;
          cout << "Enter item name: ";
          cin >> item;
          int frequency = itemFreqMap.getItemFrequency(item);
          cout << "Frequency of " << item << ": " << frequency << endl;
          break;
        }
        case 2:
          itemFreqMap.printAllFrequencies();
          break;
        case 3:
          itemFreqMap.printHistogram();
          break;
        case 4:
          cout << "Exiting program." << endl;
          break;
        default:
          cout << "Invalid choice. Please try again." << endl;
      }
    } while (choice != 4);

  return 0;
}