# CS 210 Module Five - File I/O: Fahrenheit to Celsius

Read city temperatures from `FahrenheitTemperature.txt`, converted F to C, wrote to `CelsiusTemperature.txt`. Pure file I/O exercise.

## Lessons Learned

- **[C++, fstream]:** `ifstream` for read, `ofstream` for write. Separate I/O objects prevent accidental overwrite.
- **[C++, Data Parsing]:** Spaces delimit city name from int temperature. Parsing structured text is foundational.
- **[C++, Integer Math]:** `(°F - 32) * 5 / 9`. Order of ops matters - integer division truncates without float cast.
