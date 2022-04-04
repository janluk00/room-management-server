package pl.jandom.roomanager.teacher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Teacher {

    @Id
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String title;

    public Teacher(String login, String name, String surname, String title) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.title = title;
    }
}
