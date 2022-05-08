package pl.jandom.roomanager.room;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class Room {
    @Id
    @Column(name = "room_nr")
    private Long roomNr;
    private Long level;
    private long capacity;
    private String type;

}
