package io.sample.springmvc.services;

import io.sample.springmvc.models.Person;
import io.sample.springmvc.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public List<Person> getPersonInfo() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person) {
        Optional<Person> existingPerson = personRepository.findPersonByEmail(
                person.getEmail());
        if (existingPerson.isPresent()) {
            throw new IllegalStateException("email taken");
        }
        personRepository.save(person);

    }

    public void deleteStudent(Long personId) {
        boolean exist = personRepository.existsById(personId);
        if (!exist) {
            throw new IllegalStateException("Person with id" + personId + " does not exist");
        }
        personRepository.deleteById(personId);
    }

    @Transactional
    public void updatePerson(Long personId, String name, String email) {

        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "person with id " + personId + "does not exist"
                ));

        if (name != null
                && name.length() > 0
                && !Objects.equals(person.getName(), name)) {
            person.setName(name);
        }

        if (email != null
                && email.length() > 0
                && !Objects.equals(person.getEmail(), email)) {
            Optional<Person> existingPerson = personRepository.findPersonByEmail(
                    email);
            if (existingPerson.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            person.setEmail(email);
        }
    }
}
