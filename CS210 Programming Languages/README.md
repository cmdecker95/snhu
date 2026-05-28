# CS210 Programming Languages

This course focuses on building reliable C++ applications with strong debugging, input handling, file processing, and object-oriented design practices.

## [Corner Grocer Frequency Tracker](./corner-grocer-frequency-tracker)
Built a menu-driven inventory analyzer that reads item data, computes frequencies, and exports report output.

### Lessons Learned
- Learned how to do frequency counting in `C++` using `std::map` and incremental updates.
- Implemented exception-based file handling patterns for safer CLI workflows.
- Architected menu features around reusable class methods instead of duplicating logic.

---

## [Airgead Banking Calculator](./airgead-banking-calculator)
Implemented a compound-interest reporting tool with yearly summaries with and without monthly deposits.

### Lessons Learned
- Learned how to model financial calculations in `C++` using controlled monthly compounding loops.
- Implemented robust numeric input validation using stream state checks and `numeric_limits`.
- Fixed rounding and output consistency issues with formatted precision controls.

---

## [Dual Clock Console App](./dual-clock-console-app)
Created an interactive dual-format clock that keeps synchronized 12-hour and 24-hour displays.

### Lessons Learned
- Learned how to manage time rollover logic in `C++` across hours, minutes, and seconds.
- Implemented separation of concerns through header/source modular design.
- Architected user interaction flow so UI actions call focused time-update functions.

---

## [Fahrenheit to Celsius](./fahrenheit-to-celsius)
Developed a file transformation program that converts city temperatures and writes converted output.

### Lessons Learned
- Learned how to do staged file pipelines in `C++` with input parsing, transform, and output phases.
- Implemented defensive file-open checks before processing data.
- Fixed conversion workflow by separating parsing and conversion loops for easier testing.

---

## [Calculator Debugging](./calculator-debugging)
Repaired a broken arithmetic program by correcting syntax errors, control flow, and replay handling.

### Lessons Learned
- Learned how to debug conditional behavior in `C++` by tracing branch execution.
- Implemented safer divide operations with explicit zero checks.
- Fixed repeated-input logic by validating replay prompts and stream state.

---

## [Hello World Comparison](./hello-world-comparison)
Compared identical output behavior in C++ and Python to understand language ceremony and runtime style.

### Lessons Learned
- Learned how equivalent logic differs between `C++` and `Python` entry-point structure.
- Implemented minimal test cases to verify cross-language output parity.
