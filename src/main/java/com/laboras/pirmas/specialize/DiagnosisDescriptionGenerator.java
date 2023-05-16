package com.laboras.pirmas.specialize;

import javax.enterprise.context.Dependent;

@Dependent
public class DiagnosisDescriptionGenerator implements IDescription{
    @Override
    public String generateDescription() {

        return "Diagnosis is yet to be filed";
    }
}
