package app;


import testdao.TestDao;

public class App {
    public static void main(String[] args) {

        TestDao.testStudent();
        System.out.println("///////////////////////////////////////////");
        TestDao.testEmployee();

    }
}