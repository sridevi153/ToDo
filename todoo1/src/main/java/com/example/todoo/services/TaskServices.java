package com.example.todoo.services;

import com.example.todoo.models.Task;

import com.example.todoo.repository.TaskRepository;
import com.example.todoo.services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @author ragcrix
 */
@Service
public class TaskServices implements IServiceTask{

    @Autowired
    private TaskRepository taskRepository;
    
    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }
      
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }
      
    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }
      
    public List<Task> findAllCompletedTask() {
        return taskRepository.findByCompletedTrue();
    }
      
    public List<Task> findAllInCompleteTask() {
        return taskRepository.findByCompletedFalse();
    }
      
    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }
      
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }
    @Override
    public List<Task> findPaginated(int pageNo, int pageSize) {

        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Task> pagedResult = taskRepository.findAll(paging);

        return pagedResult.toList();
    }
    @Override
    public List<Task> findAllOrderByDateAsc() {

        var sort = Sort.by(Sort.Direction.ASC, "duedate");
        return taskRepository.findAllOrderByDateAsc(sort);
    }
    @Override
    public List<Task> findBytaskRegex(String regexString) {
        List<Task> tasks =taskRepository.findBytaskRegex(regexString);
        return tasks;
    }
}
