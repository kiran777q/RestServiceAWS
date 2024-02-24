package com.example.RestServiceAWS.Service;

import com.example.RestServiceAWS.DTO.Person;
import com.example.RestServiceAWS.helper.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person person) {
        return personRepository.save(person);
    }
}