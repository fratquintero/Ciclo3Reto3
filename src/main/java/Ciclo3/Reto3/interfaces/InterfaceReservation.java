package Ciclo3.Reto3.interfaces;

import Ciclo3.Reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceReservation extends CrudRepository<Reservation,Integer> {
}
