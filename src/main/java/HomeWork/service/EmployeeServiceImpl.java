package HomeWork.service;


import HomeWork.Employee;
import HomeWork.exception.EmployeeAlreadyAddedException;
import HomeWork.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    protected final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }

    public Map<String, Employee> getEmployees() {
        return Collections.unmodifiableMap(employees);
    }

    @PostConstruct
    public void init() {
        employees.put("Вася Петров", new Employee("Вася", "Петров", 35_000, 1));
        employees.put("Иван Иванов", new Employee("Иван", "Иванов", 40_000, 2));
        employees.put("Виктор Сидоров", new Employee("Виктор", "Сидоров", 66_000, 3));
        employees.put("Владимир Быстров", new Employee("Владимир", "Быстров", 90_000, 3));
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getNameKey())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getNameKey(), employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getNameKey())) {
            return employees.get(employee.getNameKey());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, double salary, int department) {
        Employee employee = new Employee(firstName, lastName, salary, department);
        if (employees.containsKey(employee.getNameKey())) {
            return employees.remove(employee.getNameKey());
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> list() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
