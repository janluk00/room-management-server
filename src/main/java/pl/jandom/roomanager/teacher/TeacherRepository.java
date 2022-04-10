package pl.jandom.roomanager.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findTeacherByLogin(String login);
    Boolean existsByLogin(String login);
    void deleteByLogin(String login);
}
