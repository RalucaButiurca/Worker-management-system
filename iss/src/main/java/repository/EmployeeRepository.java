package repository;

import domeniu.Employee;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

        try(PreparedStatement preSmt = con.prepareStatement("insert into employee " +
                "(id, email, name) values (?, ?, ?)")) {
            preSmt.setInt(1, Employee.getId());
            preSmt.setString(2, Employee.getEmail());
            preSmt.setString(3, Employee.getName());

            int result = preSmt.executeUpdate();

        }
        catch (SQLException ex) {
            System.err.println("Error db" + ex);
        }

        //employees.add(Employee);
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

        Employee employee = null;

        try (PreparedStatement preSmt = con.prepareStatement("SELECT * FROM employee WHERE email = ? AND password = ?")) {
            preSmt.setString(1, email);
            preSmt.setString(2, password);

            try (ResultSet rs = preSmt.executeQuery()) {
                if (rs.next()) {
                    Integer id = rs.getInt("id");
                    String name = rs.getString("name");
                    String passwordEmployee = rs.getString("password");

                    // Construct the Employee object
                    employee = new Employee(id, name, passwordEmployee);
                }
            }
        } catch (SQLException ex) {
            System.err.println("Error db" + ex);
        }

        return employee;
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
