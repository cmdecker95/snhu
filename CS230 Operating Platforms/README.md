# CS230 Operating Platforms

This course centers on platform-oriented software design using Java architecture patterns, secure APIs, and full-stack service integration.

## [GameAuth Full Stack](./gameauth-full-stack)
Delivered an authenticated full-stack system with a Dropwizard API, React UI, and containerized local deployment.

### Lessons Learned
- Learned how to secure Java REST services using `Dropwizard` auth filters and role-based endpoint controls.
- Implemented typed frontend-to-backend contracts in `TypeScript` for safer CRUD interactions.
- Architected multi-service local delivery with Docker Compose for reproducible environments.

---

## [GameAuth API](./gameauth-full-stack/gameauth-api)
Built the backend service layer for authenticated game-user CRUD with validation and operational health checks.

### Lessons Learned
- Learned how to build REST resources in `Java` with clear response semantics for success and error cases.
- Implemented DTO validation and authorization policies close to controller endpoints.
- Fixed API reliability gaps by adding explicit conflict and not-found handling.

---

## [GameAuth UI](./gameauth-full-stack/gameauth-ui)
Implemented the React frontend for login, protected routes, and game-user management operations.

### Lessons Learned
- Learned how to enforce client-side access control in `React` using route guards.
- Implemented typed state and request payloads in `TypeScript` to reduce integration defects.
- Fixed frontend deployment flow with a multi-stage Docker build to serve static assets cleanly.

---

## [Singleton Game Service](./singleton-game-service)
Created a Java game domain model with singleton service ownership and uniqueness constraints for entities.

### Lessons Learned
- Learned how to implement a singleton manager in `Java` for centralized domain state.
- Implemented inheritance-based entity modeling to share behavior across game objects.
- Architected object creation rules that prevent duplicate names across collections.

---

## [Singleton Iterator Foundation](./singleton-game-service/singleton-iterator-foundation)
Built the milestone foundation for singleton lifecycle control and iterator-based game lookup.

### Lessons Learned
- Learned how to traverse and query game collections in `Java` using iterators.
- Implemented singleton initialization and guarded access through a static instance pattern.
