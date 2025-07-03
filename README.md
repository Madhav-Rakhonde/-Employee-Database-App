# Employee Management System

A simple console-based Employee Management System built with Java and MySQL that allows you to perform CRUD (Create, Read, Update, Delete) operations on employee records.

## Features

- **Add Employee**: Add new employees with name, department, and salary
- **View All Employees**: Display all employees in a formatted table
- **Update Employee Salary**: Modify an employee's salary by ID
- **Delete Employee**: Remove an employee from the database by ID
- **Input Validation**: Handles invalid inputs gracefully
- **Error Handling**: Comprehensive error handling for database operations

## Project Structure

```
Employee-Management-System/
├── DBConnection.java    # Database connection configuration
├── Employee.java        # Employee model class
├── EmployeeDAO.java     # Data Access Object for employee operations
├── Main.java           # Main application with console interface
└── README.md           # This file
```

## Prerequisites

- **Java Development Kit (JDK)** 8 or higher
- **MySQL Server** 5.7 or higher
- **MySQL Connector/J** (JDBC driver)

## Database Setup

1. **Install MySQL** if not already installed
2. **Create a database** named `employee_db`:
   ```sql
   CREATE DATABASE employee_db;
   ```

3. **Create the employees table**:
   ```sql
   USE employee_db;
   
   CREATE TABLE employees (
       id INT PRIMARY KEY AUTO_INCREMENT,
       name VARCHAR(100) NOT NULL,
       department VARCHAR(50) NOT NULL,
       salary DOUBLE NOT NULL
   );
   ```

## Configuration

1. **Update database credentials** in `DBConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/employee_db";
   private static final String USER = "your_username";
   private static final String PASSWORD = "your_password";
   ```

2. **Download MySQL Connector/J**:
   - Download from [MySQL Official Website](https://dev.mysql.com/downloads/connector/j/)
   - Add the JAR file to your project's classpath

## Compilation and Execution

### Method 1: Using Command Line

1. **Compile all Java files**:
   ```bash
   javac -cp "path/to/mysql-connector-java.jar" *.java
   ```

2. **Run the application**:
   ```bash
   java -cp ".:path/to/mysql-connector-java.jar" Main
   ```

### Method 2: Using IDE

1. **Import project** into your preferred IDE (IntelliJ IDEA, Eclipse, etc.)
2. **Add MySQL Connector/J** to project dependencies
3. **Run** the `Main.java` file

## Usage

When you run the application, you'll see a menu with the following options:

```
--- Employee Management Menu ---
1. Add Employee
2. View All Employees
3. Update Employee Salary
4. Delete Employee
5. Exit
Choose an option:
```

### Adding an Employee
- Select option 1
- Enter employee name, department, and salary when prompted
- The system will confirm successful addition

### Viewing All Employees
- Select option 2
- All employees will be displayed in a table format with ID, Name, Department, and Salary

### Updating Employee Salary
- Select option 3
- Enter the employee ID and new salary
- The system will update the salary and confirm the operation

### Deleting an Employee
- Select option 4
- Enter the employee ID to delete
- The system will remove the employee and confirm the operation

## Error Handling

The application includes comprehensive error handling for:
- Database connection failures
- Invalid user inputs
- SQL execution errors
- Employee not found scenarios

## Sample Data

You can insert sample data to test the application:

```sql
INSERT INTO employees (name, department, salary) VALUES
('John Doe', 'IT', 50000),
('Jane Smith', 'HR', 45000),
('Bob Johnson', 'Finance', 55000);
```

## Troubleshooting

### Common Issues

1. **Database Connection Failed**:
   - Verify MySQL server is running
   - Check database credentials in `DBConnection.java`
   - Ensure the database `employee_db` exists

2. **ClassNotFoundException**:
   - Ensure MySQL Connector/J is in the classpath
   - Verify the JAR file path is correct

3. **SQLException**:
   - Check if the `employees` table exists
   - Verify table structure matches the expected schema

### Debug Tips

- Enable MySQL query logging to see executed queries
- Check console output for detailed error messages
- Verify database connectivity using a MySQL client

## Future Enhancements

- Add employee search functionality
- Implement employee update for all fields (not just salary)
- Add data validation for employee fields
- Create a GUI interface
- Add employee reporting features
- Implement user authentication

## License

This project is open source and available under the [MIT License](LICENSE).

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## Contact

For questions or support, please contact [your-email@example.com]
