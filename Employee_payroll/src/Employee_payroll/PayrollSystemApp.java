package Employee_payroll;
import java.util.List;
import java.util.Scanner;

public class PayrollSystemApp {
    private Scanner scanner;
    private EmployeeDAO employeeDAO;
    private DeductionDAO deductionDAO;

    public static void main(String[] args) {
        PayrollSystemApp app = new PayrollSystemApp();
        app.run();
    }

    public PayrollSystemApp() {
        scanner = new Scanner(System.in);
        employeeDAO = new EmployeeDAO();
        deductionDAO = new DeductionDAO();
    }

    public void run() {
        while (true) {
            System.out.println("Payroll System");
            System.out.println("1. View All Employees");
            System.out.println("2. Add New Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. View All Deductions");
            System.out.println("6. Add New Deduction");
            System.out.println("7. Update Deduction");
            System.out.println("8. Delete Deduction");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    viewAllEmployees();
                    break;
                case 2:
                    addNewEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    viewAllDeductions();
                    break;
                case 6:
                    addNewDeduction();
                    break;
                case 7:
                    updateDeduction();
                    break;
                case 8:
                    deleteDeduction();
                    break;
                case 9:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void viewAllEmployees() {
        List<Employee> employees = employeeDAO.getAllEmployees();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee List:");
            for (Employee employee : employees) {
                System.out.println("ID: " + employee.getEmployeeId() + ", Name: " + employee.getName() + ", Salary: $" + employee.getSalary());
            }
        }
    }

    private void addNewEmployee() {
        System.out.print("Enter Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        Employee newEmployee = new Employee(0, name, salary);
        employeeDAO.insertEmployee(newEmployee);
        System.out.println("New employee added successfully!");
    }

    private void updateEmployee() {
        System.out.print("Enter Employee ID to update: ");
        int employeeId = scanner.nextInt();

        Employee existingEmployee = employeeDAO.getEmployeeById(employeeId);
        if (existingEmployee == null) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        System.out.print("Enter New Employee Name: ");
        String name = scanner.next();
        System.out.print("Enter New Employee Salary: ");
        double salary = scanner.nextDouble();

        existingEmployee.setName(name);
        existingEmployee.setSalary(salary);

        employeeDAO.updateEmployee(existingEmployee);
        System.out.println("Employee with ID " + employeeId + " updated successfully!");
    }

    private void deleteEmployee() {
        System.out.print("Enter Employee ID to delete: ");
        int employeeId = scanner.nextInt();

        Employee existingEmployee = employeeDAO.getEmployeeById(employeeId);
        if (existingEmployee == null) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        employeeDAO.deleteEmployee(employeeId);
        System.out.println("Employee with ID " + employeeId + " deleted successfully!");
    }

    private void viewAllDeductions() {
        List<Deduction> deductions = deductionDAO.getAllDeductions();
        if (deductions.isEmpty()) {
            System.out.println("No deductions found.");
        } else {
            System.out.println("Deduction List:");
            for (Deduction deduction : deductions) {
                System.out.println("ID: " + deduction.getDeductionId() + ", Employee ID: " + deduction.getEmployeeId() +
                        ", Deduction Type: " + deduction.getDeductionType() + ", Amount: $" + deduction.getAmount());
            }
        }
    }

    private void addNewDeduction() {
        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Enter Deduction Type: ");
        String deductionType = scanner.next();
        System.out.print("Enter Deduction Amount: ");
        double amount = scanner.nextDouble();

        Deduction newDeduction = new Deduction(0, employeeId, deductionType, amount);
        deductionDAO.insertDeduction(newDeduction);
        System.out.println("New deduction added successfully!");
    }

    private void updateDeduction() {
        System.out.print("Enter Deduction ID to update: ");
        int deductionId = scanner.nextInt();

        Deduction existingDeduction = deductionDAO.getDeductionById(deductionId);
        if (existingDeduction == null) {
            System.out.println("Deduction with ID " + deductionId + " not found.");
            return;
        }

        System.out.print("Enter Employee ID: ");
        int employeeId = scanner.nextInt();
        System.out.print("Enter New Deduction Type: ");
        String deductionType = scanner.next();
        System.out.print("Enter New Deduction Amount: ");
        double amount = scanner.nextDouble();

        existingDeduction.setEmployeeId(employeeId);
        existingDeduction.setDeductionType(deductionType);
        existingDeduction.setAmount(amount);

        deductionDAO.updateDeduction(existingDeduction);
        System.out.println("Deduction with ID " + deductionId + " updated successfully!");
    }

    private void deleteDeduction() {
        System.out.print("Enter Deduction ID to delete: ");
        int deductionId = scanner.nextInt();

        Deduction existingDeduction = deductionDAO.getDeductionById(deductionId);
        if (existingDeduction == null) {
            System.out.println("Deduction with ID " + deductionId + " not found.");
            return;
        }

        deductionDAO.deleteDeduction(deductionId);
        System.out.println("Deduction with ID " + deductionId + " deleted successfully!");
    }
}
