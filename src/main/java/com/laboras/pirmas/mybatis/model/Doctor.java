package com.laboras.pirmas.mybatis.model;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.AGE
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private Short age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.PHONE_NUMBER
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private String phoneNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.QUALIFICATION_FIELD
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private String qualificationField;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.DOCTOR.SURNAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    private String surname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.ID
     *
     * @return the value of PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.ID
     *
     * @param id the value for PUBLIC.DOCTOR.ID
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.AGE
     *
     * @return the value of PUBLIC.DOCTOR.AGE
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public Short getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.AGE
     *
     * @param age the value for PUBLIC.DOCTOR.AGE
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.NAME
     *
     * @return the value of PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.NAME
     *
     * @param name the value for PUBLIC.DOCTOR.NAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.PHONE_NUMBER
     *
     * @return the value of PUBLIC.DOCTOR.PHONE_NUMBER
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.PHONE_NUMBER
     *
     * @param phoneNumber the value for PUBLIC.DOCTOR.PHONE_NUMBER
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.QUALIFICATION_FIELD
     *
     * @return the value of PUBLIC.DOCTOR.QUALIFICATION_FIELD
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public String getQualificationField() {
        return qualificationField;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.QUALIFICATION_FIELD
     *
     * @param qualificationField the value for PUBLIC.DOCTOR.QUALIFICATION_FIELD
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setQualificationField(String qualificationField) {
        this.qualificationField = qualificationField;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.DOCTOR.SURNAME
     *
     * @return the value of PUBLIC.DOCTOR.SURNAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.DOCTOR.SURNAME
     *
     * @param surname the value for PUBLIC.DOCTOR.SURNAME
     *
     * @mbg.generated Tue Apr 25 15:56:50 EEST 2023
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Getter @Setter
    private List<Patient> patients = new ArrayList<>();
}