# Ensolvers-To-Do-List

## Technologies used in this project
### REACT
- React: 17.0.2
- NodeJS: 10.19.0
- Axios: 0.21.1
- Material UI: 4.11.4
- Material UI Icons: 4.11.2

### Spring Boot
- Java: 11
- Spring Boot: 2.4.5
- Maven: 3.6.3

### MySQL
- MySQL: 8.0.23

## How to run this project

### Required

#### NodeJS
`sudo apt install nodejs`

#### NPM
`sudo apt install npm`

#### React
`npm i react`

#### Maven
`sudo apt install maven`

#### MySQL
`sudo apt install mysql-server`

#### TTab
`sudo npm install ttab -g`


## Command to start the application
First, go to `backend/target/classes/application.properties` and to `backend/src/main/resources/application.properties` and change the values for username and password for your MySQL server

Copy the following alias to your `.zshrc`:

`alias run_todo="cd backend; mvn spring-boot:run & ttab 'cd ../frontend; npm start'"`

Reload your `.zshrc` and run `run_todo` and the application will start

*This project was made by Rayan Avelino.*