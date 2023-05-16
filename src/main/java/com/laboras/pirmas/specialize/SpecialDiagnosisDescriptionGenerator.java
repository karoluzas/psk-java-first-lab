package com.laboras.pirmas.specialize;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Specializes;

@Dependent
@Specializes
public class SpecialDiagnosisDescriptionGenerator extends DiagnosisDescriptionGenerator{
    @Override
    public String generateDescription() {
        return "NEW random diagnosis description";
    }
}
