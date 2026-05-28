# CS230 Project 1 - Singleton Game Service

## Assignment Brief
This project implements a Java domain model for games, teams, and players with singleton-managed service state and uniqueness checks during entity creation. The `GameService`, `Game`, `Team`, and `Player` classes coordinate ID generation, duplicate detection, and object relationships, while `ProgramDriver` and `SingletonTester` exercise the behavior.

## Lessons Learned (High Impact)
- **[Java, Singleton Pattern]:** `GameService.getService()` returns one shared instance through a private constructor and static holder. Centralized lifecycle avoids conflicting game registries.
- **[Java, Domain Modeling, Inheritance]:** `Entity` provides shared id/name behavior that `Game`, `Team`, and `Player` extend. Reuse at the model layer reduces duplication and keeps object APIs consistent.
- **[Java, Collection Validation]:** Add methods scan existing collections before constructing new game/team/player objects with incrementing IDs. Enforcing uniqueness at write-time protects data integrity.
- **[Java, Driver-based Verification]:** `ProgramDriver` and `SingletonTester` explicitly test duplicate paths and singleton reuse. Scenario-driven checks validate behavior without external test frameworks.
