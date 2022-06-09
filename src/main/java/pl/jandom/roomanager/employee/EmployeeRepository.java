package pl.jandom.roomanager.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findEmployeeByLogin(String login);
    Boolean existsByLogin(String login);
    @Modifying
    @Query("delete from Employee e WHERE e.id=:id")
    void deleteEmployeeById(@Param("id") Long id);
}
