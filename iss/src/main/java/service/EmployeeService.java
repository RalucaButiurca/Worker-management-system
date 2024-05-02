package service;

import domeniu.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    public void addEmployee(Employee Employee) {
        employeeRepository.addEmployee(Employee);
    }

    public Employee findEmployeeById(int id) {
        return employeeRepository.findEmployeeById(id);
    }

    public Employee findEmployee(String email, String password) {
        return employeeRepository.findEmployee(email, password);
    }

    public void updateEmployee(Employee Employee) {
        employeeRepository.updateEmployee(Employee);
    }

    public void deleteEmployee(Employee Employee) {
        employeeRepository.deleteEmployee(Employee);
    }

    public List<Employee> getAngajati() {
        return employeeRepository.getEmployees();
    }

}