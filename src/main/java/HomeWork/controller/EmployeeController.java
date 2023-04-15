package HomeWork.controller;
import HomeWork.Employee;
import HomeWork.service.EmployeeService;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam Double salary,
                        @RequestParam Integer department) {
        return employeeService.addEmployee(firstName, lastName,salary ,department);
    }


    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Double salary,
                           @RequestParam Integer department) {
        return employeeService.removeEmployee(firstName, lastName, salary, department);
    }


    @GetMapping("/find")
    public Employee find(@RequestParam String firstName,
                         @RequestParam String lastName,
                         @RequestParam Double salary,
                         @RequestParam Integer department) {
        return employeeService.findEmployee(firstName, lastName, salary, department);
    }


    @GetMapping
    public Collection<Employee> list() {
        return employeeService.list();
    }
}
