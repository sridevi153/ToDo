package com.example.todoo.repository;

import com.example.todoo.models.Task;


import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ragcrix
 */

// No need implementation, just one interface, and you have CRUD, thanks Spring Data!
public interface TaskRepository extends MongoRepository<Task, String>, PagingAndSortingRepository<Task, String> {

	public Task findByTask(String task);
    public List<Task> findByCompletedTrue();
    public List<Task> findByCompletedFalse();
    public List<Task> findAll();
    public Task getById(Long id);
    @Query("task")
    List<Task> findAllOrderByDateAsc(Sort sort);
    @Query(value = "{'task': {$regex : ?0, $options: 'i'}}")
    List<Task> findBytaskRegex(String regexString);
//    List<Task> searchTasks(String query);

}