## Some ideas to improve the current project:

- use a non in memory database, for example **postgres** database (for production, it is more important)
- use a database integration tool, like **flyway/liquibase**
- the `Weather` entity can improve:
  - use `Long` as id
  - use `LocalDate` as date type
  - could add `created_at` and `updated_at` timestamps
- for integration test, **TestContainers** can be useful
- API-first could be beneficial