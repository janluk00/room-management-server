package pl.jandom.roomanager.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {

    @Autowired
    TeacherRepository teacherRepository;

    public List<Teacher> findAllTeachers() {
        return teacherRepository.findAll();
    }

    public void addNewTeacher(Teacher newTeacher){
        Optional<Teacher> teacherTestEmail = teacherRepository.findTeacherByLogin(newTeacher.getLogin());
        if (teacherTestEmail.isPresent()){
            throw new IllegalStateException("Ten login jest zajety!");
        }

        teacherRepository.save(newTeacher);
    }
}
