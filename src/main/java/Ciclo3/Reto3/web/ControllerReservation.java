package Ciclo3.Reto3.web;

import Ciclo3.Reto3.model.ClientCount;
import Ciclo3.Reto3.model.Reservation;
import Ciclo3.Reto3.services.ServicesReservation;
import Ciclo3.Reto3.services.StatusReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ControllerReservation {
    @Autowired
    private ServicesReservation service;
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return service.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation) {
        return service.save(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation) {
        return service.update(reservation);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return service.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservation getReservation(){
        return service.reporteStatusServicio();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getReservacionesTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo ){
        return service.reporteTiempoServicio(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ClientCount> getClient(){
        return service.reporteClientesServicio();
    }
}
