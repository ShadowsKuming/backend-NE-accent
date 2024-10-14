# Project Name

This is a Spring Boot project that serves as the backend for a web application. The project is structured in a multi-layer architecture consisting of Controllers, Services, DAOs, and Entities. The database configuration can be modified via the `application.properties` file, and the server port defaults to `8081`.

## Features
- **Controller Layer**: Handles API requests corresponding to the frontend pages.
- **Service Layer**: Implements business logic for each frontend page.
- **DAO Layer**: Interfaces with the database, with each DAO matching the corresponding table in the database.
- **Entity Classes**: Represent database tables, with each entity class corresponding to a specific table.
- **DTO**: Data Transfer Objects, used to process data received from the frontend.

## Prerequisites

To run this project, ensure you have the following installed:
- Java 8 or above
- Maven
- MySQL (or any other configured relational database)

## Getting Started

### Step 1: Configure the Server Port and Database Connection

1. Go to `src/main/resources/application.properties`.
2. Modify the following properties to match your database configuration:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
    spring.datasource.username=git remote add origin
    spring.datasource.password={your_password}
    server.port=8081
    ```

   - Replace `{database_name}` with your database name.
   - Replace `{your_username}` and `{your_password}` with your database credentials.

### Step 2: Set Up the Database

1. Create the database using the name specified in `application.properties`.
2. Create tables based on the entity classes. The table names should match the entity class names, and column names should align with the variables inside each class.
3. Import the CSV file located in the `static/csv` folder into the `StimuliAnswer` table. The CSV file contains necessary data for the `StimuliAnswer` entity.
4. Optionally, the `static/audio` folder contains audio files that may be utilized by specific features in your application.

### Step 3: Run the Application

1. Ensure the database is up and running.
2. Run the following Maven command to start the Spring Boot application:
    ```bash
    mvn spring-boot:run
    ```

3. The server will start on `http://localhost:8081` by default (or any other port you configure).

### Step 4: Frontend Integration

The project is designed to serve as the backend for a frontend application. Each controller in the backend corresponds to a specific page or feature of the frontend. Data from the frontend is processed using DTOs, and the backend returns responses in a structured format.

## Project Structure

```bash
src/
│
├── main/
│   ├── java/
│   │   └── com/game/demo/
│   │       ├── controller/         # Controllers for handling frontend requests
│   │       ├── service/            # Business logic for each feature/page
│   │       ├── dao/                # Data access objects, interfaces to the database
│   │       ├── entity/             # Entity classes representing database tables
│   │       └── dto/                # Data Transfer Objects for data exchange between frontend and backend
│   └── resources/
│       ├── application.properties  # Configuration file for database and server settings
│       └── static/                 
│           ├── csv/                # CSV files for importing data into the database
│           └── audio/              # Audio files for specific use cases in the application
