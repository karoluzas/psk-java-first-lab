package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Doctor;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.persistence.DoctorsDAO;
import com.laboras.pirmas.persistence.PatientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class DoctorPatients implements Serializable {

    @Inject
    private DoctorsDAO doctorsDAO;

    @Inject
    private PatientsDAO patientsDAO;

    @Getter @Setter
    private Patient createdPatient = new Patient();

    @Getter @Setter
    private Doctor doctor;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer doctorID = Integer.parseInt(requestParameters.get("doctor_id"));
        this.doctor = doctorsDAO.findOne(doctorID);
    }

    @Transactional
    @LoggedInvocation
    public void createPatient(){
        createdPatient.setDoctor(this.doctor);
        patientsDAO.persist(createdPatient);
    }
}
