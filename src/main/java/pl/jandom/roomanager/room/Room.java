package pl.jandom.roomanager.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.jandom.roomanager.reservation.Reservation;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_nr")
    private Long roomNr;
    private Long level;
    private Long capacity;
    private String type;
    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Reservation> reservations;

    public Room(Long level, Long capacity, String type) {
        this.level = level;
        this.capacity = capacity;
        this.type = type;
    }
}
