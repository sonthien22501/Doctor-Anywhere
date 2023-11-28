#1. CRUD Task API

#2. Using JPA to create entity and call api to control data in local db

#3. Spring Secuirty
- All user: Can only get all Tasks
- Admin: Can do everything (Get All, Get By ID, Create, Update, Delete)

#4. HOW TO RUN
- Clone repo
- Set up local DB in /src/resources/application.properties
- Open terminal
- Command "mvn clean install" 
- Command "mvn spring-boot:run" to run the application.

#5: Run application in Docker container
- Create a directory named: mysql -> create setup.sql with content "CREATE DATABASE tasks;"
- Open terminal
- Command "mvn clean install" 
- Command "docker compose up" to create and run container
  
