package com.laboras.pirmas.persistence;

import com.laboras.pirmas.entities.Doctor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DoctorsDAO {
    @Inject
    private EntityManager entity_manager;

    public List<Doctor> loadAll(){
        return entity_manager.createNamedQuery("Doctor.findAll", Doctor.class).getResultList();
    }

    public void setEntity_manager(EntityManager entity_manager){
        this.entity_manager = entity_manager;
    }

    public void persist(Doctor doctor){
        this.entity_manager.persist(doctor);
    }

    public Doctor findOne(Integer id){
        return entity_manager.find(Doctor.class, id);
    }
}
