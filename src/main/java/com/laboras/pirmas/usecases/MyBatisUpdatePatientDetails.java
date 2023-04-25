package com.laboras.pirmas.usecases;

import com.laboras.pirmas.mybatis.model.Patient;
import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.mybatis.dao.PatientMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@RequestScoped
public class MyBatisUpdatePatientDetails {
    @Getter @Setter
    private Patient patient;

    @Inject
    private PatientMapper patientMapper;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer patientID = Integer.parseInt(requestParameters.get("patient_id"));
        this.patient = patientMapper.selectByPrimaryKey(patientID);
    }
        @Transactional
    @LoggedInvocation
    public String updateDetails(){
        try{
            patientMapper.updateByPrimaryKey(this.patient);
            //patientsDAO.update(this.patient);
        } catch(OptimisticLockException e){
            return "/patientDetails.xhtml?faces-redirect=true&patient_id=" + this.patient.getId() + "&error=optimistic-lock-exception";
        }
        return "patients.xhtml?doctor_id=" + patientMapper.findDoctorById(this.patient.getDoctorId()).getId() + "&faces-redirect=true";

    }

}
