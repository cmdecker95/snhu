# CS 230 Module Four - Dropwizard REST API & React Login UI

Built RESTful game user management API with Dropwizard (Java). Basic Authentication, role-based authorization (ADMIN/USER), React login UI.

## Lessons Learned

- **[Java, Dropwizard]:** Bundles Jetty + Jersey + Jackson. Fast path to production REST. Config via YAML.
- **[Java, JAX-RS]:** `@Path`, `@GET`, `@POST`, `@Produces` define endpoints declaratively.
- **[Java, Basic Auth]:** `@Auth` + authenticator/authorizer classes. Simple auth; upgrade to OAuth2 later.
- **[Java, Role-based Access]:** `@RolesAllowed("ADMIN")` restricts endpoints. Principle of least privilege.
- **[React, TypeScript, Vite]:** SPA login with typed API calls. Vite HMR speeds dev cycle.
- **[Docker Compose]:** `compose.yml` containerizes API + UI. Consistent local dev environment.
