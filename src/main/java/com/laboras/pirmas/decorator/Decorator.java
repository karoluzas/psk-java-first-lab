package com.laboras.pirmas.decorator;

import javax.enterprise.context.Dependent;

@Dependent
public class Decorator implements DoctorDecorator{
    @Override
    public String DecoratedString (String string){
        return string;
    }
}
