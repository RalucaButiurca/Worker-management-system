package repository;

import domeniu.Employee;
import utils.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeeRepository {

    private JDBCUtils dbUtils;

    public EmployeeRepository(Properties props) {

        dbUtils = new JDBCUtils(props);
    }
    private List<Employee> employees;

    public EmployeeRepository() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee Employee) {

        Connection con = dbUtils.getConnection();

        employees.add(Employee);
    }

    public Employee findEmployeeById(int id) {

        Connection con = dbUtils.getConnection();

        for (Employee Employee : employees) {
            if (Employee.getId() == id) {
                return Employee;
            }
        }
        return null;
    }

    public Employee findEmployee(String email, String password) {

        Connection con = dbUtils.getConnection();

        for (Employee employee : employees) {
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }

    public void updateEmployee(Employee Employee) {

        Connection con = dbUtils.getConnection();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == Employee.getId()) {
                employees.set(i, Employee);
                return;
            }
        }
    }

    public void deleteEmployee(Employee Employee) {

        Connection con = dbUtils.getConnection();

        employees.remove(Employee);
    }
    public List<Employee> getEmployees() {
        return employees;
    }
}
