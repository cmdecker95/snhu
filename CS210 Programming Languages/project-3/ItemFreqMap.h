#ifndef ITEM_FREQ_MAP_H
#define ITEM_FREQ_MAP_H

#include <iostream>
#include <map>
#include <string>
using namespace std;

class ItemFreqMap {
public:

  // Constructed with the filename of the input file
  ItemFreqMap(const string& filename);

  // Returns the frequency of the given item
  int getItemFrequency(const string& item) const;

  // Prints all item frequencies
  void printAllFrequencies() const;

  // Prints a histogram of item frequencies
  void printHistogram() const;

private:
  map<string, int> itemFreqMap;
};

#endif // ITEM_FREQ_MAP_H
