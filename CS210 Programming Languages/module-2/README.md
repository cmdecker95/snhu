# CS210 Module 2 - Calculator Debugging

## Assignment Brief
This module contains a broken starter calculator (`Calculator.cpp`) and a corrected version (`Calculator-fixed.cpp`) with preserved inline "OLD/NEW/ADD" change notes. The fixed implementation repairs syntax issues, arithmetic branch behavior, and input-loop handling for repeated calculations.

## Lessons Learned (High Impact)
- **[C++, Debugging Workflow]:** Keeping original faulty lines as comments beside fixes creates an auditable change trail from bug to correction. This improves traceability during review and grading.
- **[C++, Control Flow, Conditionals]:** Removing stray semicolons after `if` conditions and adding braces restores branch correctness for arithmetic operations. Small syntax mistakes can silently break business logic.
- **[C++, Input Validation, Error Handling]:** The fixed version validates replay prompts and handles division-by-zero before calculating. Guard clauses prevent runtime failures and undefined output.
