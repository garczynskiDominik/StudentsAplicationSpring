package com.example.service;

import com.example.model.Task;
import com.example.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;



    public List<Task> getTaskList() {
        return taskRepository.findAll();
    }

    public Task getTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void editTask(Task task, Long id) {
        Task editTask = new Task(
                        id,
                        task.getDeadline(),
                task.getDateAdd(),
                task.getContentTask(),
                task.getCheckbox(),
                task.getPerson()

                );
        taskRepository.save(editTask);
    }
}
