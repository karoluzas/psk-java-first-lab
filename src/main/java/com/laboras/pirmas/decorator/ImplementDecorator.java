package com.laboras.pirmas.decorator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.Random;

@Decorator
public abstract class ImplementDecorator implements DoctorDecorator{
    @Inject
    @Delegate
    @Any
    DoctorDecorator doctorDecorator;

    public String DecoratedString (String string){
        Random random = new Random();
        String answer = "";
        System.out.println("DECORATOR USED");
        int[] numbers = random.ints(97, 122).limit(20).toArray();
        for(int i = 0; i < numbers.length; i++) {
            answer += (char)numbers[i];
        }
        return doctorDecorator.DecoratedString("Stringas") + answer;
    }
}
