package com.laboras.pirmas.usecases;

import com.laboras.pirmas.mybatis.model.Doctor;
import com.laboras.pirmas.mybatis.model.Patient;
import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.mybatis.dao.DoctorMapper;
import com.laboras.pirmas.mybatis.dao.PatientMapper;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
@RequestScoped
public class MyBatisDoctorPatients {
    @Inject
    private DoctorMapper doctorsMapper;

    @Inject
    private PatientMapper patientsMapper ;

    @Getter @Setter
    private Patient createdPatient = new Patient();

    @Getter @Setter
    private Doctor doctor;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer doctorID = Integer.parseInt(requestParameters.get("doctor_id"));
        this.doctor = doctorsMapper.selectByPrimaryKey(doctorID);
    }

    @Transactional
    @LoggedInvocation
    public void createPatient(){
        createdPatient.setDoctor(this.doctor);
        createdPatient.setDoctorId(this.doctor.getId());
        patientsMapper.insert(createdPatient);
    }
}
