package pl.jandom.roomanager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees") /* localhost:8080/employees */
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
       this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public List<Employee> findAllEmployee(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/{login}")
    public Optional<Employee> getEmployeeByLogin(@PathVariable("login") String login){
        return employeeService.findEmployeeByLogin(login);
    }

    @PostMapping("/add")
    public void registerNewEmployee (@RequestBody Employee newEmployee){
        employeeService.addNewEmployee(newEmployee);
    }

    @PutMapping("/edit/{id}")
    public void editEmployee(@PathVariable("id") Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String surname,
                            @RequestParam(required = false) String job){
        employeeService.updateEmployee(id, name, surname, job);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployeeById(id);
    }
}
