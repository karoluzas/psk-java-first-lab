package com.laboras.pirmas.usecases;

import com.laboras.pirmas.decorator.DoctorDecorator;
import com.laboras.pirmas.entities.Diagnosis;
import com.laboras.pirmas.entities.Doctor;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.persistence.DoctorsDAO;
import com.laboras.pirmas.persistence.DiagnosisDAO;
import com.laboras.pirmas.persistence.PatientsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Doctors {
    @Inject
    private DoctorsDAO doctorsDAO;

    @Inject
    private DiagnosisDAO diagnosisDAO;

    @Inject
    private PatientsDAO patientsDAO;

    @Getter @Setter
    private Doctor createdDoctor = new Doctor();

    @Getter
    private List<Doctor> allDoctors;

    @Inject
    private DoctorDecorator doctorDecorator;

    @PostConstruct
    public void init(){
        loadAllDoctors();
    }

    @Transactional
    @LoggedInvocation
    public void createDoctor(){
        System.out.println("Decoratorius: " + doctorDecorator.DecoratedString(""));
        this.doctorsDAO.persist(createdDoctor);
    }

    private void loadAllDoctors(){
        this.allDoctors = doctorsDAO.loadAll();
    }

    public List<Diagnosis> getPatientDiagnosis(Patient patient){

        return patientsDAO.getDiagnosisByPatientID(patient.getId());
    }
}
