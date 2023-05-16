package com.laboras.pirmas.persistence;

import com.laboras.pirmas.entities.Diagnosis;
import com.laboras.pirmas.entities.Patient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PatientsDAO {
    @Inject
    private EntityManager entity_manager;

    public void persist(Patient patient){
        this.entity_manager.persist(patient);
    }

    public Patient findOne(Integer id){
        return entity_manager.find(Patient.class, id);
    }

    public Patient update(Patient patient){
        return entity_manager.merge(patient);
    }

    public List<Patient> getAllPatients(){
        return entity_manager.createNamedQuery("Patient.findAll", Patient.class).getResultList();
    }

    public void delete(Patient patient){
        this.entity_manager.remove(patient);
    }

    public List<Diagnosis> getDiagnosisByPatientID(Integer patientID){
        Patient patients = entity_manager.find(Patient.class, patientID);
        if (patients != null){
            return patients.getDiagnoses();
        }
        return new ArrayList<>();
    }
}
