package pl.jandom.roomanager.room;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table
public class Room {
    @Id
    @Column(name = "room_nr")
    private Long roomNr;
    private Long level;
    private Long capacity;
    private String type;

    public Room(Long level, Long capacity, String type) {
        this.level = level;
        this.capacity = capacity;
        this.type = type;
    }
}
