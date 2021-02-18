# habit Builder (not finish yet)

## Overview 
#### What is Habit Builder?
* Web app
* App target
  * People who want to track progress when building a new habit
  * People who would love to have friends support while developing their habits
* App features 
  * Start a habit
  * Track habit progress
  * Create a friendship and get encouragements from friends
## How to get it set up
#### Tech Stack for Habit Builder
* Back-end (In this habit-builder repo)
  * Spring Boot (Java)
* Database
  * PostgreSQL
* Front-end (In [reactjs-habit-builder](https://github.com/ichbinorange/reactjs-habit-builder) repo)
  * React (TypeScript)
#### Deployment
* Back-end
  * Dockerized Spirng Boot and deployed Docker image to Heroku
* Front-end
  * Deployed to Github Pages
## Resources that inspired this
#### Tutorials
* [Java concept](https://docs.oracle.com/javase/tutorial/) & [Java tutorial - Tutorialspoint](https://www.tutorialspoint.com/java/index.htm) & [Java tutorial - W3Schools](https://www.w3schools.com/java/default.asp)  
* [TypeScript handbook](https://www.typescriptlang.org/) 
* [Spring Boot documentations](https://spring.io/guides)
* [How to start Spring Boot](https://www.youtube.com/watch?v=9SGDpanrc8U)
  * Setup Entity --> Controller --> Service --> Repository --> Config
  * JPA + Hibernate
  * Gradle project for Spring Boot
    * [use Gradle.properties to setup environment variable](https://docs.gradle.org/current/userguide/build_environment.html)
  * PostgreSQL 
    * [How to get started with PostgreSQL](https://www.freecodecamp.org/news/how-to-get-started-with-postgresql-9d3bc1dd1b11/)
    * [PostgreSQL reserved keywords](https://www.postgresql.org/docs/8.1/sql-keywords-appendix.html)
    * [PostgreSQL terminal query](https://www.postgresql.org/docs/8.3/app-psql.html), ex \l, \c, \dt
  * [One-to-many table relations using JPA & Hibernate annotation](https://medium.com/@rajibrath20/the-best-way-to-map-a-onetomany-relationship-with-jpa-and-hibernate-dbbf6dba00d3)
* [Setup Spring Boot + React + Google OAuth](https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/)
  * Spring Security
  * OAuth2 Client
  * CORS
  * JWT 
* Docker
* [Deploy docker image to Heroku](https://devcenter.heroku.com/articles/container-registry-and-runtime)
  * troubleshooting 
    * [covert postgre format to JDBC format](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java)
    * [R10 no PORT issue]()
* Deploy React to Github Pages
  * troubleshooting SAP issues ([Github pages doesn't support Route](https://create-react-app.dev/docs/deployment/))
    * [Add a 404.html](https://github.com/rafgraph/spa-github-pages)
    
