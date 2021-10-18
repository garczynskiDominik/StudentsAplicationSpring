package com.example.contoller;

import com.example.model.Person;
import com.example.model.Task;
import com.example.repository.PersonRepository;
import com.example.repository.TaskRepository;
import com.example.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class Tasks {


    private final TaskRepository taskRepository;
    private final TaskService taskService;
    private final PersonRepository personRepository;

    @GetMapping(value = {"/tasks"})
    public String getAllTasks(Model model) {
        List<Task> list = taskRepository.findAll();
        model.addAttribute("task", list);
        return "tasks/tasks";
    }

    @PostMapping(value = {"addTasks"})
    public RedirectView postAdNewTask(@ModelAttribute Task newTask) {
        taskRepository.save(newTask);
        return new RedirectView("tasks");
    }

    @GetMapping(value = {"/addTasks"})
    public String getAddTasks(Model model) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        return "tasks/addTask";
    }

    @GetMapping(value = {"editTask/{id}"})
    public String editTask(Model model, @PathVariable("id") Long id) {
        List<Person> list = personRepository.findAll();
        model.addAttribute("person", list);
        model.addAttribute("task", taskRepository.getOne(id));
        return "tasks/editTask";
    }

    @PostMapping(value = {"/editTask/{id}"})
    public RedirectView EditTask(@ModelAttribute Task task, @PathVariable("id") Long id) {
        taskService.editTask(task, id);
        return new RedirectView("/editTask/{id}");

    }

    @PostMapping(value = {"/deleteTask/{id}"})
    public RedirectView deleteTask(@PathVariable("id") Long id) {
        taskRepository.deleteById(id);
        return new RedirectView("/tasks");
    }


}



