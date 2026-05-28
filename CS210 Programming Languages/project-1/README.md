# CS210 Project 1 - Dual Clock Console App

## Assignment Brief
This project implements a C++ console clock that displays synchronized 12-hour and 24-hour formats and lets users increment hours, minutes, or seconds from a menu. `main.cpp` controls interaction flow while `time.cpp`/`time.h` encapsulate parsing, formatting, and rollover logic.

## Lessons Learned (High Impact)
- **[C++, Modular Design, Header Files]:** Extracting time operations into `time.cpp` with declarations in `time.h` keeps UI flow separate from date-time logic. Clear boundaries simplify maintenance.
- **[C++, Input Validation, Streams]:** `inputInt()` repeatedly clears `cin` error state and ignores invalid buffer content before retrying. This prevents malformed input from corrupting clock state.
- **[C++, Time Arithmetic]:** Hour/minute/second increment functions implement rollover chaining (second -> minute -> hour) using modulo constraints. Explicit overflow handling preserves correctness over long sessions.
