# CS230 Operating Platforms Portfolio

## Assignment Brief
This folder contains CS230 work spanning Java design-pattern exercises and a module-4 full-stack implementation. The project folders model game entities and singleton service behavior in Java, while `module-4` adds a Dropwizard REST API, a React + TypeScript UI, and Docker Compose orchestration. This README covers the full CS230 folder scope rather than a single submodule.

## Lessons Learned (High Impact)
- **[Java, Singleton Pattern]:** Both milestone and final project code centralize game state in a singleton service (`getInstance`/`getService`) to avoid duplicate managers. Shared state ownership is explicit and testable.
- **[Java, Collection Traversal, Uniqueness Rules]:** Game/team/player creation paths check existing collections before adding new objects. Enforcing uniqueness at creation time prevents inconsistent domain data.
- **[Dropwizard, JAX-RS, Role-based Access]:** Module-4 API protects CRUD endpoints with `@PermitAll` and `@RolesAllowed` backed by a basic authenticator/authorizer pair. Authorization rules remain close to endpoint definitions.
- **[React, TypeScript, REST Integration]:** The UI performs typed CRUD requests against `/gameusers` and binds responses into dashboard state. Typed DTO usage reduces integration ambiguity.
- **[Docker Compose, Multi-service Delivery]:** `compose.yml` coordinates API and UI containers with shared local networking and exposed ports. This provides one-command local environment startup.
