# Task Management API

## Project Overview

A Task Management REST API built using Spring Boot.

## Features

- Create Task
- Get All Tasks
- Update Task Status
- Delete Task
- Dashboard Summary

## Technologies

- Java 17
- Spring Boot
- Lombok
- Swagger
- Maven

## API Endpoints

POST /tasks

GET /tasks

PUT /tasks/{id}/status

DELETE /tasks/{id}

GET /tasks/dashboard

## Validation

Task Name
- Required
- 3 to 100 characters

Description
- Maximum 500 characters

## Running the Project

mvn spring-boot:run

## Swagger

http://localhost:8080/swagger-ui/index.html