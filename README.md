
# 📦 Módulo Ventas - Backend (Spring Boot)

Este proyecto es el backend del sistema de gestión de productos, clientes y ventas. Está construido con **Spring Boot**, usa **PostgreSQL** como base de datos, y **JWT** para autenticación y control de roles.

---

## 🚀 Requisitos

- Java 17+
- Maven 3.8+
- PostgreSQL
- IDE recomendado: IntelliJ IDEA o VSCode

---

## ⚙️ Configuración y ejecución paso a paso

### 1. Crear base de datos en PostgreSQL

Conéctate a PostgreSQL y ejecuta:

```sql
CREATE DATABASE modulo_ventas;
```

### 2. Configura el archivo `application.yml`

Ubicado en `src/main/resources/application.yml`, debe verse así:

```yaml
server:
  port: 8080

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/modulo_ventas
    username: postgres
    password: tu_contraseña
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    open-in-view: false

  sql:
    init:
      mode: always

  jackson:
    serialization:
      write-dates-as-timestamps: false
```

> Cambia el usuario y contraseña según tu configuración local de PostgreSQL.

---

### 3. Importar el proyecto en tu IDE

- Abre el proyecto como **proyecto Maven**
- Espera a que se descarguen las dependencias

---

### 4. Ejecutar el backend

Puedes ejecutar desde tu IDE o desde terminal:

```bash
./mvnw spring-boot:run
```

O directamente desde el archivo principal `ModuloVentasApplication.java`.

---

## 🔐 Acceso y autenticación

### Usuarios preconfigurados (por `data.sql`)

| Usuario   | Rol         | Contraseña   |
|-----------|-------------|--------------|
| admin     | ADMIN       | adminpass    |
| operador  | OPERADOR    | operadorpass |

---

## 📬 Endpoints principales

- `POST /api/auth/login` → login con JWT
- `GET /api/productos` → listado de productos
- `GET /api/clientes` → listado de clientes
- `GET /api/ventas/estadisticas/top-productos` → productos más vendidos
- `GET /api/ventas/estadisticas/cliente-mayor` → cliente con mayor ingreso
- `GET /api/ventas/estadisticas/ingreso-ultimo-mes` → ingreso mensual

---

## 📁 Estructura del backend

- `controller` → controladores REST
- `dto` → objetos de transferencia
- `entity` → entidades JPA
- `repository` → interfaces JPA
- `service` → lógica de negocio
- `security` → configuración JWT y roles

---

## 🧪 Pruebas

Puedes probar el backend con herramientas como:

- Postman
- Thunder Client (VSCode)
- Frontend en React (consumiendo APIs con token)

---

## 📄 Licencia

Este proyecto está bajo licencia MIT.
