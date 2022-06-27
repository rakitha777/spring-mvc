package io.sample.springmvc.config;

import io.sample.springmvc.models.Person;
import io.sample.springmvc.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class PersonConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(PersonRepository repository) {
        return args -> {
            Person alex = new Person(
                    "Alex",
                    "alex@gmail.com",
                    LocalDate.of(1990, Month.FEBRUARY, 2)
            );

            Person max = new Person(
                    "Max",
                    "max@gmail.com",
                    LocalDate.of(1992, Month.FEBRUARY, 18)
            );
            repository.saveAll(List.of(alex, max));
        };
    }
}
