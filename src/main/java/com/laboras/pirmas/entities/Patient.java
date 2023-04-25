package com.laboras.pirmas.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PATIENT")
@NamedQueries({
        @NamedQuery(name = "Patient.findAll", query = "select patient from Patient as patient")
})
@EqualsAndHashCode
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic(optional = true)
    @Column(name = "SURNAME")
    private String surname;
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic(optional = true)
    @Column(name = "PHONE_NUMBER")
    private String phone_number;
    public String getPhone_number() {
        return phone_number;
    }
    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Basic(optional = true)
    @Column(name = "ADDRESS")
    private String address;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    @Basic(optional = true)
    @Column(name = "EMAIL")
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Basic(optional = true)
    @Column(name = "GENDER")
    private Character gender;
    public Character getGender() {
        return gender;
    }
    public void setGender(Character gender) {
        this.gender = gender;
    }

    @Basic(optional = true)
    @Column(name = "AGE")
    private Short age;
    public Short getAge() {
        return age;
    }
    public void setAge(Short age) {
        this.age = age;
    }

    @ManyToOne(optional = true)
    @JoinColumn(name = "DOCTOR_ID")
    private Doctor doctor;
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @ManyToMany(mappedBy = "patients")
    private List<Diagnosis> diagnoses;
    public List<Diagnosis> getDiagnoses() {
        return diagnoses;
    }
    public void setDiagnoses(List<Diagnosis> diagnoses) {
        this.diagnoses = diagnoses;
    }
}
