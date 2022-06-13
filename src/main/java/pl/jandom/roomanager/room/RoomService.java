package pl.jandom.roomanager.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    public static final String ROOM_NR_NOT_FOUND = "Nie znaleziono pokoju o numerze %d!";

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }

    public Optional<Room> findRoomByNr(Long nr){
        Optional<Room> room = roomRepository.findRoomByRoomNr(nr);

        if(room.isEmpty()){
            throw new IllegalStateException(String.format(ROOM_NR_NOT_FOUND, nr));
        }

        return roomRepository.findRoomByRoomNr(nr);
    }

    public void addNewRoom(Room newRoom) {
        roomRepository.save(newRoom);
    }

    public void removeRoomByNr(Long nr) {
        boolean isRoomInDatabase = roomRepository.existsById(nr);

        if(!isRoomInDatabase){
            throw new IllegalStateException(String.format(ROOM_NR_NOT_FOUND, nr));
        }

        roomRepository.deleteById(nr);
    }
}
