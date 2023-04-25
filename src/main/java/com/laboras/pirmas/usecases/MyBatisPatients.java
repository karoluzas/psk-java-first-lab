package com.laboras.pirmas.usecases;

import com.laboras.pirmas.mybatis.model.Diagnosis;
import com.laboras.pirmas.mybatis.model.Patient;
import com.laboras.pirmas.mybatis.dao.PatientMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@Model
public class MyBatisPatients {
    @Inject
    private PatientMapper patientMapper;

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
        this.allPatients = patientMapper.selectAll();
    }

    private Patient loadPatient(Integer patientID){
        return patientMapper.selectByPrimaryKey(patientID);
    }

    public List<Diagnosis> getLoadDiagnosis(Integer patientID){
        //return patientsDAO.getDiagnosisByPatientID(patientID);
        return patientMapper.getLoadDiagnosis(patientID);
    }
}
