package pl.jandom.roomanager.reservations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }
}
