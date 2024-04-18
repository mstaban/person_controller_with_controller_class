package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    PersonRepo repo;

    @PostMapping  ("/person")
    public Person addPerson (@ModelAttribute Person person){
repo.save(person);
        return person;
    }
    @RequestMapping("/persons")

    public List<Person> getPersons (){

        return repo.findAll();
    }
    @RequestMapping("/person/{id}")

    public Optional<Person>  getPerson (@PathVariable("id") int id){
        return repo.findById(id);
    }
}
