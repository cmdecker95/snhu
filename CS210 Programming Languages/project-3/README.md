# CS210 Project 3 - Corner Grocer Frequency Tracker

## Assignment Brief
This project reads grocery item names from an input file, counts item frequency, and provides menu-driven lookup, full listing, and histogram output. The `ItemFreqMap` class owns file ingestion, map-backed counting, and backup export to `frequency.dat`, while `main.cpp` handles user interaction.

## Lessons Learned (High Impact)
- **[C++, std::map, Frequency Analysis]:** Item counts are accumulated with `++itemFreqMap[line]` over each input line. Associative containers make incremental counting concise and reliable.
- **[C++, Exceptions, File I/O]:** Constructor-level checks throw `runtime_error` when source or backup files cannot be opened. Explicit failure signaling avoids partial or misleading reports.
- **[C++, CLI Design, Data Presentation]:** Separate methods for point lookup, full dump, and histogram provide multiple views over the same dataset. Multiple output modes improve usability without duplicating storage logic.
