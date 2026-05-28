# CS230 Project 1 Milestone - Singleton and Iterator Foundation

## Assignment Brief
This milestone implements an early Java version of the game service model focused on singleton lifecycle and iterator-based game lookup. `GameService` owns a singleton `instance`, maintains a game list, and uses iterators to enforce unique names when adding or searching games. This README covers only milestone source under `project-1/milestone`.

## Lessons Learned (High Impact)
- **[Java, Singleton Pattern]:** A private static `instance` and `getInstance()` gate construction of `GameService`. Shared global access ensures one authoritative game collection.
- **[Java, Iterator, Collection Traversal]:** `Iterator<Game>` is used for duplicate checks and lookups by name/id. Iterator-based traversal keeps collection access explicit and extensible.
- **[Java, Encapsulation]:** `Game`, `Player`, and `Team` expose identifiers and names through getters without mutators. Limited write paths reduce accidental object-state mutation.
