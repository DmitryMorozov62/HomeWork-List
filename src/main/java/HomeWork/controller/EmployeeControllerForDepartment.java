package HomeWork.controller;


import HomeWork.Employee;
import HomeWork.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Collection;


@RestController
@RequestMapping("/departments")
public class EmployeeControllerForDepartment {


    private final EmployeeServiceImpl service;


    public EmployeeControllerForDepartment(EmployeeServiceImpl service) {
        this.service = service;
    }


    @GetMapping("/max-salary")
    public Employee getMaxSalary(@RequestParam Integer departmentId) {
        return service.getMaxSalaryByDepartment(departmentId);
    }


    @GetMapping("/min-salary")
    public Employee getMinSalary(@RequestParam Integer departmentId) {
        return service.getMinSalaryByDepartment(departmentId);
    }


    @GetMapping("/all")
    public Collection<Employee> getListEmployeeByDepartment(@RequestParam (value = "departmentId", required = false)Integer departmentId) {
        if (departmentId == null) {
            return service.getListEmployee();
        }
        return service.getListEmployeeByDepartment(departmentId);
    }


}
