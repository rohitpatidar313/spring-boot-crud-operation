package com.company.rest;

import com.company.domain.Person;
import com.company.dto.PersonDto;
import com.company.exception.InputValidationException;
import com.company.exception.PersonNotFoundException;
import com.company.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path="/api/v1")
@Api(value="CRUD_Operation_RESTAPI")
public class PersonRest {
    private static Logger logger = LogManager.getLogger(PersonRest.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private InputValidator inputValidator;

    @ApiOperation(value = "Add person with personal details.")
    @PostMapping(path="/person", consumes = "application/json", produces = "application/json")
    public Person create(@RequestBody Person person){
        ModelMapper modelMapper = new ModelMapper();
        PersonDto dto = modelMapper.map(person,PersonDto.class);
        if(inputValidator.inValidInput(dto.getAge(),dto.getFirstName())) throw new InputValidationException(dto.getFirstName());
        logger.info("Add person request received:{}",System.currentTimeMillis());
        return personService.addPerson(person);
    }

    @ApiOperation(value = "Get person's personal details using first name.")
    @GetMapping(path="/getPersonDetails/{firstName}", produces = "application/json")
    public ResponseEntity<Person> getByFirstName(@PathVariable String firstName){
        logger.info("Get person request received:{}",System.currentTimeMillis());
        Person p = personService.getByFirstName(firstName);
        if(p==null) {
            logger.info("Person with first name doesn't exists in the system. Please check the input value and try-again.");
            throw new PersonNotFoundException(firstName);
        }
        logger.info("Get person request processed with success status:{}",System.currentTimeMillis());
        return ResponseEntity.ok().body(p);
    }

    @ApiOperation(value = "Get person's personal details using first and last name.")
    @GetMapping(path="/getPersonDetails/{firstName}/{lastName}", produces = "application/json")
    public ResponseEntity<Person> getByFirstNameAndLastName(@PathVariable String firstName,@PathVariable String lastName){
        logger.info("Get person request received:{}",System.currentTimeMillis());
        Person p = personService.getByFirstNameAndLastName(firstName,lastName);
        if(p==null) {
            logger.info("Person with first name with last name doesn't exists in the system. Please check the input value and try-again.");
            throw new PersonNotFoundException(firstName);
        }
        logger.info("Get person request processed with success status:{}",System.currentTimeMillis());
        return ResponseEntity.ok().body(p);
    }

    @ApiOperation(value = "Modify person's personal details using first name.")
    @PutMapping(path="/person/{firstName}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Person> updatePersonDetail(@PathVariable String firstName, @RequestBody Person person){
        logger.info("Modify person detail request received:{}",System.currentTimeMillis());
        ModelMapper modelMapper = new ModelMapper();
        PersonDto dto = modelMapper.map(person,PersonDto.class);
        if(inputValidator.inValidInput(dto.getAge(),dto.getFirstName())) throw new InputValidationException(dto.getFirstName());
        Person p = personService.updatePersonDetail(person);
        if(p==null) {
            logger.info("Person with given first name doesn't exists in the system. Please check the input value and try-again.");
            new PersonNotFoundException(firstName);
        }
        logger.info("Modify person detail request processed with success.");
        return ResponseEntity.ok().body(p);
    }

    @ApiOperation(value = "Remove person from the system.")
    @DeleteMapping(path="/person/{firstName}", produces = "application/json")
    public ResponseEntity<Person> delete(@PathVariable String firstName){
        logger.info("Delete person request received:{}",System.currentTimeMillis());
        Person p = personService.deleteByFirstName(firstName);
        if(p==null) {
            logger.info("Person with given first name doesn't exists in the system. Please check the input value and try-again.");
            new PersonNotFoundException(firstName);
        }
        logger.info("Person details deleted.");
        return ResponseEntity.ok().body(p);
    }

    @ApiOperation(value = "Remove all persons from the system.")
    @RequestMapping(path="/persons/removeAll")
    public String deleteAll(){
        logger.info("Delete all persons request received:{}",System.currentTimeMillis());
        personService.removeAll();
        logger.info("All persons deleted from system.");
        return "All records deleted.";
    }
}
