package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Diagnosis;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.persistence.PatientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class Patients {
    @Inject
    private PatientsDAO patientsDAO;

    @Getter
    private Patient patient;

    @Getter @Setter
    private Patient createdPatient = new Patient();

    @Getter
    private List<Patient> allPatients;

    @PostConstruct
    public void init(){
        loadAllPatients();
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer patientID = Integer.parseInt(requestParameters.get("patient_id"));
        loadPatient(patientID);
    }

    private void loadAllPatients(){
        this.allPatients = patientsDAO.getAllPatients();
    }

    private Patient loadPatient(Integer patientID){
        return patientsDAO.findOne(patientID);
    }

    public List<Diagnosis> getLoadDiagnosis(Integer patientID){
        return patientsDAO.getDiagnosisByPatientID(patientID);
    }
}
