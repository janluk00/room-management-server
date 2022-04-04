package pl.jandom.roomanager.teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path = "/addTeacher")
    public void registerNewTeacher (@RequestBody Teacher newTeacher){
        teacherService.addNewTeacher(newTeacher);
    }
}
