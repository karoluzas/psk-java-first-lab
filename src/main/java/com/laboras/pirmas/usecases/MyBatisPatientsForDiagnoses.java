package com.laboras.pirmas.usecases;
import lombok.Getter;
import lombok.Setter;
import com.laboras.pirmas.mybatis.dao.PatientMapper;
import com.laboras.pirmas.mybatis.model.Patient;
import com.laboras.pirmas.mybatis.model.Diagnosis;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class MyBatisPatientsForDiagnoses {
    @Inject
    private PatientMapper patientMapper;

    @Getter @Setter
    private Integer selectedPatientId;

    @Getter
    private List<SelectItem> options;

    @Getter
    private List<Patient> patientsAll;

    @PostConstruct
    public void init(){
        options = new ArrayList<>();
        this.patientsAll = patientMapper.selectAll();
        for(Patient patient : patientsAll){
            String label = patient.getName() + " - " + patientMapper.findDoctorById(patient.getDoctorId()).getName();
            this.options.add(new SelectItem(patient.getId(), label));
        }
    }

    public void handleSubmit(Diagnosis diagnosis){
        Map<String, Object> params = new HashMap<>();
        params.put("diagnosis_id", diagnosis.getId());
        params.put("patient_id", selectedPatientId);
        patientMapper.addPatientToDiagnosis(params);
    }

}
