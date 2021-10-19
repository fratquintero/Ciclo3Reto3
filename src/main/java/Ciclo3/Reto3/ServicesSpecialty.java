package Ciclo3.Reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesSpecialty {
    @Autowired
    private RepositorySpecialty methodsCrud;

    public List<Specialty> getAll() {
        return methodsCrud.getAll();
    }

    public Optional<Specialty> getSpecialty(int SpecialtyId) {
        return methodsCrud.getSpecialty(SpecialtyId);
    }

    public Specialty save(Specialty specialty) {
        if (specialty.getId()== null) {
            return methodsCrud.save(specialty);
        } else {
            Optional<Specialty> e= methodsCrud.getSpecialty(specialty.getId());
            if (e.isEmpty()) {
                return methodsCrud.save(specialty);
            } else {
                return specialty;
            }
        }
    }

    public Specialty update(Specialty specialty){
        if(specialty.getId()!=null){
            Optional<Specialty>g= methodsCrud.getSpecialty(specialty.getId());
            if(!g.isEmpty()){
                if(specialty.getDescription()!=null){
                    g.get().setDescription(specialty.getDescription());
                }
                if(specialty.getName()!=null){
                    g.get().setName(specialty.getName());
                }
                return methodsCrud.save(g.get());
            }
        }
        return specialty;
    }
    public boolean deletespecialty(int specialtyId){
        Boolean d=getSpecialty(specialtyId).map(specialty -> {
            methodsCrud.delete(specialty);
            return true;
        }).orElse(false);
        return d;
    }
}
