package com.laboras.pirmas.persistence;

import com.laboras.pirmas.entities.Diagnosis;
import com.laboras.pirmas.entities.Patient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class DiagnosisDAO {
    @Inject
    private EntityManager em;

    public List<Diagnosis> loadAll(){
        return  em.createNamedQuery("Diagnosis.findAll", Diagnosis.class).getResultList();
    }

    public void persist(Diagnosis diagnosis){
        this.em.persist(diagnosis);
    }

    @Transactional
    public void addPatientToDiagnosis(Integer patientID, Integer diagnosisID){
        Patient patient = em.find(Patient.class, patientID);
        Diagnosis diagnosis = em.find(Diagnosis.class, diagnosisID);

        if(patient != null && diagnosis != null){
            diagnosis.getPatients().add(patient);
            em.persist(diagnosis);
        }
    }

    public List<Patient> getPatientByDiagnosisID(Integer diagnosisID){
        Diagnosis diagnosis = em.find(Diagnosis.class, diagnosisID);
        if (diagnosis != null){
            return diagnosis.getPatients();
        }
        return new ArrayList<>();
    }

    public List<Diagnosis> getDiagnosisByPatientID(Integer patientID){
        Patient patients = em.find(Patient.class, patientID);
        if (patients != null){
            return patients.getDiagnoses();
        }
        return new ArrayList<>();
    }
}
