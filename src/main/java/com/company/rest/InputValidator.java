package com.company.rest;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Component
public class InputValidator {
    public boolean inValidInput(int age, String firstName, String lastName){
        if(age <=1 || age >= 120 || (firstName==null || firstName.length()==0) || (lastName==null || lastName.length()==0)) return true;
        return false;
    }
}
