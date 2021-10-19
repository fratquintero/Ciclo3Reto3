package Ciclo3.Reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorySpecialty {
    @Autowired
    private InterfaceSpecialty crud;
    public List<Specialty> getAll(){
        return (List<Specialty>) crud.findAll();
    }
    public Optional<Specialty> getSpecialty(int id){
        return crud.findById(id);
    }

    public Specialty save(Specialty Specialty){
        return crud.save(Specialty);
    }
    public void delete(Specialty Specialty){
        crud.delete(Specialty);
    }
}
