package io.sample.springmvc.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Person {
    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    @Transient
    private Integer age;

    public Person(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(
                this.dob,
                LocalDate.now()).getYears();
    }
}
