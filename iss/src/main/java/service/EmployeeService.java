package service;

import domeniu.Employee;
import repository.EmployeeRepository;

import java.util.List;

import HashUtil.HashUtil;

public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
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

    public boolean validateEmployee(String email, String password) {
        String hashedPassword = HashUtil.hashPassword(password);
        Employee employee = findEmployee(email, hashedPassword);
        if (employee != null) {
            return employee.getPassword().equals(hashedPassword);
//            return true;
        }
        return false;
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

    public Employee addSignintime(String signintime, Integer currentUserId) {
        employeeRepository.addSignInTime(signintime, currentUserId);
        return null;
    }
}