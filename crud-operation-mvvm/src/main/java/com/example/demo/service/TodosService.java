package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Todos;
import com.example.demo.repository.TodosRepository;

@Service
public class TodosService {
	
	@Autowired
	private TodosRepository todosRepository;

	public List<Todos> getAllTodos() {
		return todosRepository.findAll();
	}

	public void saveTodo(Todos todo) {
		todosRepository.save(todo);
		
	}

	public Todos getTodoById(long id) {
		return todosRepository.findById(id).get();
	}

	public void deleteTodoById(long id) {
		todosRepository.deleteById(id);
		
	}

}
