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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;
    @Column(name = "date_from")
    private Date from;
    @Column(name = "date_to")
    private Date to;
    @Column(name = "room_id")
    private Long roomId;
    @Column(name = "emp_id")
    private Long empId;

    public Reservation(Date from, Date to, Long roomId, Long empId) {
        this.from = from;
        this.to = to;
        this.roomId = roomId;
        this.empId = empId;
    }
}
