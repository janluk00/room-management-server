package pl.jandom.roomanager.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

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
}
