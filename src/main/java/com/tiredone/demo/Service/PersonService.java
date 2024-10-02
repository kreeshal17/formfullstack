package com.tiredone.demo.Service;

import com.tiredone.demo.Model.Person;
import com.tiredone.demo.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;
    public void registerPerson(Person person) {
        personRepository.save(person);
    }
    public Person findByEmail(String email) {
        return personRepository.findByEmail(email); // Now correctly returns the found Person or null
    }

    public List<Person> getAll(){
        return personRepository.findAll();
 }
}
