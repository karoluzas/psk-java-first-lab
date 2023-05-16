package com.laboras.pirmas.rest;

import lombok.Getter;
import lombok.Setter;
import com.laboras.pirmas.entities.Doctor;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.persistence.PatientsDAO;
import com.laboras.pirmas.rest.contracts.PatientDTO;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/patient")
public class PatientController {
    @Inject
    @Getter @Setter
    private PatientsDAO patientsDAO;

    @Getter @Setter
    private Doctor doctor;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        Patient patient = patientsDAO.findOne(id);
        if(patient == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName(patient.getName());
        patientDTO.setGender(patient.getGender());
        patientDTO.setEmail(patient.getEmail());

        return Response.ok(patientDTO).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") final Integer patient_id, PatientDTO patientDTO){
        try{
            Patient currentPatient = patientsDAO.findOne(patient_id);
            if(currentPatient == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            currentPatient.setName(patientDTO.getName());
            currentPatient.setEmail(patientDTO.getEmail());
            currentPatient.setGender(patientDTO.getGender());
            patientsDAO.persist(currentPatient);
            return Response.ok().build();
        }catch(OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response deleteById(@PathParam("id") final Integer id){
        Patient patient = patientsDAO.findOne(id);
        if(patient == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        patientsDAO.delete(patient);
        return Response.ok().build();
    }

}
