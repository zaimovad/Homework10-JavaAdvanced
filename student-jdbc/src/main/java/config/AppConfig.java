package config;

import dao.EmployeeDao;
import dao.StudentDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {




    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/did");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

    @Bean
    public EmployeeDao employeeDao(){
        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.setJdbcTemplateObject(jdbcTemplate());
        return employeeDao;
    }

    @Bean
    public StudentDao studentDao(){
        StudentDao studentDao = new StudentDao();
        studentDao.setJdbcTemplateObject(jdbcTemplate());
        return studentDao;
    }
}
