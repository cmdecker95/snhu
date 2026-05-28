# CS230 Module 4 — GameAuth: Dropwizard API + React UI

Full-stack CRUD application with a Java Dropwizard REST API backend and a React + TypeScript frontend, orchestrated via Docker Compose. Demonstrates authenticated role-based user management over HTTP.

## Lessons Learned

- **[Dropwizard, Basic Auth, JAX-RS]:** Dropwizard's `BasicCredentialAuthFilter` paired with `@PermitAll` and `@RolesAllowed` annotations provides declarative auth on endpoints. `GameAuthenticator` validates credentials against a hardcoded user map with role sets; `GameAuthorizer` checks role membership at runtime.
- **[Dropwizard, CORS, Jetty]:** `CrossOriginFilter` is registered programmatically with wildcard origins, methods, and headers (`*`) to allow the frontend dev server to call the API. CORS must be configured when serving a separate UI from the API host.
- **[Java, HashMap, In-memory store]:** `GameUserDB` uses a static `HashMap<Integer, GameUserInfo>` as a lightweight data layer with seed users. Suitable for prototyping before migrating to a persistent database.
- **[JAX-RS, RESTful CRUD, HTTP status codes]:** `GameUserRESTController` maps `GET/POST/PUT/DELETE` to `/gameusers` with distinct status codes — 201 for creation, 200 for success, 400 for validation errors, 404 for missing resources, 409 for duplicate ID — communicating intent clearly to clients.
- **[JAX-RS, Client API, Auth forwarding]:** `RESTClientController` builds a Jersey `Client` via `JerseyClientBuilder`, proxies requests to the same API, and forwards the `Authorization` header from the incoming request. Demonstrates server-side REST client usage in Dropwizard.
- **[Dropwizard, Health checks]:** `AppHealthCheck` pings the `/gameusers` endpoint and returns healthy/unhealthy status. `HealthCheckController` exposes `/status` as a JSON endpoint. Registered in `GameAuthApplication.run()` with `e.healthChecks().register()`.
- **[React, TypeScript, Vite, Tailwind CSS 4]:** Modern frontend stack. Vite configured with `@tailwindcss/vite` plugin (CSS-first Tailwind 4 via `@import "tailwindcss"`). TypeScript types defined in `types.ts` for the `GameUserInfo` DTO shared with the API.
- **[React Router, Cookie-based auth guard]:** `App.tsx` checks `document.cookie` for a `TOKEN` cookie to conditionally render `Home` or redirect to `/login` with `<Navigate>`. Simple session pattern without server-side state.
- **[React, fetch API, Basic Auth]:** `Home.tsx` performs full CRUD using `fetch()` with HTTP Basic Auth headers encoded from the cookie value. Uses `async/await` with try/catch error handling for each operation.
- **[Docker, Multi-stage builds, Docker Compose]:** API Dockerfile uses `maven:3.8-openjdk-11` to build and `openjdk:11-jre-slim` to run. UI Dockerfile uses `node:20-alpine` to build and `nginx:alpine` to serve static assets. `compose.yml` wires both services, exposing API ports 8080/8081 and UI port 80 with `depends_on`.
- **[Java, DTO vs Principal separation]:** `GameUser` (principal with `id`, `name`, `roles`) and `GameUserInfo` (data DTO with `id`, `firstName`, `lastName`, `email`) are distinct classes serving different concerns — one for auth context, one for business data. The controller explicitly cautions against conflating them.
- **[Hibernate Validator, Bean Validation annotations]:** `GameUserInfo` uses `@NotNull`, `@NotBlank`, `@Length(min=2, max=255)`, and `@Pattern(regexp=".+@.+\\.[a-z]+")` on fields. The REST controller validates incoming objects and returns 400 with violation messages — keeps validation declarative and consistent.
