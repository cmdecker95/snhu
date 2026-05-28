# CS210 Programming Languages Portfolio

## Assignment Brief
This folder contains CS210 module and project work written in C++ with one Python comparison exercise. The code covers debugging a broken calculator, file transformation from Fahrenheit to Celsius, a dual-clock console app, an interest calculator, and a grocery frequency analyzer. Scope here is course-level; implementation details live in module and project subfolders.

## Lessons Learned (High Impact)
- **[C++, Input Validation, Defensive Programming]:** Multiple assignments use loops around `cin` failure handling and constrained numeric input before processing. Early validation prevents invalid state from propagating through calculations.
- **[C++, Header/Source Separation]:** Projects split interfaces (`.h`) from implementations (`.cpp`) for reusable types like `Calculator`, `ItemFreqMap`, and time utilities. This improves maintainability and compile-time clarity.
- **[C++, File I/O, Data Pipelines]:** Exercises read structured text, transform data, and persist output files (`CelsiusTemperature.txt`, `frequency.dat`). Explicit I/O stages make results reproducible and testable.
- **[C++, OOP, Single Responsibility]:** Project code moves domain logic into focused classes while `main` handles user interaction and control flow. This supports clearer extension paths and easier reasoning.
- **[C++, Python, Language Tradeoffs]:** The module-1 pair of hello-world programs shows equivalent behavior with very different runtime/setup ceremony. Language choice directly affects implementation overhead.
