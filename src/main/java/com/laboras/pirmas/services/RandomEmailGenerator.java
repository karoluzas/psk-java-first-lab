package com.laboras.pirmas.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.Random;

@ApplicationScoped
public class RandomEmailGenerator implements  Serializable{

    public String generateRandomEmail(){
        Random random = new Random();
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            return null;
        }
        String email = "";
        int[] numbers = random.ints(97, 122).limit(15).toArray();
        for(int i = 0; i < numbers.length; i++) {
            email += (char)numbers[i];
        }
        return email + "@email.com";
    }
}
