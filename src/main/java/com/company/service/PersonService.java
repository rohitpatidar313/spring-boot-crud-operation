package com.company.service;

import com.company.domain.Person;
import com.company.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public Person getByFirstName(String firstName){
        return personRepository.findByFirstName(firstName);
    }

    public Person getByFirstNameAndLastName(String firstName, String lastName){
        return personRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    public Person updatePersonDetail(Person p){
        Person person = personRepository.findByFirstName(p.getFirstName());
        person.setLastName(p.getLastName());
        person.setAge(p.getAge());
        person.setFavColor(p.getFavColor());
        person.setHobby(p.getHobby());
        return personRepository.save(person);
    }

    public void removeAll(){
        personRepository.deleteAll();
    }

    public Person deleteByFirstName(String firstName){
        Person person = personRepository.findByFirstName(firstName);
        personRepository.delete(person);
        return person;
    }
}
