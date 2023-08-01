package payroll;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("==== Employee Payroll System ====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Contract Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. View Employee Details");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character from the buffer
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Monthly Salary: ");
                    double monthlySalary = scanner.nextDouble();
                    payrollSystem.addEmployee(new FullTimeEmployee(id, name, monthlySalary));
                    System.out.println("Full-Time Employee added successfully!");
                    break;

                case 2:
                    System.out.print("Enter Employee ID: ");
                    int id2 = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character from the buffer
                    System.out.print("Enter Employee Name: ");
                    String name2 = scanner.nextLine();
                    System.out.print("Enter Hourly Rate: ");
                    double hourlyRate = scanner.nextDouble();
                    System.out.print("Enter Hours Worked: ");
                    int hoursWorked = scanner.nextInt();
                    payrollSystem.addEmployee(new ContractEmployee(id2, name2, hourlyRate, hoursWorked));
                    System.out.println("Contract Employee added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Employee ID to remove: ");
                    int empIdToRemove = scanner.nextInt();
                    payrollSystem.removeEmployee(empIdToRemove);
                    System.out.println("Employee removed successfully!");
                    break;

                case 4:
                    System.out.print("Enter Employee ID to view details: ");
                    int empIdToView = scanner.nextInt();
                    Employee employee = payrollSystem.getAllEmployees().stream()
                            .filter(e -> e.getId() == empIdToView)
                            .findFirst()
                            .orElse(null);

                    if (employee != null) {
                        System.out.println(employee);
                        System.out.println("Monthly Salary: " + employee.calculateMonthlySalary());
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 5:
                    System.out.println("All Employees:");
                    for (Employee emp : payrollSystem.getAllEmployees()) {
                        System.out.println(emp);
                        System.out.println("Monthly Salary: " + emp.calculateMonthlySalary());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }
}
