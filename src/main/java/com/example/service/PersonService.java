package com.example.service;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;


    public List<Person> getPersonList() {
        return personRepository.findAll();
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }


    public void addPerson(Person person) {
        Person newPerson = new Person(
                person.getFirstName(),
                person.getLastName(),
                person.getGitHub(),
                person.getStart(),
                person.getJava(),
                person.getBestpractice(),
                person.getTdd(),
                person.getQuestion(),
                person.getHibernate(),
                person.getHtml(),
                person.getJsp(),
                person.getThymeleaf(),
                person.getGit(),
                person.getCheckbox());


        personRepository.save(newPerson);
        System.out.printf("adding person on id:" + newPerson.getId());
    }

    public void editPerson(Person person, Long id) {
        Person editPerson = new Person(
                id,
                person.getFirstName(),
                person.getLastName(),
                person.getGitHub(),
                person.getStart(),
                person.getJava(),
                person.getBestpractice(),
                person.getTdd(),
                person.getQuestion(),
                person.getHibernate(),
                person.getHtml(),
                person.getJsp(),
                person.getThymeleaf(),
                person.getGit(),
                person.getCheckbox());
        personRepository.save(editPerson);
        System.out.println("adding person on id:" + editPerson.getId());

    }
}
