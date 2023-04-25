package com.laboras.pirmas.usecases;

import com.laboras.pirmas.mybatis.dao.DiagnosisMapper;
import com.laboras.pirmas.mybatis.model.Diagnosis;
import com.laboras.pirmas.mybatis.model.Patient;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class MyBatisDiagnoses {
    @Inject
    private DiagnosisMapper diagnosisMapper;

    @Getter @Setter
    private Diagnosis createdDiagnosis = new Diagnosis();

    @Getter
    private List<Diagnosis> allDiagnoses;

    @Transactional
    public void createDiagnosis(){
        this.diagnosisMapper.insert(createdDiagnosis);
    }

    @PostConstruct
    public void init(){
        loadAllDiagnoses();
    }

    private void loadAllDiagnoses(){
        this.allDiagnoses = diagnosisMapper.selectAll();
    }

    public List<Patient> getLoadPatients(Integer diagnosisID){
        System.out.println(diagnosisMapper.selectPatientsOfDiagnosis(diagnosisID));
        return diagnosisMapper.selectPatientsOfDiagnosis(diagnosisID);
    }

}

