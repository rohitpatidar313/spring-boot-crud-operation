package com.company.repository;

import com.company.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer> {
    Person findByFirstName(String firstName);
    Person findByFirstNameAndLastName(String firstName,String lastName);
}
