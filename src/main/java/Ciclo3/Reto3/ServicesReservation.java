package Ciclo3.Reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesReservation {
    @Autowired
    private RepositoryReservation methodsCrud;

    public List<Reservation> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Reservation> getReservation(int reservationId) {
        return methodsCrud.getReservation(reservationId);
    }

    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return methodsCrud.save(reservation);
        }else{
            Optional<Reservation> e= methodsCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return methodsCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reservation update(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> e= methodsCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            methodsCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
