package pl.jandom.roomanager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    public static final String EMPLOYEE_LOGIN_NOT_FOUND = "Pracownik o loginie %s nie zostal znaleziony!";
    public static final String EMPLOYEE_ID_NOT_FOUND = "Pracownik o id %d nie zostal znaleziony!";
    public static final String EMPLOYEE_LOGIN_TAKEN = "Ten login jest juz zajety!";

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee newEmployee){
        Optional<Employee> employeeTestEmail = employeeRepository
                .findEmployeeByLogin(newEmployee.getLogin());

        if (employeeTestEmail.isPresent()){
            throw new IllegalStateException(EMPLOYEE_LOGIN_TAKEN);
        }
        else {
            employeeRepository.save(newEmployee);
        }
    }

    public Optional<Employee> findEmployeeByLogin(String login){
        Optional<Employee> optionalEmployee = employeeRepository
                .findEmployeeByLogin(login);

        if(optionalEmployee.isEmpty()){
            throw new IllegalStateException(
                    String.format(EMPLOYEE_LOGIN_NOT_FOUND, login));
        }

        return employeeRepository.findEmployeeByLogin(login);
    }

    @Transactional
    public void deleteEmployeeById(Long id){
        boolean isEmployeeInDatabase = employeeRepository.existsById(id);
        if(!isEmployeeInDatabase){
            throw new IllegalStateException(
                    String.format(EMPLOYEE_ID_NOT_FOUND, id));
        }
        else {
            employeeRepository.deleteEmployeeById(id);
        }
    }

    @Transactional
    public void updateEmployee(Long id, String name, String surname, String job){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        String.format(EMPLOYEE_ID_NOT_FOUND, id)
                ));

        if(name != null && name.length() > 0 &&
                !name.equalsIgnoreCase(employee.getName())){
            employee.setName(name);
        }

        if(surname != null && surname.length() > 0 &&
                !surname.equalsIgnoreCase(employee.getSurname())){
            employee.setJob(job);
        }

        if(job != null && job.length() > 0 &&
                !job.equalsIgnoreCase(employee.getJob())){
            employee.setJob(job);
        }
    }
}
