package com.example.todoo.controller;

import com.example.todoo.controller.TaskController;


import com.example.todoo.models.Task;
import com.example.todoo.repository.TaskRepository;
import com.example.todoo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ragcrix
 */
@RestController
@CrossOrigin
@RequestMapping("/ToDo")
public class TaskController {

    @Autowired
    private TaskServices taskService;
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTask());
    }
    @GetMapping("/completed")
    public ResponseEntity<List<Task>> getAllCompletedTasks() {
        return ResponseEntity.ok(taskService.findAllCompletedTask());
    }
    @GetMapping("/incomplete")
    public ResponseEntity<List<Task>> getAllIncompleteTasks() {
        return ResponseEntity.ok(taskService.findAllInCompleteTask());
    }
    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createNewTask(task));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable String id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
    @GetMapping("/task/{pageNo}/{pageSize}")
    public List<Task> getPaginatedCountries(@PathVariable int pageNo, 
            @PathVariable int pageSize) {

        return taskService.findPaginated(pageNo, pageSize);
    }
    @GetMapping(value = "/duedate")
    public List<Task> getTaskByDate() {

        return taskService.findAllOrderByDateAsc();
    }
    
    @RequestMapping("/home")
    public void getHomepage(){
    }
    
    @GetMapping("/totalpages")
    public ResponseEntity<Integer> getTotalPages(Pageable pageable) {
    Page<Task> page = taskRepository.findAll(pageable);
    int totalPages = page.getTotalPages();
    return ResponseEntity.ok(totalPages);
    }
    
//    
//    	Query query = new Query(Criteria.where("task").is(task));
////    	query.addCriteria(Criteria.where("task").is(task));
//    	return mongoTemplate.findAll(query,Task.class);
//    }
//  public List<Task> findAll(@PathVariable(value="task")String task){
    @GetMapping("/search")
    public ResponseEntity<List<Task>> searchTasks(@RequestParam("task") String regexString){
        return ResponseEntity.ok(taskService.findBytaskRegex(regexString));
    }
    
}