package com.example.contoller;

import com.example.model.Person;
import com.example.repository.PersonRepository;
import com.example.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@AllArgsConstructor
@Controller
public class PersonList {
    private final PersonService personService;
    private final PersonRepository personRepository;


    //get all persons
    @RequestMapping(value = {"/personList"}, method = RequestMethod.GET)
    public String getPersonList(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "persons/personList";
    }

    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.GET)
    public String getAddNewPerson() {
        return "persons/addNewPerson";
    }

    //save person in database and show personList after
    @RequestMapping(value = {"/addNewPerson"}, method = RequestMethod.POST)
    public RedirectView postAddNewPerson(@ModelAttribute Person newPerson) {
        personRepository.save(newPerson);
        return new RedirectView("/personList");
    }

    //edit person i database
    @RequestMapping(value = {"/editPerson/{id}"}, method = RequestMethod.GET)
    public String getEditPerson(Model model, @PathVariable("id") Long id) {
        model.addAttribute("person", personService.getPerson(id));
        return "persons/editPerson";
    }


    @RequestMapping(value = {"/editPerson/{id}"}, method = RequestMethod.POST)
    public RedirectView saveEditPerson(@ModelAttribute Person person, @PathVariable("id") Long id) {
        personService.editPerson(person, id);
        return new RedirectView("/editPerson/{id}");

    }
    //nowy maping do usuwania, nie dziala
    @RequestMapping(value = {"/personList/{id}"}, method = RequestMethod.DELETE)
    public String deletePerson(Model model, @PathVariable("id") Long id) {
        personRepository.deleteById(id);
        model.addAttribute("person", personService.getPerson(id));
        return "persons/editPerson";
    }


//nowy maping do skilsow ale tez nie dziala
    @RequestMapping(value = {"/personList/{id}"}, method = RequestMethod.GET)
    public String getSkills(Model model, @PathVariable("id") Long id) {
        model.addAttribute("skills", personService.getPerson(id));
         return "persons/personList";

    }


}





