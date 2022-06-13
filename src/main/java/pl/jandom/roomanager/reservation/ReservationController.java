package pl.jandom.roomanager.reservation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.jandom.roomanager.employee.Employee;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/list")
    public List<Reservation> getAllReservations(){
        return reservationService.findAllReservations();
    }

    @GetMapping("/{reservationId}")
    public Optional<Reservation> getReservationById(@PathVariable("reservationId") Long id){
        return reservationService.findReservationByID(id);
    }

    @PostMapping("/add")
    public void registerNewReservation(@RequestBody Reservation newReservation){
        reservationService.addNewReservation(newReservation);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable("id") Long id){
        reservationService.removeReservationById(id);
    }

}
