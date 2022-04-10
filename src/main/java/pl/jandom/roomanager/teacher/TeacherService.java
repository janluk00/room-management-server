package pl.jandom.roomanager.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        Optional<Teacher> teacherTestEmail = teacherRepository
                .findTeacherByLogin(newTeacher.getLogin());

        if (teacherTestEmail.isPresent()){
            throw new IllegalStateException("Ten login jest zajety!");
        }

        teacherRepository.save(newTeacher);
    }

    public Optional<Teacher> findTeacherByLogin(String login){
        Optional<Teacher> optionalTeacher = teacherRepository
                .findTeacherByLogin(login);

        if(optionalTeacher.isEmpty()){
            throw new IllegalStateException(
                    "Nauczyciel o loginie " + login + " nie zostal znaleziony" );
        }

        return teacherRepository.findTeacherByLogin(login);
    }

    public void deleteTeacherById(Long id){
        boolean isTeacherInDatabase = teacherRepository.existsById(id);
        if(!isTeacherInDatabase){
            throw new IllegalStateException(
                    "Nauczyciela o id " + id + "nie ma w bazie danych!");
        }

        teacherRepository.deleteById(id);
    }

    @Transactional
    public void updateTeacher(Long id, String name, String title){
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException(
                        "Nauczyciel o id: " + id + " nie istnieje!"));

        if(name != null && name.length() > 0 &&
        !name.equalsIgnoreCase(teacher.getName())){
            teacher.setName(name);
        }

        if(title != null && title.length() > 0 &&
                !title.equalsIgnoreCase(teacher.getTitle())){
            teacher.setTitle(title);
        }
    }
}
