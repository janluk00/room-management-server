package pl.jandom.roomanager.employee;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jandom.roomanager.credentials.Credentials;
import pl.jandom.roomanager.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String name;
    private String surname;
    private String job;
    @Column(name = "serial_number")
    private String serialNumber;
    @OneToMany
    @JoinColumn(name = "emp_id")
    private List<Reservation> reservations;

    public Employee(String login, String name, String surname, String job, String serialNumber) {
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.serialNumber = serialNumber;
    }
}
