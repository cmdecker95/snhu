# CS210 Module 5 - Fahrenheit to Celsius File Conversion

## Assignment Brief
This module reads city-temperature pairs from `FahrenheitTemperature.txt`, converts each Fahrenheit value to Celsius, and writes results to `CelsiusTemperature.txt`. The C++ program uses vectors to store parsed input before transformation and output.

## Lessons Learned (High Impact)
- **[C++, fstream, Error Handling]:** The program checks `is_open()` for both input and output streams before processing. Fast-fail file checks avoid silent data loss.
- **[C++, vector, Batch Processing]:** Reading into parallel vectors and transforming in a separate loop decouples parsing from conversion. This structure makes each stage easier to inspect and test.
- **[C++, Integer Arithmetic]:** Celsius conversion uses integer math (`(F - 32) * 5 / 9`) with truncation behavior. Numeric type choices directly affect output precision.
