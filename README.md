# spring-boot-library-management-system

# Project Title: Spring Boot Library Management System

** Description:**

This is a demo project showcasing the implementation of a Library Management System using the Spring Boot framework, Spring Security for authentication, and Thymeleaf for server-side templating. The system provides essential functionalities for managing books, users, and borrowing activities in a library.

** Key Features:**

** User Authentication: ** Secure user authentication and authorization using Spring Security.

** Book Management:** Add, edit, and delete books with details such as title, author, genre, and availability status.

** User Management:** Manage library users with roles, including librarians and regular users.


** Responsive UI:** Utilize Thymeleaf for server-side templating to create dynamic and responsive user interfaces.

** Tech Stack:**

1. Spring Boot: Rapid application development using the Spring framework.

2. Spring Security: Robust security features for user authentication and authorization.

3. Thymeleaf: Server-side templating engine for dynamic web pages.

4. Database:  Integration with a database for persistent data storage (you can specify the database used).Here I am using ** MYSQL ** as RDMS


Database configuration in application.properties

```
# database configurations
spring.datasource.url= jdbc:mysql://localhost:3306/bookstore
spring.datasource.username=root
spring.datasource.password=

# hibernate configurations
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialet=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.properties.hibernate.globally_quoted_identifiers=true


spring.servlet.multipart.max-file-size=15MB
spring.servlet.multipart.max-request-size=15MB
```


** How to Run: **

Clone the repository.
1. Configure the database settings in the application.properties file.
2. Build and run the application using Maven or your preferred build tool.
3. Access the system through the provided URL (usually http://localhost:8080).

** Note:** This is a simplified demo project and might lack certain features found in a production-ready Library Management System. It serves as a starting point for building more complex applications.






