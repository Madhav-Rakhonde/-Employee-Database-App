import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\n--- Employee Management Menu ---");
                System.out.println("1. Add Employee");
                System.out.println("2. View All Employees");
                System.out.println("3. Update Employee Salary");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter department: ");
                        String dept = sc.nextLine();

                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();

                        dao.addEmployee(new Employee(name, dept, salary));
                        break;

                    case 2:
                        List<Employee> list = dao.getAllEmployees();
                        if (list.isEmpty()) {
                            System.out.println(" No employees found.");
                        } else {
                            System.out.println("\nID | Name | Department | Salary");
                            for (Employee e : list) {
                                System.out.println(e.getId() + " | " + e.getName() + " | " +
                                        e.getDepartment() + " | " + e.getSalary());
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Enter employee ID to update: ");
                        int updateId = sc.nextInt();
                        System.out.print("Enter new salary: ");
                        double newSal = sc.nextDouble();
                        dao.updateEmployeeSalary(updateId, newSal);
                        break;

                    case 4:
                        System.out.print("Enter employee ID to delete: ");
                        int deleteId = sc.nextInt();
                        dao.deleteEmployee(deleteId);
                        break;

                    case 5:
                        System.out.println(" Exiting...");
                        sc.close();
                        return;

                    default:
                        System.out.println(" Invalid choice. Please choose 1-5.");
                }
            } catch (InputMismatchException e) {
                System.err.println(" Invalid input. Please enter numbers where required.");
                sc.nextLine(); // clear the invalid input
            } catch (Exception e) {
                System.err.println(" Unexpected error: " + e.getMessage());
            }
        }
    }
}
