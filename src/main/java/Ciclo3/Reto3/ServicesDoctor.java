package Ciclo3.Reto3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesDoctor {
    @Autowired
    private RepositoryDoctor methodsCrud;

    public List<Doctor> getAll(){
        return methodsCrud.getAll();
    }

    public Optional<Doctor> getDoctor(int doctorId) {
        return methodsCrud.getDoctor(doctorId);
    }

    public Doctor save(Doctor doctor){
        if(doctor.getId()==null){
            return methodsCrud.save(doctor);
        }else{
            Optional<Doctor> e= methodsCrud.getDoctor(doctor.getId());
            if(e.isEmpty()){
                return methodsCrud.save(doctor);
            }else{
                return doctor;
            }
        }
    }

    public Doctor update(Doctor doctor){
        if(doctor.getId()!=null){
            Optional<Doctor> e= methodsCrud.getDoctor(doctor.getId());
            if(!e.isEmpty()){
                if(doctor.getName()!=null){
                    e.get().setName(doctor.getName());
                }
                if(doctor.getDepartment()!=null){
                    e.get().setDepartment(doctor.getDepartment());
                }
                if(doctor.getYear()!=null){
                    e.get().setYear(doctor.getYear());
                }
                if(doctor.getDescription()!=null){
                    e.get().setDescription(doctor.getDescription());
                }
                if(doctor.getSpecialty()!=null){
                    e.get().setSpecialty(doctor.getSpecialty());
                }
                methodsCrud.save(e.get());
                return e.get();
            }else{
                return doctor;
            }
        }else{
            return doctor;
        }
    }


    public boolean deleteDoctor(int doctorId) {
        Boolean aBoolean = getDoctor(doctorId).map(doctor -> {
            methodsCrud.delete(doctor);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
