# CS210 Module 1 - Hello World Comparison

## Assignment Brief
This module implements the same "Hello, World!" output in both C++ (`main.cpp`) and Python (`main.py`). The scope is a minimal syntax comparison between a compiled language and an interpreted scripting language, with no external libraries or build tooling.

## Lessons Learned (High Impact)
- **[C++, iostream, Program Entry]:** The C++ version requires includes, namespace handling, and an explicit `main` return path to print one line. Language ceremony is higher but execution boundaries are explicit.
- **[Python, print]:** The Python version performs the same task with a single top-level `print()` call. Lower ceremony reduces friction for simple scripting tasks.
- **[Cross-language Comparison, Runtime Model]:** Both files produce identical output while using different language structures and startup assumptions. Matching behavior across implementations clarifies where complexity comes from syntax versus logic.
