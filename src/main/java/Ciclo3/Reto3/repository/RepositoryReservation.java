package Ciclo3.Reto3.repository;

import Ciclo3.Reto3.interfaces.InterfaceReservation;
import Ciclo3.Reto3.model.Client;
import Ciclo3.Reto3.model.ClientCount;
import Ciclo3.Reto3.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryReservation {
    @Autowired
    private InterfaceReservation crud4;

    public List<Reservation> getAll(){
        return (List<Reservation>) crud4.findAll();
    }
    public Optional<Reservation> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservation save(Reservation reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservation reservation){
        crud4.delete(reservation);
    }

    public List<Reservation> ReservacionStatusRepositorio (String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservation> ReservacionTiempoRepositorio (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);

    }

    public List<ClientCount> getRepositoryClient(){
        List<ClientCount> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size(); i++){
            res.add(new ClientCount((Long)report.get(i)[1],(Client) report.get(i)[0]));
        }
        return res;
    }
}
