package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.persistence.PatientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class PatientsForDiagnoses {
    @Inject
    Diagnoses diagnoses;

    @Inject
    private PatientsDAO patientsDAO;

    @Getter
    private List<SelectItem> options;

    @Getter @Setter
    private int selectedPatientId;

    @PostConstruct
    public void init(){
        this.options = new ArrayList<>();
        List<Patient> patients = patientsDAO.getAllPatients();
        for (Patient patient : patients){
            String label = patient.getName() + " - " + patient.getDoctor().getName();
            this.options.add(new SelectItem(patient.getId(), label));
        }
    }

    public void handleSubmit(Integer diagnosisID){
        diagnoses.addPatientToDiagnosis(selectedPatientId, diagnosisID);
    }



}
