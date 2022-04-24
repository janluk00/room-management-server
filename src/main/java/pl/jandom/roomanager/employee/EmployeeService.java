package pl.jandom.roomanager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee newEmployee){
        Optional<Employee> employeeTestEmail = employeeRepository
                .findEmployeeByLogin(newEmployee.getLogin());

        if (employeeTestEmail.isPresent()){
            throw new IllegalStateException("Ten login jest zajety!");
        }

        employeeRepository.save(newEmployee);
    }

    public Optional<Employee> findEmployeeByLogin(String login){
        Optional<Employee> optionalEmployee = employeeRepository
                .findEmployeeByLogin(login);

        if(optionalEmployee.isEmpty()){
            throw new IllegalStateException(
                    "Pracownik o loginie " + login + " nie zostal znaleziony" );
        }

        return employeeRepository.findEmployeeByLogin(login);
    }

    public void deleteEmployeeById(Long id){
        boolean isTeacherInDatabase = employeeRepository.existsById(id);
        if(!isTeacherInDatabase){
            throw new IllegalStateException(
                    "Pracownik o id " + id + "nie ma w bazie danych!");
        }

        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Long id, String name, String job){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Pracownik o id: " + id + " nie istnieje!"));

        if(name != null && name.length() > 0 &&
                !name.equalsIgnoreCase(employee.getName())){
            employee.setName(name);
        }

        if(job != null && job.length() > 0 &&
                !job.equalsIgnoreCase(employee.getJob())){
            employee.setJob(job);
        }
    }
}
