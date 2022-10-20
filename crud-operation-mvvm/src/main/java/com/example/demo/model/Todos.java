package com.example.demo.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Todos {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="target_date")
	private String targetDate;
	
	@Column(name="todo_status")
	private String todoStatus;
	


	public Todos() {
	}


	public Todos(long id, String title, String targetDate, String todoStatus) {
		this.title = title;
		this.targetDate = targetDate;
		this.todoStatus = todoStatus;
	}
	

	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getTargetDate() {
		return targetDate;
	}



	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}



	public String getTodoStatus() {
		return todoStatus;
	}



	public void setTodoStatus(String todoStatus) {
		this.todoStatus = todoStatus;
	}


	@Override
	public String toString() {
		return "Todos [id=" + id + ", title=" + title + ", targetDate=" + targetDate + ", todoStatus=" + todoStatus
				+ "]";
	}
	
	
	

}
