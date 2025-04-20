# CS 210 Project One - Dual Clock (12 & 24 Hour)

OOP C++ app displaying two clocks simultaneously (12-hr and 24-hr). User can add hour/minute/second. Modular design with header files.

## Lessons Learned

- **[C++, OOP]:** Separated clock logic into `time.cpp`/`time.h`. Modularization keeps `main()` clean.
- **[C++, Encapsulation]:** Private members + public methods control state. Prevents invalid time values.
- **[C++, ISO 8601]:** 24-hr clock meets international standard. Real-world code must comply with regulations.
- **[C++, Console UX]:** Side-by-side clock display via console formatting. Presentation matters in CLI too.
