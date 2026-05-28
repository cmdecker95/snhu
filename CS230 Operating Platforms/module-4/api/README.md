# CS230 Module 4 API - GameAuth Backend

## Assignment Brief
This subfolder contains a Java Dropwizard backend for authenticated game-user CRUD operations. It includes role-aware authentication/authorization, JAX-RS resource controllers, DTO validation, in-memory persistence helpers, health-check endpoints, and Maven/Docker build configuration. This README documents only the `api` scope, not the frontend.

## Lessons Learned (High Impact)
- **[Java, Dropwizard, Dependency Management]:** `pom.xml` centralizes Dropwizard/auth/client/validation dependencies and build plugins (shade, compiler, jar). Controlled dependency graphs keep packaging predictable.
- **[Dropwizard, Authentication, Authorization]:** `GameAuthApplication` wires `BasicCredentialAuthFilter`, principal binding, and `RolesAllowedDynamicFeature` for endpoint protection. Security plumbing is framework-integrated rather than ad hoc.
- **[JAX-RS, Bean Validation, Response Modeling]:** Controller methods validate `GameUserInfo` constraints and return targeted HTTP responses for conflict, not-found, and malformed input. Explicit contract handling improves API robustness.
- **[Health Checks, Operational Readiness]:** `AppHealthCheck` performs authenticated downstream checks and `HealthCheckController` exposes health status. Built-in observability enables faster diagnosis in deployed environments.
- **[Docker, Java Runtime Packaging]:** The Dockerfile builds with Maven and runs with a slim JRE image exposing app/admin ports. Containerized packaging standardizes runtime setup.
