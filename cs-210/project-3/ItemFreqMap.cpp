#include <fstream>
#include <iostream>
#include <stdexcept>
#include <string>
#include <map>
#include "ItemFreqMap.h"
using namespace std;

// Constructor
ItemFreqMap::ItemFreqMap(const string& filename) {
  // Extract item frequency from input file 
  ifstream file(filename);
  if (!file.is_open()) {
    throw runtime_error("Could not open file");
  }

  string line;
  while (getline(file, line)) {
    ++itemFreqMap[line];
  }

  file.close();

  // Backup item frequency to file
  ofstream backupFile("frequency.dat");
  if (!backupFile.is_open()) {
    throw runtime_error("Could not open backup file");
  }

  for (map<string, int>::const_iterator item = itemFreqMap.begin(); item != itemFreqMap.end(); ++item) {
    backupFile << item->first << " " << item->second << endl;
  }

  backupFile.close();
}

// Get the frequency of the given item
int ItemFreqMap::getItemFrequency(const string& item) const {
  if (itemFreqMap.count(item)) {
    return itemFreqMap.at(item);
  }
  return 0;
}

// Prints all item frequencies
void ItemFreqMap::printAllFrequencies() const {
  for (map<string, int>::const_iterator item = itemFreqMap.begin(); item != itemFreqMap.end(); ++item) {
    cout << item->first << " " << item->second << endl;
  }
}

// Prints a histogram of item frequencies
void ItemFreqMap::printHistogram() const {
  for (map<string, int>::const_iterator item = itemFreqMap.begin(); item != itemFreqMap.end(); ++item) {
    cout << item->first << " ";
    for (int i = 0; i < item->second; ++i) {
      cout << "*";
    }
    cout << endl;
  }
}