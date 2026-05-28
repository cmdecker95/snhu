# CS210 Project 2 - Airgead Banking Calculator

## Assignment Brief
This project builds a C++ compound-interest calculator that prints yearly reports with and without monthly deposits. `main.cpp` handles repeat-run control, and the `Calculator` class handles validated user input plus monthly compounding calculations.

## Lessons Learned (High Impact)
- **[C++, Class Design, Separation of Concerns]:** Report generation and validation are encapsulated in `Calculator` while `main` remains orchestration-only. This keeps financial logic isolated from control flow.
- **[C++, Input Validation, numeric_limits]:** `getValidInt` and `getValidDouble` loop until positive numeric input and clear stream failures between attempts. Robust input gating prevents invalid financial calculations.
- **[C++, Financial Computation, Precision]:** Yearly reports derive from monthly rate application and accumulated yearly interest with `double` plus fixed formatting. Predictable precision improves trust in money-related output.
