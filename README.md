# Parthasarathi Bala — Portfolio CMS

A Spring Boot based Portfolio Management System with a public portfolio website and a custom admin panel.

## Features
- Public portfolio website
- Custom Admin Panel
- JWT-based admin login
- Dashboard with content counts
- CRUD management for About, Skills, Projects, Blogs, Experience, Testimonials and Services
- Contact message management
- Image/media upload
- Spring Boot REST API
- H2 file database by default (PostgreSQL supported)
- Maven
- HTML/CSS/JavaScript

## How to Run

### Requirements
- Java 17+
- Maven 3.10+

### Local development

From the project root:

```bash
mvn clean spring-boot:run
```

Then open:

- Public portfolio: http://localhost:8080/
- Admin panel: http://localhost:8080/admin.html

### Admin login

For local development, set these environment variables before starting the application:

PowerShell:

```powershell
$env:ADMIN_USER="admin"
$env:ADMIN_PASSWORD="your-password"
$env:JWT_SECRET="a-long-random-secret-at-least-32-characters"
mvn spring-boot:run
```

If you do not set them, the application uses its local-development fallback values. **Change them before deployment.**

## Admin Panel

The admin panel authenticates against `POST /api/auth/login` and sends the JWT as a Bearer token for protected CRUD requests.

Available management areas:

- Dashboard
- About
- Skills
- Projects
- Blogs
- Experience
- Testimonials
- Services
- Messages
- Media upload

## API

Examples:

```text
GET    /api/projects
POST   /api/projects
PUT    /api/projects/{id}
DELETE /api/projects/{id}

POST   /api/auth/login
POST   /api/auth/refresh
POST   /api/upload/image
```

## Important

Do not commit real passwords, JWT secrets, database passwords or mail credentials to GitHub. Use environment variables for deployment.

