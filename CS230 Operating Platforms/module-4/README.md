# CS230 Module 4 - GameAuth Full Stack

## Assignment Brief
This module implements authenticated game-user CRUD across a Java Dropwizard backend (`api`) and a React + TypeScript frontend (`ui`). The backend configures auth filters, role-protected JAX-RS endpoints, validation, health checks, and CORS; the frontend provides login and dashboard flows that call backend routes via `fetch`. Dockerfiles plus `compose.yml` define local multi-container execution for both services.

## Lessons Learned (High Impact)
- **[Dropwizard, Basic Auth, RolesAllowed]:** Backend auth uses `BasicCredentialAuthFilter` with `GameAuthenticator` and `GameAuthorizer`, and endpoint-level role annotations enforce access rules. Authorization policy stays explicit at the API surface.
- **[JAX-RS, HTTP Semantics, Validation]:** `GameUserRESTController` returns distinct status codes for create/update/not-found/conflict/validation outcomes and validates DTO constraints before persistence. Clear response contracts improve client reliability.
- **[Java, HashMap, In-memory DAO]:** `GameUserDB` provides a static map-based store with CRUD helpers for rapid prototyping. Data-access indirection simplifies later migration to persistent storage.
- **[React, TypeScript, State-driven CRUD]:** `Home.tsx` maintains typed user state and maps each UI action to explicit REST calls. Strongly typed request/response flow reduces integration defects.
- **[Docker, Maven, Node, Compose]:** Multi-stage builds for API and UI plus compose-level service wiring create a reproducible local stack. Environment parity lowers "works on my machine" risk.
