# HARSHINI_EI_CODING_EXERCISES

## Overview
This repository contains solutions for the **Ei Coding Exercises (2025–26)**.  
---
- **Exercise 1 – Design Pattern Use Cases**  
  Implementations of six different software design patterns (Creational, Structural, Behavioral) with creative real-world use cases.

- **Exercise 2 – Mini Project**  
  A complete console-based application implementing multiple design patterns, SOLID principles, and OOP best practices.

Each project has its own dedicated folder with a **README.md** file explaining the problem statement, use case, and pattern justification.

## Exercise 1: Design Patterns
The following design patterns have been implemented with separate projects:

### Creational Patterns
- **Factory Method – Document Exporter**  
  Dynamically generates exporters (PDF, Word, Excel) without hardcoding specific classes.

- **Singleton – Global Session Manager**  
  Ensures a single session manager instance that handles token generation and validation.

### Structural Patterns
- **Adapter – Payment Gateway Integration**  
  Unifies different payment providers (PayPal, Stripe, Razorpay) under a common interface.

- **Decorator – LLM AI Agent Subscription Demo**  
  Dynamically adds subscription features like premium support or analytics to AI agents.

###  Behavioral Patterns
- **Mediator – IDE Plugin Communication**  
  Coordinates interactions between editor, debugger, and compiler plugins without tight coupling.

- **Observer – Social Media Notification System**  
  Notifies followers whenever a user posts a new update.
---

##  Exercise 2: Mini Project
### Astronaut Daily Schedule Manager
A console-based CRUD application to help astronauts organize their daily tasks with validations and conflict detection.

#### Features
- Add, remove, view, and update tasks.
- Prevent overlapping tasks and validate inputs.
- View tasks sorted by time or filtered by priority.
- Observer notifications for conflicts.
- Logging and error handling built in.
- Additional features like like Daily summary report, Conflict Resolution Suggestion

#### Design Patterns Applied
- **Singleton** → Single ScheduleManager instance.  
- **Factory** → Task creation via TaskFactory.  
- **Observer** → Alerts for schedule conflicts.  

---

## Tech Stack
- **Language:** Java  
- **Paradigms:** OOP, SOLID principles, Defensive Programming  
- **Patterns:** Creational, Structural, Behavioral  
- **Execution:** Console-based applications (no UI frameworks)  

---
