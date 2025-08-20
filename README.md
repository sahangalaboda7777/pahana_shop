# Pahana Shop System

This repository contains the Online Billing System of **pahana shop**developed for the CIS6003 Advanced Programming module.  
The project is built using Java (JSP & Servlets),MySQL workbench, and follows OOP principles, SOLID design, and DAO architecture.

---

##Features
- **User Authentication** (Login/Logout)  
- **Customer Management** (CRUD operations)  
- **Item Management** (CRUD operations)  
- **Billing System**(Invoice generation,billing process) 
- **User management** 
- **Role-based Access Control**(Admin / staff)  

---
##Tech Stack
- **Backend:**Java Servlets, JSP  
- **Database:** MySQL workbench
- **Build Tool:**Maven  
- **Server:**Apache Tomcat  
- **IDE:**Eclipse

---

##Project Structure
src/
└── com.pahanabookshop
├── controller/ # Servlets (UserServlet, CustomerServlet, BillServlet, etc.)
├── model/ # Data Models (User, Customer, Item, Bill)
├── dao/ # DAO Interfaces
├── dao/impl/ # DAO Implementations (using JDBC/PDO)
├── service/ # Service Interfaces
├── service/impl/ # Service Implementations
└── util/ # DBUtil for database connection

web/
├── login.jsp
├── admin.jsp
├── dashboard.jsp
├── customers.jsp
├── items.jsp
├── bill.jsp
└── css/ # Stylesheets
┣ pom.xml → Maven dependencies
┗ README.md → Documentation

## 🚀 Installation & Setup

### Prerequisites
Ensure the following are installed on your system:  
- Java Development Kit (JDK 11 or later)  
- Eclipse IDE  
- MySQL Server & MySQL Workbench  
- Apache Tomcat (v9 or later)  
- Git  

### Steps to Set Up
1. **Clone the Repository**
   ```bash
   git clone https://github.com/sahangalaboda7777/pahana_shop.git
   cd pahana_shop
Configure the Database

Open MySQL Workbench

Import the provided SQL script (in /db/ folder) to set up required tables


## 🗄️ Database Schema

### `users`
| Field       | Type                           | Notes                  |
|-------------|--------------------------------|------------------------|
| user_id     | INT (AI, PK)                   | Unique user ID         |
| username    | VARCHAR(50)                    | Login username         |
| password    | VARCHAR(255)                   | SHA-256 hashed password|
| role        | ENUM('admin','staff')          | User role              |

### `customers`
| Field       | Type          | Notes            |
|-------------|---------------|------------------|
| customer_id | INT (AI, PK)  | Auto-generated ID |
| name        | VARCHAR(100)  | Customer name    |
| address     | VARCHAR(255)  | Customer address |
| phone       | VARCHAR(15)   | Phone number     |

### `items`
| Field       | Type          | Notes            |
|-------------|---------------|------------------|
| item_id     | INT (AI, PK)  | Auto-generated ID |
| name        | VARCHAR(100)  | Item name        |
| price       | DECIMAL(10,2) | Item price       |

### `bills`
| Field       | Type          | Notes            |
|-------------|---------------|------------------|
| bill_no     | VARCHAR(20)   | Bill number      |
| customer_id | INT (FK)      | Linked customer  |
| total       | DECIMAL(10,2) | Total amount     |

---


Run the System

Open the project in Eclipse

Configure Apache Tomcat server

Run the application on the server

The system will work fully once the database is imported and connected.



## Git Workflow
- Repository has two main branches:  
  - **master** → Stable, production-ready code  
  - **dev** → Active development branch  

- Workflow followed:  
  1. Initial commit with base project structure  
  2. Daily commits on `dev` branch with new features  
  3. Merged tested features from `dev` → `master`  

---

## Version Control Techniques
- **Branching:** Development isolated from production  
- **Commit History:** Frequent, meaningful commits documenting changes  
- **Merging:** Tested code merged into `master` branch  
- **Versioning:** Each commit and branch represents a project version  

---

##  Repository Access
This repository is **public** and can be accessed here:  
👉GitHub Repository Link - https://github.com/sahangalaboda7777/pahana_shop.git  

---

##Future Enhancements

--Improved UI with responsive design (mobile-friendly JSP pages)
--Advanced search and filtering for customers and items
--Online payment gateway integration

👨‍💻 Author
- **Name**Sahan Vimukthi
- **Module**Advanced Programming – CIS6003
**Institution:** cardiff
