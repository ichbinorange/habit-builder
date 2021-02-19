# Habit Buddy 
## Overview 
#### What is Habit Buddy?
* <strong>Habit Buddy is a capstone project for [Ada Developers Academy](https://adadevelopersacademy.org/) by [ichbinorange](https://github.com/ichbinorange)</strong>
* Web app
* It was inspired by the support system of Ada developers Academy
  * Habit Buddy tries combining a habit developing system with a friend support system
* App target
  * People who want to track progress when building a new habit
  * People who would love to have friends support while developing their habits
* App features 
  * Start a habit
  * Track habit progress
  * Create a friendship and get encouragements from friends

<img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/habit-budy-homepage.png" alt="Habit Buddy homepage" width="500">.
## How to get it set up
* Sign up/login with your google account with [Habit Buddy](https://ichbinorange.github.io/reactjs-habit-builder/)
* Customize your profile
* Create your first Habit
* Submit a record about your habit, including how much time you spent on it
  * You then have the record for the habit; also
  * You can visualize your habit progress at a stacked bar chart either by month or by year
  * You can check the chart by single habit or overview all the habits
* Become friend with your friends by searching their email
  * You can send a friend request
  * You can confirm a friend request 
* Send an encouragement message to your friend based on their habits
* View the messages from your friends
## Demo
| Features                              |     Gifs    |
| :---                              |    :----:   |  
| Create a new habit                | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/add-habit.gif" alt="Create a new habit" width="500">       | 
| Create a habit record             | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/add-habit-record.gif" alt="Create a habit record" width="500">        | 
| Check progress chart              | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/check-chart.gif" alt="Check chart" width="500">       | 
| Create friendship                 | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/add-friend.gif" alt="Create friendship" width="500">       | 
| Send message to a friend's habit  | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/send-msg.gif" alt="Send message to a friend's habit" width="500">        | 
| Read message from friends         | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/view-msg.gif" alt="Read message from friends" width="500">        | 
## Tech Stack for Habit Buddy
#### Core tech
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

|         Tech Stack                      |     Database ERD    |
| :----:                              |    :----:   |  
| <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/tech-stack.png" alt="Tech Stack" width="500">               | <img src="https://github.com/ichbinorange/reactjs-habit-builder/blob/readme-demo/src/img/erd.png" alt="Database ERD" width="500">       | 
#### React dependencies
* [axios](https://www.npmjs.com/package/axios)
* [react-router-dom](https://www.npmjs.com/package/react-router-dom)
* [React-Bootstrap](https://www.npmjs.com/package/react-bootstrap)
* [React-vis](https://www.npmjs.com/package/react-vis) and its [storybook](http://uber.github.io/react-vis/website/dist/storybook/)
* [React Date Picker](https://www.npmjs.com/package/react-datepicker)
## Resources that made this app happened
#### Tutorials
* [Java concept](https://docs.oracle.com/javase/tutorial/) & [Java tutorial - Tutorialspoint](https://www.tutorialspoint.com/java/index.htm) & [Java tutorial - W3Schools](https://www.w3schools.com/java/default.asp)  
* [TypeScript handbook](https://www.typescriptlang.org/) 
* [Spring Boot Guides](https://spring.io/guides)
* [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
* [How to start Spring Boot (youtube)](https://www.youtube.com/watch?v=9SGDpanrc8U)
  * Setup Entity --> Controller --> Service --> Repository --> Config
  * JPA + Hibernate
  * Gradle project for Spring Boot
    * [use Gradle.properties to setup environment variable](https://docs.gradle.org/current/userguide/build_environment.html)
    * Spring Boot's [externalized configuration for properties order](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-external-config)
  * PostgreSQL 
    * [How to get started with PostgreSQL](https://www.freecodecamp.org/news/how-to-get-started-with-postgresql-9d3bc1dd1b11/)
    * [PostgreSQL reserved keywords](https://www.postgresql.org/docs/8.1/sql-keywords-appendix.html)
    * [PostgreSQL terminal query](https://www.postgresql.org/docs/8.3/app-psql.html), ex \l, \c, \dt
  * [One-to-many table relations using JPA & Hibernate annotation](https://medium.com/@rajibrath20/the-best-way-to-map-a-onetomany-relationship-with-jpa-and-hibernate-dbbf6dba00d3)
  * [Database auditing](https://springbootdev.com/2018/03/13/spring-data-jpa-auditing-with-createdby-createddate-lastmodifiedby-and-lastmodifieddate/)
* [Setup Spring Boot + React + Google OAuth](https://www.callicoder.com/spring-boot-security-oauth2-social-login-part-1/)
  * Spring Security
  * OAuth2 Client
  * CORS
  * JWT 
* Docker
  * [Docker Desktop](https://docs.docker.com/docker-for-mac/install/) 
  * [Spring Boot + PostgreSQL and Docker](https://www.baeldung.com/spring-boot-postgresql-docker)
  * [Setup .env for Dockerfile](https://docs.docker.com/compose/environment-variables/)
* [Deploy docker image to Heroku](https://devcenter.heroku.com/articles/container-registry-and-runtime)
  * troubleshooting 
    * [covert add-on postgres database to JDBC format](https://devcenter.heroku.com/articles/connecting-to-relational-databases-on-heroku-with-java)
    * [R10 no PORT issue for Spring Boot](https://devcenter.heroku.com/articles/setting-the-http-port-for-java-applications#spring-boot)
    * [R14 Memory Issues in Java Applications for Spring Boot](https://devcenter.heroku.com/articles/java-memory-issues)
* Deploy React to Github Pages
  * troubleshooting SAP issues 
    * Either try [hashrouter](https://daryllwong.medium.com/github-pages-does-not-work-for-me-f9d48fd44a5f) (this one didn't work for me)
    * or [Add a 404.html](https://github.com/rafgraph/spa-github-pages) (I ended up using this)
