package com.laboras.pirmas.mybatis.dao;

import com.laboras.pirmas.mybatis.model.Diagnosis;
import com.laboras.pirmas.mybatis.model.Patient;
import com.laboras.pirmas.mybatis.model.Doctor;

import java.util.List;
import java.util.Map;

import org.mybatis.cdi.Mapper;

@Mapper
public interface PatientMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    int insert(Patient record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    Patient selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    List<Patient> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PATIENT
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    int updateByPrimaryKey(Patient record);

    Doctor findDoctorById(Integer id);

    void addPatientToDiagnosis(Map<String, Object> params);

    List<Diagnosis> getLoadDiagnosis(Integer id);
}