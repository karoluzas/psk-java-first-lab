package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.persistence.PatientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdatePatientDetails implements Serializable{
    private Patient patient;

    @Inject
    private PatientsDAO patientsDAO;

    @PostConstruct
    private void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer patientID = Integer.parseInt(requestParameters.get("patient_id"));
        this.patient = patientsDAO.findOne(patientID);
    }

    @Transactional
    @LoggedInvocation
    public String updateDetails(){
        try{
            patientsDAO.update(this.patient);
        } catch(OptimisticLockException e){
            return "/patientDetails.xhtml?faces-redirect=true&patient_id=" + this.patient.getId() + "&error=optimistic-lock-exception";
        }
        return "patients.xhtml?doctor_id=" + this.patient.getDoctor().getId() + "&faces-redirect=true";
    }

}
