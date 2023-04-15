package HomeWork.service;


import HomeWork.Employee;


import java.util.Collection;
import java.util.List;


public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, double salary, int department);


    Employee findEmployee(String firstName, String lastName, double salary, int department);


    Employee removeEmployee(String firstName, String lastName, double salary, int department);


    Collection<Employee> list();


    Employee getMaxSalaryByDepartment(int department);


    Employee getMinSalaryByDepartment(int department);


    Collection<Employee> getListEmployeeByDepartment(int department);


    Collection<Employee> getListEmployee();
}
