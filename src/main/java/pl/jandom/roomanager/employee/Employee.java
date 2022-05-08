package pl.jandom.roomanager.employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jandom.roomanager.reservations.Reservation;

import javax.persistence.*;
import java.util.Set;

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
    @OneToMany
    @JoinColumn(name = "emp_id")
    private Set<Reservation> reservations;

    public Employee(String login, String name, String surname, String job, String serialNumber) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.serialNumber = serialNumber;
    }
}
