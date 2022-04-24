package pl.jandom.roomanager.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByLogin(String login);
    Boolean existsByLogin(String login);
    void deleteByLogin(String login);
}
