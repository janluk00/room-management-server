package pl.jandom.roomanager.reservations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import pl.jandom.roomanager.employee.Employee;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    private Long reservationId;
    private Date from;
    private Date to;
    // many to many
    @Column(name = "room_id")
    private Long roomId;
    //@Column(name = "emp_id")
    //private Long empId;

}
