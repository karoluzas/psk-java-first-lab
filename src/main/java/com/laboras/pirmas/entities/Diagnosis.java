package com.laboras.pirmas.entities;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Entity
@EqualsAndHashCode
@NamedQueries({
        @NamedQuery(name = "Diagnosis.findAll", query = " select diagnosis from Diagnosis as diagnosis"),
        @NamedQuery(name = "Diagnosis.findAllPatients", query = "SELECT d.patients FROM Diagnosis d WHERE d.id = :diagnoses_id")
})
@Table(name = "DIAGNOSIS")
public class Diagnosis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "NAME", nullable=false, unique = false)
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Basic
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany
    @JoinTable(name="PATIENT_DIAGNOSIS", joinColumns=@JoinColumn(name="PATIENTS_ID"), inverseJoinColumns=@JoinColumn(name="DIAGNOSES_ID"))
    private List<Patient> patients;
    public List<Patient> getPatients() {
        return patients;
    }
    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
