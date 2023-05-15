package com.laboras.pirmas.usecases;

import com.laboras.pirmas.interceptors.LoggedInvocation;
import com.laboras.pirmas.persistence.PatientsDAO;
import com.laboras.pirmas.entities.Patient;
import com.laboras.pirmas.services.RandomEmailGenerator;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class GeneratePatientEmail implements Serializable{
    @Inject
    RandomEmailGenerator randomEmailGenerator;
    @Inject
    private PatientsDAO patientsDAO;

    @Getter @Setter
    private Patient patient;

    private CompletableFuture<String> randomEmailGenerationTask = null;

    @LoggedInvocation
    public String generateNewRandomEmail(){
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        randomEmailGenerationTask = CompletableFuture.supplyAsync(() -> randomEmailGenerator.generateRandomEmail());
        return "patientDetails?faces-redirect=true&patient_id=" + requestParameters.get("patient_id");
    }

    public boolean isRandomEmailGeneratorRunning(){
        return randomEmailGenerationTask != null && !randomEmailGenerationTask.isDone();
    }

    public String getRandomEmailGenerationStatus() throws ExecutionException, InterruptedException{
        if (randomEmailGenerationTask == null){
            return null;
        } else if (isRandomEmailGeneratorRunning()){
            return "Email generation is still in progress";
        }
        return "Email generated: " + randomEmailGenerationTask.get();
    }
}
