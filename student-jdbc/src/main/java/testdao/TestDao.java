package testdao;

import config.AppConfig;
import dao.EmployeeDao;
import dao.StudentDao;
import model.Employee;
import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestDao {


    private static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


    public static void testStudent() {

        StudentDao studentDao =
                (StudentDao) context.getBean("studentDao");

        System.out.println("------Records Creation--------");
        studentDao.create("Zara", 11, "Mladost2", "Bulgarian", "Economics");
        studentDao.create("Nuha", 2, "Nadejda", "Bulgarian", "Math");
        studentDao.create("Ayan", 15, "Iztok", "Bulgarian", "Physics");

        System.out.println("------Listing Multiple Records--------");
        List<Student> students = studentDao.listStudents();

        for (Student record : students) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
            System.out.println(", Neighbourhood : " + record.getNeighbourhood());
            System.out.println(", Nationality : " + record.getNationality());
            System.out.println(", Specialty : " + record.getSpecialty());
        }

        System.out.println("----Updating Record with ID = 2 -----");
        studentDao.update(2, 20);

        System.out.println("----Listing Record with ID = 2 -----");
        Student student = studentDao.getStudent(2);
        System.out.print("ID : " + student.getId());
        System.out.print(", Name : " + student.getName());
        System.out.println(", Age : " + student.getAge());
        System.out.println(", Neighbourhood : " + student.getNeighbourhood());
        System.out.println(", Nationality : " + student.getNationality());
        System.out.println(", Specialty : " + student.getSpecialty());

        System.out.println("----Updating Record with ID = 2 -----");
        studentDao.updateNationalityById(2, "Polish");

        System.out.println("----Deleting Record with ID = 2 -----");
        studentDao.delete(4);

    }

    public static void testEmployee() {

        EmployeeDao employeeDao =
                (EmployeeDao) context.getBean("employeeDao");

        System.out.println("------Records Creation--------");
        employeeDao.create("Ivan", 25, 1250.90, "Management");
        employeeDao.create("Lydia", 30, 1580.30, "Logistics");
        employeeDao.create("Rosen", 45, 2500.50, "Accounting");

        System.out.println("------Listing Multiple Records--------");
        List<Employee> employees = employeeDao.getEmployees();

        for (Employee record : employees) {
            System.out.print("ID : " + record.getId());
            System.out.print(", Name : " + record.getName());
            System.out.println(", Age : " + record.getAge());
            System.out.println(", Salary : " + record.getSalary());
            System.out.println(", Department : " + record.getDepartment());
        }

        System.out.println("----Updating Employee Salary with ID = 3 -----");
        employeeDao.updateSalaryById(3, 2800.30);

        System.out.println("----Listing Record with ID = 2 -----");
        Employee employee = employeeDao.getEmployeeById(2);
        System.out.print("ID : " + employee.getId());
        System.out.print(", Name : " + employee.getName());
        System.out.println(", Age : " + employee.getAge());
        System.out.println(", Salary : " + employee.getSalary());
        System.out.println(", Department : " + employee.getDepartment());

        System.out.println("----Deleting Record with ID = 1 -----");
        employeeDao.delete(1);

    }
}
