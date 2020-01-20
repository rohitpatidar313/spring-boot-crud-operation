package com.company.rest;

import com.company.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = PersonRest.class)
public class PersonRestTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PersonService personService;

    @MockBean
    PersonRest personRest;

    @Test
    public void getPersonTestUnauthorized() throws Exception{
        mockMvc.perform(get("/api/v1/getPersonDetails/John")
                .contentType("application/json"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void modifyPersonTestUnauthorized() throws Exception{
        mockMvc.perform(put("/api/v1/person/John")
                .contentType("application/json"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void deletePersonTestUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/v1/person/John")
                .contentType("application/json"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    public void deleteAllTestUnauthorized() throws Exception{
        mockMvc.perform(delete("/api/v1/persons/removeAll")
                .contentType("application/json"))
                .andExpect(status().isUnauthorized());
    }
}
