package com.example.contoller;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepository;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
public class Tasks {


    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final PersonRepository personRepository;


    public Tasks(TaskRepository taskRepository, TaskService taskService, PersonRepository personRepository) {
        this.taskRepository = taskRepository;
        this.taskService = taskService;
        this.personRepository = personRepository;
    }

    //get all tassks
    @RequestMapping(value = {"/tasks"}, method = RequestMethod.GET)
    public String getAllTasks(Model model) {
        List<Task> list = taskRepository.findAll();
        model.addAttribute("task", list);
        return "tasks/tasks";
    }

    //add task
    @RequestMapping(value = {"addTask"}, method = RequestMethod.POST)
    public RedirectView postAdNewTask(@ModelAttribute Task newTask) {
        taskRepository.save(newTask);
        return new RedirectView("tasks");
    }

    //    get all tasks
    @RequestMapping(value = {"/addTasks"}, method = RequestMethod.GET)
    public String getAddTasks(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }

    @RequestMapping(value = {"editTask/{id}"}, method = RequestMethod.GET)
    public String editTask(Model model, @PathVariable("id") Long id) {
        List<Person> list = personRepository.findAll();
//        Optional<Task> task = taskRepository.findById(id);
        model.addAttribute("person", list);
        model.addAttribute("task", taskRepository.getOne(id));
        return "tasks/editTask";
    }


    @RequestMapping(value = {"/editTask/{id}"}, method = RequestMethod.POST)
    public RedirectView EditTask(@ModelAttribute Task task, @PathVariable("id") Long id) {
        taskService.editTask(task, id);
        return new RedirectView("/editTask/{id}");

    }


    @RequestMapping(value = {"/deleteTask/{id}"}, method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView deleteTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return new RedirectView("/tasks");
    }


}



