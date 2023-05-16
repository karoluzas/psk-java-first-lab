package com.laboras.pirmas.rest;

import lombok.Getter;
import lombok.Setter;
import com.laboras.pirmas.entities.Doctor;
import com.laboras.pirmas.persistence.DoctorsDAO;
import com.laboras.pirmas.rest.contracts.DoctorDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@ApplicationScoped
@Path("/doctors/")
public class DoctorController {
    @Inject
    @Getter @Setter
    private DoctorsDAO doctorsDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id){
        Doctor doctor = doctorsDAO.findOne(id);

        if(doctor == null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        DoctorDTO doctorDTO = new DoctorDTO();
        doctorDTO.setName(doctor.getName());
        doctorDTO.setSurname(doctor.getSurname());

        return Response.ok(doctorDTO).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(DoctorDTO doctorDTO){
        try{
            if(doctorDTO == null){
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            Doctor newDoctor = new Doctor();
            newDoctor.setName(doctorDTO.getName());
            newDoctor.setSurname(doctorDTO.getSurname());
            doctorsDAO.persist(newDoctor);

            URI location = UriBuilder.fromResource(DoctorController.class)
                    .path("/{id}")
                    .resolveTemplate("id", newDoctor.getId())
                    .build();
            return Response.created(location).build();

        }catch(OptimisticLockException e){
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
