# CS230 Module 4 UI - GameAuth Frontend

## Assignment Brief
This subfolder contains the React + TypeScript frontend for module-4 game-user authentication and CRUD management. `App.tsx` enforces route guarding using a cookie token, `Login.tsx` handles credential entry, and `Home.tsx` executes typed REST calls for create/read/update/delete workflows. Tooling includes Vite, TypeScript project references, ESLint, Tailwind plugin integration, and a Docker build for static serving via Nginx.

## Lessons Learned (High Impact)
- **[React Router, Client-side Auth Guard]:** Route rendering depends on presence of a `TOKEN` cookie before loading protected views. Guarded routing prevents accidental access to privileged screens.
- **[TypeScript, DTO Contracts]:** A shared `GameUserInfo` type drives UI state and API payload shapes. Strong typing catches schema mismatches during development instead of at runtime.
- **[Fetch API, Basic Auth]:** Each CRUD action sets explicit method, headers, and serialized payload against backend endpoints. Transparent request construction simplifies debugging network failures.
- **[Vite, Modern Frontend Tooling]:** Vite + React plugin plus concise config delivers fast iteration with low configuration overhead. Faster feedback loops accelerate UI refinement.
- **[Docker, Static Deployment]:** Multi-stage build compiles app assets in Node and serves final output from Nginx. Separating build and serve stages reduces production image complexity.
