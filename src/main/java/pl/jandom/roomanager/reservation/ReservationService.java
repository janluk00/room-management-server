package pl.jandom.roomanager.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;
    public static final String RESERVATION_ID_NOT_FOUND = "Rezerwacja o id %d nie zostala znaleziona!";

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public Optional<Reservation> findReservationByID(Long id){
        Optional<Reservation> reservationOptional = reservationRepository.findReservationByReservationId(id);
        if(reservationOptional.isEmpty()){
            throw new IllegalStateException("W bazie nie ma rezerwacji o id" + id);
        }

        return reservationRepository.findReservationByReservationId(id);
    }

    public void addNewReservation(Reservation newReservation) {
        reservationRepository.save(newReservation);
    }

    public void removeReservationById(Long id) {
        boolean isReservationInDatabase = reservationRepository.existsById(id);

        if(!isReservationInDatabase){
            throw new IllegalStateException(String.format(RESERVATION_ID_NOT_FOUND, id));
        }

        reservationRepository.deleteById(id);
    }
}
