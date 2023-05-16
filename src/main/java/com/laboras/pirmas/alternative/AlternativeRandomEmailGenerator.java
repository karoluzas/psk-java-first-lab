package com.laboras.pirmas.alternative;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.io.Serializable;
import java.util.Random;

@Alternative
@ApplicationScoped
public class AlternativeRandomEmailGenerator implements  Serializable, EmailGenerator{

    @Override
    public String generateRandomEmail(){
        Random random = new Random();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            return null;
        }
        String email = "";
        int[] numbers = random.ints(97, 122).limit(5).toArray();
        for(int i = 0; i < numbers.length; i++) {
            email += (char)numbers[i];
        }
        return email + "@GMAIL.com";
    }
}
