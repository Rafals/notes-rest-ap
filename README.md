# Notes REST API

Prosty serwis REST do zarządzania notatkami i autorami.  
Projekt wykonany w ramach zadania rekrutacyjnego.

## Technologie
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Springdoc OpenAPI (Swagger)

## Funkcjonalności
- **Authors**
  - POST `/authors` — utworzenie nowego autora
  - GET `/authors` — pobranie listy autorów
  - GET `/authors/{id}` — pobranie autora po ID
- **Notes**
  - POST `/notes` — utworzenie nowej notatki
  - GET `/notes` — pobranie listy notatek
  - GET `/notes/{id}` — pobranie notatki po ID
  - DELETE `/notes/{id}` — usunięcie notatki po ID

## Uruchomienie
1. Sklonuj repozytorium:
   ```bash
   git clone https://github.com/<twoj-user>/notes-rest-api.git
