package io.sample.springmvc.controllers;

import io.sample.springmvc.models.Person;
import io.sample.springmvc.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/home")
public class RegistrationController {

    @Autowired
    PersonService personService;
    @GetMapping
    public List<Person> getPersonInfo() {
        return personService.getPersonInfo();
    }

    @PostMapping
    public void addNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    // api/v1/home/1?name=Max&email=max@gmail.com
    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        personService.updatePerson(personId, name, email);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId
    ) {
        personService.deleteStudent(personId);
    }
}
