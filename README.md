<h1>Simplified Bank System</h1>
The Simplified Bank System is an application designed to simulate basic banking operations. It leverages various technologies to provide a functional and efficient system for managing bank transactions.

<h1>Tech Stack</h1>

- Spring Boot: Framework for building the application;
- Spring MVC: Handles HTTP requests and responses;
- Spring Data JDBC: Facilitates data access;
- Spring for Apache Kafka: Integrates Kafka messaging;
- Docker Compose: Orchestrates containers for the application;
- H2: In-memory database for development and testing;


<h1>Getting Started</h1>
To run the application locally, follow these steps:

Ensure you have Docker installed on your system.
Clone this repository to your local machine.
Navigate to the project directory.
<h2>Running the Application</h2>
Execute the following command to start the application, along with Kafka:

`docker-compose up -d`

<h2>Accessing Endpoints</h2>
Once the application is up and running, you can access the endpoints via the following URL:

`http://localhost:8080/swagger-ui/index.html#/`

<h1>Troubleshooting</h1>

If you encounter any issues during setup or running the application, consider the following troubleshooting steps:

- Check Docker Compose logs for any error messages.
- Ensure there are no port conflicts with other services running on your system.
- Verify that Docker is installed correctly and running.
- Make sure you have the necessary permissions to execute Docker commands.

 <h2>Contributing</h2>
Contributions to this project are welcome! Feel free to submit bug reports, feature requests, or pull requests to help improve the application.

<h2>License</h2>
This project is licensed under the MIT License.
