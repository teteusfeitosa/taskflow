# TaskFlow

A task management application built with **Java 21**, developed incrementally as part of a backend Java learning portfolio.

> **Status:** In development — current version is a command-line Java prototype. There is no web interface, REST API, or database yet.

## Features (current implementation)

- Create tasks with a unique positive ID, required title, and optional description.
- Store tasks in memory with `ArrayList<Tarefa>`.
- List tasks and search by ID.
- Mark tasks as completed.
- Update task title and description.
- Remove tasks.
- Reject null tasks and duplicate IDs with validation before insertion.

**Known limitations:** Automated tests and comprehensive edge-case scenarios are still pending. Data is stored only in memory and is lost when the program stops.

## Tech stack

- Java 21
- Java Collections (`ArrayList`)
- Git and GitHub

## Project structure

```text
taskflow/
├── src/
│   ├── Main.java
│   ├── Tarefa.java
│   └── GerenciadorTarefas.java
├── .gitignore
└── README.md
```

## Run locally

Requirements: JDK 21 and a terminal.

```bash
javac -d out src/*.java
java -cp out Main
```

`Main.java` currently runs hard-coded demonstrations; it does not yet provide an interactive menu.

## Design

- `Tarefa`: represents a task and protects its state through validation and methods.
- `GerenciadorTarefas`: manages the in-memory collection and CRUD operations.
- `Main`: exercises the application.

Searching by ID currently uses a linear scan, with **O(n)** worst-case time complexity.

## Roadmap

- [x] Model the `Tarefa` entity.
- [x] Implement in-memory CRUD methods.
- [x] Fix null checks and define consistent removal behavior for missing IDs.
- [ ] Add automated tests and more edge-case scenarios.
- [ ] Add an interactive command-line menu.
- [ ] Migrate to a Spring Boot REST API.
- [ ] Persist tasks using MySQL and JPA.
- [ ] Add DTOs, validation, exception handling, and automated tests.
- [ ] Build a frontend with HTML, CSS, and JavaScript.
- [ ] Containerize, deploy, and document the application.

## Learning goals

Practice object-oriented programming, encapsulation, collections, algorithmic complexity, business rules, Git, and backend architecture through an evolving real-world project.

