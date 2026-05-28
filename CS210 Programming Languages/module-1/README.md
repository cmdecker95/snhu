# CS210 Module 1 — Hello World in C++ and Python

Two implementations of the classic Hello World program written the same day (2025-01-06) in C++ and Python, demonstrating the syntax and ceremony differences between a compiled systems language and an interpreted scripting language.

## Lessons Learned

- **[C++, iostream, main function]:** C++ requires `#include <iostream>` for console I/O and an explicit `int main()` entry point returning `0` to the OS. Even trivial output demands boilerplate the language enforces.
- **[C++, cout, endl]:** `cout` with `<<` insertion and `endl` (newline + flush) is the standard C++ output pattern. The `using namespace std;` directive avoids repeated `std::` prefix but pulls the entire std namespace into scope — a tradeoff between brevity and namespace pollution.
- **[Python, print function]:** Python's built-in `print()` needs no import, no entry-point function, no type annotations, and no explicit return. The language runtime handles all ceremony implicitly.
- **[C++ vs Python, language comparison]:** Same algorithm (~10 tokens of logic) requires 3× the lines in C++ (15 vs 8) due to include directives, namespace declarations, function signatures, and return statements. This illustrates the C++ philosophy of explicit control versus Python's "convention over configuration" design.
