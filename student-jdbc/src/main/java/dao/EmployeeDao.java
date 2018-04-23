package dao;

import model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class EmployeeDao {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, int age, Double salary, String department) {
        String sql = "insert into employee (name, age, salary, department) values (?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, name, age, salary, department);
        System.out.println("Created Record Name = " + name + " Age = " + age + "Salary= " + salary + " Department = " + department);
    }

    public void updateSalaryById(int id, Double salary) {
        String sql = "update employee set salary = ? where id = ?";
        jdbcTemplateObject.update(sql, salary, id);
        System.out.println("Updated Record with ID = " + id);
    }

    public void delete(int id) {
        String sql = "delete from employee where id = ?";
        jdbcTemplateObject.update(sql, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public Employee getEmployeeById(int id) {
        String sql = "select * from employee where id = ?";
        Employee employee = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
        return employee;
    }

    public List<Employee> getEmployees() {
        String sql = "select * from employee";
        List<Employee> employee = jdbcTemplateObject.query(sql, new EmployeeRowMapper());
        return employee;
    }

}
