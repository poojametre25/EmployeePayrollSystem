# Employee Payroll Management System (Mini Project)

## Project Overview
The **Employee Payroll Management System** is a **Mini Project** desktop application that allows the admin to add, view, and delete employee records along with automatic salary calculations using allowances and deductions.  
This project demonstrates Java Core concepts, OOP, JDBC connectivity, MySQL database operations, and GUI using Swing 

---

## Features
- ✅ Secure Login System (hardcoded credentials in `LoginWindow.java`)  
- ✅ Add Employee & Automatic Salary Calculation  
- ✅ View All Employee Records  
- ✅ Delete Employee by ID  
- ✅ JDBC Database Connectivity  
- ✅ GUI built using Java Swing Framework  

---

## Technologies Used

| Technology | Purpose |
|------------|---------|
| Java (Core + OOP) | Backend Logic & GUI |
| Swing (JFrame, JButton, JOptionPane) | Graphical Interface |
| JDBC | Database Connectivity |
| MySQL | Data Storage |
| Eclipse / IntelliJ | IDE used to develop the project |

---

## Login Credentials
| Username | Password |
|----------|---------|
| admin    | admin   |
| pooja    | 1234    |
| Abhi     | abcd    |

> ⚠️ Note: In the current version, login credentials are **hardcoded** in `LoginWindow.java`.

---

## Project Structure

EmployeePayrollSystem/
│
├── src/com/payroll/
│ ├── DBConnection.java
│ ├── Employee.java
│ ├── LoginWindow.java
│ └── DashboardWindow.java
│
├── screenshots/
│ ├── login_screen.png
│ ├── dashboard.png
│ └── add_employee_output.png
│ └── database_output.png
└── README.md


---

## Salary Formula


Net Salary = Basic Salary + HRA + DA + TA - Deductions


Where:  
- HRA = 10% of Basic Salary  
- DA  = 8% of Basic Salary  
- TA  = 5% of Basic Salary  
- Deductions = 2% of Basic Salary  

---

## MySQL Database Setup

Run these commands in MySQL Workbench:

```sql
CREATE DATABASE payroll_system;
USE payroll_system;

-- Users table (optional reference)
CREATE TABLE users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO users VALUES
('admin','admin'),
('pooja','1234'),
('rahul','abcd');

-- Employees table
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(50),
    salary DOUBLE,
    hra DOUBLE,
    da DOUBLE,
    ta DOUBLE,
    deductions DOUBLE,
    net_salary DOUBLE
);

How to Run the Project

Open the project in Eclipse:
File → Open Projects from File System → Select project folder

Add MySQL Connector JAR:
Right-click Project → Build Path → Configure Build Path → Add External JAR → Select mysql-connector.jar

Run the Login Window:
Right-click LoginWindow.java → Run As → Java Application

Enter credentials → Dashboard opens → Test Add / View / Delete Employee

Sample Output Screenshots






Project Highlights for Evaluation

✨ Mini Project implementing OOP Concepts (Encapsulation, Classes, Objects)

✨ Demonstrates Real-world Payroll Calculation Logic

✨ Uses GUI for Interactive User Experience

✨ Integrated with MySQL using JDBC

✨ Professional GitHub Presentation (Advantage to get top rank/certificate)

Developed By

Name: Pooja Metre

Contact

 LinkedIn:
🔗 https://www.linkedin.com/in/pooja-metre

