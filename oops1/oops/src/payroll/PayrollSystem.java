package payroll;

import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        this.employees = new ArrayList<>();
    }

    // Method to add an employee to the payroll system
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    // Method to remove an employee from the payroll system
    public void removeEmployee(int employeeId) {
        employees.removeIf(e -> e.getId() == employeeId);
    }

    // Method to get all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }
}

