package dao;

import model.Employee;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements org.springframework.jdbc.core.RowMapper<Employee> {

    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getInt("id"));
        employee.setName(rs.getString("name"));
        employee.setAge(rs.getInt("age"));
        employee.setSalary(rs.getDouble("salary"));
        employee.setDepartment(rs.getString("department"));
        return employee;
    }
}
