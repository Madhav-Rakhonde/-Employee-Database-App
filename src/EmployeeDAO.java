import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees (name, department, salary) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.err.println(" Cannot perform add: DB connection is null.");
                return;
            }

            stmt.setString(1, emp.getName());
            stmt.setString(2, emp.getDepartment());
            stmt.setDouble(3, emp.getSalary());
            stmt.executeUpdate();
            System.out.println(" Employee added successfully.");
        } catch (SQLException e) {
            System.err.println(" Error adding employee: " + e.getMessage());
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn != null ? conn.createStatement() : null;
             ResultSet rs = stmt != null ? stmt.executeQuery(sql) : null) {

            if (conn == null || stmt == null || rs == null) {
                System.err.println(" Failed to retrieve employees.");
                return list;
            }

            while (rs.next()) {
                list.add(new Employee(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department"),
                        rs.getDouble("salary")
                ));
            }
        } catch (SQLException e) {
            System.err.println(" Error fetching employees: " + e.getMessage());
        }

        return list;
    }

    public void updateEmployeeSalary(int id, double newSalary) {
        String sql = "UPDATE employees SET salary = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.err.println(" Cannot update: DB connection is null.");
                return;
            }

            stmt.setDouble(1, newSalary);
            stmt.setInt(2, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println(" Employee updated successfully.");
            else
                System.out.println("️ Employee not found.");
        } catch (SQLException e) {
            System.err.println(" Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            if (conn == null) {
                System.err.println(" Cannot delete: DB connection is null.");
                return;
            }

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            if (rows > 0)
                System.out.println(" Employee deleted successfully.");
            else
                System.out.println(" Employee not found.");
        } catch (SQLException e) {
            System.err.println(" Error deleting employee: " + e.getMessage());
        }
    }
}

