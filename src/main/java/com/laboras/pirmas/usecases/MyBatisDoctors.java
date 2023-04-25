package com.laboras.pirmas.usecases;

import com.laboras.pirmas.mybatis.dao.DoctorMapper;
import com.laboras.pirmas.mybatis.model.Doctor;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MyBatisDoctors {
    @Inject
    private DoctorMapper doctorMapper;

    @Getter
    private List<Doctor> allDoctors;

    @Getter @Setter
    private Doctor createdDoctor = new Doctor();

    @PostConstruct
    public void init(){
        this.loadAllDoctors();
    }

    private void loadAllDoctors(){
        this.allDoctors = doctorMapper.selectAll();
    }

    @Transactional
    public String createDoctor(){
        doctorMapper.insert(createdDoctor);
        return "/myBatis/doctors.xhtml?faces-redirect=true";
    }
}
