package se.kth.sda8.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class TaskService {
    @Autowired
  private TaskRepository repository;

    public List<Task> getAll(String sort)
    {
        return repository.findAll().stream()
               .sorted(Comparator.comparing(sort.equals("name")?Task::getName : Task::getDate))
                .collect(Collectors.toList());
    }

    public Optional <Task> getById(Long id)
    {
        return repository.findById(id);


    }


    public Task createTask(Task newTask) {

        return  repository.save(newTask);

    }


    public void delete(Long id) {
       repository.deleteById(id);

    }
    public Task update(Task updatedTask)
    {

     return repository.save(updatedTask);
    }
}

