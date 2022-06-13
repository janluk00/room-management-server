package pl.jandom.roomanager.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public void registerNewRoom(@RequestBody Room newRoom){
        roomService.addNewRoom(newRoom);
    }

    @DeleteMapping("/delete/{nr}")
    public void deleteRoom(@PathVariable("nr") Long nr){
        roomService.removeRoomByNr(nr);
    }

}
