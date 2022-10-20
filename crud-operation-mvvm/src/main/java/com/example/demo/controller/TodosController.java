package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Todos;
import com.example.demo.service.TodosService;


@Controller
public class TodosController {
	
	@Autowired
	private TodosService todosService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Todos> todos = todosService.getAllTodos();
		model.addAttribute("todos",todos);
		return "home";		
	}
	
	@GetMapping("/showNewTodoForm")
	public String showNewTodoForm(Model model) {
		Todos todo = new Todos();
		model.addAttribute("todo", todo);
		return "new_todo";
	}
	
	@PostMapping("/saveTodo")
	public String saveTodo(@ModelAttribute("todo") Todos todo) {
		todosService.saveTodo(todo);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		Todos todo = todosService.getTodoById(id);
		System.out.println(todo);
		model.addAttribute("todo", todo);
		return "update_todo";
	}
	
	@GetMapping("/deleteTodo/{id}")
	public String deleteTodo(@PathVariable (value = "id") long id) {
		this.todosService.deleteTodoById(id);
		return "redirect:/";
	}

}

