package com.company.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InputValidateTest {

    @InjectMocks
    private InputValidator inputValidator;

    @Test
    public void testInputInvalidAge(){
        assertEquals(inputValidator.inValidInput(0,"Terry"),true);
    }

    @Test
    public void testInputValidAge(){
        assertEquals(inputValidator.inValidInput(10,"Terry"),false);
    }

    @Test
    public void testInputValidFirstName(){
        assertEquals(inputValidator.inValidInput(10,"Terry"),false);
    }

    @Test
    public void testInputInValidFirstName(){
        assertEquals(inputValidator.inValidInput(20,null),true);
    }
}
