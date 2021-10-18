package com.example.contoller;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class PersonList {
    private final PersonService personService;
    private final PersonRepository personRepository;


    @GetMapping(value = {"/personList"})
    public String getPersonList(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "persons/personList";
    }

    @GetMapping(value = {"/addNewPerson"})
    public String getAddNewPerson() {
        return "persons/addNewPerson";
    }

    @PostMapping(value = {"/addNewPerson"})
    public RedirectView postAddNewPerson(@ModelAttribute Person newPerson) {
        personRepository.save(newPerson);
        return new RedirectView("/personList");
    }

    @GetMapping(value = {"/editPerson/{id}"})
    public String getEditPerson(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", personService.getPerson(id));
        return "persons/editPerson";
    }


    @PostMapping(value = {"/editPerson/{id}"})
    public RedirectView saveEditPerson(@ModelAttribute Person person, @PathVariable("id") Long id) {
        personService.editPerson(person, id);
        return new RedirectView("/editPerson/{id}");

    }

    @PostMapping(value = {"/deletePerson/{id}"})
    public RedirectView deletePerson(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
        return new RedirectView("/personList");
    }




}





