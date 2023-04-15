package HomeWork.service;

import HomeWork.Employee;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
@Service
public class EmployeeServiceForDepartment{
    private final EmployeeServiceImpl employeeService;

    public EmployeeServiceForDepartment(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    public Employee getMaxSalaryByDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Employee getMinSalaryByDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(Employee::getSalary))
                .orElseThrow();
    }

    public Collection<Employee> getListEmployeeByDepartment(int department) {
        return employeeService.getEmployees().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    public Collection<Employee> getListEmployee() {
        return employeeService.getEmployees().values().stream()
                .sorted(Comparator.comparingInt(Employee::getDepartment))
                .collect(Collectors.toList());
    }
}
