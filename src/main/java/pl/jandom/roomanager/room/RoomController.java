package pl.jandom.roomanager.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/list")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }

    @GetMapping("/{nr}")
    public Optional<Room> getRoomByNr(@PathVariable("nr") Long nr){
        return roomService.findRoomByNr(nr);
    }
}
