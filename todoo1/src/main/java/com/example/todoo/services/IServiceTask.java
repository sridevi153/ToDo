package com.example.todoo.services;

import java.util.List;

import com.example.todoo.models.Task;

public interface IServiceTask {
	List<Task> findPaginated(int pageNo, int pageSize);
	List<Task> findAllOrderByDateAsc();
	List<Task> findBytaskRegex(String regexString);
}
