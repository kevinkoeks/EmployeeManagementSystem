# Employee Management System

A full-stack web application for managing employee records. The backend is a Spring Boot REST API secured with HTTP Basic Auth, and the frontend is an Angular 19 single-page application.

## What this MVP does

- **Login** — authenticate with a username and password before accessing any data
- **View employees** — see all employees in a table with name, email, job title, phone, and employee code
- **Add employee** — fill in a form to create a new employee record
- **Edit employee** — update any field on an existing employee
- **Delete employee** — remove an employee after confirmation
- **API docs** — Swagger UI available for exploring and testing the REST API directly

---

## Project structure

```
EmployeeManagementSystem/
├── employeeManager/          # Spring Boot backend (Java 11, Maven)
└── employeemanagerfrontend/  # Angular 19 frontend (TypeScript)
```

---

## Prerequisites

| Tool | Version |
|---|---|
| Java | 11+ |
| Maven | 3.6+ (or use the included `./mvnw`) |
| MySQL | 8.0+ |
| Node.js | 18+ |
| Angular CLI | 17+ (`npm install -g @angular/cli`) |

---

## Running the project

### 1. Set up the database

Start MySQL and create the database:

```sql
CREATE DATABASE employeemanager;
```

The default credentials are `root / root`. If your MySQL setup is different, update them in:

```
employeeManager/employeeManager/src/main/resources/application.properties
```

### 2. Start the backend

```bash
cd employeeManager/employeeManager
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

### 3. Start the frontend

```bash
cd employeemanagerfrontend
npm install
ng serve
```

The app will be available at `http://localhost:4200`.

### 4. Log in

Open `http://localhost:4200` in your browser and log in with:

- **Username:** `admin`
- **Password:** `admin`

---

## API documentation

Swagger UI is available at `http://localhost:8080/swagger-ui.html` — no login required.

## API endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/employee/all` | Get all employees |
| GET | `/employee/find/{id}` | Get employee by ID |
| POST | `/employee/add` | Create a new employee |
| PUT | `/employee/update` | Update an existing employee |
| DELETE | `/employee/delete/{id}` | Delete an employee |
