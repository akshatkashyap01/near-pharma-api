# NearPharma 

Spring Boot Pharmacy Discovery API with SQLite Integration

---

## Project Overview

**NearPharma** is a RESTful Spring Boot API for managing and discovering pharmacies. It supports:

Full CRUD operations on pharmacy records  
SQLite embedded database (lightweight, no manual DB setup)  
Auto-seeding of pharmacy dataset on first startup  
Clean Java 17 and Spring Boot 3.5.x implementation  

---

## Tech Stack

- Java 17  
- Spring Boot 3.5.x  
- Spring Data JPA  
- HikariCP Connection Pool  
- SQLite  
- Lombok  

---

## Prerequisites

Make sure you have:

- Java 17 or higher  
- Maven 3.x or higher  
- Git  
- Postman or similar tool for API testing (optional)  

---

## Setup Instructions

```bash
# Clone the repository
git clone https://github.com/akshatkashyap01/near-pharma-api.git
cd nearpharma

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
