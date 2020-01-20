package com.company.service;

import com.company.repository.PersonRepository;
import com.company.rest.PersonRest;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Before;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest(controllers = PersonService.class)
public class PersonServiceTest {

    @InjectMocks
    private PersonService personService;

    @Mock
    private PersonRepository personRepository;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }
}
