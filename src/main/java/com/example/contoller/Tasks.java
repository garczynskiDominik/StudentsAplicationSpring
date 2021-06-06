package com.example.contoller;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepository;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class Tasks {

    private final PersonRepository personRepository;
    private final TaskRepository taskRepository;

    public Tasks(PersonRepository personRepository, TaskRepository taskRepository) {
        this.personRepository = personRepository;
        this.taskRepository = taskRepository;
    }



    //get all tassks
    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String getAllTasks(Model model) {
        List<Task> list = taskRepository.findAll();
        model.addAttribute("task", list);
        return "tasks/tasks";
        // return "tasks/addTask";
    }


    @RequestMapping(value = {"addTask"}, method = RequestMethod.POST)
    public RedirectView postAdNewTask(@ModelAttribute Task newTask) {
        taskRepository.save(newTask);
        return new RedirectView("tasks");
    }

    @RequestMapping(value = {"/addTasks"}, method = RequestMethod.GET)
    public String getAddTasks(Model model) {

        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }
}



