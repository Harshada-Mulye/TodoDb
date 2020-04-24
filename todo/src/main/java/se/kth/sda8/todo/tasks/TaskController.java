package se.kth.sda8.todo.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private static List<Task> taskList=new ArrayList<>();
    @Autowired
    private TaskService taskService;
    @GetMapping("")
    public List<Task> getAll(@RequestParam String sort)
    {
        return taskService.getAll(sort);
    }
    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id)
    {
   return taskService.getById(id)

           .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));


    }
    @PostMapping("")
    public Task create(@RequestBody Task newTask)
    {
        return taskService.createTask(newTask);

    }
  @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id)
  {
      taskService.delete(id);
  }
@PutMapping("")
  public Task update(@RequestBody Task updatedTask){
    return taskService.update(updatedTask);
}
}
