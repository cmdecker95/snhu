# CS 230 Module Four - GameAuth API

Dropwizard Java backend for game user authentication. Maven-managed project with health checks, REST controllers, DAO layer.

## Lessons Learned

- **[Java, Maven]:** `pom.xml` manages dependencies (Dropwizard, Jersey, Jackson). Avoids JAR hell.
- **[Java, Dropwizard]:** App class registers resources + health checks. `config.yml` externalizes config.
- **[Java, Health Checks]:** `/healthcheck` endpoint separate from API. Ops monitoring built in from day one.
- **[Java, DAO Pattern]:** In-memory `GameUserDB` simulates database. Abstracting data access behind interface makes DB swap easy.
