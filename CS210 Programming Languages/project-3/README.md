# CS 210 Project Three - Corner Grocer Item Tracker

Frequency analyzer for grocery purchase data. Reads receipt items, counts occurrences, shows histogram. C++ with map-based storage.

## Lessons Learned

- **[C++, std::map]:** Map gives O(log n) frequency lookups. Chose over vector for readability and performance.
- **[C++, File I/O]:** Read input, write `frequency.dat` backup. Dual file ops reinforce robust data handling.
- **[C++, Histogram]:** Asterisk visual frequency display. Simple format, high impact for stakeholders.
- **[C++, Class Design]:** `ItemFreqMap` class with public interface, private map. Clean separation for testability.
