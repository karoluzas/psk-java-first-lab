package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Diagnosis;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.persistence.DiagnosisDAO;
import com.laboras.pirmas.specialize.IDescription;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Diagnoses {
    @Inject
    private DiagnosisDAO diagnosisDAO;

    @Getter @Setter
    private Diagnosis createdDiagnosis = new Diagnosis();

    @Getter
    private List<Diagnosis> allDiagnoses;

    @Inject
    private IDescription description;

    @PostConstruct
    public void init(){
        loadAllDiagnoses();
    }

    @Transactional
    public void createDiagnosis(){
        this.createdDiagnosis.setDescription(description.generateDescription());
        this.diagnosisDAO.persist(createdDiagnosis);
    }

    @Transactional
    public void addPatientToDiagnosis(Integer patientID, Integer diagnosisID){
        this.diagnosisDAO.addPatientToDiagnosis(patientID, diagnosisID);
    }

    private void loadAllDiagnoses(){
        this.allDiagnoses = diagnosisDAO.loadAll();
    }

    public List<Patient> getLoadPatients(Integer diagnosisID){
        return diagnosisDAO.getPatientByDiagnosisID(diagnosisID);
    }

}
