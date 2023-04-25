package com.laboras.pirmas.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Doctor.findAll", query = "select t from Doctor as t")
})
@Table(name = "DOCTOR")
@EqualsAndHashCode
public class Doctor {
    public Doctor(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }
    //------------------------------
    @Basic(optional = true)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional = true)
    private String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic(optional = true)
    private String qualification_field;
    public String getQualification_field() {
        return qualification_field;
    }
    public void setQualification_field(String qualification_field) {
        this.qualification_field = qualification_field;
    }

    @Basic(optional = true)
    private String phone_number;
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Basic
    private Short age;
    public Short getAge() {
        return age;
    }
    public void setAge(Short age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
