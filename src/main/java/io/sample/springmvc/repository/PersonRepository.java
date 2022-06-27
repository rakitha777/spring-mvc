package io.sample.springmvc.repository;

import io.sample.springmvc.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
//    @Query("SELECT p from Person p where p.email = ?1")
    Optional<Person> findPersonByEmail(String email);
}
