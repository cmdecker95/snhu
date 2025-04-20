#include <fstream>
#include <iostream>
#include <string>
#include <vector>
using namespace std;

/*
 * @brief Reads city names and average temperatures in Fahrenheit from a file.
 * Calculates the average temperature in Celsius for each city, then outputs
 * the results to a new file.
 *
 * @author Christian Decker
 * @date 2025-02-09
 */
int main() {
  ifstream inputFile;
  ofstream outputFile;
  string cityName;
  int temperatureF;
  int temperatureC;
  vector<string> cityNames;
  vector<int> temperaturesF;
  vector<int> temperaturesC;

  // Open the input file
  inputFile.open("FahrenheitTemperature.txt");
  if (!inputFile.is_open()) {
    cerr << "Error opening file." << endl;
    return 1;
  }

  // Read the input file
  while (inputFile >> cityName >> temperatureF) {
    cityNames.push_back(cityName);
    temperaturesF.push_back(temperatureF);
  }

  // Close the input file
  inputFile.close();

  // Calculate the average temperature in Celsius for each city
  for (int i = 0; i < temperaturesF.size(); ++i) {
    temperatureC = (temperaturesF[i] - 32) * 5 / 9;
    temperaturesC.push_back(temperatureC);
  }

  // Open the output file
  outputFile.open("CelsiusTemperature.txt");
  if (!outputFile.is_open()) {
    cout << "Error opening file." << endl;
    return 1;
  }

  // Write the output file
  for (int i = 0; i < cityNames.size(); ++i) {
    outputFile << cityNames[i] << " " << temperaturesC[i] << endl;
  }

  // Close the output file
  outputFile.close();

  return 0;
}