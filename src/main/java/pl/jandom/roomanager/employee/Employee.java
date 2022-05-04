package pl.jandom.roomanager.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String job;
    @Column(name = "serial_number")
    private String serialNumber;

    public Employee(String login, String name, String surname, String job, String serialNumber) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.serialNumber = serialNumber;
    }
}
