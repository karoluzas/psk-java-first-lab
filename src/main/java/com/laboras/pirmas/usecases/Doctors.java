package com.laboras.pirmas.usecases;

import com.laboras.pirmas.entities.Doctor;
import com.laboras.pirmas.persistence.DoctorsDAO;
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

    @Getter @Setter
    private Doctor createdDoctor = new Doctor();

    @Getter
    private List<Doctor> allDoctors;

    @PostConstruct
    public void init(){
        loadAllDoctors();
    }

    @Transactional
    public void createDoctor(){
        this.doctorsDAO.persist(createdDoctor);
    }

    private void loadAllDoctors(){
        this.allDoctors = doctorsDAO.loadAll();
    }
}
