package com.laboras.pirmas.rest.contracts;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientDTO {
    private String name;
    private String email;
    private char gender;
}
