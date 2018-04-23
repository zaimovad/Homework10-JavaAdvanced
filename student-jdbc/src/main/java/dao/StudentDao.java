package dao;

import model.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import javax.sql.DataSource;
import java.util.List;

public class StudentDao {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;

    public void setJdbcTemplateObject(JdbcTemplate jdbcTemplateObject) {
        this.jdbcTemplateObject = jdbcTemplateObject;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String name, int age, String neighbourhood, String nationality, String specialty) {
        String sql = "insert into student (name, age, neighbourhood, nationality, specialty ) values (?, ?, ?, ?, ?)";
        jdbcTemplateObject.update(sql, name, age, neighbourhood, nationality, specialty);
        System.out.println("Created Record Name = " + name + " Age = " + age + "Neighbourhood= " + neighbourhood + " Nationality = " + nationality + " Specialty = " + specialty);
    }

    public Student getStudent(int id) {
        String SQL = "select * from student where id = ?";
        Student student = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new StudentRowMapper());
        return student;
    }

    public List<Student> listStudents() {
        String sql = "select * from student";
        List<Student> students = jdbcTemplateObject.query(sql, new StudentRowMapper());
        return students;
    }

    public void delete(int id) {
        String sql = "delete from student where id = ?";
        jdbcTemplateObject.update(sql, id);
        System.out.println("Deleted Record with ID = " + id);
    }

    public void update(int id, int age) {
        String sql = "update student set age = ? where id = ?";
        jdbcTemplateObject.update(sql, age, id);
        System.out.println("Updated Record with ID = " + id);
    }

    public void updateNationalityById(int id, String nationality) {
        String sql = "update student set nationality = ? where id = ?";
        jdbcTemplateObject.update(sql, nationality, id);
        System.out.println("Updated Record with ID = " + id);
    }
}