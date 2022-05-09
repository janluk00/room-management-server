package pl.jandom.roomanager.reservation;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table
public class Reservation {
    @Id
    @Column(name = "reservation_id")
    private Long reservationId;
    private Date from;
    private Date to;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "emp_id")
    private Long empId;

}
