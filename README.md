Student Registration Database

A simple Student Registration Database Application developed using Java Swing and MySQL.

This project provides a graphical user interface (GUI) where users can enter student details such as Student ID, Name, Gender, and Branch and save them directly into a MySQL database.

🚀 Features
🧑‍🎓 Register new student details
🆔 Enter Student ID
👤 Enter student name
⚥ Select gender
🎓 Enter branch
💾 Save student data into MySQL database
🧹 Clear all input fields
⚠️ Displays error messages when an error occurs
✅ Displays a success message after registration
🛠️ Technologies Used
Java
Java Swing – for creating the graphical user interface
JDBC – for connecting Java with MySQL
MySQL – for storing student data
PreparedStatement – for executing SQL queries safely
🖥️ Project Interface

The application contains a simple registration form with:

Field	Description
Student ID	Unique ID of the student
Name	Student's name
Gender	Male/Female selection
Branch	Student's branch
Save	Stores data in the database
Clear	Clears all input fields
🗄️ Database Setup
1. Create Database

Open MySQL and create the database:

CREATE DATABASE studentregistration;
2. Create Student Table
USE studentregistration;

CREATE TABLE student (
    sid INT PRIMARY KEY,
    name VARCHAR(100),
    gender VARCHAR(20),
    Branch VARCHAR(100)
);
🔌 Database Connection

The Java program connects to MySQL using JDBC.

Update the following part of the code with your own MySQL username and password:

con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/studentregistration",
    "root",
    "your password"
);

Important: Do not upload your real database password to GitHub. Keep it private.

▶️ How to Run
Step 1: Install Requirements

Make sure you have:

Java JDK installed
MySQL Server installed
MySQL Connector/J (JDBC Driver)
VS Code, IntelliJ IDEA, or another Java IDE
Step 2: Create the Database

Run the database commands given above in MySQL.

Step 3: Add MySQL JDBC Driver

Add the MySQL Connector/J .jar file to your Java project's classpath.

Step 4: Update Database Credentials

Change:

"your password"

to your local MySQL password.

Step 5: Run the Program

Run:

StudentRegistrationdatabase.java

The Student Registration window will open.

📂 Project Structure
Student-Registration-Database/
│
├── StudentRegistrationdatabase.java
├── README.md
└── mysql-connector-j.jar

If you do not want to include the JDBC .jar file in your repository, add it to .gitignore and mention the dependency in the README.

💡 How It Works
The user enters the student details.
The program collects the entered information.
Java connects to the MySQL database using JDBC.
A PreparedStatement is created for the SQL INSERT query.
Student information is inserted into the student table.
A success message is displayed.
The Clear button removes all entered values from the form.
📌 Example
Student ID: 101
Name: Rahul
Gender: Male
Branch: Computer Science

After clicking Save, the data is stored in the MySQL student table.

🎯 Learning Outcomes

Through this project, you can learn:

Java Swing GUI development
Event handling using ActionListener
JDBC database connectivity
MySQL database operations
PreparedStatement
Basic CRUD concepts
Exception handling in Java
🔮 Future Improvements

The project can be extended by adding:

🔍 Search student
✏️ Update student details
🗑️ Delete student records
📋 Display all students in a JTable
🔐 Login system
📊 Student report generation
📝 Input validation
👩‍💻 Author

Student Registration Database Project

Built using Java Swing + MySQL + JDBC.
