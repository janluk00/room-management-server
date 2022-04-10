package pl.jandom.roomanager.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher") /* localhost:8080/teacher */
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/allTeachers")
    public List<Teacher> findAllTeachers(){
        return teacherService.findAllTeachers();
    }

    @GetMapping("/{login}")
    public Optional<Teacher> getTeacherByLogin(@PathVariable("login") String login){
        return teacherService.findTeacherByLogin(login);
    }

    @PostMapping("/addTeacher")
    public void registerNewTeacher (@RequestBody Teacher newTeacher){
        teacherService.addNewTeacher(newTeacher);
    }

    @PutMapping("/editTeacher/{id}")
    public void editTeacher(@PathVariable("id") Long id,
                            @RequestParam(required = false) String name,
                            @RequestParam(required = false) String title){
        teacherService.updateTeacher(id, name, title);
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public void deleteTeacher(@PathVariable("id") Long id){
        teacherService.deleteTeacherById(id);
    }
}
