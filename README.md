# s24-5pm-5-team01

Lab instructions: <https://ucsb-cs156.github.io/s24/lab/team01.html>

```
|   Name    | GitHub Id             |  Service                    | Controller                |
|-----------|-----------------------|-----------------------------|---------------------------|
|  Thomas   | Tommygithubaccount123 | `JokeQueryService`          | `JokeController`          |
|  Gen      | Ononymous             | `LocationQueryService`      | `LocationController`      |
|  Mai      | maidang111            | `PublicHolidayQueryService` | `PublicHolidayController` |
|  Tejas    | tejasvissa813         | `TidesQueryService`         | `TidesController`         |
|  Riley    | rileychou             | `UniversityQueryService`    | `UniversityController`    |
|  William  | walexgreen            | `ZipCodeQueryService`       | `ZipCodeController`       |
```

Repo: https://github.com/ucsb-cs156-s24/team01-s24-5pm-5

On Heroku: https://team01.dokku-13.cs.ucsb.edu/

## About this repo

This is a minimal backend only webapp built with Spring Boot.

The app provides some sample code for an API, and a Swagger user interface
to test that API.  The API is essentially a proxy for another API.

This code is the basis for a programming exercise where each student on a
team of up to 5 students can build a proxy similar to the one in the example code.

## What can you do with this code?

| Command | What it does   |
|----------|---------------------------------------|
| `mvn compile` | Should result in a clean compile |
| `mvn test` | Runs JUnit tests on the code base |
| `mvn test jacoco:report` | Runs JUnit tests, and if all tests pass, computes code coverage.  The code coverage report (Jacoco) can be found in `target/site/jacoco/index.html` |
| `mvn package` | Builds the jar file `target/team01-spring-boot-1.0.0.jar` |
| `mvn spring-boot:run` | Runs the code to startup a web server.  Access it via `http://localhost:8080` on the *same machine* where the server is running.  Use CTRL/C to stop it. |
| `java -jar target/team01-spring-backend-1.0.0.jar` | If done after `mvn package`, this is another way to start up the web server.|
| `mvn test pitest:mutationCoverage` | Run [pitest mutation coverage](https://pitest.org).  View `target/pit-reports/index.html` for results (may take a few minutes)|

# Deploying on Dokku

For advice on deploying on Dokku, see: [/docs/dokku.md](/docs/dokku.md)

