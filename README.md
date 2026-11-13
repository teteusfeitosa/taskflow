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
- Reject duplicate IDs (with a null-check fix still pending).

**Known limitations:** The current implementation needs a corrected null check in `adicionarTarefa`, consistent handling of missing IDs on removal, and more complete tests. Data is lost when the program stops.

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
- [ ] Fix edge cases and add more test scenarios.
- [ ] Add an interactive command-line menu.
- [ ] Migrate to a Spring Boot REST API.
- [ ] Persist tasks using MySQL and JPA.
- [ ] Add DTOs, validation, exception handling, and automated tests.
- [ ] Build a frontend with HTML, CSS, and JavaScript.
- [ ] Containerize, deploy, and document the application.

## Learning goals

Practice object-oriented programming, encapsulation, collections, algorithmic complexity, business rules, Git, and backend architecture through an evolving real-world project.

