# Catalyst

## Motivation
Healthcare professionals often spend significant time managing paperwork and administrative tasks.
This project, inspired by the name "Catalyst" (substance that facilitates reactions) aims to streamline these processes and enhance workflow efficiency.
Focusing on visual assessments and optometrists, our application enables optometrists to conveniently store, access, and securely share patient medical records, reducing administrative burden while prioritizing patient privacy.

## Project Installation & Setup
This project is a Spring Boot application that uses Spring MVC and includes a REST API with an H2 in-memory database, built with Maven.
Follow these steps to install and run the project locally.

### Prerequisites

- Java JDK 21 or later: Ensure you have Java installed and set up. You can check your Java version with:

```shell
java -version
```

You can download the latest Java versions from [Oracle](https://www.oracle.com/ca-en/java/technologies/downloads/).

### Installation Steps

1. Clone the project repository to your local machine:

```shell
git clone https://github.com/hvpham-yorku/catalyst.git
cd catalyst
```

2. You can use the Maven wrapper provided with the project, which means you don’t need a separate Maven installation.
   Run the following command to build the project and download any necessary dependencies:

```shell
./mvnw clean install   # For Linux/macOS
mvnw clean install     # For Windows
```

3. Start the Spring Boot application with the Maven wrapper:

```shell
./mvnw spring-boot:run   # For Linux/macOS
mvnw spring-boot:run     # For Windows
```

- The application will run on the default port `http://localhost:8080`.
- To access the H2 console, navigate to `http://localhost:8080/h2-console`.
- Use the following default credentials configured in `application.properties`:
    - URL: `jdbc:h2:file:./data/testdb`
    - Username: `sa`
    - Password: (leave blank, unless specified in `application.properties`)

## Contribution

We use GitHub Issues to represent user stories on our Trello board and to track project progress.

### Branching

Our branch naming convention uses kebab case and follows this format: `story-<story-number>`.

For each story, the branch is further subdivided into front-end and back-end branches:

- `story-<story-number>-frontend`
- `story-<story-number>-backend`

As developers complete their respective front-end or back-end tasks, they will merge their changes into the story branch. Once the entire feature is complete, the story branch will be merged into the `main` branch.

### Pull Request Process

Once an issue is complete, contributors submit a pull request and assign it to one of the following main developers for review:
- Amir Ali Mohaghegh ([AMoh1026](https://github.com/AMoh1026))
- Barbod Habibi ([BarbodH](https://github.com/BarbodH))
- Kevin Nguyen ([kevnngyen](https://github.com/kevnngyen))

After review and approval, the pull request is merged into the main branch.